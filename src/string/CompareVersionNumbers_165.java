package string;

/**
 * @author rale
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers_165 {
	
	/**
	 * 调用API的将每个版本内的string转化为interger后再进行比较
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		String[] v1Detail = version1.split("\\.");
		String[] v2Detail = version2.split("\\.");
		int i = 0;
		while(i<v1Detail.length && i<v2Detail.length){
			int tempV1 = Integer.parseInt(v1Detail[i]);
			int tempV2 = Integer.parseInt(v2Detail[i]);
			if(tempV1<tempV2) return -1;
			if(tempV1>tempV2) return 1;
			i++;
		}
		while(i<v2Detail.length && Integer.parseInt(v2Detail[i])==0) i++;
		while(i<v1Detail.length && Integer.parseInt(v1Detail[i])==0) i++;
		if(i>=v1Detail.length && i>=v2Detail.length) return 0;
		else if(i>=v1Detail.length) return -1;
		return 1;
    }
	
	public static void main(String[] args){
		CompareVersionNumbers_165 c = new CompareVersionNumbers_165();
		c.compareVersion("1", "1.0.1");
	}
	
	public int compareVersion2(String version1, String version2){
		int i = 0;
		int j = 0;
		int length1 = version1.length();
		int length2 = version2.length();
		while(i<length1 || j<length2){
			int num1 = 0, num2 = 0;
			while(i<length1 && version1.charAt(i)!='.') num1 = num1*10+(version1.charAt(i++)-'0');
			while(j<length2 && version2.charAt(j)!='.') num2 = num2*10+(version2.charAt(j++)-'0');
			if(num1>num2) return 1;
			else if(num1<num2) return -1;
			i++;
			j++;
		}
		return 0;
	}
	
}
