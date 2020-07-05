package apiRest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = apiRestTest.class)
@TestPropertySource(locations="classpath:test.properties")
public class apiRestTest {

	@Test
	public void contextLoads() {
	}

}