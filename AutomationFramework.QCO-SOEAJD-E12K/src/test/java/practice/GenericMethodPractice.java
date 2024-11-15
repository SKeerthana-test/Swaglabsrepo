package practice;

public class GenericMethodPractice {
public static void main(String[] args) {

	int sum=add(10,20);
	System.out.println(sum);
	System.out.println(add(sum,40));
	System.out.println(add(100,sum));
	System.out.println(add(200,300));
	System.out.println(add(2,4,5));
	
}
public static int add(int a,int b)
{
	int c= a+b;
	return c;
}
public static int add(int a,int b,int s)
{
	int c= a+b+s;
	return c;
}

}
