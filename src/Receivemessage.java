import java.io.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Receivemessage {
	public static void main(String[] args) throws IOException {

		sendGet();
	}

	public static void sendGet() {
		String result = " ";
		try {

			URL U = new URL(
					"http://sms.webchinese.cn/web_api/SMS/GBK/?Action=UP&Uid=ABCDEF91&Key=0f7e794922e27d5bbbb5&Prompt=0");

			URLConnection connection = U.openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
				System.out.println(line);
			}
			in.close();
		} catch (Exception e) {
			System.out.println("����������ӷ����쳣����     : " + e.toString());
			System.out
					.println("���ӵ�ַ��     :"
							+ "http://sms.webchinese.cn/web_api/SMS/GBK/?Action=UP&Uid=ABCDEF91&Key=0f7e794922e27d5bbbb5&Prompt=0");
		}

	}
}