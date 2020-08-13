
package micromaze;

/**
 *
 * @author RICHIK NANDY
 */
public class Maze 
{
    private String s;
    private int state;
    public void storesurroundCell(String a)
    {
        s=a;
    }
    
    public String getsurroundCell()
    {
        return s;
    }
    
    public void changeState(int a)
    {
        state = a;
    }
    
    public int getState()
    {
        return state;
    }
}
