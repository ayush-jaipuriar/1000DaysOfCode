import java.util.*;

public class CaesarCipherEncryptor {
	
	// Time Complexity : O(n) where n is the length of the string
	// Space Complexity : O(n) where n is the length of the string

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
		caesarCypherEncryptor("xyz", 2);

	}

}
