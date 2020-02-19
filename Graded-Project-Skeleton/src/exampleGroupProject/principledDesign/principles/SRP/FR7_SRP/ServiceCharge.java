package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;


public class ServiceCharge {

	public Double serviceChargeAmount;


	public ServiceCharge( Double serviceChargeAmount ) {

		this.serviceChargeAmount = serviceChargeAmount;
	}

	public void toPrint() {

		System.out.println( "\tService charge amount : " + serviceChargeAmount );
	}
}
