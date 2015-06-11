package com.nana.common.mq;

public interface MqProducer {

	void shutDown();

	void sendMessage(String key, String tag, byte[] body);
}
