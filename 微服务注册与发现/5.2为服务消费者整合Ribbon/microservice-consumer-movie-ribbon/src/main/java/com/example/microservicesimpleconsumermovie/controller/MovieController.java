package com.example.microservicesimpleconsumermovie.controller;

import com.example.microservicesimpleconsumermovie.pojo.User;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/21
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }



    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/log-user-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient
                .choose("microservice-provider-user");
        MovieController.LOGGER.info("{}:{}:{}:",serviceInstance.getServiceId(),
                serviceInstance.getHost(),serviceInstance.getPort());
    }


    @PostMapping("/search")
    public User[] findById2(String name,String username,Integer age){
        Map<String,Object> paramMap= Maps.newHashMap();
        paramMap.put("name",name);
        paramMap.put("username",username);
        paramMap.put("age",age);
        return this.restTemplate.getForObject("http://microservice-provider-user/search?name={name}&username={username}&age={age}",User[].class);

    }



}
