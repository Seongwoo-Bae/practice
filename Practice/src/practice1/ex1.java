package practice1;
import java.util.Scanner;
import java.util.Arrays;

public class ex1 {
	static final int TYPE=8;
	static final int PRIORITY=4;
	static int[][] W;
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		W=new int[N][N];
		int[][] city=new int[TYPE][N];
		int[] worth=new int[TYPE];
		int[] index=new int[TYPE];
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
		for(int i=0;i<10;i++) {
			for(int j=0;j<PRIORITY/2;j++)
				mut(city[j]);
			
			for(int j=PRIORITY/2;j<PRIORITY/2+2;j++) {
				for(int k=1;k<N;k++) {
					city[j][k]=(int)(Math.random()*(N-1))+1;
					if(W[city[j][k-1]][city[j][k]]==0) k--;
					else 
						for(int l=0;l<k;l++) {
							if(city[j][k]==city[j][l]) {
								k--;
								break;
							}
						}
				}
			}
			worth=Worth(city);
			System.out.println("-----"+(i+1)+"¼¼´ë-----");
			for(int j=0;j<TYPE;j++) { 
				for(int k=0;k<N;k++)
					System.out.print(city[j][k]+" ");
				System.out.println("->"+worth[j]+";");
			}
			
			index=sort(worth);
			city=gene(city[index[TYPE-1]],city[index[TYPE-2]],city[index[TYPE-3]],city[index[TYPE-4]]);
			
			
		}

	}
	public static void mut(int[] city) {
		int x;
		x=city[N-1];
		city[N-1]=city[N-2];
		city[N-2]=x;
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
				if(worth[j]<worth[j+1]) {
					min=worth[j];
					worth[j]=worth[j+1];
					worth[j+1]=min;
					index=indexof[j];
					indexof[j]=indexof[j+1];
					indexof[j+1]=index;
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
