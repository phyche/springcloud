package com.example.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @Autowired
    private HystrixRemote hystrixRemote;

    @Autowired
    private ZuulRemote zuulRemote;

    @Autowired
    private SecurityRemote securityRemote;

    @Autowired
    private StreamRemote streamRemote;

    @Autowired
    private RedisRemote redisRemote;

    @RequestMapping("/hello")
    public String hello() {
        //return restTemplate.getForEntity("http://132.126.3.55:4444/hello", String.class).getBody();
        return helloRemote.hello();

    }

    @RequestMapping("/hystrix")
    public String hystrix() {
        return hystrixRemote.hello();
    }

    @RequestMapping("/hystrix/license")
    public String license() {
        String response = hystrixRemote.license();
        return response;
    }

    @RequestMapping("/zuul")
    public String zuul() {
        return zuulRemote.hello();
    }

    @RequestMapping("/security")
    public String security() {
        return securityRemote.hello();
    }

    @RequestMapping("/security/user")
    public String user() {
        return securityRemote.user();
    }

    @RequestMapping("/stream")
    public String stream() {
        return streamRemote.hello();
    }

    @RequestMapping("/stream/saveOrg")
    public String saveOrg() {
        return streamRemote.saveOrg();
    }

    @RequestMapping("/redis")
    public String redis() {
        return redisRemote.hello();
    }

    @RequestMapping("/redis/save")
    public String save() {
        return redisRemote.save();
    }

    @RequestMapping("/redis/delete")
    public String delete() {
        return redisRemote.delete();
    }

    @RequestMapping("/redis/query")
    public String query() {
        return redisRemote.query();
    }
}
