class Solution {
    int visited[];
    public int findCircleNum(int[][] isConnected) {
        visited= new int[isConnected.length];
        int count=0;
        for(int i=0; i<visited.length;i++)
        {
            if(visited[i]==0)
            {
                count++;
                dfs(i,isConnected);
            }
        }
        return count;
    }


    void dfs(int node, int adjMat[][])
    {
        visited[node]=1;
        for(int i=0; i<adjMat[0].length;i++)
        {
            if(i==node)
            continue;

            if(adjMat[node][i]==1 && visited[i]!=1)
            dfs(i,adjMat);

        }

    }
}