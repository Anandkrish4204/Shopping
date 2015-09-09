/*
 * Author : Anand Krishnamoorthy
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Shops{
	public int[] item  = new int[3];
	Shops(){
	}
	Shops(int v){
		for(int i=0;i<3;i++)
			item[i]=v;
	}
}

public class Shopping {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		int testCase=0;
		// Getting input- Starts
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCase=Integer.valueOf(br.readLine()).intValue();
				
			for(int i=0;i<testCase;i++){
				
				int shopSize=0;
				int index=-1;
				int result =0;
				String temp;
				StringTokenizer tokens ;
				shopSize=Integer.valueOf(br.readLine()).intValue();
				
				Shops[] sh = new Shops[shopSize];	//Creating shops
			
				for(int s=0;s<shopSize;s++){
						sh[s] = new Shops();
						tokens = new StringTokenizer(br.readLine()," ");
						for(int it =0;it<3;it++){	//Setting the amount for 3 items for each shop
							temp=(String)tokens.nextElement();
							sh[s].item[it]=Integer.valueOf(temp).intValue();
						}
				}
			// Required input received
				
				for(int s=0;s<shopSize;s++){
				//making value of one of the item of next shop in  pipeline as 105 based on the index of the least value determined from previous shop
					// 104 is the maximum value for item in a shop (as per problem statement input values cannot exceed 104)
					if(index!= -1){
						sh[s].item[index]=105;
					}
					index=compare(sh[s]);	//Identifying least value's index position 
					result += sh[s].item[index]; 
				}
				System.out.println("result "+result);
			}
		
		}catch (Exception e) {
			System.out.println("oops !  There is some problem ... Please rerun the program");
		}


	}
	public static int compare(Shops s){
		
		// General Comparison to find least value among 3 items 
 
			if(s.item[0] <s.item[1]){
				if(s.item[0] < s.item[2])
					return 0;
				else
					return 2;
			}
			
			else{
				if(s.item[1] < s.item[2]){
					return 1;
				}else
					return 2;
			}
	}
	
}
