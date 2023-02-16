import java.util.*;

class graphConstruct{

   

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int e = scn.nextInt();
        
        ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        //taking input for edges
        for(int i = 0;i<e;i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            //undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for(int i = 0;i<n;i++){
            System.out.println(i+": "+graph.get(i));
        }
        

        scn.close();
    }
}