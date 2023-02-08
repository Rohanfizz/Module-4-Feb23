import java.util.Scanner;

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

	public static int idx ;

	public static TreeNode construct(int[] post,int min,int max){
		if(idx <0 || post[idx]<min || post[idx] > max) return null;
		TreeNode me = new TreeNode(post[idx]);
		idx--;
		me.right = construct(post,me.val,max);
		me.left = construct(post,min,me.val);
		return me;
	}
	
    public static TreeNode CreateTree(int n,int[] postOrder) {
        //write code here
		idx =postOrder.length-1;
		TreeNode root =  construct(postOrder,Integer.MIN_VALUE,Integer.MAX_VALUE);	
		return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        TreeNode root = CreateTree(n,post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}