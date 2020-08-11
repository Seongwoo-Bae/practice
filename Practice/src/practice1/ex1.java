package practice1;
import java.util.Scanner;
import java.util.Arrays;

public class ex1 {
	static final int TYPE=50;
	static final int PRIORITY=4;
	static int[][] W;
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		W=new int[N][N];
		int[][] city=new int[TYPE][N];
		int[] worth=new int[TYPE];
		int[] index;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				W[i][j]=sc.nextInt();
		for(int i=0;i<TYPE;i++) {
			for(int j=1;j<N;j++) {
				city[i][j]=(int)(Math.random()*(N-1))+1;
				if(W[city[i][j-1]][city[i][j]]==0) j--;
				else 
					for(int k=0;k<j;k++) {
						if(city[i][j]==city[i][k]) {
							j--;
							break;
						}
					}
			}
		}
		for(int i=0;i<30;i++) {
			worth=Worth(city);
			System.out.println(min(worth));
			index=sort(worth);
			city=gene(city[index[TYPE-1]],city[index[TYPE-2]],city[index[TYPE-3]],city[index[TYPE-4]]);
			
		}

	}
	public static int[] Worth(int[][] a) {
		int[] value=new int[TYPE];
		for(int i=0;i<TYPE;i++) {
			for(int j=0;j<N-1;j++) {
				value[i]+=W[a[i][j]][a[i][j+1]];
			}
			value[i]+=W[a[i][N-1]][a[i][0]];
		}
		return value;
	}
	public static int[] sort(int[] worth) {
		int[] indexof=new int[TYPE];
		for(int i=0;i<TYPE;i++) indexof[i]=i;
		int index=0;
		int min=0;
		for(int i=0;i<PRIORITY;i++) {
			for(int j=0;j<TYPE-i-1;j++) {
				if(worth[i]<worth[i+1]) {
					min=worth[i];
					worth[i]=worth[i+1];
					worth[i+1]=min;
					index=indexof[i];
					indexof[i]=indexof[i+1];
					indexof[i+1]=index;
				}
			}
		}
		return indexof;
	}
	public static int[][] gene(int[] a,int[] b,int[] c,int[] d) {
		int[][] type=new int[TYPE][N];
		for(int i=0;i<(TYPE/2);i++) {
			for(int j=1;j<N;j++) {
				if((int)(Math.random()*100)<50)
					type[i][j]=a[j];
				else
					type[i][j]=b[j];
				for(int k=0;k<j;k++) {
					if(type[i][j]==type[i][k]) {
						j--;
						break;
					}
				}
			}
			for(int j=1;j<N;j++) {
				if((int)(Math.random()*100)<50)
					type[i+TYPE/2][j]=a[j];
				else
					type[i+TYPE/2][j]=b[j];
				for(int k=0;k<j;k++) {
					if(type[i+TYPE/2][j]==type[i+TYPE/2][k]) {
						j--;
						break;
					}
				}
			}
		}
		return type;
	}
	public static int min(int[] worth) {
		int min=worth[0];
		for(int i=0;i<TYPE-1;i++) 
			if(worth[i+1]<min)
				min=worth[i+1];
		return min;
	}

}
