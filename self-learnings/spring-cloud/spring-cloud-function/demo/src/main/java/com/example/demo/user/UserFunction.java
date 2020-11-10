package com.example.demo.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author : anuj.kumar
 **/
@Component
@AllArgsConstructor
public class UserFunction implements Function<UserInput, UserOutput> {

	private final UserService userService;

	@Override
	public UserOutput apply(UserInput userInput) {
		return userService.getUserOutput(userInput);
	}
}
