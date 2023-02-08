import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);
  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
      this.val = val;
    }
  }

  public static class BSTIterator {
	  Stack<Helper> st;
	  public class Helper{
		  TreeNode node;
		  int state;
		  Helper(TreeNode node,int state){
			  this.node = node;
			  this.state = state;
		  }
	  }
    public BSTIterator(TreeNode root) {
      //Your code here
		st = new Stack<>();
		st.push(new Helper(root,0));
    }
    public int next() {
      //Your code here
		while(st.size() > 0){
			Helper top = st.peek();
			if(top.state == 0){
				// preorder
				if(top.node.left != null) st.push(new Helper(top.node.left,0));
				top.state++;
			}else if(top.state == 1){
				//inorder
				st.pop();
				if(top.node.right != null) st.push(new Helper(top.node.right,0));
				top.state++;
				return top.node.val;
			}
		}
		return -1;
    }
    public boolean hasNext() {
      //Your code here
		return st.size()>0;
    }
  }

  public static void display(TreeNode node) {
    if (node == null)
      return;
    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));
    System.out.println(sb.toString());
    display(node.left);
    display(node.right);

  }

  public static TreeNode constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;
    int mid = (si + ei) / 2;
    TreeNode node = new TreeNode(in[mid]);
    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);
    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();
    TreeNode root = constructFromInOrder_(in, 0, in.length - 1);
    BSTIterator itr = new BSTIterator(root);
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }

  public static void main(String[] args) {
    solve();
  }
}