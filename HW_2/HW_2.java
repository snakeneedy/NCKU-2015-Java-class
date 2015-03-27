import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HW_2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner( System.in );
		System.out.printf("Input a filename: ");
		String filename = scanner.nextLine();

		int lineCount = countFileLines( filename );
		String resString = stringStream( filename );

		// replace "hate" with "love"
		if( lineCount % 2 == 1 ) {
			// odd lines
			resString = resString.replaceFirst( "hate", "love" );
		}
		else {
			// even lines
			int i = resString.lastIndexOf("hate");
			resString = (resString.substring(0, i) + "love" + resString.substring( i+4 ));
		}

		// replace all "Java" with "Java Software Development"
		String copyString = resString, tmpString = resString, oriString = resString;
		resString = "";
		tmpString = tmpString.toUpperCase();
		int index = (-1), preIndex = (-1);
		while( (index = tmpString.indexOf("JAVA")) != (-1) ) {
			preIndex = index;
			resString = resString + copyString.substring(0, index) + "Java Software Development";
			copyString = copyString.substring(index + 4);
			tmpString = tmpString.substring(index + 4);
		}
		if( preIndex==index ) {
			// no replacement is processed
			resString = oriString;
		}
		else {
			resString = resString + copyString;
		}

		// result
		System.out.print( resString );
	}// end of main()

	static int countFileLines( String filename ) {
		Scanner scanner = null;
		int num = 0;
		try{
			scanner = new Scanner( new FileInputStream( filename ) );
			while( scanner.hasNextLine() ){
				scanner.nextLine();
				num++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}
		return num;
	}

	static String stringStream ( String filename ) {
		String str = "";
		try {
			Scanner fileScanner = new Scanner( new FileInputStream( filename ) );
			while( fileScanner.hasNextLine() ){
				str = str + fileScanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}
		return str;
	}
}
// end of java
