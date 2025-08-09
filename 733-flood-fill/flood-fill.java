class pair{
    int r;
    int c;
    public pair(int r, int c)
    {
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int visited[][] = new int[image.length][image[0].length];

        Queue<pair> q= new LinkedList<>();
        int initialColor=image[sr][sc];
        q.offer(new pair(sr,sc));
        
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0; i<q.size(); i++)
            {
                pair ele=q.poll();
                image[ele.r][ele.c]=color;
                visited[ele.r][ele.c]=-100;
                if(ele.r+1<image.length && visited[ele.r+1][ele.c]!=-100 && image[ele.r+1][ele.c]==initialColor)
                q.offer(new pair(ele.r+1,ele.c));
                if(ele.r-1>=0 && visited[ele.r-1][ele.c]!=-100 && image[ele.r-1][ele.c]==initialColor)
                q.offer(new pair(ele.r-1,ele.c));
                if(ele.c+1<image[0].length && visited[ele.r][ele.c+1]!=-100 && image[ele.r][ele.c+1]==initialColor)
                q.offer(new pair(ele.r,ele.c+1));
                if(ele.c-1>=0 && visited[ele.r][ele.c-1]!=-100 &&  image[ele.r][ele.c-1]==initialColor)
                q.offer(new pair(ele.r,ele.c-1));
            }
        }


        return image;
    }
}