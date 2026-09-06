class Solution {
    public static class Pair{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
    }

    public class Triplet implements Comparable<Triplet>{
        int node;
        int par;
        int wt;
        Triplet(int node,int par,int wt){
            this.node=node;
            this.par=par;
            this.wt=wt;
        }
        public int compareTo(Triplet t){
            return this.wt-t.wt;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        int n=edges.length;
        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            int wt=edges[i][2];
            adj.get(a).add(new Pair(b,wt));
            adj.get(b).add(new Pair(a,wt));
        }

        boolean[] vis=new boolean[V];

        int sum=0;

        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));

        while(!pq.isEmpty()){
            Triplet t=pq.remove();
            int node=t.node;
            int par=t.par;
            int wt=t.wt;
            if(vis[node]) continue;
            sum+=wt;
            vis[node]=true;
            for(Pair p:adj.get(node)){
                if(p.node!=par && !vis[p.node]){
                    pq.add(new Triplet(p.node,node,p.wt));
                }
            }
        }
        return sum;
    }
}