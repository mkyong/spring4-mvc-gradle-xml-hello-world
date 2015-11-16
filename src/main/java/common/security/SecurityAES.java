package common.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AES 대칭키 암호/복호화 예제
 * 
 * @author Administrator
 *         http://aesencryption.net/#Java-aes-encryption-example
 */
class SecurityAES {

	private final static Logger log = LoggerFactory.getLogger(SecurityAES.class);

	private static SecretKeySpec secretKey;
	private static byte[] key;

	private static String decryptedString;
	private static String encryptedString;

	public static void setKey(String myKey) {

		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			System.out.println("key.length:" + key.length);
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16); // use only first 128 bit// 지우면 인코딩 안됨
			System.out.println("key.length:" + key.length);
			System.out.println("key:" + new String(key, "UTF-8"));
			secretKey = new SecretKeySpec(key, "AES");

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getDecryptedString() {
		return decryptedString;
	}

	public static void setDecryptedString(String decryptedString) {
		SecurityAES.decryptedString = decryptedString;
	}

	public static String getEncryptedString() {
		return encryptedString;
	}

	public static void setEncryptedString(String encryptedString) {
		SecurityAES.encryptedString = encryptedString;
	}

	/**
	 * 암호화
	 * 
	 * @param strToEncrypt
	 * @return 실패시 널값 반환
	 */
	public static String encrypt(String strToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
			return getEncryptedString();
		} catch (Exception e) {

			// e.printStackTrace();
			log.info("암호화 오류 : " + e.toString());
			setEncryptedString(null);
			return null;
		}
	}

	/**
	 * 복호화
	 * 
	 * @param strToDecrypt
	 * @return 실패시 널값 반환
	 */
	public static String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));
			return getDecryptedString();
		} catch (Exception e) {

			// e.printStackTrace();
			log.info("복호화  오류: " + e.toString());
			setDecryptedString(null);
			return null;
		}
	}

	/**
	 * 실행 예제
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		final String strToEncrypt = "내용";
		final String strPssword = "암호";

		SecurityAES.setKey(strPssword);// 암호키

		SecurityAES.encrypt(strToEncrypt.trim());// 암호화할 내용

		System.out.println("암호화할 내용: " + strToEncrypt);
		System.out.println("암호화된 내용: " + SecurityAES.getEncryptedString());

		final String strToDecrypt = SecurityAES.getEncryptedString();// 암호화된 내용
																		// 저장
		SecurityAES.decrypt(strToDecrypt.trim());// 복호화 처리

		System.out.println("복호화할 내용 : " + strToDecrypt);
		System.out.println("복호화된 내용 : " + SecurityAES.getDecryptedString());

		SecurityAES.setKey(strPssword + "ㅁ");// 틀린 암호키일 경우
		SecurityAES.decrypt(strToDecrypt.trim());// 복호화 처리

		System.out.println("복호화할 내용 : " + strToDecrypt);
		System.out.println("복호화된 내용  : " + SecurityAES.getDecryptedString());

	}

}
