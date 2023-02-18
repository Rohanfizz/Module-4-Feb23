import java.io.*;
import java.util.*;

class Solution {

	public boolean allCharactersPresent(int[] tf,int[] cwf){
		for(int i = 0;i<tf.length;i++){
			if(tf[i] > cwf[i]) return false;
		}
		return true;
	}
	
    public String minWindow(String s, String t) {
		// write code here
		int sp = 0;
		int ep = 0;
		int[] cwf = new int[257];
		int[] tf = new int[257];

		int os = -1;// start point for my answer substring
		int oe =-1;//end point for my answer substring
		int anssize = Integer.MAX_VALUE;
			
			//fill the tf array
		for(int i = 0;i<t.length();i++) tf[t.charAt(i)]++;

		//sliding window
		while(ep<s.length()){
			//we visit end point here and increase character freq
			cwf[s.charAt(ep)]++;

			while(allCharactersPresent(tf,cwf)){
				//keeping track of the best possible window
				if(ep-sp+1<anssize){
					anssize = ep-sp+1;
					os = sp;
					oe = ep;
				}
				cwf[s.charAt(sp)]--;
				sp++;
			}
			ep++;
		}

		if(os==-1) return "";
		return s.substring(os,oe+1);
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}