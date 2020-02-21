package OCP;

import java.util.ArrayList;
import java.util.List;


public class AdminOfficeUI {

	public static void main( String[] args ) {

		List<Employee> employees = new ArrayList<>();

		StdInput stdInput = new StdInput();

		ListPrint listPrint = new ListPrint();

		while( true ) {

			System.out.println( "\n0. Exit" );
			System.out.println( "1. Add new employee" );
			System.out.println( "2. Delete employee" );
			System.out.println( "3. Post Union Service Charge" );
			System.out.println( "4. Changing Employee Details" );
			String choice = stdInput.read( "choice" );


			if( choice.equals( "0" ) ) break;

			else if( choice.equals( "1" ) ) {

				AddTransaction object = new AddTransactionImpl1();

				object.addNewEmployee( employees );
			}

			else if( choice.equals( "2" ) ) {

				DeleteTransaction object = new DeleteTransaction();

				object.deleteEmployee( employees );
			}

			else if( choice.equals( "3" ) ) {

				PostUnionServiceChargeTransaction object = new PostUnionServiceChargeTransaction();

				object.postUnionServiceCharge( employees );
			}

			else if( choice.equals( "4" ) ) {

				ChangeEmployeeDetailsTransaction object = new ChangeEmployeeDetailsTransaction();

				object.executeChangeEmployeeDetailsTransaction( employees );
			}


			listPrint.print( employees );
		}
	}
}
