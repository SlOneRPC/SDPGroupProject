package exampleGroupProject.principledDesign.principles.OCP;

import java.util.List;


public class DeleteTransaction {

	public int id;
	public int pos;


	public void deleteEmployee( List<Employee> employees ) {

		provideEmployeeDetails();

		String error = checkTransactionStructure( employees );


		if( error != null ) printErrorMessage( error );

		else executeDeleteTransaction( employees );
	}

	public void provideEmployeeDetails() {

		StdInput stdInput = new StdInput();

		String value = stdInput.read( "employee ID" );

		id = Integer.parseInt( value );
	}

	public String checkTransactionStructure( List<Employee> employees ) {

		for( pos = 0; pos < employees.size(); ++pos ) if( employees.get( pos ).employeeID == id ) break;

		if( pos < 0 || pos >= employees.size() ) return "Invalid employee id";


		return null;
	}

	public void printErrorMessage( String message ) {

		System.err.println( message );
	}

	public void executeDeleteTransaction( List<Employee> employees ) {

		employees.remove( pos );
	}
}
