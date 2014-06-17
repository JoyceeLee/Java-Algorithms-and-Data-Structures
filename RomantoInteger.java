/**
* Given a roman numeral, convert it to an integer.
* 
* Input is guaranteed to be within the range from 1 to 3999.
* 
* 右加左减。
* 左减的数字有限制，仅限于I、X、C（比如45不可以写成VL，只能是XLV）
* 左减时不可跨越一个位数。（如99不可以用 IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示）
* 左减数字必须为一位。
* 右加数字不可连续超过三位。
*/

public class Solution {
    public int romanToInt(String s) {
        char[] A = s.toCharArray();
        int sum = 0;
        for(int i=0; i<A.length; i++){
            switch(A[i]){
                case 'I':
                    if(i<(A.length-1) && (A[i+1]=='V' || A[i+1]=='X')) { sum -= 1;}
                    else sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if(i<(A.length-1) && (A[i+1]=='L' || A[i+1]=='C')) {sum -= 10;}
                    else sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if(i<(A.length-1) && (A[i+1]=='D' || A[i+1]=='M')) {sum -= 100;}
                    else sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }
}
