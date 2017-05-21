package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	
	
	private RateDomainModel RDM;
	
	
	public RateException (RateDomainModel RDM){
		this.RDM = RDM;
	}

	public RateDomainModel getRDM() {
		return RDM;
	}
	
	
	
}
