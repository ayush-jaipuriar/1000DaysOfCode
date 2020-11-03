class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        String smallestString=strs[0];
        for (int i=0; i<strs.length; i++) {
            if (strs[i].isEmpty()) {
                return "";
            }
            if (strs[i].length()<smallestString.length()) {
                smallestString=strs[i];
            }
        }
        int lengthOfSmallestString = smallestString.length();        
        String answer="";
        for (int i=0; i<lengthOfSmallestString; i++) {
            char ch = smallestString.charAt(i);
            for (int j=0; j<strs.length; j++) {
                if (strs[j].charAt(i)!=ch) {
                    return answer;
                } 
            }
            answer+=ch;
        }
        return answer;
        
    }
}
