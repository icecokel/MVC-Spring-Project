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

	@RequestMapping(value = "/xml/hanirss", method = RequestMethod.GET)
	public String hanirss(Model model) {
		String xml = "";

		// xml 다운로드 진행.
		try {
			// 한겨례 rss 주소,
			String addr = "http://www.hani.co.kr/rss/";

			URL url = new URL(addr);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 연결대기시간.
			con.setConnectTimeout(30000);

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuilder sb = new StringBuilder();

			while (true) {
				String line = br.readLine();

				if (line == null) {
					break;
				}

				sb.append(line + "\n");
			}

			xml = sb.toString();

			br.close();
			con.disconnect();

		} catch (Exception e) {
			System.out.println("xml 다운로드 예외");
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
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
			Element root = docu.getDocumentElement();

			// title 태그 찾아오기
			NodeList titles = root.getElementsByTagName("title");
			NodeList contents = root.getElementsByTagName("description");
			NodeList links = root.getElementsByTagName("link");
			// title을 하나씩 가져와서 출력
			for (int i = 0; i < 6; i++) {
				Node nodet = titles.item(i);
				Node nodetitle = nodet.getFirstChild();

				Node nodel = links.item(i);
				Node nodelink = nodel.getFirstChild();

				Node nodec = contents.item(i);
				Node nodecontent = nodec.getFirstChild();

				hani = new XMLhani();
				String titleori = nodetitle.toString();
				
				int lio = titleori.lastIndexOf("]");
				String title = titleori.substring(0, lio);
				title = title.split("#text:")[1];
			
				String linkori = nodelink.toString();
				String link = linkori.split("#text: ")[1].split("]")[0];
				
				
				String contentori = nodecontent.toString();
				hani.setNum(i);
				hani.setTitle(title);
				hani.setContent(contentori);
				hani.setLink(link);
				
				hanilist.add(i, hani); 
			}
			
			hanilist.remove(0);
			
			// content 가공하기 위한 for 문.
			for(int j =0 ; j < hanilist.size() ; j++) {
				hani = new XMLhani();
				hani = hanilist.get(j);
				int contentfio = 1;
				if(hani.getContent().lastIndexOf("</table>") >1) {
					contentfio =hani.getContent().lastIndexOf("</table>");
				}
				int contentlio = hani.getContent().lastIndexOf("]");

//				System.out.println(contentfio);
//				System.out.println(contentlio);
				
				String content = hani.getContent().substring(contentfio,contentlio);
				

				
				// 이미지 경로만 잘라내기.
				int imgfio = hani.getContent().lastIndexOf("http:");
				int imglio = hani.getContent().lastIndexOf("' border=0>");
				
//				System.out.println(imgfio);
//				System.out.println(imglio);
				
				String img = "";
				if(imgfio*imglio != 1) {
					img = hani.getContent().substring(imgfio,imglio);
				}
				
//				System.out.println(img);
				
				hani.setImg(img);
				hani.setContent(content);
//				System.out.println(hani);
			}
			model.addAttribute("hanilist", hanilist);

		} catch (Exception e) {
			System.out.println("xml 파싱예외.");
			e.printStackTrace();
			System.out.println(e.getMessage());

		}

		return "/xml/hanirss";
		// 참고 소스 https://blog.naver.com/ffiwe/221687137070
	}

}
