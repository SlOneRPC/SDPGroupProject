package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class PostSalesReceiptTransaction {

	public int name;
	public int pos;
	public int id;
	public Date salesReceiptDate;
	public Double salesReceiptAmount;


	public void postSalesReceipt( List<Employee> employees ) {

		provideSalesReceiptDetails();

		String error = checkTransactionStructure( employees );


		if( error != null ) printErrorMessage( error );

		else executeSalesReceiptTransaction( employees );
	}

	public void provideSalesReceiptDetails() {

		StdInput stdInput = new StdInput();

		id = Integer.parseInt( stdInput.read( "Employee ID" ) );

		salesReceiptDate = null;

		try {

			salesReceiptDate = new SimpleDateFormat( "dd/MM/yyyy" ).parse( stdInput.read( "Sales Receipt Date" ) ); //String sDate1 = "31/12/1998";
		}

		catch( ParseException ex ){ ex.printStackTrace(); }

		salesReceiptAmount = Double.parseDouble( stdInput.read( "Salares Receipt Amount" ) );
	}

	public String checkTransactionStructure( List<Employee> employees ) {

		if( salesReceiptDate == null || salesReceiptAmount == null ) return "Error posting sales receipt transaction";


		pos = 0;

		for( pos = 0; pos < employees.size(); ++pos ) if( employees.get( pos ).employeeID == id && employees.get( pos ) instanceof CommissionedEmployee ) break;

		if( pos < 0 || pos >= employees.size() ) return "Invalid employee id";

		return null;
	}

	public void printErrorMessage( String message ) {

		System.err.println( message );
	}

	public void executeSalesReceiptTransaction( List<Employee> employees ) {

		Employee employee = employees.get( pos );

		SalesReceipt salesReceipt = new SalesReceipt( salesReceiptDate, salesReceiptAmount );

		((CommissionedEmployee) employee).addSalesReceipt( salesReceipt );
	}
}
