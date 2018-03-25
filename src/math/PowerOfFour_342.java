package math;

public class PowerOfFour_342 {
	public boolean isPowerOfFour(int num) {
        return (num > 0) &&
        		//是否为偶数
        		((num & (num - 1)) == 0) &&
        		//是否都在奇数位上
        		((num & 0x55555555) == num);
    }
}
