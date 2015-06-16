package com.nana.common.mq;

public interface ConsumerListener {
	void process(String key, String tag, byte[] body);
	
}
