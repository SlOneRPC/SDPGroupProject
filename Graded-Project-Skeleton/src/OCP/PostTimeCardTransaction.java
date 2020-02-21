package exampleGroupProject.principledDesign.principles.OCP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class PostTimeCardTransaction {

	public int name;
	public int pos;
	public int id;
	public Date timeCardDate;
	public Double timeCardHours;
	public Double hourlyPay;


	public void postTimeCard( List<Employee> employees ) {

		provideTimeCardDetails();

		String error = checkTransactionStructure( employees );


		if( error != null ) printErrorMessage( error );

		else executePostTimeCardTransaction( employees );
	}

	public void provideTimeCardDetails() {

		StdInput stdInput = new StdInput();

		id = Integer.parseInt( stdInput.read( "Employee ID" ) );

		timeCardDate = null;

		try {

			timeCardDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( stdInput.read( "Time Stamp Date" ) ); //String sDate1 = "31/12/1998";
		}

		catch( ParseException ex ){ ex.printStackTrace(); }

		timeCardHours = Double.parseDouble( stdInput.read( "Time Stamp Hours" ) );

		hourlyPay = Double.parseDouble( stdInput.read( "the amount of money paid for an hour" ) );
	}

	public String checkTransactionStructure( List<Employee> employees ) {

		if( timeCardDate == null || timeCardHours == null || hourlyPay == null ) return "Error posting time card transaction";


		pos = 0;

		for( pos = 0; pos < employees.size(); ++pos ) if( employees.get( pos ).employeeID == id && employees.get( pos ) instanceof HourlyEmployee ) break;

		if( pos < 0 || pos >= employees.size() ) return "Invalid employee id";

		return null;
	}

	public void printErrorMessage( String message ) {

		System.err.println( message );
	}

	public void executePostTimeCardTransaction( List<Employee> employees ) {

		Employee employee = employees.get( pos );

		TimeCard timeCard = new TimeCardImpl1( timeCardDate, timeCardHours, hourlyPay );

		((HourlyEmployee) employee).addTimeCard( timeCard );
	}
}
