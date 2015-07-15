package com.nana.common.mq.ons;

import java.util.Properties;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.nana.common.mq.ConsumerListener;
import com.nana.common.mq.MqConsumer;
import com.nana.common.utils.Property;

public class OnsConsumerClient implements MqConsumer {

	public OnsConsumerClient(String cid, String topic,
			ConsumerListener linstener) {

		Properties properties = new Properties();
		properties.put(PropertyKeyConst.ConsumerId, cid);
		properties.put(PropertyKeyConst.AccessKey, Property.getInstance().getCfg("AccessKey"));
		properties.put(PropertyKeyConst.SecretKey,
				 Property.getInstance().getCfg("SecretKey"));
		Consumer consumer = ONSFactory.createConsumer(properties);
		consumer.subscribe(topic, "*", new MessageListener() {
       
			public Action consume(Message message, ConsumeContext context) {
				linstener.process(message.getKey(), message.getTag(),
						message.getBody());
				return Action.CommitMessage;
			}
		});

		consumer.start();

		System.out.println("Consumer Started");

	}
}
