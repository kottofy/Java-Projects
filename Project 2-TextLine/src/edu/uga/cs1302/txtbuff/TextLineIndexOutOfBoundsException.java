package edu.uga.cs1302.txtbuff;

/**
 * TextLineIndexOutOfBoundsException class extends from
 * IndexOutOfBoundsException. This class contains the exceptions.
 * @author Kristin Ottofy
 */
public class TextLineIndexOutOfBoundsException extends IndexOutOfBoundsException
{

    /**
     * TextLineIndexOutOfBoundsException() calls the constructor from
     * IndexOutOfBoundsException and exits.
     */
    public TextLineIndexOutOfBoundsException()
    {
        super();
        System.exit(1);
    }

    /**
     * TextLineIndexOutOfBoundsException(String errMsg) calls the constructor
     * from IndexOutOfBoundsException, displays an error message, and exits.
     * @param errMsg    error message displayed
     */
    public TextLineIndexOutOfBoundsException(String errMsg)
    {
        super(errMsg);
        System.exit(1);
    }

    /**
     * TextLineIndexOutOfBoundsException(int index) calls the constructor
     * from IndexOutOfBoundsException, prints which index is out of bounds,
     * and exits.
     * @param index the index that is out of bounds
     */
    public TextLineIndexOutOfBoundsException(int index)
    {
        super("TextLine index out of range: " + index);
        System.exit(1);
    }
}
