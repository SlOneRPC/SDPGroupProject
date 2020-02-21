package OCP;

import java.util.Date;


public class SalesReceiptImpl1 extends SalesReceipt {

	public SalesReceiptImpl1( Date salesReceiptDate, Double salesReceiptAmount ) {

		super( salesReceiptDate, salesReceiptAmount );
	}

	public void toPrint() {

		System.out.println( "\tSales receipt dates: " + salesReceiptDate );
		System.out.println( "\tSales receipt amount: " + salesReceiptAmount );
	}
}
