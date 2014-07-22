/**
* Given an absolute path for a file (Unix-style), simplify it.
* 
* For example,
* path = "/home/", => "/home"
* path = "/a/./b/../../c/", => "/c"
* click to show corner cases.
* 
* Corner Cases:
* Did you consider the case where path = "/../"?
* In this case, you should return "/".
* Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
* In this case, you should ignore redundant slashes and return "/home/foo".
*/


public class Solution {
    public String simplifyPath(String path) {
        StringBuilder ret = new StringBuilder();
        Stack<String> stack=new Stack<String>();
 
        String[] strs=path.split("/");
        for (String s: strs) {
            if (s.length()==0 ||s.equals(".")) {
                continue;  
            } else if (s.equals("..")) { // only 1 upper level
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
      
        if (stack.isEmpty()) {
            ret.append('/');
        } else{
            while (!stack.isEmpty()){
                ret.insert(0, "/"+ stack.pop());
            }
        }
 
        return ret.toString();
    }
}
