package com.example.demo.user;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

/**
 * @author : anuj.kumar
 **/
public class UserFunctionHandler extends SpringBootRequestHandler<UserInput, UserOutput> {
}
