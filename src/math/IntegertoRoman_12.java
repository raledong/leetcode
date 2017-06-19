package math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 *Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 1. 罗马单个数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
2.一个罗马数字重复几次，就表示这个数的几倍。但同一数码不能出现三次以上。
3.遵循右加左减的规则。
左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，
而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）
左减数字必须为一位，比如8写成VIII，而非IIX。
 */
public class IntegertoRoman_12 {
	//map
	public String intToRoman(int num) {
		Map<Integer, Character> romanIntMap = new HashMap<Integer, Character>();
		romanIntMap.put(1, 'I');
		romanIntMap.put(5, 'V');
		romanIntMap.put(10, 'X');
		romanIntMap.put(50, 'L');
		romanIntMap.put(100, 'C');
		romanIntMap.put(500, 'D');
		romanIntMap.put(1000, 'M');
		StringBuilder finalResult = new StringBuilder();
		for(int i = 1 ; num>0 ; i*=10){
			StringBuilder result = new StringBuilder("");
			int digit = num%10;

			if(digit==0){
				
			}else if(digit<=3){
				for(int j = 0 ; j<digit ; j++){
					result.append(romanIntMap.get(i));
				}
			}else if(digit==4){
				result.append(romanIntMap.get(i*5));
				result.append(romanIntMap.get(i));
			}else if(digit==5){
				result.append(romanIntMap.get(i*5));
			}else if(digit<=8){
				for(int j = 0 ; j<digit-5 ; j++){
					result.append(romanIntMap.get(i));
				}
				result.append(romanIntMap.get(i*5));
			}else{
				result.append(romanIntMap.get(i*10));
				result.append(romanIntMap.get(i));
			}
			finalResult.insert(0,result.reverse());
			num /= 10;
		}
		return finalResult.toString();
    }
	
	//数组
	public String intToRoman2(int num){
		char[] romans = new char[]{'I','V','X','L','C','D','M'};
		StringBuilder finalResult = new StringBuilder();
		for(int i = 0 ; num>0 ; i++){
			StringBuilder result = new StringBuilder("");
			int digit = num%10;
            num /= 10;
			if(digit==0){
				continue;
			}else if(digit<=3){
				for(int j = 0 ; j<digit ; j++){
					result.append(romans[i*2]);
				}
			}else if(digit==4){
				result.append(romans[i*2+1]);
				result.append(romans[i*2]);
			}else if(digit==5){
				result.append(romans[i*2+1]);
			}else if(digit<=8){
				for(int j = 0 ; j<digit-5 ; j++){
					result.append(romans[i*2]);
				}
				result.append(romans[i*2+1]);
			}else{
				result.append(romans[i*2+2]);
				result.append(romans[i*2]);
			}
			finalResult.insert(0,result.reverse());
			
		}
		return finalResult.toString();
	}
	
	//穷尽枚举！！！
	public String intToRoman3(int num) {
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
        StringBuilder sb = new StringBuilder();
    
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
	public static void main(String[] args){
		IntegertoRoman_12 i = new IntegertoRoman_12();
		System.out.println(i.intToRoman3(3999));
	}
}
