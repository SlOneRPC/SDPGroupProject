package OCP;

import java.util.List;


public class ChangeEmployeeDetailsTransaction {

	public int pos;
	public int id;
	public String address;
	public String paycheck;
	public String bank;
	public String account;
	public String mailAddress;


	public void executeChangeEmployeeDetails( List<Employee> employees ) {

		provideTimeCardDetails();

		String error = checkTransactionStructure( employees );


		if( error != null ) printErrorMessage( error );

		else executeChangeEmployeeDetailsTransaction( employees );
	}

	public void provideTimeCardDetails() {

		StdInput stdInput = new StdInput();

		id = Integer.parseInt( stdInput.read( "Employee ID" ) );

		address = stdInput.read( "address" );
		paycheck = stdInput.read( "hold paycheck" );
		bank = stdInput.read( "bank" );
		account = stdInput.read( "account" );
		mailAddress = stdInput.read( "mail address" );
	}

	public String checkTransactionStructure( List<Employee> employees ) {

		if( address == null || paycheck == null || bank == null || account == null || mailAddress == null ) return "Error change employee details transaction";


		pos = 0;

		for( pos = 0; pos < employees.size(); ++pos ) if( employees.get( pos ).employeeID == id ) break;

		if( pos < 0 || pos >= employees.size() ) return "Invalid employee id";

		return null;
	}

	public void printErrorMessage( String message ) {

		System.err.println( message );
	}

	public void executeChangeEmployeeDetailsTransaction( List<Employee> employees ) {

		Employee employee = employees.get( pos );

		PaymentMethod paymentMethod = new PaymentMethod( paycheck, mailAddress, bank, account );

		employee.changeEmployeeDetails( address, paymentMethod );
	}
}
