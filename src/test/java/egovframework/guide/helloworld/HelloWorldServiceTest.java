package egovframework.guide.helloworld;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldServiceTest {
	
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		String configLocation = "context-helloworld.xml";
		context = new ClassPathXmlApplicationContext(configLocation);
	}

	@Test
	public void testSayHello() {
		HelloWorldService helloworld = (HelloWorldService)context.getBean("helloworld");
		assertEquals( "Hello egov framework!!!", helloworld.sayHello() );
	}

}
