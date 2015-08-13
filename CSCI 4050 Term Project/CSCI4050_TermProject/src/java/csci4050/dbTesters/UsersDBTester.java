/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csci4050.dbTesters;

import csci4050.dbAccess.UsersDB;
import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class UsersDBTester
{

    public void testSelectAllUsers()
    {
        System.out.println("testSelectAllUsers()");
        UsersDB usersDB = new UsersDB();
        ArrayList list = usersDB.selectAllUsers();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println();
        }
    }
    
    public void testInsertUsers()
    {
        System.out.println("testInsertUsers()");
    }
    
    public void testUpdateUsers()
    {
        System.out.println("testUpdateUsers()");
    }
    
    public void testSelectFromUsers()
    {
        System.out.println("testSelectFromUsers()");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("UsersDBTester");
        UsersDBTester usersDBTester = new UsersDBTester();
        usersDBTester.testSelectAllUsers();
        usersDBTester.testInsertUsers();
        usersDBTester.testUpdateUsers();
        usersDBTester.testSelectFromUsers();
    }
}
