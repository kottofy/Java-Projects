/**
 * Linked implementation of the <code>java.util.List</code> interface
 * by extending <code>java.util.AbstractSequentialList</code>.<p>
 */
package edu.uga.cs1302.mp3files;

import java.util.*;
import java.io.Serializable;
import java.util.AbstractList;

/**
 * LinkedList<E> extends AbstractSequentialList<E> and implement Serializable.
 * @author Last Edited: Kristin Ottofy
 * Date: July 15, 2010
 * Program Name: MP3 File Collection
 * @param <E>   Generic object
 */
public class LinkedList<E> extends AbstractSequentialList<E> implements Serializable {

    private transient int size = 0;   // size can never be < 0
    private transient DLNode<E> head;
    private transient DLNode<E> tail;

    /**
     *  Create a linked list with a head and tail with attributes:
     *  size, tail, head, modCount set to zero or null
     */
    public LinkedList() {
      size = 0;
      tail = new DLNode<E>();		         // the tail dummy node
      head = new DLNode<E>( null, null, tail );  // the head dummy node
      tail.setPredecessor( head );
      modCount = 0;
    }

    public ListIterator<E> listIterator( int index ) {
        if (( index < 0 ) || ( index > size ) )
            throw new IndexOutOfBoundsException("index " + index
                             + " is out of range: 0 to " + size);
        return new LinkedListIterator<E>( index );
    }

    public int size() {
        return this.size;
    }

    /*
        pre: 0 <= index <= size()
             We DO NOT check that this is true!
    */
    private DLNode<E> getNodeAt( int index ) {
        // check for empty list and appending at the tail
        if ( index == this.size ) return tail;
        DLNode<E> p = null;

        if ( ( index < this.size / 2 )  ) { // start at beginning of the list
            p = head.getSuccessor();
            for ( int i = 0; i != index; i++ )
              p = p.getSuccessor();
        }
        else {
            p = tail.getPredecessor();
            for ( int i = this.size - 1; i != index; i-- )
              p = p.getPredecessor();
        }
        return p;
    }

    /**
     * Add a new element to the list in front of the tail dummy node.
     * @param o object to be added
     * @return  return true to indicate a successful addition to the list
     */
    public boolean add(E o)
    {
        //create a temporary node to hold the predecessor of tail
        DLNode<E>  pred = tail.getPredecessor();

        //create a new node to hold the element o inbetween the predecessor of tail and tail
        DLNode<E> newnode = new DLNode<E>(o, pred, tail);  //create a new node

        //set the predecessor of tail to the new node
        tail.setPredecessor(newnode);

        //set the sucessor of tail to null
        tail.setSuccessor(null); 

        //set the predecessor of new node to the previous predecessor of tail
        pred.setSuccessor(newnode);

        size++;       // update List data field
        modCount++;   // update List data field

        //indicate successful addition to the list
        return true;
    }

    /**
     * Remove all nodes from the list.
     * It is public so it can override and be called from other classes.
     */
    public void clear()
    {
        head.setSuccessor(tail);
        tail.setPredecessor(head);

        size = 0;      //all nodes were removed so decrease size to 0
        modCount = 0;  //all nodes were removed so decrease modCount to 0
    }

    /**
     * indexOf(Object o) returns the index of the object being test,
     * or -1 if the object is not found.
     * @param o the object being searched for
     * @return  0 will be returned if a match was made, -1 will be returned
     * if no match was made
     */
    public int indexOf(Object o)
    {
        DLNode<E> temp = head.getSuccessor();  //create a new node

        for (int i = 0; i < size ; i++)
        {
            if (temp.getElement().equals(o))
            {
                return i;
            }
            temp = temp.getSuccessor();
        }
        return -1;
    }

    /**
     * Removes element at specified index, or throw exception if index is out of bounds
     * @param index index specified at which to remove a node at
     * @return      return the element of the node removed. If no
     * @throws java.lang.IndexOutOfBoundsException  exception thrown if index is out of bounds
     */
    public E remove(int index) throws IndexOutOfBoundsException
    {
        //check to make sure that the specified index to remove is in bounds
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        //create a node to help locate the index in the list
        DLNode<E> to_Remove;

        //create a copy of the node to be removed to return it's element
        E to_Remove_Element;

        //set the
        to_Remove = head.getSuccessor();

        if (index != 0 )    //if index is 0, then to_Remove is already set
            for (int i = 0; i < index; i++)     //loop through the list until the index
               to_Remove = to_Remove.getSuccessor();    //set to_Remove

        //create a copy of the node to be removed to return it's element
        to_Remove_Element = to_Remove.getElement();

        //remove the node at index by changing its successor and predecessor
        to_Remove.getPredecessor().setSuccessor(to_Remove.getSuccessor());
        to_Remove.getSuccessor().setPredecessor(to_Remove.getPredecessor());
        
        //set all aspects of the node that was removed to null
        to_Remove.setElement(null);
        to_Remove.setPredecessor(null);
        to_Remove.setSuccessor(null);
        to_Remove = null;

        //decrease the size and modcount of the list since a node was removed
        size--;
        modCount--;

        //return the element
        return to_Remove_Element;
    }

    /**
     * Set a specific element at specific position
     * @param index     specific position at which to set new element
     * @param element   specific element at which to set at specific index
     * @return          return the element at which
     * @throws java.lang.IndexOutOfBoundsException
     */
    public E set(int index, E element) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
           
        //create a temporary node to replace with new element
        DLNode<E> replace = head.getSuccessor();

        //loop through the list until specified index in direction of head to tail
        for (int i = 0; i < index; i++)
        {
            //update the position of replace
            replace = replace.getSuccessor();
        }

        //hold the element before replacing with new element for return purposes
        E previousElement = replace.getElement();

        //replace the element at the specified index with the new element
        replace.setElement(element);

        //return the previous element before it was replaced
        return previousElement;
    }

    /**
     * inner class implementing the list iterator
     * @param <E>
     */
    public class LinkedListIterator<E> implements ListIterator<E> {
        // invariant: cursor should always reference a node from
        //  head's successor to tail. cursor should never reference head.
        private DLNode<E> cursor;  // references node to be returned by next(), which
                                // is successor to node to be returned by previous()

        private DLNode<E> lastNodeReturned;  // last node reterned by next() or previous()
        private int nextIndex; // index of node returned by NEXT call to next()

        /**
         * Provides fail-fast operation of the iterator. For each call to an
         * iterator method, expectedModCount should be equal to the collection's
         * modCount, otherwise an intervening change (concurrent modification)
         * to the collection has been made and we cannot guarantee that the
         * iterator will behave correctly.
         */
        private int expectedModCount;

        /**
         * the contract of remove() says that each call to remove() must have
         * been preceded by a call to next()/previous() (they are paired). So if there has
         * been NO call to next()/previous() prior to a remove() or if there were two
         * remove() calls without an intervening next()/previous() call, it is NOT ok to
         * try to remove an item.
         */
        private boolean okToRemove;

        // pre: 0 <= index <= size()
        /**
         *
         * @param index
         */
        public LinkedListIterator( int index ) {
            if (( index < 0 ) || ( index > size ) )
                throw new IndexOutOfBoundsException("index " + index
                             + " is out of range: 0 to " + size);
            // cursor starts out at the target node's predecessor
            //DLNode to_Remove = head;
            if ( index == 0 )
		cursor = (DLNode<E>)head.getSuccessor();
            else if ( index == size )
                cursor = (DLNode<E>)tail;
            else
                cursor = (DLNode<E>)getNodeAt( index );
            nextIndex = index;
            okToRemove = false;
            expectedModCount = modCount;
            lastNodeReturned = null;
        }

        public E next() {
            if ( ! hasNext() )
                throw new NoSuchElementException( "no next element" );

            checkForConcurrentModification();

            okToRemove = true;

            // next() is the inverse of previous():
            //   always get the element field THEN advance the cursor
            nextIndex++;
            E element = cursor.getElement();
            lastNodeReturned = cursor;
            cursor = cursor.getSuccessor();
            return element;
        }

        public E previous() {
            checkForConcurrentModification();
            if ( ! hasPrevious() )
                throw new NoSuchElementException( "no previous element" );

            okToRemove = true;

            // previous() is the inverse of next():
            //   always decrement the cursor THEN get the element field
            nextIndex--;
            cursor = cursor.getPredecessor();
            lastNodeReturned = cursor;
            //System.err.println("previous(): cursor is " + cursor);
            return cursor.getElement();
        }

        // nextIndex is the index of the element to be returned by next(),
        //  so the previous index will be one less than nextIndex
        public int previousIndex() {
            checkForConcurrentModification();
            if ( hasPrevious() ) return nextIndex - 1;
            else return -1;
        }

        public int nextIndex() {
            checkForConcurrentModification();
            if ( hasNext() ) return nextIndex;
            else return size;
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return cursor != tail;
        }

        public boolean hasPrevious() {
            checkForConcurrentModification();
            return cursor.getPredecessor() != head;
        }

        public void add( E o ) {
            checkForConcurrentModification();

            okToRemove = false;

            DLNode<E> newnode = new DLNode<E>( o, cursor.getPredecessor(), cursor );
            newnode.getPredecessor().setSuccessor( newnode );
            cursor.setPredecessor( newnode );

            nextIndex++;
            size++;       // update List data field
            modCount++;   // update List data field
            expectedModCount = modCount;
        }

        public void remove() {
            checkForConcurrentModification();

            // check that there has been a next()/previous() message to provide
            // an element to remove
            if ( !okToRemove )
                throw new IllegalStateException();

            okToRemove = false;

            // either the cursor or nextIndex needs to be updated
            if ( cursor == lastNodeReturned )  // removing item returned by a previous() call
                cursor = cursor.getSuccessor();     // move cursor forward
            else                               // removing item returned by a next() call
                nextIndex--;                   // move nextIndex backward

            lastNodeReturned.getPredecessor().setSuccessor( lastNodeReturned.getSuccessor() );
            lastNodeReturned.getSuccessor().setPredecessor( lastNodeReturned.getPredecessor() );

            // now do cleanup
            lastNodeReturned.setSuccessor( null );
            lastNodeReturned.setPredecessor( null );
            lastNodeReturned.setElement( null );
            lastNodeReturned = null;

            size--;       // update LinkedList data field
            modCount++;   // update AbstractList data field
            expectedModCount = modCount;
        }

        // change the value stored by the last node returned by next() or
        //   previous()
        public void set( E o ) {
            checkForConcurrentModification();
            lastNodeReturned.setElement( o );
        }

        private void checkForConcurrentModification() {
            if ( expectedModCount != modCount )
                throw new java.util.ConcurrentModificationException();
        }

    }

}
