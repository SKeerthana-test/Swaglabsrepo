package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser interface of TestNG
 *@author Keerthana S
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=0;
    int retryCount=3;
    
	@Override
	public boolean retry(ITestResult result) {
		
		
		
		//0<3//1<3//2<3//3<3 no
		if(count<retryCount)
		{
			count++;// 1 2 3
			return true;//retry
		}
		
		
		return false;//not retry
	}

}
