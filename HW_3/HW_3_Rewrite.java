import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class HW_3_Rewrite {
  public static void main(String[] args) {
    String filename = "file.txt";
    try {
      Scanner scanner = new Scanner(new FileInputStream(filename));
      String sentence;
      HashMap<String, Integer> hashMap;

      while (scanner.hasNextLine()) {
        sentence = scanner.nextLine();
        hashMap = analyzeString(sentence);
        printResult(hashMap);
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  } // main

  static HashMap<String, Integer> analyzeString(String sentence) {
    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    for (int i = 0; i < sentence.length(); i++) {
      char ch = sentence.charAt(i);
      if ('A' <= ch && ch <= 'Z' && hashMap.get(ch) == null) {
        hashMap.put("" + ch, 0);
      }
    }

    while (checkNumNotRepeated(hashMap) == false
        || checkResult(sentence, hashMap) == false) {
      plusHashMap(hashMap);
    }
    return hashMap;
  } // analyzeString

  static boolean checkNumNotRepeated(HashMap<String, Integer> hashMap) {
    for (String key1 : hashMap.keySet()) {
      for (String key2 : hashMap.keySet()) {
        if (key1 != key2 && hashMap.get(key1) == hashMap.get(key2)) {
          return false;
        }
      }
    }
    return true;
  } // checkNumNotRepeated

  static boolean checkResult(String sentence,
      HashMap<String, Integer> hashMap) {
    Integer sum = 0, ans = 0;
    // replace letters with numbers
    for (String key : hashMap.keySet()) {
      int num = hashMap.get(key);
      sentence = sentence.replaceAll(key, Integer.toString(num));
    }
    // split String with " + " or " = "
    String[] strAry = sentence.split(" \\+ | = ");
    // check
    int len = Array.getLength(strAry);
    for (int i = 0; i < len; i++) {
      if (strAry[i].charAt(0) == '0') return false;

      if (i + 1 == len) {
        ans = Integer.parseInt(strAry[i]);
      } else {
        sum += Integer.parseInt(strAry[i]);
      }
    }

    if (sum.equals(ans)) return true;

    return false;
  } // checkResult

  static void plusHashMap(HashMap<String, Integer> hashMap) {
    int carry = 1, num = 0;
    for (String key : hashMap.keySet()) {
      if (carry == 0) break;

      num = hashMap.get(key) + carry;
      if (num > 9) {
        num = 0;
        carry = 1;
      } else {
        carry = 0;
      }
      hashMap.put(key, num);
    }
  } // plusHashMap

  static void printResult(HashMap<String, Integer> hashMap) {
    TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
    for (Object key : treeMap.keySet()) {
			System.out.print("(" + key + "," + treeMap.get( key ) + "); ");
    }
    System.out.println();
  } // printResult
}
