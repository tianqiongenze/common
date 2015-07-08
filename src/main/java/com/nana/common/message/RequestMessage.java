package com.nana.common.message;

/**
 * request message from user (or robot)
 *
 */
public class RequestMessage {
	private String id;// user id
	private int type;// message type: original, robot processed,
	private String username;//name of user
	private String content;// message text
	private GPS gps;// GPS info
	private int mobileType;// iOS 0, android 1

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public int getMobileType() {
		return mobileType;
	}

	public void setMobileType(int mobileType) {
		this.mobileType = mobileType;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
