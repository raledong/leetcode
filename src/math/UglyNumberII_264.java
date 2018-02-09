package math;

/**
 * @author rale
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class UglyNumberII_264 {

	public int nthUglyNumber(int n) {
        int indexOfSequenceTwo = 0;
        int indexOfSequenceThree = 0;
        int indexOfSequenceFive = 0;
        
        int numberOfSequenceTwo = 2;
        int numberOfSequenceThree = 3;
        int numberOfSequenceFive = 5;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1 ; i<n ; i++){
        	if(numberOfSequenceTwo <= numberOfSequenceThree && numberOfSequenceTwo <= numberOfSequenceFive){
        		if(numberOfSequenceTwo != result[i-1]){
            		result[i] = numberOfSequenceTwo;
        		}else{
        			i--;
        		}
        		numberOfSequenceTwo = 2 * result[++indexOfSequenceTwo];
        	}else if(numberOfSequenceThree <= numberOfSequenceTwo && numberOfSequenceThree<=numberOfSequenceFive){
        		if(numberOfSequenceThree != result[i-1]){
            		result[i] = numberOfSequenceThree;
        		}else{
        			i--;
        		}
        		numberOfSequenceThree = 3 * result[++indexOfSequenceThree];
        	}else{
        		if(numberOfSequenceFive != result[i-1]){
        			result[i] = numberOfSequenceFive;
        		}else{
        			i--;
        		}
        		numberOfSequenceFive = 5 * result[++indexOfSequenceFive];
        	}
        }
        return result[n-1];
    }
	
	public int nthUglyNumber2(int n){
        int idx1 = 0, idx2 = 0, idx3 = 0;
		int[] result = new int[n];
		result[0] = 1;
		for(int i = 1 ; i<n ; i++){
			int num1 = result[idx1] * 2;
			int num2 = result[idx2] * 3;
			int num3 = result[idx3] * 5;
			result[i] = Math.min(num1, Math.min(num2, num3));
			if(num1==result[i]) idx1++;
			if(num2==result[i]) idx2++;
			if(num3==result[i]) idx3++;
		}
		return result[n-1];
	}
	
	public static void main(String[] args){
		UglyNumberII_264 u = new UglyNumberII_264();
		System.out.println(u.nthUglyNumber(7));
	}
}
