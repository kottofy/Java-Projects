package edu.uga.cs1302.txtbuff;

/**
 * TextLine class holds all the methods related to the text line, _TextLine.
 * @author Kristin Ottofy
 */
public class TextLine {
    
    /**
     * DEFAULT_SIZE is used to control the capacity size of _TextLine.
     * It is public so it can be called from other classes.
     */
    public final int DEFAULT_SIZE = 80;

    /**
     * _TextLine holds the array of characters.
     * It is protected so it can be called from other classes in this package.
     */
    protected char[] _TextLine;

    /**
     * _TempTextLine is used to hold a copy of _TextLine to allow for
     * _TextLine to be resized and easily reinitialized.
     * It is protected so it can be called from other classes in this package.
     */
    protected char[] _TempTextLine;

    /**
     * capacitySize holds the capacity size for _TextLine.
     * It is protected so it can be called from other classes in this package.
     */
    public int capacitySize;

    /**
     * stringLength holds the length of the string in _TextLine.
     * It is public so it can be called from other classes.
     */
    public int stringLength;

    /**
     * tempStringLength is used to hold the original string length during
     * a resize process, and also is used to determine if a resize is needed.
     * It is protected so it can be called from other classes in this package.
     */
    protected int tempStringLength;

    /**
     * TextLine constructor initializes the variables stringLength to 0,
     * capacitySize to DEFAULT_SIZE (80), and creates a new character array of
     * DEFAULT_SIZE, _TextLine.
     * It is public so it can be accessed in other classes or packages
     */
    public TextLine()
    {
        this.stringLength = 0;
        this.capacitySize = DEFAULT_SIZE;
        this._TextLine = new char[DEFAULT_SIZE];
    }

    /**
     * TextLine(String line) constructor initalizes each character in the
     * string line to a new character array _TextLine
     * It is public so it can be accessed in other classes or packages
     * @param line  the string that will be assigned to _TextLine
     */
    public TextLine(String line)
    {
        this(); //initaliaze the variables needed in the constructor of this class

        this.stringLength = line.length();  //assign the string length to the length of the line

        while (stringLength > capacitySize) //determine if capacity is needed to be increased
            capacitySize += DEFAULT_SIZE;

        this._TextLine = new char[this.capacitySize];   //create new array of new capacitySize

        //initialize each character of _TextLine
        for (int index = 0; index < this.stringLength; index++)
        {
            this._TextLine[index] = line.charAt(index);
        }
    }

    /**
     * TextLineCopy() copies _TextLine to _TempTextLine during a resizing process
     * It is protected so it can be accessed in other classes.
     */
    protected void TextLineCopy()
    {
        //create a new character array
        _TempTextLine = new char[this.capacitySize];

        //initialize the array to _TextLine
        for (int i = 0; i < this.stringLength; i++)
        {
            _TempTextLine[i] = this._TextLine[i];
        }

        //make a copy of the original string length because it will
        //be changed if resize is necessary
        tempStringLength = this.stringLength;
    }

    /**
     * TextLineCopyBack() copies _TempTextLine to a new _TextLine and resizes
     * if needed.
     * It is protected so it can be accessed in other classes.
     */
    public void TextLineCopyBack()
    {
        boolean ifResizeBool = false;   //keeps track of whether a resize is necessary or not

        //determine if a resize is necessary, if it is, increase capacity size
        //and create a new character array
        while (this.stringLength > this.capacitySize)
        {
            this.capacitySize += DEFAULT_SIZE;
            this._TextLine = new char[this.capacitySize];
            ifResizeBool = true;
        }

        // is a resize occured, then the new character will be initialized
        //to the values in the temporary copy before the resize
        if (ifResizeBool == true)
        {
            //use length of original array since after resize, string length increases
            for (int i = 0; i < tempStringLength; i++)
            {
                this._TextLine[i] = _TempTextLine[i];
            }
        }
    }

    /**
     * indexOf(String fragment) determines if the string fragment is in 
     * the _TextLine starting at index 0.
     * It is public so it can be accessed in other classes or packages.
     * @param fragment  the fragment searching to find in _TextLine
     * @return -1 is fragment not found, or index at which the fragment was found
     */
    public int indexOf(String fragment)
    {
        int textLineCount, fragmentCount, tempCount;    //used to hold counts for indexes
        String found = "";  //holds the letters found in _TextLine that match fragment

        //loop through the character array at each index (textLineCount)
        //until it reaches the end of the string
        for (textLineCount = 0; textLineCount < this.stringLength; textLineCount++)
        {
            //if the first character in the fragment matches,
            //check if the rest of the fragment matches
            if (this._TextLine[textLineCount] == fragment.charAt(0))
            {
                //add the character that matches to the string found
                found +=this._TextLine[textLineCount];

                //if the fragment length is greater than one, then search for
                //the rest of the fragment, else return the index in the character array
                if (fragment.length() > 1)
                {
                    //search through the fragment and the character array for a match
                    //using a temporary count for the _TextLine count so that
                    //the index at the first matched letter can be found
                    for (fragmentCount = 1, tempCount = textLineCount +1; fragmentCount < fragment.length(); fragmentCount++, tempCount++)
                    {
                        //if a match is found
                        if (this._TextLine[tempCount] == fragment.charAt(fragmentCount))
                        {
                            //add the matched character to the string found
                            found += this._TextLine[tempCount];

                            //if the string found matches the string fragment,
                            //then the fragment was successfully found and return the index
                            if (found.equals(fragment))
                                //return tempCount-found.length()+1;
                                return textLineCount;
                        }
                        else    //continue looping in the character array
                            break;
                    }
                    found = ""; //match not found so remove all characters found
                }
                else    //return the index at the matched character since there is only one character in the fragment
                    return textLineCount;

               }
        }
        return -1;  //fragment not found
    }

    /**
     * indexOf(String fragment, int fromIdex) searches through the character
     * array starting at index fromIndex for the string fragment. If the
     * fragment is found, the index at which it was found is returned, if
     * the fragment was not found, then -1 is returned.
     * It is public so it can be accessed in other classes or packages
     * @param fragment     string searched for in character array
     * @param fromIndex     index to start searching at
     * @return      returns -1 is fragment not found, or index at which the fragment was found
     */
    public int indexOf (String fragment, int fromIndex)
    {
        int textLineCount, fragmentCount, tempCount; //hold indexes
        String found = "";  //holds the characters that match the fragment

        //loop through the character array at each index (textLineCount)
        //until it reaches the end of the string
        for (textLineCount = fromIndex; textLineCount < this.stringLength; textLineCount++)
        {
            //if the first character in the fragment matches,
            //check if the rest of the fragment matches
            if (this._TextLine[textLineCount] == fragment.charAt(0))
            {
                //add the character that matches to the string found
                found +=this._TextLine[textLineCount];

                //if the fragment length is greater than one, then search for
                //the rest of the fragment, else return the index in the character array
                if (fragment.length() > 1)
                {
                    //search through the fragment and the character array for a match
                    //using a temporary count for the _TextLine count so that
                    //the index at the first matched letter can be found
                    for (fragmentCount = 1, tempCount = textLineCount +1; fragmentCount < fragment.length(); fragmentCount++, tempCount++)
                    {
                        //if a match is found
                        if (this._TextLine[tempCount] == fragment.charAt(fragmentCount))
                        {
                            //add the matched character to the string found
                            found += this._TextLine[tempCount];

                            //if the string found matches the string fragment,
                            //then the fragment was successfully found and return the index
                            if (found.equals(fragment))
                                //return tempCount-found.length()+1;
                                return textLineCount;
                        }
                        else
                            break;  //continue looping in the character array
                    }
                    found = ""; //match not found so remove all characters found
                }
                else    //return the index at the matched character since there is only one character in the fragment
                    return textLineCount;
               }
        }
        return -1;  //fragment not found
    }

    /**
     * length() returns the string length in the character array.
     * It is public so it can be accessed in other classes or packages.
     * @return this.stringLength
     */
    public int length()
    {
        return this.stringLength;
    }

    /**
     * capacity() returns the capacity size of the character array.
     * It is public so it can be accessed in other classes or packages.
     * @return this.capacitySize
     */
    public int capacity()
    {
        return this.capacitySize;
    }

    /**
     * toString() is an overridden method that converts the character
     * array _TextLine to a string and returns that string.
     * It is public so it can be accessed in other classes or packages.
     * @return textLineString    the converted string
     */
    public String toString()
    {
        //store the converted char array to a string to be returned
        String textLineString = new String(this._TextLine);

        return textLineString;
    }

 /*     BONUS METHOD
  * I left this commented here in case I would like to try it at a later time
  int indexOfMatch(String regex, int fromIndex)
    {
        return 0;
    }*/
}
