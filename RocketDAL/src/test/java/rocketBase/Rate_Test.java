package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import rocketDomain.RateDomainModel;


public class Rate_Test {

	private static RateDAL _RateDAL = new RateDAL();
	
	ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
	
	@Test
	public void test() {
		
		
		
		int size = rates.size();
		System.out.println ("Rates size: " + size);
		assert(size > 0);
		
		
	}
	
	@AfterClass
	public void takedown(){
		rates =null;
	}
	
	


}
