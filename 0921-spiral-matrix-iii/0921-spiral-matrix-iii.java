class Solution {

    int x=0,y=0,pos=0;
    int dirs[][]={{1,0},{0,-1},{-1,0},{0,1}};

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] ans=new int[rows*cols][2];

        ans[pos][0]=rStart;
        ans[pos][1]=cStart;

        pos++;

        x=rStart;
        y=cStart;
        
        int jumps=0;

        while(pos<rows*cols)
        {
            jumps++;
            help(rows,cols,jumps,ans,3);
            help(rows,cols,jumps,ans,0);

            jumps++;

            help(rows,cols,jumps,ans,1);
            help(rows,cols,jumps,ans,2);
        }
        return ans;
    }

    public void help(int n,int m,int jump,int[][] ans,int ind)
    {
        while(jump--!=0)
        {
            x+=dirs[ind][0];
            y+=dirs[ind][1];

            if(x<n && y<m && x>-1 && y>-1)
            {
                ans[pos][0]=x;
                ans[pos][1]=y;
                pos++;
            }
        }
    }
}