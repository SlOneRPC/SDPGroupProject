package exampleGroupProject.principledDesign.principles.OCP;


public class MonthlySchedule implements PaymentSchedule{

	public void calculate( Employee employee ) {

		Double pay = ((SalariedEmployee)employee).salary;

		if( employee.unionMember.unionMember ) pay -= employee.unionMember.serviceCharge.serviceChargeAmount;

		employee.toPrint();

		System.out.println( pay );
	}
}
