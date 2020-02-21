package OCP;

import java.util.ArrayList;
import java.util.List;


public class EmployeeUI {

	public static void main( String[] args ) {

		List<Employee> employees = new ArrayList<>();

		StdInput stdInput = new StdInput();

		ListPrint listPrint = new ListPrint();


		Employee employee1 = new HourlyEmployee( "D1", "A1", new UnionMember( true ) );

		Employee employee2 = new SalariedEmployee( "D2", "A2", new UnionMember( true ), 1000.0 );
		((SalariedEmployee) employee2).salary = 1000.0;
		employee2.unionMember.setServiceChargeAmount( new ServiceCharge( 100.0 ) );

		Employee employee3 = new CommissionedEmployee( "D3", "A3", new UnionMember( true ), 1000.0 );
		((CommissionedEmployee) employee3).salary = 900.0;
		employee3.unionMember.setServiceChargeAmount( new ServiceCharge( 100.0 ) );


		employees.add( employee1 );
		employees.add( employee2 );
		employees.add( employee3 );


		while( true ){

			listPrint.print( employees );

			System.out.println( "\n0. Exit" );
			System.out.println( "1. Post a Time Card" );
			System.out.println( "2. Post a Sales Receipt" );
			String choice = stdInput.read( "choice" );


			if( choice.equals( "0" ) ) break;

			else if( choice.equals( "1" ) ) {

				PostTimeCardTransaction postTimeCardTransaction = new PostTimeCardTransaction();

				postTimeCardTransaction.postTimeCard( employees );
			}

			else if( choice.equals( "2" ) ) {

				PostSalesReceiptTransaction postSalesReceiptTransaction = new PostSalesReceiptTransaction();

				postSalesReceiptTransaction.postSalesReceipt( employees );
			}
		}
	}
}
