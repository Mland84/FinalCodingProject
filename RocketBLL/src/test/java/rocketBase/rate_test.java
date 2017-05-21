package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {
	@Test
	public void test() throws Exception {
		assert(1==0);
		try {
			assert(3.5 == RateBLL.getRate(805));
			assert(3.75 == RateBLL.getRate(751));
			assert(4.0 == RateBLL.getRate(749));
		
			assert(0.0 == RateBLL.getRate(564)); 		

		} catch (RateException e) {
			
			e.printStackTrace();
		}

	}
}
