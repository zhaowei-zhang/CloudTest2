package com.example.microservicesimpleconsumermovie.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/25
 */
@Configuration
public class RibbonConfiguration {

    public IRule ribbonRule(){
        return new RandomRule();
    }

}
