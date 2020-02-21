package OCP;

import java.util.ArrayList;
import java.util.List;


public class HourlyEmployee extends Employee {

	public List<TimeCard> timeCards;


	public HourlyEmployee( String name, String address, UnionMember unionMember ) {

		super( name, address, unionMember );
	}


	public void addTimeCard( TimeCard timeCard ) {

		if( timeCards == null ) timeCards = new ArrayList<TimeCard>();

		timeCards.add( timeCard );
	}

	public void toPrint() {

		super.toPrint();


		System.out.println( "\tcontract type: hourly" );

		for( int i = 0; timeCards != null && i < timeCards.size(); ++i ) timeCards.get( i ).toPrint();
	}
}
