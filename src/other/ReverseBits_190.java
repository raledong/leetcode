package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rale
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits_190 {
	
	public int reverseBits(int n) {
		int mask = 1;
		int result = 0;
        for(int i=0 ; i<32 ; i++){
        	result <<= 1;
        	result |= (n & mask);
        	n >>= 1;
        }
        return result;
    }
	
	/**
	 * 充分利用缓存 将32bit转化为4个长度为8bit的byte
	 * @param n
	 * @return
	 */
	Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
	public int reverseBits2(int n){
		byte[] bytes = new byte[4];
		for(int i = 0 ; i<4 ; i++){
			// 获得8位并转换为1个byte
			bytes[i] = (byte) ((n>>>(i*8)) & 0xff);
		}
		int result = 0;
		for(int i = 0 ; i<4 ; i++){
			result += reverseByte(bytes[i]);
			if(i<3) result<<=8;
		}
		return result;
	}
	
	public int reverseByte(byte b){
		Integer value = cache.get(b);
		if(value != null) return value;
		value = 0;
		for(int i = 0 ; i<8 ; i++){
			value += ((b>>>i) & 1);
			if(i<7) value <<= 1;
		}
		cache.put(b, value);
		return value;
	}
	public static void main(String[] args){
		ReverseBits_190 r = new ReverseBits_190();
		System.out.println(r.reverseBits(2));
	}
}
