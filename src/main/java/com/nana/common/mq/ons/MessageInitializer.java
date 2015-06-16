package com.nana.common.mq.ons;

import com.nana.common.mq.MqFactory;
import com.nana.common.mq.MqProducer;

public class MessageInitializer{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MqProducer opc=MqFactory.getMqProducer("PID_DEV_NANA_2");
		String topic="DEV_NANA_2";
		String key="1212";
	    String tag="1";
	    byte[] body="test".getBytes();
	    opc.sendMessage(topic, key, tag, body);
	    	
	}
	

}
