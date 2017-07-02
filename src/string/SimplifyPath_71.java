package string;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * @author rale
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".

 */
public class SimplifyPath_71 {
	public String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();
        String[] pathDetail = path.split("/");
        for(int i = 0 ; i < pathDetail.length ; i++){
        	if(pathDetail[i].equals("..")){
        		if(s.isEmpty()){
        			continue;
        		}
        		s.pop();
        	}else if(pathDetail[i].equals(".") || pathDetail[i].isEmpty()){
        		continue;
        	}else{
        		s.push(pathDetail[i]);
        	}
        }
        if(s.isEmpty()){
        	return "/";
        }
        StringBuilder result = new StringBuilder();
        do{
        	result.insert(0, s.pop());
        	result.insert(0, "/");
        }while(!s.isEmpty());
        return result.toString();
    }
	
	//用链表实现堆栈功能
	public String simplifyPath2(String path){
		LinkedList<String> s = new LinkedList<String>();
		String[] pathDetail = path.split("/");
		for(int i = 0 ; i < pathDetail.length ; i++){
        	if(pathDetail[i].equals("..")){
        		if(s.isEmpty()){
        			continue;
        		}
        		s.pop();
        	}else if(pathDetail[i].equals(".") || pathDetail[i].isEmpty()){
        		continue;
        	}else{
        		s.push(pathDetail[i]);
        	}
        }
        if(s.isEmpty()){
        	return "/";
        }
        StringBuilder result = new StringBuilder();
        
        do{
        	result.append("/");
        	result.append(s.removeLast());	
        }while(!s.isEmpty());
        return result.toString();
	}
	
	//deque实现linkedlist
	public String simplifyPath3(String path) {
	    Deque<String> stack = new LinkedList<>();
	    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
	    for (String dir : path.split("/")) {
	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
	        else if (!skip.contains(dir)) stack.push(dir);
	    }
	    String res = "";
	    for (String dir : stack) res = "/" + dir + res;
	    return res.isEmpty() ? "/" : res;
	}
	public static void main(String[] args){
		SimplifyPath_71 s = new SimplifyPath_71();
		System.out.println(s.simplifyPath3("/..."));
	}
}
