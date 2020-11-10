package com.example.demo.lower;

import java.util.function.Function;

/**
 * @author : anuj.kumar
 **/
public class LowerCaseFunction implements Function<String, String> {
	@Override public String apply(String s) {
		return s.toLowerCase();
	}
}
