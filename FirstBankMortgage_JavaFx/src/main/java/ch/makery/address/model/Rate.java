package ch.makery.address.model;

import ch.makery.address.view.MortgageController;
import domain.RateDomainModel;
import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;

public class Rate extends RateDomainModel {
	
	
	public static double getPayment(int NumberOfPayments, int creditScore, int houseCost)
	{
		//FinalExam
		//	Normally this kind of method would be in a BLL, but alas...
		
		//	Figure out payment based on:
		//	Interest rate
		//	PV
		//	FV (make FV = 0, unless you want a balloon payment
		//	Compounding = True
		//	Number of Payments (passed in)
		
		double interest = RateDAL.getRate(creditScore);
		double pv = FinanceLib.pv((interest/100)/12, NumberOfPayments, -1 * houseCost, 0, true);
		double mortgage_pay = FinanceLib.pmt((interest/100)/12, NumberOfPayments, -1*houseCost, 0, true);
		
		return mortgage_pay;
	}
}
