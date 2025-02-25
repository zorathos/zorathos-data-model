## zorathos-data-model

zorathos-data-model是数据中台的数据模型基底。该module将以maven module的形式为其他主干项目提供数据模型支持。

+ data-model-human-machine 是为 翔腾 XXX系统提供数据基底的项目
+ data-model-maps 是为 205 MAPS无人机防御系统提供数据基底的项目
  + data-model-maps的original包包含上行数据模型
  + data-model-maps的aggregation包符合标准silas格式，是聚合后的数据类型，也是上传给silas的标准数据，完全符合silas协议
