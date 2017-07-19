package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses_93 {

	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int length = s.length();
		if(s==null || s.length()<4 || s.length()>12) return result; 
        for(int i = 1 ; i<4&&i<length-2 ; i++){
        	for(int j = i+1 ; j<i+4&&j<length-1 ; j++){
        		for(int k = j+1 ; k<j+4 && k<length ; k++){
        			String s1 = s.substring(0,i),
            				s2 = s.substring(i,j), 
            				s3 = s.substring(j,k), 
            				s4 = s.substring(k);
            		if(isValid(s1) && isValid(s2)&& isValid(s3) && isValid(s4)){
            			result.add(s1+"."+s2+"."+s3+"."+s4);
            		}
        		}
        	}
        }
        return result;
    }
	
	private boolean isValid(String s){
		if(s.length()!=1 && s.startsWith("0")) return false;
		if(Integer.parseInt(s)>255) return false;
		return true;
	}
	
	
}
