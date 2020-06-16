package com.point.aes;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class AES {

	public static byte[] encrypt(byte[] data, byte[] key) {
		CheckUtils.notEmpty(data, "data");
		CheckUtils.notEmpty(key, "key");
		if(key.length<16){
			throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
		}

		try{
			SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec seckey = new SecretKeySpec(enCodeFormat,"AES");
			Cipher cipher = Cipher.getInstance(ConfigureEncryptAndDecrypt.AES_ALGORITHM);// 创建密码器
			cipher.init(Cipher.ENCRYPT_MODE, seckey);// 初始化
			byte[] result = cipher.doFinal(data);
			return result; // 加密
		} catch (Exception e){
			throw new RuntimeException("encrypt fail!", e);
		}
	}


	public static byte[] decrypt(byte[] data, byte[] key) {
		CheckUtils.notEmpty(data, "data");
		CheckUtils.notEmpty(key, "key");
		if(key.length<16){
			throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
		}
		try {
			SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec seckey = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance(ConfigureEncryptAndDecrypt.AES_ALGORITHM);// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, seckey);// 初始化
			byte[] result = cipher.doFinal(data);
			return result; // 加密
		} catch (Exception e){
			throw new RuntimeException("decrypt fail!", e);
		}
	}

	public static String encryptToBase64(String data, String key){
		try {
			byte[] valueByte = encrypt(data.getBytes(ConfigureEncryptAndDecrypt.CHAR_ENCODING), key.getBytes(ConfigureEncryptAndDecrypt.CHAR_ENCODING));
			return new String(Base64.encode(valueByte));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("encrypt fail!", e);
		}

	}

	public static String decryptFromBase64(String data, String key){
		try {
			byte[] originalData = Base64.decode(data.getBytes());
			byte[] valueByte = decrypt(originalData, key.getBytes(ConfigureEncryptAndDecrypt.CHAR_ENCODING));
			return new String(valueByte, ConfigureEncryptAndDecrypt.CHAR_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("decrypt fail!", e);
		}
	}
    //不允许有空格
	public static String decryptFromBase64NoSpase(String data, String key){
		try {
			byte[] originalData = Base64.decodeNoSpase(data.getBytes());
			byte[] valueByte = decrypt(originalData, key.getBytes(ConfigureEncryptAndDecrypt.CHAR_ENCODING));
			return new String(valueByte, ConfigureEncryptAndDecrypt.CHAR_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("decrypt fail!", e);
		}
	}

	public static String encryptWithKeyBase64(String data, String key){
		try {
			byte[] valueByte = encrypt(data.getBytes(ConfigureEncryptAndDecrypt.CHAR_ENCODING), Base64.decode(key.getBytes()));
			return new String(Base64.encode(valueByte));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("encrypt fail!", e);
		}
	}

	public static String decryptWithKeyBase64(String data, String key){
		try {
			byte[] originalData = Base64.decode(data.getBytes());
			byte[] valueByte = decrypt(originalData, Base64.decode(key.getBytes()));
			return new String(valueByte, ConfigureEncryptAndDecrypt.CHAR_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("decrypt fail!", e);
		}
	}

	public static byte[] genarateRandomKey(){
		KeyGenerator keygen = null;
		try {
			keygen = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(" genarateRandomKey fail!", e);
		}
		SecureRandom random = new SecureRandom();
		keygen.init(random);
		Key key = keygen.generateKey();
		return key.getEncoded();
	}

	public static String genarateRandomKeyWithBase64(){
		return new String(Base64.encode(genarateRandomKey()));
	}


	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\王飞鱼\\Desktop\\2020-06-11 13_37_57_0a6b70e807e749a09e2a91cce3d017b4.sql");
			String line="";
			BufferedReader reader=new BufferedReader(new FileReader(file));

			File fileOut = new File("C:\\Users\\王飞鱼\\Desktop\\解密2020-06-11 13_37_57.sql");
			BufferedWriter writer=new BufferedWriter(new FileWriter(fileOut));
			while ((line=reader.readLine())!=null){
				String sql = AES.decryptFromBase64(line,"rsfnDKwYlpkwPMIzQpmjLQ==");
				writer.write(sql);
				writer.newLine();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
