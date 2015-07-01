package com.nana.common.fs;

import java.nio.ByteBuffer;

public class ChatRecord {
	private int type;// 消息类型，0 用户 1 机器人 2 客服
	private String text; // 消息文本
	private String gps; // 发消息时gps数据,只有用户消息才需要。 TODO
	private long timestamp;// 消息时间戳
	private byte[] audio;// 音频数据 TODO

	public ChatRecord() {
	}

	public ChatRecord(int type, long timestamp, String text) {
		this.type = type;
		this.timestamp = timestamp;
		this.text = text;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public byte[] getAudio() {
		return audio;
	}

	public void setAudio(byte[] audio) {
		this.audio = audio;
	}

	public byte[] toArray() {
		byte[] typeBytes = Utils.int2bytes(type);
		byte[] textBytes = text.getBytes();
		byte[] timeBytes = Utils.long2bytes(timestamp);

		ByteBuffer bf = ByteBuffer.allocate(typeBytes.length + timeBytes.length
				+ textBytes.length);

		bf.put(typeBytes);
		bf.put(timeBytes);
		bf.put(textBytes);
		return bf.array();
	}

	public String toString() {
		return String.valueOf(type) + String.valueOf(timestamp) + text;
	}

}
