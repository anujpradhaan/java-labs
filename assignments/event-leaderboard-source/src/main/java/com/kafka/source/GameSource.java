package com.kafka.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * @author : anuj.kumar
 **/
public interface GameSource {
	String OUTPUT = "game-progress-topic";

	@Output(GameSource.OUTPUT)
	MessageChannel output();
}
