import java.util.*;

public class CaesarCipherEncryptor {
	
    // Time Complexity : O(n) where n is the length of the string
    // Space Complexity : O(n) where n is the length of the string
    // This method encrypts a given string using the Caesar cipher technique.
    // Each character in the input string is shifted by a specified number of positions in the alphabet.
    public static String caesarCypherEncryptor(String str, int key) {
        String alphabets = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
        String[] alphabetArr = alphabets.split(",");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabetArr.length; i++) {
            map.put(alphabetArr[i], i);
        }
        String encryptedString = "";
        for (Character ch : str.toCharArray()) {			
            encryptedString = encryptedString.concat(alphabetArr[(map.get(ch.toString()) + key) % 26]);
        }
        return encryptedString;
    }

    public static void main(String[] args) {
        // Demonstrating the usage of the caesarCypherEncryptor method with a sample string "xyz" and a shift value of 2.
        System.out.println(caesarCypherEncryptor("xyz", 2));
    }
}