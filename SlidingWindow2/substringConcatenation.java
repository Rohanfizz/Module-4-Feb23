import java.util.*;

class Solution {
	public boolean weHaveExtraWords(HashMap<String,Integer> ideal,HashMap<String,Integer> cwin ){
		for(String s: cwin.keySet()){
			//if the word is not present in ideal hashmap
			if(!ideal.containsKey(s)) return true;
			if(cwin.get(s) > ideal.get(s)) return true;
		}
		return false;
	}
    public List<Integer> findSubstring(String s, String[] words) {
        // write code here
		List<Integer> ans  = new ArrayList<>();
		// ideally my answer strings should have all the strings of words[]
		HashMap<String,Integer> ideal = new HashMap<>();

		for(String ss: words){
			ideal.put(ss,ideal.getOrDefault(ss,0)+1);
		}
		// helper variables
		int wordLen = words[0].length();
		int n = s.length();
		int totalWords = words.length;

		for(int i = 0;i<wordLen;i++){
			int sp = i;
			int ep = i;
			HashMap<String,Integer> cwhm = new HashMap<>();
			
			while(ep+wordLen<=n){
				String curr = s.substring(ep,ep+wordLen);
				cwhm.put(curr,cwhm.getOrDefault(curr,0)+1);
				ep+=wordLen;

				//after adding this word, i can have excess words
				while(sp<ep && weHaveExtraWords(ideal,cwhm)){
					String toBeDeleted = s.substring(sp,sp+wordLen);
					
					cwhm.put(toBeDeleted,cwhm.get(toBeDeleted)-1);
					if(cwhm.get(toBeDeleted) == 0) cwhm.remove(toBeDeleted);
					
					sp+=wordLen;
				}
				//at this line, i am not having excess words
				//curr string can or cannot be the ans
				if(totalWords*wordLen==ep-sp){
					ans.add(sp);
				}
			}
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}
