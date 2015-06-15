package com.nana.common.mq;

public interface MqProducer {

	void shutDown();

	void sendMessage(String topic,String key, String tag, byte[] body);
}
