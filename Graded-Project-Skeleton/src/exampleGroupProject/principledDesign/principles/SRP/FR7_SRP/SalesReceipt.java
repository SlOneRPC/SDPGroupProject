package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.util.Date;


public class SalesReceipt {

	public Date salesReceiptDate;

	public Double salesReceiptAmount;


	public SalesReceipt( Date salesReceiptDate, Double salesReceiptAmount ) {

		this.salesReceiptDate = salesReceiptDate;

		this.salesReceiptAmount = salesReceiptAmount;
	}

	public void toPrint() {

		System.out.println( "\tSales receipt dates: " + salesReceiptDate );
		System.out.println( "\tSales receipt amount: " + salesReceiptAmount );
	}
}
