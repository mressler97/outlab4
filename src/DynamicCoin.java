import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Authors: Michael Ressler and Levi Hill
 * Date: 19 April 2018
 * Overview: Dynamic programming for the minimum coin 
 * problem using Junit testing, Dynamic program coin change class
 */


	
public class DynamicCoin {
	
	    public static int numCoins(int coinList[], int amount)
	    {
	    	if(coinList.length == 0) {
				throw new IllegalArgumentException("Array of size 0 is not allowed");
			}
	    	int dyn[] = new int[amount+1];
	        dyn[0]=0;
	        int []prevCoin = new int[amount+1];  
	        for(int j=1;j<=amount;j++){
	            dyn[j]=Integer.MAX_VALUE;
	            for(int i=0;i<coinList.length;i++){
	                if(coinList[i]<=j && (1+dyn[j-coinList[i]] < dyn[j]) ){               
	                    dyn[j]=1+dyn[j-coinList[i]];
	                    prevCoin[j]=coinList[i];
	                }                   
	            }
	        }

	        int result = dyn[amount];
	        List<Integer> coinsAdded = new ArrayList<Integer>();
	        for(int i=amount;i>=1;){
	            coinsAdded.add(prevCoin[i]);
	            int j=i;
	            i=amount-prevCoin[i];
	            amount = amount - prevCoin[j];
	        }
	        Integer[] coins = coinsAdded.toArray(new Integer[coinsAdded.size()]);
	        System.out.println( Arrays.toString(coins)); 
	        return result;
	        }

}
