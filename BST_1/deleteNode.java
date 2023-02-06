
import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){
        
    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{
	public int getMin(Node root){
		if(root.left == null) return root.val;
		return getMin(root.left);
	}
    public Node deleteNode(Node root, int val){
        // WRITE YOUR CODE HERE
		
		if(root == null) return null;
		if(root.val == val){
			if(root.left == null && root.right == null) return null; // leaf node
			// we will come to this line if one or both child are present
			else if(root.left == null && root.right != null){// root is having right only
				return root.right;
			}else if(root.left != null && root.right == null){//root is having left only
				return root.left;
			}else{// we will come to this line if both child are present
				//Step1: we will get the minimum from rightsubtree
				int minVal = getMin(root.right);
				//step 2 : overwrite 
				root.val = minVal;
				//step 3: delete minVal from the right subtree
				root.right = deleteNode(root.right,minVal);
			}
		}
		else if(root.val < val){
			root.right = deleteNode(root.right,val);
		}else{
			root.left = deleteNode(root.left,val);
		}
		return root;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}