package com.example.demo.user;

import org.springframework.stereotype.Service;

/**
 * @author : anuj.kumar
 **/
@Service
public class UserService {

	public UserOutput getUserOutput(UserInput userInput) {
		return UserOutput.builder()
				.output(String.format("My name is %s and my email %s", userInput.getName(), userInput.getEmail()))
				.build();
	}
}
