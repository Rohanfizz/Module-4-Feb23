import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	   public static void main(String args[]) {
		  
		   Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.numberOfSubstrings(s));
	    }
}
class Solution{
	   public static int numberOfSubstrings(String s) {
		   int len = s.length();
		   int letter[] = new int[3];
		   int count = 0;
		   int result = 0;
		   int start = 0, end = 0;

		   while(end < len){
			   char ch = s.charAt(end);

			   if(letter[ch-'a'] == 0){
				   count++;
			   }
				letter[ch-'a']++;
			   while(count == 3){
				   char c = s.charAt(start);
				   if(letter[c-'a'] == 1){
					   count--;
				   }
					letter[c-'a']--;
				   start++;
			   }
			   result += start;
				end++;
		   }
		   return result;

}
}