package com.example.demo.upper;

import java.util.function.Function;

/**
 * @author : anuj.kumar
 **/
public class UpperCaseFunction implements Function<String, String> {
	@Override public String apply(String s) {
		return s.toUpperCase();
	}
}
