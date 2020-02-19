package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;


public class SalariedEmployee extends Employee {

	public Double salary;


	public SalariedEmployee( String name, String address, UnionMember unionMember, Double salary ) {

		super( name, address, unionMember );


		this.salary = salary;
	}

	public void toPrint() {

		super.toPrint();

		System.out.println( "\tcontract type: salaried" );

		System.out.println( "\tSalary: " + salary );
	}
}
