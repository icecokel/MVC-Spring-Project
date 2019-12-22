package icecokeWebproject;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//스프링의 테스트 클래스로 설정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링의 설정 파일을 실행해서 bean을 객체로 만들도록 설정
@ContextConfiguration(locations= 
	{"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class DBTest {

	@Autowired
	private DataSource dataSource;

	
	@Test
	public void ConnectionTest() {
		try {
			Connection con = dataSource.getConnection();
			System.err.println(con);
			System.err.println("DB 연결 테스트");
		}catch(Exception e) {
			System.err.println(e.getMessage());
			System.out.println(" DB 연결 예외발생");
		}

	}
}
