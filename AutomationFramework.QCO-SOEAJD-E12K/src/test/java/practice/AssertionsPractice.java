package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
@Test
public void sample()
{
	System.out.println("step 1");
	System.out.println("step 2");
	System.out.println("step 3");
	//Assert.assertEquals(false,true);
	System.out.println("step 4");
	System.out.println("step 5");
	//Assert.assertEquals(true,true);
}
@Test
public void sample1()
{
	SoftAssert sa=new SoftAssert();
	System.out.println("step 1");
	System.out.println("step 2");
	System.out.println("step 3");
	sa.assertEquals(false, true);
System.out.println("step 4");
System.out.println("step 5");
	//Assert.assertEquals(true,true);
	sa.assertAll();
}
}
