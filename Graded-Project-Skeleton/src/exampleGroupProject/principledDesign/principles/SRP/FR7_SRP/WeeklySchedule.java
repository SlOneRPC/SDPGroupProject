package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.util.List;


public class WeeklySchedule {

	public void calculate( HourlyEmployee employee ) {

		List<TimeCard> timeCards = employee.timeCards;

		double pay = 0.0;

		for( int j = 0; j < timeCards.size(); ++j ) {

			Double timeCardHours = timeCards.get( j ).timeCardHours;

			Double hourlyPay = timeCards.get( j ).hourlyPay;

			pay += timeCardHours * hourlyPay;
		}

		if( employee.unionMember.unionMember ) pay -= employee.unionMember.serviceCharge.serviceChargeAmount;

		employee.toPrint();

		System.out.println( pay );
	}
}
