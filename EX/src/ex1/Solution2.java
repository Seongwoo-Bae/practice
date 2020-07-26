package ex1;

import java.util.Scanner;

public class Solution2
{
	static int count;
	public static void main(String args[]) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		int test_case=sc.nextInt();
		
		for(int cs=0;cs<test_case;cs++) 
		{
			count=0;
			int num=sc.nextInt();
			returner(num);
			System.out.println(count);
			
		}
	}
	public static void returner(int num) {
		if(num==1 || num==0) 
			count++;
		else if(num==2) 
			count+=2;
		else if(num>=3)
			for(int i=1;i<4;i++)
				returner(num-i);
	}
}