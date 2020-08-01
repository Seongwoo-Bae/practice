package ex1;

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int N = sc.nextInt();
		int[][] value= new int[N][3];
		int[][] min=new int[N][3];
		int[][][] route=new int[N][3][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<3;j++)
				value[i][j]=sc.nextInt();
		for(int i=0;i<3;i++) {
			min[0][i]=value[0][i];
			route[0][i][0]=i;
		}
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) route[i][j][i]=j;
			min[i][0]=minimum(min[i-1][1],min[i-1][2])+value[i][0];
			min[i][1]=minimum(min[i-1][2],min[i-1][0])+value[i][1];
			min[i][2]=minimum(min[i-1][0],min[i-1][1])+value[i][2];
			route[i][0][i-1]=min[i-1][1]>min[i-1][2]? route[i-1][2][i-1] : route[i-1][1][i-1];
			route[i][1][i-1]=min[i-1][2]>min[i-1][0]? route[i-1][0][i-1] : route[i-1][2][i-1];
			route[i][2][i-1]=min[i-1][0]>min[i-1][1]? route[i-1][1][i-1] : route[i-1][0][i-1];
		} 
		int as=minimum(minimum(min[N-1][0],min[N-1][1]),min[N-1][2]);
		System.out.println(as);
		int k;
		if(as==min[N-1][1]) k=1;
		else if(as==min[N-1][0]) k=0;
		else k=2;
		for(int i=0;i<N;i++)
			System.out.print(route[N-1][k][i]+ " ");
	}
	
	public static int minimum(int a, int b) {
		if(a>b) return b;
		return a;
	}

}