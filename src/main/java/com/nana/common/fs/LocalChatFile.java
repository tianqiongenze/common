package com.nana.common.fs;

import java.io.File;

public class LocalChatFile implements ChatFile {

	// TODO config it
	// chat file path
	private String pathStr = "/home/nana/data";

	private File path;

	public LocalChatFile() {
		path = new File(pathStr);
		if (!path.exists()) {
			path.mkdirs();
		}
	}

	@Override
	// TODO 自定义File 类，支持分布式环境及云服务的File操作
	public File getFile(String id) {
		File filePath = new File(path, hashPath(id));
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		return new File(filePath, id);
	}

	private String hashPath(String id) {
		int first = id.hashCode() % 2000;
		return String.valueOf(first);
	}
}
