/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kottofy
 */
public class Test2 {

    public static void changeNumber (int num)
    {
        num = 2;
    }
    public static void changeClock (Clock c)
    {
        c.setTime(3000);
    }

    public static void main (String [] args)
    {
        int x = 32;
        changeNumber(x);
        System.out.println(x);

        Clock myClock = new Clock();
        myClock.setTime(12000);
        changeClock(myClock);
        System.out.println(myClock);
        
    }

}
