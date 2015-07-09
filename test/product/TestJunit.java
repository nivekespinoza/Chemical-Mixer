package product;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {
	
	ArrayList<Solution> l;
	Solution s;
	Chamber c;
	
	public static void main(String[] args){
		
	}

	@Test
	public void testNewSolution() {	
		System.out.println(s);
		assertEquals(s.toString(),"Solution acid: 10.0 mL");
		}
}