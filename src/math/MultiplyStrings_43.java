package math;

import java.util.LinkedList;

/**
 * @author rale
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * Note:
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings_43 {

	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")){
			return "0";
		}
		
        StringBuilder result = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        if(num1.endsWith("0")){
        	for(int i = num1.length() - 1 ; i>=0 ; i--){
            	if(num1.charAt(i) == '0'){
            		count++;
            		result.append("0");
            	}else{
            		break;
            	}
            }
            num1 = num1.substring(0, num1.length()-count);
        }
        
        count = 0;
        if(num2.endsWith("0")){
        	for(int i = num2.length() - 1 ; i>=0 ; i--){
            	if(num2.charAt(i) == '0'){
            		count++;
            		result.append("0");
            	}else{
            		break;
            	}
            }
            num2 = num2.substring(0, num2.length()-count);
        }
        
        for(int i = num1.length()-1 ; i>=0 ; i--){	
        	int number1 = num1.charAt(i) - '0';
        	if(number1 == 0){
        		result.append(queue.removeFirst());
        		queue.add(0);
        		continue;
        	}
        	int carry = 0;
        	for(int j = num2.length()-1 ; j>=0 ; j--){
        		
        		int number2 = num2.charAt(j) - '0';
        		int currentVal = number1 * number2 + carry + (i==num1.length()-1?0:queue.removeFirst());
        		if(j== num2.length()-1){
        			result.append(currentVal % 10);
        		}else{
        			queue.add(currentVal % 10);
        		}
        		carry = currentVal/10;
        	}
        	queue.add(carry);
        	carry = 0;
        }
        while(!queue.isEmpty() && queue.getLast() == 0){
        	queue.removeLast();
        }
        while(!queue.isEmpty()){
        	result.append(queue.removeFirst());
        }
        return result.reverse().toString();
        
    }
	
	//num1[i]*num2[j]的值放在indice[i+j, i+j+1]的位置上
	public String multiply2(String num1, String num2){
		int m = num1.length(), n = num2.length();
	    int[] pos = new int[m + n];
	   
	    for(int i = m - 1; i >= 0; i--) {
	        for(int j = n - 1; j >= 0; j--) {
	            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
	            int p1 = i + j, p2 = i + j + 1;
	            int sum = mul + pos[p2];

	            pos[p1] += sum / 10;
	            pos[p2] = (sum) % 10;
	        }
	    }  
	    
	    StringBuilder sb = new StringBuilder();
	    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
	    return sb.length() == 0 ? "0" : sb.toString();
	}
	
	//将位数的处理和进位的处理分开来
	public String multiply3(String num1, String num2) {
		   if(num1.isEmpty() || num2.isEmpty()) return "0";
	        int m = num1.length(), n = num2.length();
	        int[] ret = new int[m+n];
	        
	        for(int i = m-1; i >= 0; i--) {
	            int n1 = num1.charAt(i)-'0';
	            for(int j = n-1; j>=0; j--) {
	                int n2 = num2.charAt(j)-'0';
	                int mul = n1*n2;
	                ret[i+j+1] += mul;
	            }
	        }
	        
	        int carryOver = 0;
	        for(int i = ret.length-1; i>=0; i--) {
	            ret[i]+=carryOver;
	            carryOver = ret[i]/10;
	            ret[i]%=10;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int x : ret) {
	            if(x == 0 && sb.length()==0) continue;
	            sb.append(x);
	        }
	        return sb.length()==0?"0":sb.toString();
	        
	    }
	
	public static void main(String[] args){
		MultiplyStrings_43 m = new MultiplyStrings_43();
		System.out.println(m.multiply("6", "501"));
	}
}
