package OCP;

import java.util.ArrayList;
import java.util.List;


public class CommissionedEmployee extends SalariedEmployee {

	public List<SalesReceipt> salesReceipts;


	public CommissionedEmployee( String name, String address, UnionMember unionMember, double salary ) {

		super( name, address, unionMember, salary );
	}


	public void addSalesReceipt( SalesReceipt salesReceipt ) {

		if( salesReceipt == null ) System.err.println( "Error posting sales receipt transaction" );

		else{

			if( salesReceipts == null ) salesReceipts = new ArrayList<SalesReceipt>();

			salesReceipts.add( salesReceipt );
		}
	}

	public void toPrint() {

		super.toPrint();


		System.out.println( "\tcontract type: commissioned" );

		for( int i = 0; salesReceipts != null && i < salesReceipts.size(); ++i ) salesReceipts.get( i ).toPrint();
	}
}
