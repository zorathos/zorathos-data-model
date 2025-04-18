package org.datacenter.config.util;

import io.minio.BucketExistsArgs;
import io.minio.DownloadObjectArgs;
import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.StatObjectArgs;
import io.minio.StatObjectResponse;
import io.minio.UploadObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import lombok.extern.slf4j.Slf4j;
import org.datacenter.config.HumanMachineConfig;
import org.datacenter.exception.ZorathosException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.datacenter.config.keys.HumanMachineSysConfigKey.MINIO_ACCESS_KEY_ID;
import static org.datacenter.config.keys.HumanMachineSysConfigKey.MINIO_ACCESS_KEY_SECRET;
import static org.datacenter.config.keys.HumanMachineSysConfigKey.MINIO_BUCKET;
import static org.datacenter.config.keys.HumanMachineSysConfigKey.MINIO_ENDPOINT;

/**
 * @author : [wangminan]
 * @description : MinIO工具类 用来封装一些常用的方法
 */
@Slf4j
public class MinioUtil {
    private static final MinioClient minioClient;

    static {
        minioClient = MinioClient.builder()
                .endpoint(HumanMachineConfig.getProperty(MINIO_ENDPOINT))
                .credentials(HumanMachineConfig.getProperty(MINIO_ACCESS_KEY_ID), HumanMachineConfig.getProperty(MINIO_ACCESS_KEY_SECRET))
                .build();
        // 检查 bucket是否存在 如果不存在的就创建
        try {
            if (!minioClient.bucketExists(BucketExistsArgs.builder()
                    .bucket(HumanMachineConfig.getProperty(MINIO_BUCKET))
                    .build())) {
                log.info("Human machine bucket does not exist, creating:{}", HumanMachineConfig.getProperty(MINIO_BUCKET));
                minioClient.makeBucket(MakeBucketArgs.builder()
                        .bucket(HumanMachineConfig.getProperty(MINIO_BUCKET))
                        .build());
            }
        } catch (Exception e) {
            throw new ZorathosException(e, "Encounter an error while initializing MinIO bucket");
        }
    }

    public static boolean checkFileExist(String url) {
        try {
            StatObjectResponse statObjectResponse = minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(HumanMachineConfig.getProperty(MINIO_BUCKET))
                            .object(url)
                            .build());
            if (statObjectResponse != null) {
                return true;
            }
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            if (e instanceof ErrorResponseException) {
                if (((ErrorResponseException) e).response().code() == 404) {
                    return false;
                }
            } else {
                throw new ZorathosException(e, "Encounter an error while checking file existence");
            }
        }
        return false;
    }

    /**
     * 上传文件
     *
     * @param url         文件路径
     * @param inputStream 输入流
     */
    public static void upload(String url, InputStream inputStream) {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(HumanMachineConfig.getProperty(MINIO_BUCKET))
                            .object(url)
                            .stream(
                                    inputStream, -1, 10485760)
                            .contentType("application/octet-stream")
                            .build());
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new ZorathosException(e, "Encounter an error while uploading file: " + url);
        }
    }

    /**
     * 这里做比较基础的两种就行了 其他应该靠前端直连MinIO来做
     *
     * @param url         文件路径
     * @param file        文件
     * @param contentType 文件类型
     */
    public static void upload(String url, File file, String contentType) {
        try {
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(HumanMachineConfig.getProperty(MINIO_BUCKET))
                            .object(url)
                            .filename(file.getName())
                            .contentType(contentType)
                            .build());
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new ZorathosException(e, "Encounter an error while uploading file: " + file.getName());
        }
    }

    public static void delete(String url) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(HumanMachineConfig.getProperty(MINIO_BUCKET))
                    .object(url)
                    .build());
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new ZorathosException(e, "Encounter an error while deleting file: " + url);
        }
    }

    /**
     * 下载文件
     *
     * @param url 文件路径
     * @return 文件输入流
     */
    public static InputStream download(String url) {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(HumanMachineConfig.getProperty(MINIO_BUCKET))
                            .object(url)
                            .build());
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new ZorathosException(e, "Encounter an error while downloading file: " + url);
        }
    }

    /**
     * 下载文件到指定路径
     *
     * @param url 文件路径
     * @param targetPath 目标保存路径
     * @return 下载的文件对象
     */
    public static File download(String url, String targetPath) {
        File targetFile = new File(targetPath);
        try {
            // 确保目标目录存在
            File parentDir = targetFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                boolean mkdirs = parentDir.mkdirs();
                if (!mkdirs) {
                    throw new ZorathosException("Failed to create directory: " + parentDir.getAbsolutePath());
                }
            }

            minioClient.downloadObject(
                    DownloadObjectArgs.builder()
                            .bucket(HumanMachineConfig.getProperty(MINIO_BUCKET))
                            .object(url)
                            .filename(targetPath)
                            .build());

            return targetFile;
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new ZorathosException(e, "Encounter an error while downloading file to path: " + targetPath);
        }
    }
}
