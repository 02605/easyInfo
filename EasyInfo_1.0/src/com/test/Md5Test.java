package com.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.utils.Md5Bean;

public class Md5Test {

	@Test
	public void testMD5() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		Md5Bean md5Bean = new Md5Bean();
		String resultString = md5Bean.EncoderByMd5("test");
		// 后面的参数是存储在数据库中的加密数据
		if (md5Bean.checkpassword("test", "098F6BCD4621D373CADE4E832627B4F6")) {
			System.out.println("密码验证正确");
		} else {
			System.out.println("密码验证失败");
		}
		System.out.println(resultString);
	}

}
