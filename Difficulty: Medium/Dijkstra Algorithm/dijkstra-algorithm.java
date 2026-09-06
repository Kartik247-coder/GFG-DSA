class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
        public int compareTo(Pair p){
            return this.wt-p.wt;
        }
    }
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            ans.add(Integer.MAX_VALUE);
        }
        
        List<List<Pair>> adj=new ArrayList<>();
        
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            int wt=edges[i][2];
            adj.get(a).add(new Pair(b,wt));
            adj.get(b).add(new Pair(a,wt));
        }
        
        
       ans.set(src,0);
        
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        
        pq.add(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair top=pq.remove();
            int node=top.node;
            int wt=top.wt;
            if(wt>ans.get(node)) continue;
            for(Pair p:adj.get(node)){
                int totalWt=wt+p.wt;
                if(totalWt<ans.get(p.node)){
                    ans.set(p.node,totalWt);
                    pq.add(new Pair(p.node,totalWt));
                }
            }
            
        }
        return ans;
        
    }
}