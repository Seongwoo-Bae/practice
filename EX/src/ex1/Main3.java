package ex1;

import java.util.Scanner;

public class Main3 {
	static int count=0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int r=sc.nextInt();
		int c=sc.nextInt();
		z(r,c,N);
		System.out.println(count);
	}
	public static void z(int r,int c,int n) {
		if(n>0) {
			if(r%(int)Math.pow(2, n)<Math.pow(2, n-1) && c%(int)Math.pow(2, n)<Math.pow(2, n-1)) z(r,c,--n);
			else if(r%(int)Math.pow(2, n)<Math.pow(2, n-1) && c%(int)Math.pow(2, n)<Math.pow(2, n)) {
				count+=Math.pow(2, 2*(n-1));
				z(r,c,--n);
			}
			else if(r%(int)Math.pow(2, n)<Math.pow(2, n) && c%(int)Math.pow(2, n)<Math.pow(2, n-1)) {
				count+=2*Math.pow(2, 2*(n-1));
				z(r,c,--n);
			}
			else {	
				count+=3*Math.pow(2, 2*(n-1));
				z(r,c,--n);
			}
		}
	}
}
