package com.kafka.destination;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author : anuj.kumar
 **/
public interface GameSink {
	String INPUT = "game-progress-topic";

	@Input(GameSink.INPUT)
	SubscribableChannel input();
}
