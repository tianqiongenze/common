package com.nana.common.message;

/**
 * response message to user
 *
 */
public class ResponseMessage {
	private String id;// user id
	private int mobileType;// iOS 0, android 1
	private String displayText; // display the text in app screen
	private String audioText; // build audio by the text
    private String name;//user name
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMobileType() {
		return mobileType;
	}

	public void setMobileType(int mobileType) {
		this.mobileType = mobileType;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getAudioText() {
		return audioText;
	}

	public void setAudioText(String audioText) {
		this.audioText = audioText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
