package OCP;

import java.util.List;


public class AddTransactionImpl1 implements AddTransaction {

	String name;
	String address;
	String contractType;
	String unionMember;
	String salary;
	String commissionRate;


	public void addNewEmployee( List<Employee> employees ) {

		provideEmployeeDetails();

		String error = checkTransactionStructure();


		if( error != null ) printErrorMessage( error );

		else executeAddTransaction( employees );
	}

	public void provideEmployeeDetails() {

		StdInput object = new StdInput();

		name = object.read( "name" );
		address = object.read( "address" );
		contractType = object.read( "contract type (hourly-rate, monthly-salary)" );
		unionMember = object.read( "unionMember" );


		if( contractType.equals( "monthly-salary" ) ) {

			salary = object.read( "salary" );
			commissionRate = object.read( "commissionRate" );
		}
	}

	public String checkTransactionStructure() {

		if( contractType == null || (contractType != null && ! contractType.equals( "hourly-rate" ) && ! contractType.equals( "monthly-salary" ) ) ) return "Error contract type";

		if( name == null || address == null ) return "Error employee transaction";

		//TODO: more checks about the structure, like name + surname, etc.


		return null;
	}

	public void printErrorMessage( String message ) {

		System.err.println( message );
	}

	public void executeAddTransaction( List<Employee> employees ) {

		Employee employee = null;

		if( contractType.equals( "monthly-salary" ) ) {

			if( Boolean.parseBoolean( commissionRate ) ) employee = new CommissionedEmployee( name, address, new UnionMember( Boolean.parseBoolean( unionMember ) ), Double.parseDouble( salary ) );

			else employee = new SalariedEmployee( name, address, new UnionMember( Boolean.parseBoolean( unionMember ) ), Double.parseDouble( salary ) );
		}

		else if( contractType.equals( "hourly-rate" ) ) employee = new HourlyEmployee( name, address, new UnionMember( Boolean.parseBoolean( unionMember ) ) );


		employees.add( employee );
	}

	
}
