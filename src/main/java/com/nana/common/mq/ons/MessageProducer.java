package com.nana.common.mq.ons;

import com.nana.common.mq.MqFactory;
import com.nana.common.mq.MqProducer;
import com.nana.common.utils.Property;

public class MessageProducer {

	public static void main(String[] args) {
		MqProducer opc = MqFactory.getMqProducer(Property.getInstance().getCfg("pid2"));
		String topic = Property.getInstance().getCfg("topic2");
		String key = "1212";
		String tag = "1";
		byte[] body = "test".getBytes();
		opc.sendMessage(topic, key, tag, body);

	}

}
