package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.util.Date;


public class TimeCard {

	public Date timeCardDate;
	public Double timeCardHours;
	public Double hourlyPay;


	public TimeCard( Date timeCardDate, Double timeCardHours, Double hourlyPay ) {

		this.timeCardDate = timeCardDate;
		this.timeCardHours = timeCardHours;
		this.hourlyPay = hourlyPay;
	}

	public void toPrint() {

		System.out.println( "\tTime card dates: " + timeCardDate );
		System.out.println( "\tTime card hours: " + timeCardHours );
		System.out.println( "\tTime card hour pay: " + hourlyPay );
	}
}
