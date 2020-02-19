package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.util.concurrent.atomic.AtomicInteger;


public class Employee {

	public static final AtomicInteger employeeCount = new AtomicInteger( 0 );

	public int employeeID;
	public String name;
	public String address;

	public UnionMember unionMember;

	public PaymentMethod paymentMethod;


	public Employee( String name, String address, UnionMember unionMember ) {

		this.name = name;
		this.address = address;
		this.unionMember = unionMember;


		this.employeeID = employeeCount.incrementAndGet();
	}


	public void changeEmployeeDetails( String address, PaymentMethod paymentMethod ) {

		this.address = address;

		this.paymentMethod = paymentMethod;
	}

	public void toPrint() {

		System.out.println( "employeeID = " + employeeID + ", name = " + name + ", address = " + address );

		if( unionMember != null ) unionMember.toPrint();

		if( address != null ) System.out.println( "\taddress = " + address );

		if( paymentMethod != null ) paymentMethod.toPrint();
	}
}
