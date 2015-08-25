package edu.uga.cs1302.mp3files;

import java.lang.*;
import junit.framework.*;
import junit.extensions.*;
import java.util.List;
//import gray.adts.list.*;

//package gray.adts.list;

/**
 *
 * @author kottofy
 */

   //  Step 1. Create a testing class that extends TestCase.
public class LinkedListTester extends TestCase {
    protected LinkedList<String> list;
    private String A = new String("A"), B = new String("B"), C = new String("C"),
            D = new String("D"), E = new String("E");

    // Step 2: create a constructor that invokes the super constructor.
    //         The name argument is the name of a test case (see the suite()
    //         method).
    public LinkedListTester( String name ) {
		    super(name);
    }

    // Step 3. Create a setUp() method to instantiate and initialize the objects
    //         under test. This method is invoked before EVERY test case.
    protected void setUp() {
        list = new LinkedList<String>();
		list.add(0, A);
		list.add(1, B);
		list.add(2, C);
    }

   // Step 4. Create a tearDown() method to clean up after EACH test case.
   //         Unless you need something more than general garbage collection,
   //         such as closing I/O streams, you can leave this method out.
	  protected void tearDown() {
        list = null;
	  }

    // Step 5. Create the test cases. Each test case should follow the pattern
    //         void testXXX()
    //         where XXX is the name of the test we want to perform.

    /*
       Test Case 1: Verify that instantiation was done properly. Note that
       setUp() is called before this method, but isn't needed. C'est la vie.
    */
    public void testInstantiate() {
        List<String> cEmpty = new LinkedList<String>();
        assertEquals( cEmpty.size(), 0 );
        assertTrue( cEmpty.isEmpty() );
    }

    /**
       Test Case 2: Verifies the three add() ops done in setUp().
    */
    public void testAddToEmptyList() {
        assertEquals("verify size after the 3 add ops", list.size(), 3);
        assertTrue( !list.isEmpty() );
        assertTrue( list.indexOf("A") == 0 );
        assertTrue( list.indexOf("B") == 1 );
        assertTrue( list.indexOf("C") == 2 );
        assertTrue( list.indexOf("Missing") == -1 );
    }

    public void testAddAtHead() {
        list.add(0, D);
        assertTrue( list.contains(D) );
        assertTrue( list.indexOf(D) == 0 );
    }

    public void testAddAtTailIndexed() {
        list.add( list.size(), D );
        assertTrue( list.contains(D) );
        assertTrue( list.indexOf(D) == list.size() - 1 );
    }

    public void testAddAtTail(){
        list.add( D );
        assertTrue( list.contains(D) );
        assertTrue( list.indexOf(D) == list.size() - 1 );
    }

    /* this test combines the test at the head and tail */
    public void testSet() {
        list.set( 0, D );
        assertTrue( list.contains(D) );
        assertTrue( list.indexOf(D) == 0 );
        list.set( list.size() - 1, E );
        assertTrue( list.contains(E) );
        assertTrue( list.indexOf(E) == list.size() - 1 );
    }

    /* Verify that the set() method correctly catches bad indices.
       The first call to set() checks indices >= size() and the
       second call checks < 0.
    */
    public void testSetFail(){
        try{
            list.set( list.size(), E );
        } catch ( IndexOutOfBoundsException e ) {
             try{
                list.set( -1, E );
             } catch ( IndexOutOfBoundsException e2 ) {
                 return;  // exception was generated
             }
        }
        fail("IndexOutOfBoundsException not generated");
    }
    /**
       Test Case 3: Verifies removing a unique element from the collection.
    */
    public void testRemoveUniqueElement() {
        assertTrue( list.remove( B ) );
        assertEquals( 2, list.size() );
        assertTrue(//"Argh! Removed element is still in the collection!",
                     !list.contains( B ) );
        assertTrue( !list.isEmpty() );
    }

    public void testRemoveHead() {
        list.remove( 0 );
        assertTrue( !list.contains( A ) );
        assertTrue( list.indexOf( A ) == -1 );
    }

    public void testRemoveTail() {
        list.remove( list.size() - 1 );
        assertTrue( !list.contains( C ) );
        assertTrue( list.indexOf( C ) == -1 );
    }

    public void testClearWithIteratorForward(){
        java.util.ListIterator iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        assertTrue(list.size() == 0);
    }

    public void testClearWithIteratorBackward(){
        java.util.ListIterator<String> iter = list.listIterator( list.size() );
        while (iter.hasPrevious()) {
            iter.previous();
            iter.remove();
        }
        assertTrue(list.size() == 0);
    }
    public void testRemoveWithIteratorPrevious(){
        java.util.ListIterator<String> iter = list.listIterator(2);
        String s = (String)iter.previous();
        assertEquals(s, B);
        iter.remove();
        assertTrue(!list.contains(B));
        s = (String)iter.previous();
        assertEquals(s, A);
    }

    public void testRemoveWithIteratorNext(){
        java.util.ListIterator<String> iter = list.listIterator(1); // should be B
        assertEquals(iter.nextIndex(), 1);
        String s = iter.next();  // should be B
        assertEquals(s, B);
        assertEquals(iter.nextIndex(), 2);
        iter.remove();
        assertEquals(iter.nextIndex(), 1);
        assertTrue(!list.contains(B));
        s = iter.next();
        assertEquals(s, C);
    }

    public void testAddWithIterator(){
        java.util.ListIterator<String> iter = list.listIterator(1);
        assertTrue( iter.nextIndex() == 1 );
        iter.add( D );
        // A D B C
        assertTrue( iter.nextIndex() == 2 );
        assertTrue(iter.next().equals( B ));
        assertTrue(iter.previous().equals( B ));
        assertTrue(iter.previous().equals( D ));
    }

    public void testConcurrentModification(){
        try{
            java.util.ListIterator<String> iter = list.listIterator();
            list.add(E);
            assertTrue(iter.next().equals(A));
        }catch (java.util.ConcurrentModificationException e ) {
            return;  // it's cool - the exception was generated as expected
        }
        fail("ConcurrentModificationException not generated");
    }

    public void testAddAll(){
        List<String> l = new LinkedList<String>();
        l.add( D );
        l.add( E );
        assertTrue( list.addAll(1, l) );
        assertTrue( list.indexOf( D ) == 1 );
        assertTrue( list.indexOf( E ) == 2 );
        assertTrue( list.indexOf( B ) == 3 );
        assertTrue( list.indexOf( C ) == 4 );
        assertTrue( list.size() == 5 );
    }

    // Step 6: Create a suite of test cases.
  	public static Test suite() {
        // The simplest approach is to let Junit do all the work using
        // Java's reflection mechanism.
		    return new TestSuite(LinkedListTester.class);

        // Alternatively, you can create a TestSuite object and add the
        // tests manually - ugh! But this shows the purpose of the String
        // arg in the LinkedListTest constructor.
/*       TestSuite suite = new TestSuite();
        suite.addTest(new LinkedListTester1("testInstantiateandAdd"));
        suite.addTest(new LinkedListTester1("testEmpty"));
        suite.addTest(new LinkedListTester1("testResize"));
        suite.addTest(new LinkedListTester1("testClone"));
        suite.addTest(new LinkedListTester1("testEquals"));
        suite.addTest(new LinkedListTester1("testContains"));
        suite.addTest(new LinkedListTester1("testRemove"));
        return suite;   */
	  }

    // Step 7: define a main() method that invokes Junit to run the test
    //         application.
  	public static void main (String[] args) {
        // Use Java's reflection mechanism to get the name of this class.
        String[] TestCaseName = {LinkedListTester.class.getName()};
	//junit.swingui.TestRunner.main (TestCaseName);
	//junit.swingui.TestRunner.run(LinkedListTest.class);
	junit.textui.TestRunner.run (suite());
        //junit.ui.TestRunner.main(TestCaseName);
	}
}
