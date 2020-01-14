# xxl
任务调度平台
 
1、每一个项目可以理解为一个执行器。  
2、在调度任务界面根据执行器id展示出该项目的所有的任务调度计划，并且展示出当前任务状态。   
3、 可以展示任务列表，更新任务，新增任务，启动任务，停止任务，执行一次，删除任务等操作。 
### 配置文件
```
### xxl-job admin address list, such as "http://address" or "http://address01,http://address02"
xxl.job.admin.addresses=http://localhost:8889/job

### xxl-job executor address
xxl.job.executor.appname=xxl-eastsoft
xxl.job.executor.ip=
xxl.job.executor.port=16999

### xxl-job, access token
xxl.job.accessToken=

### xxl-job log path
xxl.job.executor.logpath=/data/applogs/xxl-job/jobhandler
### xxl-job log retention days
xxl.job.executor.logretentiondays=30
```
