import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import manager.IDirectoryManager;
import manager.Manager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerTest {
	
	@Autowired
	private IDirectoryManager manager;
	
	@Test
	public void testInitTrueTest() {
		/*
		User user = (User) manager.newUser();
		*/
		System.out.println("ok");
		System.out.println(manager);
	}
	
}