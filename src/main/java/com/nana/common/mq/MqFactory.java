package com.nana.common.mq;

import java.util.HashMap;
import java.util.Map;

import com.nana.common.mq.ons.OnsConsumerClient;
import com.nana.common.mq.ons.OnsProducerClient;

public class MqFactory {

	private static Map<String, MqConsumer> consumerMap = new HashMap<String, MqConsumer>();
	private static Map<String, MqProducer> producerMap = new HashMap<String, MqProducer>();

	public synchronized static void startMqConsumer(String cid, String topic,
			ConsumerListener linstener) {
		MqConsumer consumer = consumerMap.get(cid);
		if (consumer == null) {
			makeOnsConsumer(cid, topic, linstener);
			consumerMap.put(cid, consumer);
		} else {
			System.out.println(cid + "is started.");
		}
	}

	public synchronized static MqProducer getMqProducer(String pid) {
		MqProducer producer = producerMap.get(pid);
		if (producer == null) {
			producer = makeProducer(pid);
			producerMap.put(pid, producer);
		}
		return producer;
	}

	private static MqProducer makeProducer(String pid) {
		return new OnsProducerClient(pid);
	}

	private static MqConsumer makeOnsConsumer(String cid, String topic,
			ConsumerListener linstener) {
		return new OnsConsumerClient(cid, topic, linstener);
	}
}
