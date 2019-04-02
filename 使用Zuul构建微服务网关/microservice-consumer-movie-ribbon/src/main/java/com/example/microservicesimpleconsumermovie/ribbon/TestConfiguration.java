package com.example.microservicesimpleconsumermovie.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/25
 */
@Configuration
@RibbonClient(name = "microservice-provider-user",
configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
