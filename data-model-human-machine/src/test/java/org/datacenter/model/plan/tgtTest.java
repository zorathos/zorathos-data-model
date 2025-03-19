package org.datacenter.model.plan;

import org.datacenter.model.simulation.tgt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ning]
 * &#064;description  : 从CSV文件读取数据并填充tgt对象 (根据提供的tgt.csv文件)
 */
public class tgtTest {

    public static void main(String[] args) {
        String csvFilePath = "d:\\tgt.csv"; // 替换为你的CSV文件路径

        try {
            List<tgt> tgts = readTgtDataFromCsv(csvFilePath);

            for (tgt t : tgts) {
                System.out.println(t);
            }

        } catch (IOException e) {
            System.err.println("读取CSV文件时发生错误: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("数字格式错误: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("时间格式错误: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("解析数据时发生错误: " + e.getMessage());
        }
    }

    public static List<tgt> readTgtDataFromCsv(String filePath) throws IOException {
        List<tgt> tgts = new ArrayList<>();
        // 更新时间格式以匹配CSV文件中的格式 (没有小时和分钟的前导零)
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm.s");
        final int TOTAL_COLUMNS = 46; // 根据提供的CSV文件确定总列数

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // 跳过标题行
            // 处理 BOM 头
            reader.mark(1); //在文件的开头做个标记
            if (reader.read() != 0xFEFF) { //如果不是0xFEFF开头，倒回到标记处。
                reader.reset();
            }

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length != TOTAL_COLUMNS) {
                    throw new IOException("CSV行数据列数不正确，应为" + TOTAL_COLUMNS + "列，实际为" + values.length + "列：" + line);
                }

                String aircraftId = values[0].trim();
                // 解析时间，并处理可能出现的格式问题
                LocalTime messageTime = LocalTime.parse(values[1].trim(), timeFormatter);
                LocalTime satelliteGuidanceTime = LocalTime.parse(values[2].trim(), timeFormatter);
                LocalTime localTime = LocalTime.parse(values[3].trim(), timeFormatter);

                long messageSequenceNumber = Long.parseLong(values[4].trim());
                int targetCount = 5;  //应该根据表里的目标数量读取，这里方便测试设为固定

                tgt tgtObject = tgt.builder()
                        .aircraftId(aircraftId)
                        .messageTime(messageTime)
                        .satelliteGuidanceTime(satelliteGuidanceTime)
                        .localTime(localTime)
                        .messageSequenceNumber(messageSequenceNumber)
                        .targetCount(targetCount)
                        .targets(new ArrayList<>())
                        .build();

                int targetDataStartIndex = 6;
                for (int i = 0; i < targetCount; i++) {
                    int baseIndex = targetDataStartIndex + i * 5;
//
//                    if (baseIndex + 4 >= values.length) {
//                        System.err.println("警告：CSV行中目标数据不完整，已跳过部分目标数据。行内容：" + line);
//                        break;
//                    }

                    String identifier = values[baseIndex].trim();
                    String sensor = values[baseIndex + 1].trim();
                    //处理传感器数据中可能存在的空格
                    sensor = sensor.replace(" ", "");

                    double pitch = Double.parseDouble(values[baseIndex + 2].trim());
                    double azimuth = Double.parseDouble(values[baseIndex + 3].trim());
                    double slantRange = Double.parseDouble(values[baseIndex + 4].trim());

                    tgtObject.addTargetData(identifier, sensor, pitch, azimuth, slantRange);
                }
                tgts.add(tgtObject);
            }
        }

        return tgts;
    }
}