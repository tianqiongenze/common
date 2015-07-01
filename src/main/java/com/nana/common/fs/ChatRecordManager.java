package com.nana.common.fs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ChatRecordManager {
	ChatFile cf = new LocalChatFile();

	public void addRecord(String id, ChatRecord record) {
		File file = cf.getFile(id);
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(record.toString() + "\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<ChatRecord> getRecords(String id) {
		return null;
	}

	public static void main(String[] args) {
		ChatRecordManager crm = new ChatRecordManager();
		crm.addRecord("3432", new ChatRecord(1, 234234L, "hello"));
		crm.addRecord("3432", new ChatRecord(1, 234234L, "hi"));
		crm.addRecord("232", new ChatRecord(1, 234234L, "hello"));
	}

}
