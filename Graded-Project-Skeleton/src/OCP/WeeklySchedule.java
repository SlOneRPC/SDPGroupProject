package OCP;

import java.util.List;


public class WeeklySchedule implements PaymentSchedule{

	public void calculate( Employee employee ) {

		List<TimeCard> timeCards = ((HourlyEmployee)employee).timeCards;

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
