package com.kafka.source;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

/**
 * @author : anuj.kumar
 **/
@Service
@Slf4j
@AllArgsConstructor
@EnableBinding(GameSource.class)
public class Producer {

	private final GameSource gameSource;

	public void sendMessage(GameProgress gameProgress) {
		log.info("Sending message {}", gameProgress);
		gameSource.output().send(MessageBuilder.withPayload(gameProgress).build());
	}

	public void sendMessage(int totalNumber) {
	//	IntStream.range(1, totalNumber).forEach(this::sendGameProgressMessage);
		sendGameProgressMessage(1);
	}

	private void sendGameProgressMessage(int i) {
		GameProgress gameProgress = GameFactory.getRandomGameProgressEvent();
		log.info("Sending game progress event {}", gameProgress);
		gameSource.output().send(MessageBuilder.withPayload(gameProgress).build());
	}
}
