package com.example.microservicesimpleconsumermovie.feign;

import com.example.microservicesimpleconsumermovie.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/25
 */


@FeignClient(name = "MICROSERVICE-PROVIDER-USER",
        fallbackFactory = FallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}


@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                System.err.println("进入回退方法，回退原因：" + throwable);
                User user = new User();
                if (throwable instanceof IllegalArgumentException) {
                    user.setId(-1L);
                } else {
                    user.setId(-2L);
                }
                user.setUsername("游客");
                return user;
            }
        };
    }
}


//@FeignClient(name = "microservice-provider-user",fallback = FeignClientFallback.class)
//public interface UserFeignClient {
//
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public User findById(@PathVariable("id")Long id);
//}
//@Component
//class FeignClientFallback implements UserFeignClient{
//
//
//    @Override
//    public User findById(Long id) {
//        User user = new User();
//        user.setId(-1L);
//        user.setUsername("游客");
//        return user;
//    }
//}