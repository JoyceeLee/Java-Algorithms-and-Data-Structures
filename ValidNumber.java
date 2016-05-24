/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 */


/**
 * 特殊字符
 * 符号位‘+’，‘-’，小数点‘.’，还有‘e’和‘E’
 * 
 * 小数点 : 1）前面不能有小数点或者‘e’和‘E’；（2）前后至少有一面是数字
 * 符号位 : 1）必须是第一位或者在‘e’和‘E’后一位；（2）后一位要是数字
 * ‘e’和‘E’ :（1）前面不能有‘e’和‘E’；（2）不能是第一位或者最后一位
 */ 
// Solution 1>
public class Solution {
    public boolean isNumber(String s) {  
        if(s==null)  
            return false;  
        s = s.trim();  
        if(s.length()==0)  
            return false;  
        boolean dotFlag = false;  
        boolean eFlag = false;  
        for(int i=0;i<s.length();i++)  
        {  
            switch(s.charAt(i))  
            {  
                case '.':  
                    if(dotFlag || eFlag   
                    || ( (i==0 || s.charAt(i-1)<'0' || s.charAt(i-1)>'9') 
                        && (i==s.length()-1 || s.charAt(i+1)<'0' || s.charAt(i+1)>'9') 
                        )    
                       )  
                        return false; 
                    dotFlag = true;  
                    break;  
                case '+':  
                case '-':  
                    if( (i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E'))  
                     || i==s.length()-1 
                     || !(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'||s.charAt(i+1)=='.') ) 
                        return false;  
                    break;  
                case 'e':  
                case 'E':  
                    if(eFlag || i==s.length()-1 || i==0)  
                        return false;  
                    eFlag = true;  
                    break;  
                case '0':  
                case '1':  
                case '2':  
                case '3':  
                case '4':  
                case '5':  
                case '6':  
                case '7':  
                case '8':  
                case '9':  
                    break;  
                default:  
                    return false;  
            }  
        }  
        return true;  
    }
}

// Solution 2>
public class Solution {
    public boolean isNumber(String s) {
        if(s.trim().isEmpty()) return false;
        String regex = "[+-]?(\\d+\\.|\\.\\d+)\\d*(e[+-]?\\d+)?";
        if(s.trim().matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
}
