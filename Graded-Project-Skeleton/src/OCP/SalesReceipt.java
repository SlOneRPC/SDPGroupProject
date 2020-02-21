package OCP;

import java.util.Date;


public abstract class SalesReceipt {

	private Date salesReceiptDate;
	public Double salesReceiptAmount;


	public SalesReceipt( Date salesReceiptDate, Double salesReceiptAmount ) {

		this.salesReceiptDate = salesReceiptDate;

		this.salesReceiptAmount = salesReceiptAmount;
	}

	public abstract void toPrint();
}