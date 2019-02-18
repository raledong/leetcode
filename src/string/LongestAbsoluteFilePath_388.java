package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Suppose we abstract our file system by a string in the following manner:
The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
public class LongestAbsoluteFilePath_388 {

	 public int lengthLongestPath(String input) {
		 if(input==null || input.isEmpty()) return 0;
		 List<Integer> stack = new ArrayList<Integer>();
		 int left = 0, right = 0;
		 int max = 0;
		 int curDepth = 0;
		 boolean isFile = false;
		 while(right < input.length()) {
			 char c = input.charAt(right);
			 if(c == '\n' || c == '\t') {
				 if(right-1>=0 && input.charAt(right-1)!='\n' && input.charAt(right-1)!='\t') {
					 int length = right - left;
					 if(stack.isEmpty()) {
						 stack.add(length+1);
					 }else if(curDepth == 0){
						 stack.set(0, length+1);
					 }else{
						 int prev = stack.get(curDepth-1);
						 int now = prev + length + 1;
						 if(stack.size() <= curDepth) {
							 stack.add(now);
						 }else{
							 stack.set(curDepth, now);
						 }
					 }
					 if(isFile) {
						 max = Math.max(max, stack.get(curDepth)-1);
					 }
					 left = right;
					 isFile = false;
				 }
				 
				 if(right+1<input.length() && input.charAt(right+1)!='\n' && input.charAt(right+1) !='\t'){
					 curDepth = right - left;
					 left = right+1;
				 }
			 }else if(c == '.') {
				 isFile = true;
			 }
			 right++;
		 }
		 if(left != right && isFile) {
			 if(curDepth == 0) {
				 max = Math.max(max, right - left);
			 }else {
				 max = Math.max(max, stack.get(curDepth-1) + right - left);
			 }
		 }
		 return max;
	 }
	 
	 public static void main(String[] args) {
		 LongestAbsoluteFilePath_388 l = new LongestAbsoluteFilePath_388();
//		 l.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
		 l.lengthLongestPath("a");
	 }
}
