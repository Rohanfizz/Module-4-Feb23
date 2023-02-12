import java.util.*;
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;

        if(root==null)
            root=new Node(arr[mid]);

        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[]=new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt(); 
        }
        int k=sc.nextInt();
        Arrays.sort(arr);
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
            
        Solution Accio = new Solution();
        int ans=Accio.solve(root,k);
        System.out.println(ans);
        sc.close();
        
    }
}
class Solution
{

	class Pair{
		Node node;
		int state;
		Pair(Node  node,int state){
			this.node = node;
			this.state = state;
		}
	}
	
	Node getNextReverse(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//pre
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
				top.state++;
			}else if(top.state == 2){
				//in
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
				top.state++;
				return top.node;
			}else{
				st.pop();
			}
		}
		return null; //dummy return
	}
	
    int solve(Node node, int k){
        // your cod here
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(node,1));

		Node curr = getNextReverse(st);

		while(curr != null && k>1){
			curr = getNextReverse(st);
			k--;
		}
		return curr.data;
		
    }
}


















