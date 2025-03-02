## zorathos-data-model

zorathos-data-model是数据中台的数据模型基底。该module将以maven module的形式为其他主干项目提供数据模型支持。

我们希望zorathos-data-model只包含纯粹的java基类，但是为了后续的业务我们不得不引入lombok和jackson依赖。

+ data-model-human-machine 是为 翔腾 XXX系统提供数据基底的项目
+ data-model-maps 是为 205 MAPS无人机防御系统提供数据基底的项目
  + data-model-maps的model.original包包含上行数据模型
  + data-model-maps的model.aggregation包符合标准silas格式，是聚合后的数据类型，也是上传给silas的标准数据，完全符合silas协议
