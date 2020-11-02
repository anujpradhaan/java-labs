package com.kafka.destination;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @author : anuj.kumar
 **/
@Service
@EnableBinding(GameSink.class)
@Slf4j
public class MessageConsumer {

	@StreamListener(target = GameSink.INPUT)
	public void getMessage(GameProgress game) {
		log.info("Consumed Message {}", game);
	}
}
