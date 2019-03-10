package com.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {

	// 散列算法类型为MD5
	private static final String ALGORITH_NAME = "md5";
	// hash的次数
	private static final int HASH_ITERATIONS = 2;

	/**
	 * @param pswd
	 *            加密密码
	 * @param SALT
	 *            干扰数据 盐 防破解
	 * @return
	 */
	public static String encrypt(String pswd, String SALT) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}
	
	public static void main(String[] args) {
	System.out.println(encrypt("lhsftyq","1"));
	}
}
