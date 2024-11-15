package practice;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestNGPractice {
	@Test(priority = -1,invocationCount=2,enabled=true)
	
public void sampleTest()
{
	System.out.println("hi");
}
	@Test(priority = 0,enabled=true,dependsOnMethods="sampleTest")
	public void samleTest1()
	{
		System.out.println("hello");
	}
	
}
