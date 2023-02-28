import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {

	public class Node{
		int freq;
		char c;
		Node left;
		Node  right;
		Node(char c,int freq){
			this.c = c;
			this.freq = freq;
			this.left = null;
			this.right = null;
		}
	}
	
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
			// return a.freq-b.freq;
			return a.freq<b.freq?-1:1;
		});

		for(int i = 0;i<N;i++){
			int freq=f[i];
			char c = S.charAt(i);
			pq.add(new Node(c,freq));
		}

		while(pq.size() > 1){
			Node smaller = pq.remove();
			Node larger = pq.remove();

			Node nn = new Node('.',smaller.freq + larger.freq);
			nn.left = smaller;
			nn.right = larger;

			pq.add(nn);
		}

		Node root = pq.remove(); //root of the huffman tree
		ArrayList<String> ans  = new  ArrayList<>();
		dfs(root,ans,"");
		return ans;
    }

	public void dfs(Node root,ArrayList<String> ans,String psf){
		if(root.left == null && root.right == null){
			ans.add(psf);
			return;
		}
		dfs(root.left,ans,psf+"0");
		dfs(root.right,ans,psf+"1");
	}
	
}







