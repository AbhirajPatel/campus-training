import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
class euler_pro{
	private static int n=100;
	private static int[][] num=new int[n+1][n+1];
	private static int sum=0;
	private static String str;
	public static void main(String[] args)
	{
		int i,j;
		try{
		File f=new File("/home/abhiraj/learn_java/file.txt");
		Scanner s = new Scanner(f);
        for(i=0;i<n;i++)
        {
        	for(j=0;j<=i;j++)
        	{
        		num[i][j]=s.nextInt();
        	}
        	str=s.nextLine();
        }
          } catch (Exception e)
          {
          	System.out.println("An error");
          }
    sum=num[0][0];
        int h=0;
        for(i=1;i<n;i++)
        {
        	if(num[i][h]<num[i][h+1])
        		{ 
                 h++;
                 sum=sum+num[i][h];
        		}
        		else
        			sum=sum+num[i][h];
        }
        System.out.println(sum);

	}
}