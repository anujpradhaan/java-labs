package com.kafka.source;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : anuj.kumar
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/producer")
public class ProducerController {

	private final Producer producer;

	@PostMapping("/add-game")
	public void createMessage(@RequestBody GameProgress gameProgress) {
		producer.sendMessage(gameProgress);
	}

	@PostMapping("/create-random-events/{totalNumber}")
	public void addEventsForGivenNumber(@PathVariable("totalNumber") int totalNumber) {
		producer.sendMessage(totalNumber);
	}
}
