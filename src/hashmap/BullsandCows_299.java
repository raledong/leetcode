package hashmap;

/**
 * @author rale
 * You are playing the following Bulls and Cows game with your friend: 
 * You write down a number and ask your friend to guess what the number is. 
 * Each time your friend makes a guess, you provide a hint that indicates 
 * how many digits in said guess match your secret number exactly in both digit and position (called "bulls") 
 * and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 *  
 *  For example:
 *  
 *  Secret number:  "1807"
 *  Friend's guess: "7810"
 *  Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 *  Write a function to return a hint according to the secret number and friend's guess, 
 *  use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
 *  
 *  Please note that both secret number and friend's guess may contain duplicate digits, for example:
 *  Secret number:  "1123"
 *  Friend's guess: "0111"
 *  In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 *  You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class BullsandCows_299 {
	
	public String getHint(String secret, String guess) {
		int[] digits = new int[10];
        for(int i = 0 ; i<secret.length() ; i++){
        	char c = secret.charAt(i);
        	digits[c-'0']++;
        }
        int bulls = 0;
        int cows = 0;
        for(int i = 0 ; i<secret.length(); i++){
        	int s = secret.charAt(i) - '0';
        	int g = guess.charAt(i) - '0';
        	if(s == g){
        		bulls++;
                digits[s]--;
                if(digits[s]<0){
                	cows--;
                }
        	}else if(--digits[g-'0']>=0){
        		cows++;
        	}
        }
        
        return String.format("%dA%dB", bulls,cows);
    }
	
	//少一圈遍历
	public String getHint2(String secret, String guess){
		int bulls=0,cows=0;
        int[] counter = new int[10];
        int n=secret.length();
        for(int i =0; i<n; i++){
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';
            if(s==g)
                bulls++;
            else{
                if(counter[g]>0) cows++;
                if(counter[s]<0) cows++;
                counter[s]++;
                counter[g]--;
            }   
        }    
        return bulls + "A" + cows + "B";
	}
	public static void main(String[] args){
		BullsandCows_299 b = new BullsandCows_299();
		b.getHint("1807", "7810");
	}
}
