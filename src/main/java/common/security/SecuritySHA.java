package common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.utill.UtillsTimeChack;

/**
 * SHA 암호화 정리
 * b는 바이트 배열
 * s는 바이트 배열을 문자로 변환
 * 표시가 없는건 바이트 배열을 16비트값으로 표현
 * @author Administrator
 */
@Controller

@RequestMapping(value = {
		"/SecuritySHA/*"
}) // ,method = RequestMethod.POST
public class SecuritySHA {

	private final static Logger log = LoggerFactory.getLogger(SecuritySHA.class);

	/**
	 * 단일 암호화 샘플
	 * http://localhost:8080/common/sample/sample/
	 * http://localhost:8080/common/sample/ Simply selects the home view to
	 * render by returning its name. 스프링 프로젝터 생성시 기본 메소드
	 */
	@RequestMapping(value = "/")
	// @ResponseBody
	public String SecuritySample(Locale locale, Model model) {

		log.info("SecuritySample");

		String sha;

		sha = SHA256("SecuritySample").length() + ":" + SHA256("SecuritySample");
		log.debug(sha);
		model.addAttribute("sha256", sha);

		sha = SHA512("SecuritySample").length() + ":" + SHA512("SecuritySample");
		log.debug(sha);
		model.addAttribute("sha512", sha);
		
		sha = SHA512t("SecuritySample").length() + ":" + SHA512t("SecuritySample");
		log.debug(sha);
		model.addAttribute("sha512t", sha);

		sha = SHA256s("SecuritySample").length() + ":" + SHA256s("SecuritySample");
		log.debug(sha);
		model.addAttribute("sha256s", sha);

		sha = SHA512s("SecuritySample").length() + ":" + SHA512s("SecuritySample");
		log.debug(sha);
		model.addAttribute("sha512s", sha);

		sha = SHA256b("SecuritySample").length + ":" + SHA256b("SecuritySample").toString();
		log.debug(sha);
		model.addAttribute("sha256b", sha);

		sha = SHA512b("SecuritySample").length + ":" + SHA512b("SecuritySample").toString();
		log.debug(sha);
		model.addAttribute("sha512b", sha);

		// logger.info("logger Welcome home! The client locale is.");
		// log.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "forward:/debug/debug.jsp";
	}

	/**
	 * 암호화
	 * 32바이트*8비트=256비트
	 * 
	 * @param str
	 * @return
	 */
	@RequestMapping(value = {
			"/SHA256/{str}"
	}) // ,method = RequestMethod.POST
	@ResponseBody
	public final static String SHA256(@PathVariable String str) {
		//log.debug("SHA256");
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			SHA = new String(byteData, 0, byteData.length);
			// log.debug(byteData.length + ":" + SHA);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
				// sb.append(Integer.toHexString(0xff & byteData[i]));//0은 처리
				// 안되는 문제가 있음
			}
			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}

	/**
	 * 단방향 암호화
	 * 이건 쓰지 말기
	 * 
	 * @param str
	 * @return
	 */
	@RequestMapping(value = {
			"/SHA256s/{str}"
	}) // ,method = RequestMethod.POST
	@ResponseBody
	public final static String SHA256s(@PathVariable String str) {
		log.debug("SHA256s");
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			SHA = new String(byteData, 0, byteData.length);
			// log.debug(byteData.length + ":" + SHA);
			// StringBuffer sb = new StringBuffer();
			// for (int i = 0; i < byteData.length; i++) {
			// sb.append(Integer.toString((byteData[i] & 0xff) + 0x100,
			// 16).substring(1));
			// sb.append(Integer.toHexString(0xff & byteData[i]));
			// }
			// SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}

	@RequestMapping(value = {
			"/SHA256b/{str}"
	}) // ,method = RequestMethod.POST
	@ResponseBody
	public final static byte[] SHA256b(@PathVariable String str) {
		log.debug("SHA256b");
		// String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			// byte byteData[] = sh.digest();
			// SHA = new String(byteData, 0, byteData.length);
			// log.debug(sh.digest().length + ":" + sh.digest());
			// StringBuffer sb = new StringBuffer();
			// for (int i = 0; i < byteData.length; i++) {
			// sb.append(Integer.toString((byteData[i] & 0xff) + 0x100,
			// 16).substring(1));
			// sb.append(Integer.toHexString(0xff & byteData[i]));
			// }
			// SHA = sb.toString();
			return sh.digest();

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		// return SHA;
	}

	@RequestMapping(value = {
			"/SHA512/{target}"
	}) // ,method = RequestMethod.POST
	@ResponseBody
	public final static String SHA512(@PathVariable String target) {
		//log.debug("SHA512");
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-512");
			sh.update(target.getBytes());
			StringBuffer sb = new StringBuffer();
			for (byte b : sh.digest()) {
				// sb.append(Integer.toHexString(0xff & b));
				sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}
			// log.debug(sb.length() + ":" + sb.toString());
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 이방법 쓰지 말기 format 함수가 두배나 느림
	 * @param target
	 * @return
	 */
	@RequestMapping(value = {
			"/SHA512t/{target}"
	}) // ,method = RequestMethod.POST
	@ResponseBody
	public final static String SHA512t(@PathVariable String target) {
		//log.debug("SHA512t");
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-512");
			sh.update(target.getBytes());
			
			StringBuffer sb = new StringBuffer();
			for (byte b : sh.digest()) {
				// sb.append(Integer.toHexString(0xff & b));
				sb.append(String.format("%02x", b&0xff));//이방법 느림 쓰지 말기 아래와 비교해서 두배나 느림
				//sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}
			// log.debug(sb.length() + ":" + sb.toString());
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 쓰지 말기
	 * 
	 * @param target
	 * @return
	 */
	@RequestMapping(value = {
			"/SHA512s/{target}"
	}) // ,method = RequestMethod.POST
	@ResponseBody
	public final static String SHA512s(@PathVariable String target) {
		log.debug("SHA512s");
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-512");
			sh.update(target.getBytes());
			byte byteData[] = sh.digest();
			String SHA = new String(byteData, 0, byteData.length);
			// StringBuffer sb = new StringBuffer();
			// for (byte b : sh.digest()) {
			// sb.append(Integer.toHexString(0xff & b));
			// sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			// }
			// log.debug(sb.length() + ":" + sb.toString());
			// return sb.toString();
			// log.debug(byteData.length + ":" + SHA);
			return SHA;

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * SHA512b 방식 단방향 암호화
	 * 64바이트(*8비트)=512비트
	 * 
	 * @param target
	 * @return
	 */
	@RequestMapping(value = {
			"/SHA512b/{target}"
	}) // ,method = RequestMethod.POST
	@ResponseBody
	public final static byte[] SHA512b(@PathVariable String target) {
		log.debug("SHA512b");
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-512");
			sh.update(target.getBytes());
			// log.debug(sh.digest().length + ":" + sh.digest());
			// byte byteData[] = sh.digest();
			// String SHA = new String(byteData, 0, byteData.length);
			// StringBuffer sb = new StringBuffer();
			// for (byte b : sh.digest()) {
			// sb.append(Integer.toHexString(0xff & b));
			// sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			// }
			// log.debug(sb.length() + ":" + sb.toString());
			// return sb.toString();
			// log.debug(sh.digest().length + ":" + sh.digest());
			return sh.digest();

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		
		UtillsTimeChack t1=new UtillsTimeChack();
		UtillsTimeChack t2=new UtillsTimeChack();
		
		t1.setStart();
		log.debug("{}",t1.getStart());
		for (int i = 0; i < 10000; i++) {
			SHA512("SecuritySample");
		}
		t1.setEnd();
		log.debug("{}",t1.getEnd());
		
		t2.setStart();
		log.debug("{}",t1.getStart());
		for (int i = 0; i < 10000; i++) {
			SHA512t("SecuritySample");
		}
		t2.setEnd();
		log.debug("{}",t1.getEnd());
		
		log.debug("{}",t1.getTime());
		log.debug("{}",t2.getTime());


	}
}
