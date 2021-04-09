package test;

import static org.junit.Assert.assertNotNull;

import java.security.SecureRandom;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jdh.service.SendMailServiceImpl;
import com.jdh.utils.MemberDAOImpl;
import com.jdh.vo.MemberVO;
import com.jdh.vo.TicketingVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyTest {
	
	@Autowired
	SqlSession sql;
	
	
	
	@Test
	public void myTest() {
		assertNotNull(sql);
		
	}
}
