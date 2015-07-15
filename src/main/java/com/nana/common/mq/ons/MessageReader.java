package com.nana.common.mq.ons;

import com.nana.common.mq.ConsumerListener;
import com.nana.common.mq.MqFactory;
import com.nana.common.utils.Property;

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

		String cid = Property.getInstance().getCfg("cid2");
		String topic = Property.getInstance().getCfg("topic2");
		MqFactory.startMqConsumer(cid, topic, linstener);
	}

}
