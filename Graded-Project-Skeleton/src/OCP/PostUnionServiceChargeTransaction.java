package exampleGroupProject.principledDesign.principles.OCP;

import java.util.List;


public class PostUnionServiceChargeTransaction {

	public int pos;
	public int id;
	public Double serviceChargeAmount;


	public void postUnionServiceCharge( List<Employee> employees ) {

		provideTimeCardDetails();

		String error = checkTransactionStructure( employees );


		if( error != null ) printErrorMessage( error );

		else executePostUnionServiceChargeTransaction( employees );
	}

	public void provideTimeCardDetails() {

		StdInput stdInput = new StdInput();

		id = Integer.parseInt( stdInput.read( "Employee ID" ) );

		serviceChargeAmount = Double.parseDouble( stdInput.read( "service charge amount" ) );
	}

	public String checkTransactionStructure( List<Employee> employees ) {

		if( serviceChargeAmount == null ) return "Error posting union service charge transaction";


		pos = 0;

		for( pos = 0; pos < employees.size(); ++pos ) if( employees.get( pos ).employeeID == id ) break;

		if( pos < 0 || pos >= employees.size() ) return "Invalid employee id";

		return null;
	}

	public void printErrorMessage( String message ) {

		System.err.println( message );
	}

	public void executePostUnionServiceChargeTransaction( List<Employee> employees ) {

		Employee employee = employees.get( pos );

		ServiceCharge serviceCharge = new ServiceCharge( serviceChargeAmount );

		employee.unionMember.setServiceChargeAmount( serviceCharge );
	}
}
