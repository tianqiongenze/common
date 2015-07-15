package com.nana.common.mq.ons;

import java.util.Properties;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.nana.common.mq.MqProducer;
import com.nana.common.utils.Property;

public class OnsProducerClient implements MqProducer {
	Producer producer;

	public OnsProducerClient(String pid) {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.ProducerId, pid);
		properties.put(PropertyKeyConst.AccessKey, Property.getInstance().getCfg("AccessKey"));
		properties.put(PropertyKeyConst.SecretKey,Property.getInstance().getCfg("SecretKey"));
		producer = ONSFactory.createProducer(properties);

		// 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
		producer.start();
	}

	@Override
	public void shutDown() {
		// 在应用退出前，销毁Producer对象
		// 注意：如果不销毁也没有问题
		producer.shutdown();
	}

	@Override
	public void sendMessage(String topic, String key, String tag, byte[] body) {
		Message msg = new Message(
		// Message Topic
				topic, 
				// Message Tag,
				// 可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在ONS服务器过滤
				tag,
				// Message Body
				// 任何二进制形式的数据，ONS不做任何干预，需要Producer与Consumer协商好一致的序列化和反序列化方式
				body);

		// 设置代表消息的业务关键属性，请尽可能全局唯一。
		// 以方便您在无法正常收到消息情况下，可通过ONS Console查询消息并补发。
		// 注意：不设置也不会影响消息正常收发
		msg.setKey(key);

		producer.send(msg);

	}
}
