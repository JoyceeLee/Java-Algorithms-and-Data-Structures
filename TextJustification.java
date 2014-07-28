/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and 
 * is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * click to show corner cases.
 * 
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 */
 
 
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new ArrayList<String>();
        String tmp = "";
        if(words==null || words.length==0) {
            for(int i=0; i<L; i++) {
                tmp += " ";
            }
            ret.add(tmp);
            return ret;
        }

        int lineHead = 0;
        while(lineHead<words.length) {
            int lineLen = 0;
            int lineTail = lineHead;
            while(lineTail<words.length && lineLen+words[lineTail].length()<=L ) {
                lineLen += (words[lineTail++].length()+1);
            }
            if(lineTail-lineHead ==1) { // left
                tmp = words[lineHead];
                tmp = addSpace(tmp, L-tmp.length());
                ret.add(tmp);
                lineHead = lineTail;
                continue;
            }
            int wordLen = lineLen - (lineTail-lineHead);
            int meanSp = lineTail<words.length ? (L-wordLen)/(lineTail-lineHead-1):1;
            int leftSp = lineTail<words.length ? (L-wordLen)%(lineTail-lineHead-1):(L-lineLen+1);
            tmp = "";
            for(int i=lineHead; i<lineTail-1; i++) {
                tmp += words[i];
                tmp = addSpace(tmp, meanSp);
                if(lineTail<words.length && leftSp>0) { // not the last line
                    tmp += " ";
                    leftSp--;
                }
            }
            tmp += words[lineTail-1];
            if(leftSp>0) { // && lineTail==words.length, the last line
                tmp = addSpace(tmp, leftSp);
            }
            ret.add(tmp);
            lineHead = lineTail;
        }
        return ret;
    }
    public String addSpace(String str, int sp) {
        while(sp>0) {
            str += " ";
            sp--;
        }
        return str;
    }
}
