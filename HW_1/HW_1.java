public class HW_1 {
	public static void main(String args[]) {
		String first = "jeremy", last = "lin";

		String res = firstToUpperCase( first.substring(1) + first.substring(0, 1) + "ay" )
			+ " " + firstToUpperCase( last.substring(1) + last.substring(0, 1) + "ay" );

		System.out.println( res );
	}
	static String firstToUpperCase( String str ) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
