package ctr;

public class Application {

	static String reverse(String text) {
		String result = "";
		for (int i = text.length() - 1; i >= 0; i--) {
			result += text.charAt(i);
		}
		return result;
	}

	static String reverseRekursiv(String text, int zähler) {
		System.out.println(text);
		zähler++;
		if (text.length() == 1) {
			return text;
		}
		System.out.println(zähler);
		String result = "";
		char lastChar = text.charAt(text.length() - 1);
		String lastCharString = Character.toString(lastChar);
		result += lastCharString;
		String subText = text.substring(0, text.length() - 1);
		// System.out.println(
		// "Result: " + result + "\tLastChar: " + lastCharString + "\tText: " + text +
		// "\tSubtext: " + subText);

		return result += reverseRekursiv(subText, zähler);
	}

	static String reverseEndRekursiv(String text) {
		String result = "";
		return reverseEndRekursiv_Help(text, text.length(), result);

	}

	static String reverseEndRekursiv_Help(String text, int size, String result) {
		// System.out.println("Text: " + text);

		if (text.length() == 0) {
			return result;
		}
		char lastChar = text.charAt(text.length() - 1);
		String lastCharString = Character.toString(lastChar);
		String subText = text.substring(0, text.length() - 1);
		// System.out.println(
		// "Result: " + result + "\tLastChar: " + lastCharString + "\tText: " + text +
		// "\tSubtext: " + subText);
		return reverseEndRekursiv_Help(subText, size, result + lastCharString);

	}

	public static void main(String[] args) {
		String eingabe = "<!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE>";
		String eingabe2 = "<!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE><!DOCTYPE>";

		System.out.println("-----------" + eingabe.length() + "-----------");
		try {
			for (int i = 0; i < 5000; i++) {
				eingabe += eingabe2;

				System.out.println(reverseEndRekursiv(eingabe));
				//reverseRekursiv(eingabe, eingabe.length());
			}
		} catch (StackOverflowError e) {
			System.err.println("StackOverFlow at: " + eingabe.length() + "...");
		}

		System.out.println("-----------" + eingabe.length() + "-----------");

	}

}
