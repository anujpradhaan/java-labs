package com.kafka.source;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = SourceDemoForSpringCloudStreamUsingKafkaApplication.class)
@DirtiesContext
class SourceDemoForSpringCloudStreamUsingKafkaApplicationTests {

	@Autowired
	private GameSource gameSource;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	void contextLoads() {
	}

	@Test
	@SneakyThrows
	public void whenSendMessage_thenResponseShouldUpdateText() {
		ObjectMapper objectMapper = new ObjectMapper();
		GameProgress gameProgress = GameFactory.getRandomGameProgressEvent();
		gameSource.output()
				.send(MessageBuilder.withPayload(gameProgress)
						.build());

		Object payload = messageCollector.forChannel(gameSource.output())
				.poll()
				.getPayload();

		GameProgress gameProgress1 = objectMapper.readValue(payload.toString(), GameProgress.class);
		assertEquals(gameProgress1.getUserId(), gameProgress.getUserId());
		assertTrue(gameProgress1.getUserId() < GameFactory.Constants.ONE_ABOVE_USER_ID_MAX);
		assertTrue(gameProgress1.getLevel() < GameFactory.Constants.ONE_ABOVE_LEVEL_MAX);
		assertTrue(gameProgress1.getTimeSpent() < GameFactory.Constants.ONE_ABOVE_TIME_SPENT_MAX);
		assertTrue(gameProgress1.getGameCompletionPercent() <= GameFactory.Constants.PROGRESS_MAX);
	}

}
