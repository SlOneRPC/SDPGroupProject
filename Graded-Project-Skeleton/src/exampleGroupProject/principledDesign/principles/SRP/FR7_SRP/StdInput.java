package exampleGroupProject.principledDesign.principles.SRP.FR7_SRP;

import java.util.Scanner;


public class StdInput {

	@SuppressWarnings("resource")
	public String read( String label ) {

		/*System.out.println( "\nProvide " + label + ":" );

		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {
			value = input.readLine();
		}

		catch( IOException ex ) { ex.printStackTrace(); }*/


		System.out.println( "\nProvide " + label + ":" );

		System.out.println( ">" );

		Scanner scanner = new Scanner( System.in );

	    String value = scanner.nextLine();

	    //scanner.close();


	    return value;
	}
}
