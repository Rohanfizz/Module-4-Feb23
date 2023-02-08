import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

class Accio {

	public class Pair{
		Node node;
		int state;
		Pair(Node node,int state){
			this.node = node;
			this.state = state;
		}
	}

	public Node getNextFromNormal(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//pre
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
			}else if(top.state == 2){
				//in
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
				return top.node;
			}else{
				//post
				st.pop();
			}
		}
		return null;
	}
	public Node getNextFromReverse(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//pre
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
			}else if(top.state == 2){
				//in
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
				return top.node;
			}else{
				//post
				st.pop();
			}
		}
		return null;
	}
	
    public void targetSum(Node root, int tar){
        // your code here
		Stack<Pair> normal = new Stack<>();// stack for normal iteration
		Stack<Pair> reverse = new Stack<>(); // stack for reverse iteration

		normal.push(new Pair(root,1));
		reverse.push(new Pair(root,1));

		Node left = getNextFromNormal(normal);//next inorder node in normal traversal
		Node right = getNextFromReverse(reverse);//next inorder node in reverse traversal
		boolean printed = false;
		
		while(left.data < right.data){
			if(left.data + right.data == tar){
				printed = true;
				System.out.println(left.data+" "+right.data);
				left = getNextFromNormal(normal);
				right = getNextFromReverse(reverse);
			}else if(left.data + right.data<tar){
				left = getNextFromNormal(normal);
			}else{
				right = getNextFromReverse(reverse);
			}
		}

		if(!printed){
			System.out.println(-1);
		}
    }

}
