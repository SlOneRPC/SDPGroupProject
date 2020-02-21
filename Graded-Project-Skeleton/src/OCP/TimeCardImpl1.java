package OCP;

import java.util.Date;


public class TimeCardImpl1 extends TimeCard {

	public TimeCardImpl1( Date timeCardDate, Double timeCardHours, Double hourlyPay ) {

		super( timeCardDate, timeCardHours, hourlyPay );
	}

	public void toPrint() {

		System.out.println( "\tTime card dates: " + timeCardDate );
		System.out.println( "\tTime card hours: " + timeCardHours );
		System.out.println( "\tTime card hour pay: " + hourlyPay );
	}
}
