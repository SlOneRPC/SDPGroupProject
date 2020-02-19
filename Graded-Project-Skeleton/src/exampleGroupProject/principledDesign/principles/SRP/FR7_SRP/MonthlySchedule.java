package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;


public class MonthlySchedule {

	public void calculate( SalariedEmployee employee ) {

		Double pay = employee.salary;

		if( employee.unionMember.unionMember ) pay -= employee.unionMember.serviceCharge.serviceChargeAmount;

		employee.toPrint();

		System.out.println( pay );
	}
}
