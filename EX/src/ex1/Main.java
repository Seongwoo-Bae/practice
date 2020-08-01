package ex1;

import java.util.Scanner;

public class Main {
	static int count=0;
	static int r=0;
	static int c=0;
	static int N=0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		r=sc.nextInt();
		c=sc.nextInt();
		int i=0;int j=0;
		z(i,j,0);
		System.out.println(count);
	}
	public static void z(int i, int j, int n) {
		if((i!=r || j!=c) && count!=Math.pow(2, 2*N)-1) 
			if(i%Math.pow(2, n+1)==Math.pow(2,n)-1 && j%Math.pow(2, n+1)==Math.pow(2,n)-1) {
				count++;
				z(i-(int)Math.pow(2, n)+1,j+1,0);
			}
			else if(i%Math.pow(2, n+1)==Math.pow(2,n)-1 && j%Math.pow(2, n+1)==Math.pow(2,n+1)-1) {
				count++;
				z(i+1,j-(int)Math.pow(2, n+1)+1,0);
			}
			else if(i%Math.pow(2, n+1)==Math.pow(2,n+1)-1 && j%Math.pow(2, n+1)==Math.pow(2,n)-1) {
				count++;
				z(i-(int)Math.pow(2, n)+1,j+1,0);
			}
			else z(i,j,++n);
	}

}
