package org.w3c.tidy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

/**
 * TidyTest.java
 * 
 * @author ncrash
 * @since 2010. 1. 19.
 * @see
 */
public class TidyTest {

	// URL 을 인자로 받아서 HttpURLConnection Object를 생성한
	// 다음 response code 및 response message 를 반환하는 메소드

	static String checkUrl(String URLName) {

		String retValue = null;
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(URLName)
					.openConnection();
			// HttpURLConnection.setFollowRedirects(true);
			con.setRequestMethod("HEAD");
			retValue = String.valueOf(con.getResponseCode()) + ": "
					+ con.getResponseMessage();
			con.disconnect();
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}
		return retValue;
	}

	public static void main(String[] args) throws Exception {

		Tidy tidy = new Tidy();
//		tidy.setQuiet(true);
//		tidy.setShowWarnings(false);

		// 이 URL은 실제 있는 URL 입니다. 인터넷에 연결된 상태에서
		// 이프로그램을 실행하시면 결과가 죽 출력될 것입니다.
		// 자신의 link file을 한번 테스트 해보는 것도 좋겠지요.

		URL url = new URL("http://localhost/invalid.html");
		URLConnection connection = url.openConnection();
		connection.connect();

		// tidy object의 parseDOM method로 Document 를 얻습니다.
		// parseDOM을 실행하면 HMTL 을 파싱해서 valid 한 XML 로 변환합니다.
		// 이과정에서 에러내용이 출력됩니다.
		// 여기서 얻어진 Document 가 바로 DOM 입니다.
		// parseDOM 의 두번째 인자를 지정하면 valid 한 XML 로 변환된 파일이
		// 출력됩니다.

		Document doc = tidy.parseDOM(connection.getInputStream(), null);
//		tidy.parse(connection.getInputStream(), System.out);
		
		System.out.println(tidy.getParseWarnings());
		

		// Document doc = tidy.parseDOM (connection.getInputStream(),
		// new FileOutputStream(new File("c://new.txt")));

		// 이런 형태의 태그를 모두 찾습니다.
//		NodeList nl = doc.getElementsByTagName("a");
//
//		for (int i = 0; i < nl.getLength(); i++) {
//			Node node = nl.item(i);
//			
//			System.out.println(node);
//		}
	}
}
