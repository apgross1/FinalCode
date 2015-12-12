package UnitTests;

import static org.junit.Assert.*;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.Test;

import ch.makery.address.model.Rate;

public class RateBLL_Test {

	@Test
	public void mortgageCalc_Test() {
		double mortgage = FinanceLib.pmt(.04/12, 360, -300000, 0, true);
		System.out.println(mortgage);
	}

}
