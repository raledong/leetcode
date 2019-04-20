package math;


/**
 * @author rale
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * 
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * Output: "45"
 */
public class ReconstructOriginalDigitsfromEnglish_423 {
	
	public String originalDigits(String s) {
		int[] letterCount = new int[26];
		for(char c : s.toCharArray()) {
			letterCount[c-'a']++;
		}
		
		int[] result = new int[10];
		
		//zero
		if((result[2] = letterCount['z'-'a']) != 0) {
			result[0] = letterCount['z' - 'a'];
			letterCount['z'-'a'] = 0;
			letterCount['e'-'a'] -= result[0];
			letterCount['r'-'a'] -= result[0];
			letterCount['o'-'a'] -= result[0];
		}
		//two
		if((result[2] = letterCount['w'-'a']) != 0) {
			letterCount['t'-'a'] -= result[2];
			letterCount['w'-'a'] = 0;
			letterCount['o'-'a'] -= result[2];
		}
		//four
		if((result[4] = letterCount['u'-'a']) != 0) {
			letterCount['f'-'a'] -= result[4];
			letterCount['o'-'a'] -= result[4];
			letterCount['u'-'a'] -= result[4];
			letterCount['r'-'a'] -= result[4];
		}
		//five
		if((result[5] = letterCount['f'-'a']) != 0) {
			letterCount['f'-'a'] -= result[5];
			letterCount['i'-'a'] -= result[5];
			letterCount['v'-'a'] -= result[5];
			letterCount['e'-'a'] -= result[5];
		}
		//six
		if((result[6] = letterCount['x'-'a']) != 0) {
			letterCount['s'-'a'] -= result[6];
			letterCount['i'-'a'] -= result[6];
			letterCount['x'-'a'] -= result[6];
		}
		//seven
		if((result[7] = letterCount['s'-'a']) != 0) {
			letterCount['s'-'a'] -= result[7];
			letterCount['e'-'a'] -= result[7] * 2;
			letterCount['v'-'a'] -= result[7];
			letterCount['n'-'a'] -= result[7];
		}
		//one
		if((result[1] = letterCount['o'-'a']) != 0) {
			letterCount['o'-'a'] -= result[1];
			letterCount['n'-'a'] -= result[1];
			letterCount['e'-'a'] -= result[1];
		}
		//eight
		if((result[8] = letterCount['g'-'a']) != 0) {
			letterCount['e'-'a'] -= result[8];
			letterCount['i'-'a'] -= result[8];
			letterCount['g'-'a'] -= result[8];
			letterCount['h'-'a'] -= result[8];
			letterCount['t'-'a'] -= result[8];
		}
		//nine
		if((result[9] = letterCount['i'-'a']) != 0) {
			letterCount['n'-'a'] -= result[9] * 2;
			letterCount['i'-'a'] -= result[9];
			letterCount['e'-'a'] -= result[9];
		}
		result[3] = letterCount['t'-'a'];
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<result.length ; i++) {
			for(int j = 0 ; j<result[i] ; j++) {
				sb.append(i);
			}
		}
		return sb.toString();
    }
	
	public String originalDigits2(String s) {
        int[] alphabets = new int[26];
        for (char ch : s.toCharArray()) {
            alphabets[ch - 'a'] += 1;
        }
        
        int[] digits = new int[10];
        
        digits[0] = alphabets['z' - 'a'];
        digits[2] = alphabets['w' - 'a'];
        digits[6] = alphabets['x' - 'a'];
        digits[8] = alphabets['g' - 'a'];
        digits[7] = alphabets['s' - 'a'] - digits[6];
        digits[5] = alphabets['v' - 'a'] - digits[7];
        digits[3] = alphabets['h' - 'a'] - digits[8];
        digits[4] = alphabets['f' - 'a'] - digits[5];
        digits[9] = alphabets['i' - 'a'] - digits[6] - digits[8] - digits[5];
        digits[1] = alphabets['o' - 'a'] - digits[0] - digits[2] - digits[4];
        
        StringBuilder sb = new StringBuilder();
        for (int d = 0; d < 10; d++) {
            for (int count = 0; count < digits[d]; count++) sb.append(d);
        }
        
        return sb.toString();
    }
}
