package br.com.itau.tudonovo.producer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.tudonovo.producer.model.Message;

@RestController
@RequestMapping("kafka")
public class UserResource {

	@Autowired
	KafkaTemplate<String, Message> kafkaTemplate;

	private static final String TOPIC = "topic_1";

	@GetMapping("/public/{message}")
	public String post(@PathVariable("message") final String message) {

		Message msg = new Message();
		msg.setCustomer("Customer 1");
		msg.setCode("100");

		kafkaTemplate.send(TOPIC, msg);
		return "Pub";
	}
}
