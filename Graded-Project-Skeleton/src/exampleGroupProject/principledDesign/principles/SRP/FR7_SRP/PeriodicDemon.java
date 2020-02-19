package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class PeriodicDemon {

	public static void main( String[] args ) throws ParseException {

		List<Employee> employees = new ArrayList<>();

		Employee employee1 = new HourlyEmployee( "D1", "A1", new UnionMember( false ) );
		TimeCard timeCard = new TimeCard( new SimpleDateFormat( "dd/MM/yyyy" ).parse( "31/12/1998" ), 5.0, 100.0 );
		((HourlyEmployee) employee1).addTimeCard( timeCard );

		UnionMember unionMember = new UnionMember( true );
		unionMember.setServiceChargeAmount( new ServiceCharge( 100.0 ) );
		Employee employee2 = new SalariedEmployee( "D2", "A2", unionMember, 1000.0 );
		((SalariedEmployee) employee2).salary = 1000.0;

		unionMember = new UnionMember( true );
		unionMember.setServiceChargeAmount( new ServiceCharge( 100.0 ) );
		Employee employee3 = new CommissionedEmployee( "D3", "A3", unionMember, 1000.0 );
		((CommissionedEmployee) employee3).salary = 1000.0;

		employees.add( employee1 );
		employees.add( employee2 );
		employees.add( employee3 );


		StdInput stdPrint = new StdInput();

		ListPrint listPrint = new ListPrint();


		while( true ){

			listPrint.print( employees );


			System.out.println( "\n0. Exit" );
			System.out.println( "1. Weekly period" );
			System.out.println( "2. Monthly period" );
			System.out.println( "3. Biweekly period" );

			String choice = stdPrint.read( "period" );


			if( choice.equals( "0" ) ) break;

			if( choice.equals( "1" ) ){

				for( int i = 0; i < employees.size(); ++i ) {

					Employee employee = employees.get( i );

					if( employee instanceof HourlyEmployee ) { 

						WeeklySchedule w = new WeeklySchedule();

						w.calculate( (HourlyEmployee) employee );
					}
				}
			}

			else if( choice.equals( "2" ) ){

				for( int i = 0; i < employees.size(); ++i ) {

					Employee employee = employees.get( i );

					if( employee instanceof SalariedEmployee && ! (employee instanceof CommissionedEmployee) ) {

						MonthlySchedule m = new MonthlySchedule();

						m.calculate( (SalariedEmployee) employee );
					}
				}
			}

			else if( choice.equals( "3" ) ){

				for( int i = 0; i < employees.size(); ++i ) {

					Employee employee = employees.get( i );

					if( employee instanceof CommissionedEmployee ) {

						BiweeklySchedule b = new BiweeklySchedule();

						b.calculate( (CommissionedEmployee) employee );
					}
				}
			}
		}
	}
}
