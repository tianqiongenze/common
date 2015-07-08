package com.nana.common.fs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatRecordManager {

	ChatFile cf = new LocalChatFile();

	private static final ChatRecordManager manager = new ChatRecordManager();//使用单例

	private ChatRecordManager() {

	}

	public static ChatRecordManager getinstance() {
		return manager;
	}
    //保存消息到文件
	public void addRecord(String id, ChatRecord record) {
		File file = cf.getFile(id);
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, true);
			writer.write(record.toString() + "\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 读文件的保存的文件内容
	public List<ChatRecord> getRecords(String id) {
		File file = cf.getFile(id);
		List<ChatRecord> list = new ArrayList<ChatRecord>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = null;
			while ((str = br.readLine()) != null) {
				ChatRecord record = Utils.parseChatRecord(str);
				list.add(record);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		
//		ChatRecordManager manage = ChatRecordManager.getinstance();
//		 crm.addRecord("3432", new ChatRecord(1, 29834234L, "hello"));
//		 crm.addRecord("3432", new ChatRecord(1, 2342934L, "hi"));
//		 crm.addRecord("232", new ChatRecord(1, 234234L, "hello"));
//		 List<ChatRecord> list = crm.getRecords("232");
		
	}

}
