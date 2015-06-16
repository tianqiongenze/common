package com.nana.common.mq.ons;

import java.util.Scanner;

import com.nana.common.mq.ConsumerListener;
import com.nana.common.mq.MqFactory;

public class MessageReader {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		ConsumerListener linstener = new ConsumerListener() {

			@Override
			public void process(String key, String tag, byte[] body) {
				
				String input = new String(body);
				System.out.println(input);
				System.out.println(key);
				System.out.println(tag);
							
			}
		};
		String cid = "CID_DEV_NANA_2";
		String topic = "DEV_NANA_2";
		MqFactory.startMqConsumer(cid, topic, linstener);
	}

}
