import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/*Authors: Michael Ressler and Levi Hill
 * Date: 19 April 2018
 * Overview: Dynamic programming for the minimum coin 
 * problem using Junit testing, Junit test class 
 */

class DynamicCoinTest {

	@Test
	void DynamicCoinEmptyArray() {
		int coins[] = {};
		int n= 0;
		Exception e = assertThrows(IllegalArgumentException.class, () -> {  DynamicCoin.numCoins(coins, n); } );
		assertEquals("Array of size 0 is not allowed", e.getMessage());
	}
	
	@Test
	void DynamicCoinZeroValue() {
		int coins[] = {1,5,10,25};
		int total = 0;
		
		assertEquals(0, DynamicCoin.numCoins(coins, total)); 
	}
	
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
	
	@Test
	void DynamicCoin21Value() {
		int coins[] = {1,5,10,20,25};
		int n = 21;
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(20);
		assertEquals(2, DynamicCoin.numCoins(coins, n));
	}
	
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

}
