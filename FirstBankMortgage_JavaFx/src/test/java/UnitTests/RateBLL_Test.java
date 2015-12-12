package UnitTests;

import static org.junit.Assert.*;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.Test;

import ch.makery.address.model.Rate;
import ch.makery.address.view.MortgageController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RateBLL_Test {
	
	@Test
	public void mortgageCalc_Test() {
	//Testing getPayment() method in Rate class. Comparing results to direct pmt call
		double mortgage = Rate.getPayment(360, 730, 300000);
		assertTrue(mortgage == FinanceLib.pmt(.04/12, 360, -300000, 0, true));
	}

	@Test
	public void costTooHigh_Test() {
	//Testing to see if the program will determine if house is too expensive
		MortgageController mortgageCont = new MortgageController();
		Double mortgage = Rate.getPayment(360, 730, 300000);
		
		//75000*.36 = 27000; (75000-64800)*.18 = 1836; 
		//both are greater than mortgage payment of 1429. This test should assert True
		mortgageCont.setExpenseInt(new Integer(5400));
		mortgageCont.setIncomeInt(new Integer(75000));
		assertTrue(mortgageCont.canPurchase(mortgage) == true);
		
		
		//24000*.36 = 8640; (24000-16800)*.18 = 1296; 
		//Removing yearly expenses from income leads to 
		//a value less than mortgage payment of 1429. This test should
		//pass when comparing it to false
		mortgageCont.setExpenseInt(new Integer(1400));
		mortgageCont.setIncomeInt(new Integer(24000));
		assertTrue(mortgageCont.canPurchase(mortgage) == false);
		
	
		
		
	}
}
