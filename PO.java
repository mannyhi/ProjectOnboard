// Create function that takes a number as an argument and returns true if the number is a valid credit card number, false otherwise.
// Credit card numbers must be between 14-19 digits in length, and pass the Luhn test, described below:

// Remove the last digit (this is the "check digit").
// Reverse the number.
// Double value of each digit in odd-numbered positions. If doubled value has more than 1 digit, add digits together (ex: 8 x 2 = 16 --> 1 + 6 = 7)
// Add all digits.
// Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.

// Examples:  	validateCard(1234567890123452) --> true
// 				validateCard(1234567890123456) --> false
// 				Step 1: check digit = 6, num = 123456789012345
// 				Step 2: num reversed = 543210987654321
// 				Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
// 				Step 4: sum = 58
// 				Step 5: 10 - 8 = 2 (not equal to 6) --> false

package ProjectOnobard;
import java.util.ArrayList;
import java.util.Collections;

public class PO {
	public static boolean validateCard(String cc) {
		ArrayList<Integer> ccNumbers = new ArrayList<>();
		if (cc.length() >= 14 && cc.length() <= 19) {
			for (int i = 0; i < cc.length(); i++) { ccNumbers.add(cc.charAt(i) - '0'); }
			int checkDigit = ccNumbers.remove(cc.length() - 1);
			Collections.reverse(ccNumbers);
			for (int i = 0; i < cc.length(); i += 2) {
				if (ccNumbers.get(i) * 2 < 10) { ccNumbers.set(i, ccNumbers.get(i) * 2); } 
				else { ccNumbers.set(i, 1 + (ccNumbers.get(i) * 2) % 10); }
			}
			int sum = 0;
			for (int i = 0; i < cc.length() - 1; i++) { sum += ccNumbers.get(i); }
			if ((10 - (sum % 10)) == checkDigit) { return true;	}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(validateCard("1234567890123452"));
		System.out.println(validateCard("1234567890123456"));
	}
}
