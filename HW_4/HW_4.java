import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HW_4 {
	public static void main (String args[]) {
		try {
			Product[] productsArray = null;
			for ( int ti=0; ti<args.length; ++ti ) {
				StringBuilder id = new StringBuilder(
						Integer.toString( ti + 1 )
					);
				while ( id.length() < 3 ) {
					id.insert( 0, "0" );
				}
				System.out.println("--" + id.toString() + "--");
				productsArray = analyzeFile( args[ti] );
				Arrays.sort( productsArray );
				for (int i=0; i<productsArray.length; ++i) {
					productsArray[i].printFormatted();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// main
	static Product[] analyzeFile (String filename)
			throws Exception {
		// init
		Scanner inputScanner = new Scanner( new FileInputStream( filename ) );
		String inputLine = null;
		String[] nameArray = null;
		String[] rateStringArray = null;
		// name
		if ( inputScanner.hasNextLine() ) {
			inputLine = inputScanner.nextLine();
			nameArray = inputLine.split(",");
		}
		Product[] productsArray = new Product[ nameArray.length ];
		for ( int i=0; i<nameArray.length; ++i ) {
			productsArray[i] = new Product();
			productsArray[i].setName( nameArray[i] );
		}
		// rate
		while ( inputScanner.hasNextLine() ) {
			inputLine = inputScanner.nextLine();
			rateStringArray = inputLine.split(",");
			for ( int i=0; i<nameArray.length; ++i ) {
				if ( rateStringArray[i].length() > 0 ) {
					productsArray[i].addRate(
							Integer.parseInt( rateStringArray[i] )
						);
				}
			}
		}
		return productsArray;
	}// analyzeFile
}
