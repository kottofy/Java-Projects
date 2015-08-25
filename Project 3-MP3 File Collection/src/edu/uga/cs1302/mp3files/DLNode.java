package edu.uga.cs1302.mp3files;

/**
 * A doubly-linked list node.<p>
 */

import java.io.Serializable;

/**
 *
 * @author 
 * @param <E>
 */
public class DLNode<E> implements Serializable {
    private E          element;       // the data field
    private DLNode<E>  predecessor;   // link to previous (predecessor) DLNode
    private DLNode<E>  successor;     // the link to next (successor) DLNode

    /**
     *
     */
    public DLNode() {
        this.element = null;
        this.predecessor = null;
        this.successor = null;
    }

    /**
     *
     * @param list_element
     * @param pred
     * @param succ
     */
    public DLNode( E list_element, DLNode<E> pred, DLNode<E> succ ) {
        this.element = list_element;
        this.predecessor = pred;
        this.successor = succ;
    }

    public void setElement( E list_element ){
       this.element = list_element;
    }

    /**
     *
     * @return
     */
    public E getElement( ){
       return this.element;
    }

    /**
     *
     * @return
     */
    public DLNode<E> getPredecessor( ){
       return this.predecessor;
    }

    /**
     *
     * @param new_predecessor
     */
    public void setPredecessor( DLNode<E> new_predecessor ){
       this.predecessor = new_predecessor;
    }

    /**
     *
     * @return
     */
    public DLNode<E> getSuccessor( ){
       return this.successor;
    }

    /**
     *
     * @param new_successor
     */
    public void setSuccessor( DLNode<E> new_successor ){
       this.successor = new_successor;
    }
}