package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math = new MyMath();
	
	@Test
	void calculateSum_ThreeMemberArray() {
		assertEquals(5, math.calculateSum(new int[] {1, 2, 3}));
		// 실패가 없으면 통과한다.
		// fail("Not yet implemented");
	}
	
	@Test
	void calculateSum_ZeroLengthArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
	}


}
