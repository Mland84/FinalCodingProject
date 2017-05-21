package rocketBase;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import exceptions.RateException;
import rocketDomain.RateDomainModel;
import util.HibernateUtil;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	public static int MinimumCreditScore;
	public static final double LoanIncome = 0.25;
	public static final double LoanExpenses = 0.36;
	private static ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
	private static RateDomainModel rdm;

	public static double getRate(int GivenCreditScore) throws Exception {
		if (rates == null) {
			try {
				rates = RateDAL.getAllRates();
				MinimumCreditScore = 850;
				for (int rdm = 0; rdm < rates.size(); rdm++) {
					int cr = rates.get(rdm).getiMinCreditScore();
					if (cr < MinimumCreditScore) {
						MinimumCreditScore = cr;
					}
				}
			} catch (Exception e) {
				throw e;
			}
		}
				

			
				double interestrate = -1.0;
				for (int i = 0; i < rates.size(); i++) {
					rdm = rates.get(i);
					if (rdm.getiMinCreditScore() <= GivenCreditScore) {
						interestrate = rdm.getdInterestRate();
						break;
					}
				}
				if (interestrate < 0.0) {
					throw new RateException(rdm);
				}
				else{
					 interestrate=interestrate/100.0;
				}
				return interestrate;
			}
		
		
	
		
	

	

	public static double getPayment(double rate, double numperiods, double present, double future, boolean t) {
		return FinanceLib.pmt(rate, numperiods, present, future, t);
	}

	public static double maximumPayment(double income, double expenses) {
		if (expenses >= income * LoanExpenses) {
			return 0.0;
		} else {
			return Math.min(income * LoanIncome, income * LoanExpenses - expenses);
		}
	}
}
