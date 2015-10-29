
package com.misynss.common;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

// KEY SPECIFICATIONS
import java.security.spec.KeySpec;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEParameterSpec;

// EXCEPTIONS
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

/**
 * 
 * Product: solSyn - NDB Signature Management System <br/>
 * Description: Data encryption and decryption Class <br/>
 * Copyright: Copyright, 2007 (c) <br/>
 * Company: M.I. Synergy (Pvt) Ltd <br/>
 * @author Chamila Perera
 * @version 1.0
 */

public class Cryptography {

	private Cipher dcipher;

	private Cipher ecipher;

	private String encryptionKey = "StargateFX";

	/**
	 * Default constructor
	 */
	public Cryptography() {
		this.initData();
	}

	/**
	 * Constructor
	 * 
	 * @param <tt>encryptionKey</tt> Encryption key
	 */
	public Cryptography(String encryptionKey) {
		this.encryptionKey = encryptionKey.trim();
		this.initData();
	}
	
	/**
	 * Takes a encrypted String as an argument, decrypts and returns the
	 * decrypted String.
	 * 
	 * @param <tt>str</tt> Encrypted String to be decrypted
	 * @return Decrypted version of the provided String as <code>String</code>
	 */
	public String decrypt(String str) {
		try {
			// Decode base64 to get bytes
			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
			// Decrypt
			byte[] utf8 = dcipher.doFinal(dec);
			// Decode using utf-8
			return new String(utf8, "UTF8");
		} catch (BadPaddingException e) {
			System.out.println("ERROR: Cryptography.decrypt() " + e.getMessage());
		} catch (IllegalBlockSizeException e) {
			System.out.println("ERROR: Cryptography.decrypt() " + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("ERROR: Cryptography.decrypt() " + e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR: Cryptography.decrypt() " + e.getMessage());
		}
		return "";
	}

	/**
	 * Takes a single String as an argument and returns an Encrypted version of
	 * that String.
	 * 
	 * @param <tt>str</tt> String to be encrypted
	 * @return Encrypted version of the provided String as <code>String</code>
	 */
	public String encrypt(String str) {
		try {
			// Encode the string into bytes using utf-8
			byte[] utf8 = str.getBytes("UTF8");
			// Encrypt
			byte[] enc = ecipher.doFinal(utf8);
			// Encode bytes to base64 to get a string
			return new sun.misc.BASE64Encoder().encode(enc);
		} catch (BadPaddingException e) {
			System.out.println("ERROR: Cryptography.encrypt() " + e.getMessage());
		} catch (IllegalBlockSizeException e) {
			System.out.println("ERROR: Cryptography.encrypt() " + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("ERROR: Cryptography.encrypt() " + e.getMessage());
		}
		return "";
	}

	/**
	 * Initialize data
	 */
	private void initData() {
		// 8-bytes Salt
		byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
				(byte) 0x56, (byte) 0x34, (byte) 0xE3, (byte) 0x03 };

		// Iteration count
		int iterationCount = 19;

		try {
			KeySpec keySpec = new PBEKeySpec(encryptionKey.toCharArray(), salt, iterationCount);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

			ecipher = Cipher.getInstance(key.getAlgorithm());
			dcipher = Cipher.getInstance(key.getAlgorithm());

			// Prepare the parameters to the cipthers
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

		} catch (InvalidAlgorithmParameterException e) {
			System.out.println("ERROR: Cryptography.initData() " + e.getMessage());
		} catch (InvalidKeySpecException e) {
			System.out.println("ERROR: Cryptography.initData() " + e.getMessage());
		} catch (NoSuchPaddingException e) {
			System.out.println("ERROR: Cryptography.initData() " + e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("ERROR: Cryptography.initData() " + e.getMessage());
		} catch (InvalidKeyException e) {
			System.out.println("ERROR: Cryptography.initData() " + e.getMessage());
		}
	}

}
