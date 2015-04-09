import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
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
	// String format: "XX + YY = ZZ
	static HashMap<String,Integer> analyzeString (String inStr) {
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		// count how many distinct letters
		int count = 0;
		for (int i=0; (i<inStr.length()) ;i++) {
			if ( 'A' <= inStr.charAt(i)
			&& inStr.charAt(i) <= 'Z'
			&& hashMap.get( inStr.substring(i,i+1) )==null ){
				hashMap.put( inStr.substring(i,i+1), 0 );
				count++;
			}
		}
		//System.out.println("[debug] count = " + count);

		// init
		Integer[] numArray = new Integer[count];
		for (int i=0; i<count; i++) {
			numArray[i] = 0;
		}
		// replace and checkResult
		while ( ! checkResult( hashMap, inStr ) ) {
			int index = 0;
			// 
			index = 0;
			for ( String key : hashMap.keySet() ) {
				hashMap.put( key, numArray[ index ] );
				index++;
			}
			// plus
			do {
				plusNumArray( numArray, count );
			} while ( ! checkNumArrayNotRepeated( numArray, count ) );
		}
		return hashMap;
	}
	static boolean checkResult (HashMap<String,Integer> hashMap, String inStr) {
		// replace letters with numbers
		for ( String key : hashMap.keySet() ) {
			inStr = inStr.replaceAll( key
				, Integer.toString( hashMap.get(key) )
				);
		}
		// split String with " + " or " = "
		String[] stringArray = inStr.split(" \\+ | = ");

		// check the result
		Integer sum = 0, ans = 0;
		int len = Array.getLength( stringArray );
		//System.out.println("[debug]");
		for (int i=0; i<len; ++i) {
			//System.out.println( stringArray[i] );
			if ( stringArray[i].charAt(0) == '0' ) {
				return false;
			}
			if (i+1==len)
				ans = Integer.parseInt( stringArray[i] );
			else
				sum += Integer.parseInt( stringArray[i] );
		}
		// return statement
		if ( sum.equals(ans) ) {
			//System.out.println("[debug] sum=" + sum + " ans=" + ans + " true.");
			return true;
		}
		else {
			//System.out.println("[debug] sum=" + sum + " ans=" + ans + " false.");
			return false;
		}
	}
	static void plusNumArray ( Integer[] numArray, int count ) {
		int index = 0;
		numArray[0]++;
		while (index < count && numArray[index] > 9) {
			numArray[index] = 0;
			if (index + 1 < count) {
				numArray[index + 1]++;
			}
			index++;
		}
	}
	static boolean checkNumArrayNotRepeated ( Integer[] numArray, int count ) {
		boolean res = true;
		for (int i=0; i<count; i++) {
			for (int j=0; j<count; j++) {
				if ( i!=j && numArray[i]==numArray[j] ) {
					res = false;
					break;
				}
			}
			if (res == false)
				break;
		}
		return res;
	}
	static void printResult (HashMap<String,Integer> x) {
		TreeMap<String, Integer> hashMap = new TreeMap<String, Integer>( x );
		for ( Object key : hashMap.keySet() ) {
			System.out.print("(" + key + "," + hashMap.get( key ) + "); ");
		}
		System.out.println();
	}
}
