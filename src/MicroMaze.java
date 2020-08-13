
package micromaze;

import java.io.IOException;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author RICHIK NANDY
 */
public class MicroMaze
{
    public static void main(String[] args) throws IOException 
    {
        MazeMaker dataMgr = new MazeMaker();
        MazeTracer logicMgr = new MazeTracer();
        DisplayManager dispMgr = new DisplayManager();
        
        dataMgr.MakeMaze();
        int size = dataMgr.getSize();
        
        System.out.println("Maze Size - " + size);
        
        Maze myMaze[][] = new Maze[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0; j<size; j++)
                myMaze[i][j] = new Maze();
        }
        for(int i=0;i<size;i++)
        {
            for(int j=0; j<size; j++)
            {
                myMaze[i][j].storesurroundCell(dataMgr.getValue(i,j));
                myMaze[i][j].changeState(0);
            }
        }
        
        System.out.println("Maze-Cell Showing its surrounding");
        for(int i=0;i<size;i++)
        {
            for(int j=0; j<size; j++)
            {
                System.out.print( myMaze[i][j].getsurroundCell() + " ");
            }
            System.out.println();
        }
        
        myMaze[dataMgr.getX_end()][dataMgr.getY_end()].changeState(3);
        
        System.out.println("Maze-Cell Showing its initial state");
        for(int i=0;i<size;i++)
        {
            for(int j=0; j<size; j++)
            {
                System.out.print( myMaze[i][j].getState() + " ");
            }
            System.out.println();
        }
        
        if(logicMgr.pathGenerator_Backtracking(dataMgr.getX_start(),dataMgr.getY_start(), myMaze) != true)
            System.out.println("No Path Exists!");
        int path[][] = new int[10000][2];
        int pathSize = logicMgr.pathSize();
        
        System.out.println("Maze-Cell Showing its final state");
        for(int i=0;i<size;i++)
        {
            for(int j=0; j<size; j++)
            {
                System.out.print( myMaze[i][j].getState() + " ");
            }
            System.out.println();
        }
        
        System.out.println("The Path - ");
        
        for(int i=0;i<pathSize;i++)
        {
            path[i][0] = logicMgr.getpathValue(i,0);
            path[i][1] = logicMgr.getpathValue(i,1);
        }
        
        for(int i=0;i<pathSize; i++)
        {
            dispMgr.sendpathValue(path[i][0], path[i][1], i);
        }
        dispMgr.sendpathSize(pathSize);
        dispMgr.getSize(size);
        dispMgr.initialize(dataMgr.getX_end(), dataMgr.getY_end());
        for(int i=0;i<size;i++)
        {
            for(int j=0; j<size; j++)
            {
                String s2 = myMaze[i][j].getsurroundCell();
                dispMgr.creatingDecimalMaze(i, j, s2);
            }
        }
        //UI Display
        JFrame frame = new JFrame("UI Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(dispMgr);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setLocation(100,100);
        frame.setBackground(Color.gray);
        frame.setForeground(Color.black);
        Font f = new Font("Calibri", Font.BOLD, 45);
        frame.setFont(f);
        dispMgr.drawpath();
    }   
}
