import java.util.Scanner;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HW_3 {
	public static void main (String args[]) {
		// init
		Scanner scanner = null;
		String inStr = null;
		String filename = "file.txt";
		HashMap<String,Integer> hashMap = null;

		try {
			// open 'file.txt'
			scanner = new Scanner( new FileInputStream( filename ) );

			while ( scanner.hasNextLine() ) {
				inStr = scanner.nextLine();
				hashMap = analyzeString( inStr );
				printResult( hashMap );
			}

		} catch (FileNotFoundException e) {
			System.out.println("Could not find " + filename );
		}
	}
	// String format: "XX + YY = ZZ"
	static HashMap<String,Integer> analyzeString (String inStr) {
		HashMap<String,Integer> hashMap = null;
		// TODO
		return hashMap;
	}
	static boolean checkResult (HashMap<String,Integer> hashMap, String inStr) {
		// TODO
		return false;
	}
	static void printResult (HashMap<String,Integer> hashMap) {
		// TODO
	}
}
