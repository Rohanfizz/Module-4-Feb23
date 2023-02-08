import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {
	class Helper{
		int min;
		int max;
		Node parent;
		Helper(Node parent,int min,int max){
			this.parent=parent;
			this.min = min;
			this.max  = max;
		}
	}
	
    Node bstFromLevel(int arr[], int n) {
        // write code here
		Node root = new Node(arr[0]);
		int idx = 1;
		Queue<Helper> q = new LinkedList<>();
		q.add(new Helper(root,Integer.MIN_VALUE,root.data));
		q.add(new Helper(root,root.data,Integer.MAX_VALUE));
		while(q.size() > 0){
			Helper curr =  q.remove();
			if(idx == arr.length ||  arr[idx] < curr.min || arr[idx] > curr.max) continue;
			Node nn = new Node(arr[idx++]);
			if(nn.data < curr.parent.data){
				curr.parent.left = nn;
				q.add(new Helper(nn,curr.min,nn.data));
				q.add(new Helper(nn,nn.data,curr.max));
			}else{
				curr.parent.right = nn;
				q.add(new Helper(nn,curr.min,nn.data));
				q.add(new Helper(nn,nn.data,curr.max));
			}
		}
		return root;
    }

	
}









