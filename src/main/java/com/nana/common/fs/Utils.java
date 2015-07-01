package com.nana.common.fs;

public class Utils {
	public static byte[] int2bytes(int i) {
		byte[] b = new byte[4];

		b[0] = (byte) (0xff & i);
		b[1] = (byte) ((0xff00 & i) >> 8);
		b[2] = (byte) ((0xff0000 & i) >> 16);
		b[3] = (byte) ((0xff000000 & i) >> 24);
		return b;
	}

	public static int bytes2int(byte[] bytes) {
		int num = bytes[0] & 0xFF;
		num |= ((bytes[1] << 8) & 0xFF00);
		num |= ((bytes[2] << 16) & 0xFF0000);
		num |= ((bytes[3] << 24) & 0xFF000000);
		return num;
	}

	public static long bytes2long(byte[] b) {
		long temp = 0;
		long res = 0;
		for (int i = 0; i < 8; i++) {
			res <<= 8;
			temp = b[i] & 0xff;
			res |= temp;
		}
		return res;
	}

	public static byte[] long2bytes(long num) {
		byte[] b = new byte[8];
		for (int i = 0; i < 8; i++) {
			b[i] = (byte) (num >>> (56 - (i * 8)));
		}
		return b;
	}
	public ChatRecord parseChatRecord(byte[] bytes) {
		return null;
	}
	public static ChatRecord parseChatRecord(String str) {
		ChatRecord cr = new ChatRecord();
		cr.setType(Integer.valueOf(str.substring(0, 1)));
		cr.setText(str.substring(9));
		cr.setTimestamp(Long.valueOf(str.substring(1, 9)));
		return cr;

	}
	public static void main(String[] args) {
		ChatRecord mCr=new ChatRecord();
		mCr.setType(1);
		mCr.setText("你好。");
		mCr.setGps("0");
		mCr.setTimestamp(12345678L);
		mCr.setAudio(null);
		String str=mCr.toString();
		ChatRecord cr=parseChatRecord(str);
		System.out.println(cr.getType()+"\r\n"+cr.getText()+"\r\n"+cr.getTimestamp());
		
	}
}
