package icecokeWebproject;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DbTest {
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void dbCon() {
		try {
			Connection con = dataSource.getConnection();
			System.err.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
