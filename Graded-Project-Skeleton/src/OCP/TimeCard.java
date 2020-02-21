package exampleGroupProject.principledDesign.principles.OCP;

import java.util.Date;


public abstract class TimeCard {

	public Date timeCardDate;
	public Double timeCardHours;
	public Double hourlyPay;


	public TimeCard( Date timeCardDate, Double timeCardHours, Double hourlyPay ) {

		this.timeCardDate = timeCardDate;
		this.timeCardHours = timeCardHours;
		this.hourlyPay = hourlyPay;
	}

	public abstract void toPrint();
}
