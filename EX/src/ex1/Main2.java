package ex1;
import java.util.Scanner;

public class Main2 {
	static long[][] rest;
	public static void main(String[] args) { 
		Scanner sc= new Scanner(System.in);
		int i=0;
		while(i<=1000) {
			int N=sc.nextInt();
			rest=new long[N+1][N+1];
			if(N==0) break;
			System.out.println(pill(N,0));
			i++;
		}

	}
	public static long pill(int a,int b) {
		if(rest[a][b]!=0) return rest[a][b];
		if(a==0) return 1;
		else {
			rest[a][b]=pill(a-1,b+1);
			if(b!=0)
				rest[a][b]+=pill(a,b-1);
		}
		return rest[a][b];
		
	}
}
