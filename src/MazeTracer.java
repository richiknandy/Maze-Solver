
package micromaze;

/**
 *
 * @author RICHIK NANDY
 */
public class MazeTracer 
{
    private int path[][] = new int[10000][2];
    private int ctr; int c=0;
    Boolean checkPos(int x, int i2, int j2, Maze m[][])
    {
        if(x==0)
        {
            if(m[i2][j2+1].getState()==0 || m[i2][j2+1].getState()==3)
                return true;
        }
        else if(x==1)
        {
            if(m[i2+1][j2].getState()==0 || m[i2+1][j2].getState()==3)
                return true;
        }
        else if(x==2)
        {
            if(m[i2][j2-1].getState()==0 || m[i2][j2-1].getState()==3)
                return true;
        }
        else if(x==3)
        {
            if(m[i2-1][j2].getState()==0 || m[i2-1][j2].getState()==3)
                return true;
        }
        return false;
    }
   
    int getDirection(String s, int i2, int j2, Maze m[][])
    {
        int k, x=0, f=0; char ch;
        for(k=0; k<s.length(); k++)
        {
            ch = s.charAt(k);
            if(ch == '0' || ch == '3')
            {
                x=k;
                if(checkPos(x, i2, j2, m) == true)
                {
                    f=1;
                    break;
                }
            }
        }
        
        if(f==1)
        {
            if(x==0)
                return 0;
            else if(x==1)
                return 1;
            else if(x==2)
                return 2;
            else
                return 3;
        }
        return 4;
    }
    
    Boolean pathGenerator_Backtracking(int i1, int j1, Maze m[][])
    {
        String s;
        path[c][0] = i1;
        path[c++][1] = j1;
        if(m[i1][j1].getState() == 3)
        {
            return true;
        }
        else
        {
            m[i1][j1].changeState(2);
            s = m[i1][j1].getsurroundCell();
            int dir = getDirection(s,i1,j1,m);
            if(dir == 0)
            {
                if(pathGenerator_Backtracking(i1,j1+1,m)==true)
                    return true;
                if(pathGenerator_Backtracking(i1,j1,m)==true)
                    return true;
            }
            else if(dir == 1)
            {
                if(pathGenerator_Backtracking(i1+1,j1,m)==true)
                    return true;
                if(pathGenerator_Backtracking(i1,j1,m)==true)
                    return true;
            }
            else if(dir == 2)
            {
                if(pathGenerator_Backtracking(i1,j1-1,m)==true)
                    return true;
                if(pathGenerator_Backtracking(i1,j1,m)==true)
                    return true;
            }
            else if(dir == 3)
            {
                if(pathGenerator_Backtracking(i1-1,j1,m)==true)
                    return true;
                if(pathGenerator_Backtracking(i1,j1,m)==true)
                    return true;
            }
            return false;
        }  
    }
    
    //Djikstra
    //A*
    //Bellman Ford
        
    int getpathValue(int x, int y)
    {
        return path[x][y];
    }
    
    int pathSize()
    {
        ctr = c;
        return ctr;
    }
}