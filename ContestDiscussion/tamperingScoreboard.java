import java.util.*;

public class Main {

  public static int matrixScore(int[][] a) {
    // your code here
	  int n= a.length;
	  int m = a[0].length;
	  
	  for(int i =0;i<n;i++){
		  if(a[i][0] == 0){
			  //flip this row
			  for(int j =0;j<m;j++){
				  if(a[i][j] == 0) a[i][j] = 1;
				  else a[i][j] = 0;
			  }
		  }
	  }
	  // there are 1s in first col
	  
	  for(int col = 1;col<m;col++){
		  int c1 = 0;
		  int c0 = 0;
		  for(int row = 0;row<n;row++){
			  if(a[row][col] == 1) c1++;
			  else c0++;
		  }
		  if(c0 > c1){
			for(int row = 0;row<n;row++){
				if(a[row][col] == 1) a[row][col] = 0;
				else a[row][col] = 1;
			  }  
		  }
	  }
	  int total = 0;
	  for(int row = 0;row<n;row++){
		  int pow = 1;
		  int cnum = 0;
		  for(int col = m-1;col>=0;col--){
			  if(a[row][col] == 1) cnum+=pow;
			  pow*=2;
		  }
		  total+=cnum;
	  }
	  return total;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(matrixScore(matrix));
  }
}