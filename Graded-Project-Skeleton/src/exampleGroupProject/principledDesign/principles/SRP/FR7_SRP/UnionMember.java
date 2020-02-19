package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.util.concurrent.atomic.AtomicInteger;


public class UnionMember {

	public int memberID;
	public Boolean unionMember;
	public ServiceCharge serviceCharge;


	public static final AtomicInteger unionCount = new AtomicInteger( 100 );


	public UnionMember( Boolean unionMember ) {

		this.unionMember = unionMember;

		if( unionMember ) memberID = unionCount.incrementAndGet();
	}


	public void setServiceChargeAmount( ServiceCharge serviceCharge ) {

		if( serviceCharge == null ) System.err.println( "Error posting union service charge" );

		else this.serviceCharge = serviceCharge;
	}

	public void toPrint() {

		if( unionMember ) {

			System.out.println( "\tUnion number = " + memberID );

			if( serviceCharge != null ) serviceCharge.toPrint();
		}
	}
}
