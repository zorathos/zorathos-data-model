## zorathos-data-model

### 项目介绍

zorathos-data-model是数据中台的数据模型基底。该module将以maven module的形式为其他主干项目提供数据模型支持。

我们希望zorathos-data-model只包含纯粹的java基类，但是为了后续的业务我们不得不引入lombok和jackson依赖。

+ data-model-human-machine 是为 翔腾 XXX系统提供数据基底的项目
+ data-model-maps 是为 205 MAPS无人机防御系统提供数据基底的项目
  + data-model-maps的model.original包包含上行数据模型
  + data-model-maps的model.aggregation包符合标准silas格式，是聚合后的数据类型，也是上传给silas的标准数据，完全符合silas协议

### 依赖的使用方法

项目应该不能作为一个整体引入 你需要在human-machine和maps的模块做分别引入 最新的依赖版本为0.0.5

MAPS依赖如下

```xml
<dependency>
  <groupId>io.github.wangminan</groupId>
  <artifactId>data-model-human-maps</artifactId>
  <version>0.0.5</version>
</dependency>
```

human-machine依赖如下

```xml
<dependency>
  <groupId>io.github.wangminan</groupId>
  <artifactId>data-model-human-machine</artifactId>
  <version>0.0.5</version>
</dependency>
```

### Contributing

如果您需要在本地编译并测试，请使用命令

```shell
mvn -Dgpg.skip=true clean install
```

这样，zorathos-data-model将作为一个依赖被安装到本地仓库中。您可以在别的本地项目中使用该依赖。

我们没有使用release-plugin，该插件在执行多人协作时需要配置较复杂的前置环境。因此，在确认变更无误后，您需要**全局搜索并替换当前的版本号**，**修改此文档中的版本号**，然后推送到仓库。流水线将自动执行发布依赖到maven中央仓库的流程。
