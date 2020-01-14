package com.eastsoft.xxl.controller;

import com.alibaba.fastjson.JSONObject;

import com.eastsoft.xxl.bean.XxlJobInfo;
import com.zmy.sys_common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@EnableAutoConfiguration
public class IndexController {
    @Value("${xxl.job.executor.appname}")
    String appName;


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 登陆
     * @param request
     * @return
     */
    @GetMapping(value = "/logins")
    public Object logins(HttpServletRequest request) {
        String url = "http://129.1.244.244:8889/job/logins";
        HashMap<String,String> map = new HashMap<>();
        map.put("userName", "admin");
        map.put("password", "456852");
        map.put("ifRemember", "false");
        JSONObject json = restTemplate.postForEntity(url,map, JSONObject.class).getBody();
        return Result.success(json);
    }
    /**
     * 添加任务
     * @return
     */
    @GetMapping(value = "/adds")
    public Object adds() {
        String url = "http://129.1.244.244:8889/job/jobinfo/adds";
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setJobGroup(4);
        xxlJobInfo.setJobDesc("fuck");
        xxlJobInfo.setExecutorBlockStrategy("FIRST");
        xxlJobInfo.setGlueType("BEAN");
        xxlJobInfo.setJobCron("* * 8 * * ?");
        xxlJobInfo.setExecutorHandler("demoJobHandler");
        xxlJobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");
        xxlJobInfo.setExecutorRouteStrategy("FIRST");
        xxlJobInfo.setChildJobId(null);
        xxlJobInfo.setExecutorTimeout(0);
        xxlJobInfo.setExecutorFailRetryCount(0);
        xxlJobInfo.setAuthor("father");
        xxlJobInfo.setAlarmEmail("muyi.66@163.com");
        xxlJobInfo.setExecutorParam(null);

        JSONObject json = restTemplate.postForEntity(url,xxlJobInfo, JSONObject.class).getBody();
        return Result.success(json);
    }
    /**
     * 更新任务
     * @return
     */
    @GetMapping("/updates")
    public Object updates() {
        String url = "http://129.1.244.244:8889/job/jobinfo/updates";
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setId(14);
        xxlJobInfo.setJobGroup(4);
        xxlJobInfo.setJobDesc("haha");
        xxlJobInfo.setExecutorBlockStrategy("FIRST");
        xxlJobInfo.setGlueType("BEAN");
        xxlJobInfo.setJobCron("* * 10 * * ?");
        xxlJobInfo.setExecutorHandler("testJobHandler");
        xxlJobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");
        xxlJobInfo.setExecutorRouteStrategy("FIRST");
        xxlJobInfo.setChildJobId("10");
        xxlJobInfo.setExecutorTimeout(0);
        xxlJobInfo.setExecutorFailRetryCount(0);
        xxlJobInfo.setAuthor("你爸爸");
        xxlJobInfo.setAlarmEmail("muyi.66@163.com");
        xxlJobInfo.setExecutorParam("哈哈");

        JSONObject json = restTemplate.postForEntity(url,xxlJobInfo, JSONObject.class).getBody();
        return Result.success(json);
    }

    /**
     * 根据yml配置文件获取执行器的内容
     * 获取到执行器的id
     * @return
     */
    @GetMapping("/loadByName")
    public Object loadByName(){
        System.out.println("appName:"+appName);
        String url = "http://129.1.244.244:8889/job/jobgroup/loadByName";
        HashMap<String,String> map = new HashMap<>();
        map.put("appName",appName);
        JSONObject json = restTemplate.postForEntity(url, map,JSONObject.class).getBody();
        return Result.success(json);
    }

    /**
     * 更具执行器的id获取当前执行器下的所有的job列表
     * 默认从0开始，每页30条数据
     * @param jobGroup
     * @return
     */
    @GetMapping("/pageLists")
    public Object pageLists(@RequestParam int jobGroup) {
        String url = "http://129.1.244.244:8889/job/jobinfo/pageLists";
        HashMap<String,Object> map = new HashMap<>();
        map.put("start",0);
        map.put("length",30);
        map.put("jobGroup",jobGroup);
        map.put("triggerStatus",-1);
        map.put("jobDesc","");
        map.put("executorHandler","");
        map.put("author","");

        JSONObject json = restTemplate.postForEntity(url, map,JSONObject.class).getBody();
        return Result.success(json);
    }


    /**
     * 根据id触发任务
     * @param id
     * @return
     */
    @GetMapping(value = "/triggers")
    public Object testTriggers(@RequestParam int id) {
        String url = "http://129.1.244.244:8889/job/jobinfo/triggers";
        HashMap<String,String> map = new HashMap<>();
        map.put("id", id+"");
        map.put("executorParam", null);
        JSONObject json = restTemplate.postForEntity(url,map, JSONObject.class).getBody();
        return Result.success(json);
    }



    /**
     * 根据id启动任务
     * @param id
     * @return
     */
    @GetMapping("/starts")
    public Object starts(@RequestParam int id) {
        String url = "http://129.1.244.244:8889/job/jobinfo/starts";
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        JSONObject json = restTemplate.postForEntity(url, map,JSONObject.class).getBody();
        return Result.success(json);
    }

    /**
     * 根据id停止任务
     * @param id
     * @return
     */
    @GetMapping("/stops")
    public Object stops(@RequestParam int id) {
        String url = "http://129.1.244.244:8889/job/jobinfo/stops";
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        JSONObject json = restTemplate.postForEntity(url, map,JSONObject.class).getBody();
        return Result.success(json);
    }

    /**
     * 根据id删除任务
     * @param id
     * @return
     */
    @GetMapping("/removes")
    public Object removes(@RequestParam int id) {
        String url = "http://129.1.244.244:8889/job/jobinfo/removes";
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        JSONObject json = restTemplate.postForEntity(url, map,JSONObject.class).getBody();
        return Result.success(json);
    }


}