package OCP;

import java.util.List;


public class BiweeklySchedule implements PaymentSchedule{

	public void calculate( Employee employee ) {

		Double pay = ((SalariedEmployee)employee).salary;

		List<SalesReceipt> salesReceipts = ((CommissionedEmployee) employee).salesReceipts;


		for( int j = 0; salesReceipts != null && j < salesReceipts.size(); ++j ) pay += salesReceipts.get( j ).salesReceiptAmount;

		if( employee.unionMember.unionMember ) pay -= employee.unionMember.serviceCharge.serviceChargeAmount;

		System.out.println( pay );
	}
}
