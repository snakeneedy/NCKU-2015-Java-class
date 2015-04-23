import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
public class TextConverter {
	private static final String className = "TextConverter";
	public static void main (String[] args) {
		System.out.println("[demo] --- init " + className + " ---");
		printMarkdownToHtmlRule();
		System.out.println("[demo] --- end " + className + " ---");
	}
	public static void markdownToHtml ( String source ) {
	}
	public static void printMarkdownToHtmlRule () {
		System.out.println("[process] printMarkdownToHtmlRule");
		try {
			Scanner scanner = new Scanner(
				new FileInputStream("docMarkdownToHtml.txt") );
			while ( scanner.hasNextLine() ) {
				System.out.println( scanner.nextLine() );
			}
		} catch (FileNotFoundException e) {
			System.out.println("[error] docMarkdownToHtml.txt is not found.");
		}
	}
}
