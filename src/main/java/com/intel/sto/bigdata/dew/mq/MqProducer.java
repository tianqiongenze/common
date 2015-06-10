package com.intel.sto.bigdata.dew.mq;

public interface MqProducer {

	void shutDown();

	void sendMessage(String key, String tag, byte[] body);
}
