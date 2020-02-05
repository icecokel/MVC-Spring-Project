package com.coke.ice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class XMLContoller {
	
	@RequestMapping (value="/xml/hanirss" , method=RequestMethod.GET)
	public String hanirss(Model model) {
		String xml ="";

		// xml 다운로드 진행.
		try {
			// 한겨례 rss 주소,
			String addr = "http://www.hani.co.kr/rss/";
			
			URL url = new URL(addr);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			// 연결대기시간.
			con.setConnectTimeout(30000);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			StringBuilder sb = new StringBuilder();
			
			while(true){
				String line =br.readLine();
				
				if(line== null) {
					break;
				}
				
				sb.append(line + "\n");
			}
			
			xml = sb.toString();
			
			br.close();
			con.disconnect();
			
		}catch(Exception e) {
			System.out.println("xml 다운로드 예외");
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		// xml 파싱
		try {
			
		} catch (Exception e) {
			System.out.println("xml 파싱예외.");
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		
		return "/xml/hanirss";
		// 참고 소스 https://blog.naver.com/ffiwe/221687137070
	}

}
