package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.util.List;


public class BiweeklySchedule {

	public void calculate( SalariedEmployee employee ) {

		Double pay = employee.salary;

		List<SalesReceipt> salesReceipts = ((CommissionedEmployee) employee).salesReceipts;


		for( int j = 0; salesReceipts != null && j < salesReceipts.size(); ++j ) pay += salesReceipts.get( j ).salesReceiptAmount;

		if( employee.unionMember.unionMember ) pay -= employee.unionMember.serviceCharge.serviceChargeAmount;

		System.out.println( pay );
	}
}
