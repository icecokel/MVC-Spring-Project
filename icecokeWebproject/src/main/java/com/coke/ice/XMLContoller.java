package com.coke.ice;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.coke.ice.domain.XMLhani;




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
		List<String> titlelist = new ArrayList<>();
 		List<String> contentlist = new ArrayList<>();
 		XMLhani hani = null;
 		List<XMLhani> hanilist = new ArrayList<>();
		// xml 파싱
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			InputStream is = new ByteArrayInputStream(xml.getBytes());
			
			// 메모리에 펼치기.
			Document docu = db.parse(is);
			
			// 루트 찾아오기
			Element root=docu.getDocumentElement();
			
			// title 태그 찾아오기
			NodeList titles=root.getElementsByTagName("title");
			NodeList contents = root.getElementsByTagName("description");
			NodeList links =root.getElementsByTagName("link");
			// title을 하나씩 가져와서 출력
			for(int i=0; i<5; i++) {
				Node nodet=titles.item(i);
				Node nodetitle=nodet.getFirstChild();
				
				Node nodel = links.item(i);
				Node nodelink = nodel.getFirstChild();
				
				Node nodec = contents.item(i);
				Node nodecontent = nodec.getFirstChild();
				
				hani = new XMLhani();
				String titleori = nodetitle.toString();
				String title = titleori.split("#text: ")[1].split("]")[0];
				
				String linkori = nodelink.toString();
				String link = linkori.split("#text: ")[1].split("]")[0];
				
				String content = nodecontent.toString();
				System.out.println(title);
				
				
				hani.setNum(i+1);
				hani.setTitle(title);
				hani.setContent(content);
				hani.setLink(link);
				hanilist.add(i, hani);
				
				System.out.println("link"+ link) ;
				
				
				System.out.println(hanilist.toString());
				model.addAttribute("hanilist",hanilist);
				
				
			}

		} catch (Exception e) {
			System.out.println("xml 파싱예외.");
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		return "/xml/hanirss";
		// 참고 소스 https://blog.naver.com/ffiwe/221687137070
	}

}
