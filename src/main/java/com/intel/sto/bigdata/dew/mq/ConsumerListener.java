package com.intel.sto.bigdata.dew.mq;

public interface ConsumerListener {
	void process(String key, String tag, byte[] body);
}
