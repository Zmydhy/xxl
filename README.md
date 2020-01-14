# xxl
任务调度平台
 
1、每一个项目可以理解为一个执行器。  
2、在调度任务界面根据执行器id展示出该项目的所有的任务调度计划，并且展示出当前任务状态。   
3、 可以展示任务列表，更新任务，新增任务，启动任务，停止任务，执行一次，删除任务等操作。  
4、在当前任务没有执行完的情况下，停止任务，不会停止正在执行的任务，而是不再启动下一个时间点的任务。
### 策略说明
单机串行：  如果任务没执行完，并且与下次执行时间有冲突，则延迟等待第一个任务完成后执行。  
丢弃后续调度：  如果任务没执行完，并且与下次执行时间有冲突，则第二个任务不执行。  
覆盖之前的调度：  如果任务没执行完，并且与下次执行时间有冲突，当时间到的时候，则立即销毁第一个任务，执行执行第二个任务。  

![avatar](https://github.com/Zmydhy/xxl/blob/master/img/xxl_east.png?raw=true)   
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
