import java.util.*;

public class townJudge{

	public int findJudge(int n, int[][] trust)
	{
		int[] count = new int[n+1];
		for(int i = 0; i < trust.length; i++)
		{
			int[] person = trust[i];
			count[person[0]] = count[person[0]] - 1; //decrement because the judge doesn't trust anyone
			count[person[1]] = count[person[1]] + 1; //increment because that person is trusted 
		}
		for(int i = 1; i <= n; i++)
		{
			if(count[i] == n - 1) //the judge is trusted by everyone except themselves (n-1 people)
			{
				return i;
			}
		}
		return -1;
	}

    public static void main(String[] args)
	{
		townJudge tJ = new townJudge();
		int[][] trust = {{1,2}};
		System.out.println(tJ.findJudge(2, trust)); //2
		int[][] trust2 = {{1,3}, {2,3}};
		System.out.println(tJ.findJudge(3, trust2)); //3
		int[][] trust3 = {{1,3}, {2,3}, {3,1}};
		System.out.println(tJ.findJudge(3, trust3)); //-1
		int[][] trust4 = {{1,2}, {2,3}};
		System.out.println(tJ.findJudge(3, trust4)); //-1
		int[][] trust5 = {{1,3}, {1,4}, {2,3}, {2,4}, {4,3}};
		System.out.println(tJ.findJudge(4, trust5)); //3
		
	}
}
