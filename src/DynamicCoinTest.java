import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/*Authors: Michael Ressler and Levi Hill
 * Date: 19 April 2018
 * Overview: Dynamic programming for the minimum coin 
 * problem using Junit testing, Junit test class 
 */

class DynamicCoinTest {

	//exception for no coin value
	@Test
	void DynamicCoinEmptyArray() { 
		int coins[] = {};
		int n= 0;
		Exception e = assertThrows(IllegalArgumentException.class, () -> {  DynamicCoin.numCoins(coins, n); } );
		assertEquals("Array of size 0 is not allowed", e.getMessage());
	}
	
	//test with change total of zero 
	@Test
	void DynamicCoinZeroValue() { 
		int coins[] = {1,5,10,25};
		int total = 0;
		
		assertEquals(0, DynamicCoin.numCoins(coins, total)); 
	}
	
	//test dynamic programming works properly with 63 change value, different coin values
	@Test
	void DynamicCoin63Value() {  
		int coins[] = {1,5,10,21,25};
		int n = 63;
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(21);
		testList.add(21);
		testList.add(21);
		assertEquals(3, DynamicCoin.numCoins(coins, n));
	}
	
	//test dp with 21 change value, different coin values
	@Test
	void DynamicCoin21Value() {  
		int coins[] = {1,5,10,20,25};
		int n = 21;
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(20);
		assertEquals(2, DynamicCoin.numCoins(coins, n));
	}
	
	//test to see how it handled prev greedy example from inlab
	@Test
	void DynamicCoin42Value() { 
		int coins[] = {1,5,10,25};
		int n = 42;
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(1);
		testList.add(5);
		testList.add(10);
		testList.add(25);
		assertEquals(5, DynamicCoin.numCoins(coins, n));
	}
	
	//additional dp test
	@Test
	void DynamicCoin14Value() { 
		int coins[] = {1,5,7,10,25};
		int n = 14;
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(7);
		testList.add(7);
		assertEquals(2, DynamicCoin.numCoins(coins, n));
	}

	//additional normal test
	@Test
	void DynamicCoin66Value() { 
		int coins[] = {1,5,10,25};
		int n = 66;
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(25);
		testList.add(25);
		testList.add(10);
		testList.add(5);
		testList.add(1);
		assertEquals(5, DynamicCoin.numCoins(coins, n));
	}
}
