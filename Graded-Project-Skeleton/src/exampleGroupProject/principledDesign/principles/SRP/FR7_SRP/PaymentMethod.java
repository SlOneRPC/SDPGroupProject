package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;


public class PaymentMethod {

	public String paycheck;
	public String mailAddress;
	public String bank;
	public String account;


	public PaymentMethod( String paycheck, String mailAddress, String bank, String account ) {

		this.paycheck = paycheck;
		this.mailAddress = mailAddress;
		this.bank = bank;
		this.account = account;
	}

	public void toPrint() {

		if( paycheck != null ) System.out.println( "\tpaycheck = " + paycheck );
		if( mailAddress != null ) System.out.println( "\tmailAddress = " + mailAddress );
		if( bank != null ) System.out.println( "\tbank = " + bank );
		if( account != null ) System.out.println( "\taccount = " + account );
	}
}
