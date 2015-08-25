package edu.uga.cs1302.txtbuff;

/**
 * The EditableTextLine class extend from the class TextLine and implements
 * the interface Editable. It contains the bodies of the methods from
 * Editable and also some constructors that call from the super class.
 * @author Kristin Ottofy
 */
public class EditableTextLine extends TextLine implements Editable
{
    /**
     * EditableTextLine() constructor calls the constructor from the parent
     * class, TextLine.
     */
    public EditableTextLine()
    {
        super();
    }

    /**
     * EditableTextLine(String line) constructor calls the constructor in
     * the parent class TextLine to assign the string line to a new character
     * array
     * @param line  the string that the new character array will be initialized to
     */
    public EditableTextLine(String line)
    {
        super(line);
    }

    /**
     * append(String fragment) will add fragment to the end of the character array.
     * @param fragment  the string that will be added to the end of the character array.
     */
    public void append(String fragment)
    {
        TextLineCopy(); //make a copy of the array because a resize will be needed
        this.stringLength += fragment.length(); //increase the string length to account for the added fragment
        TextLineCopyBack(); //resize the original array and initalize to the copied array

        //at the end of the string, add the fragment
        for (int x = this.stringLength-fragment.length(), y=0; x < this.stringLength; x++, y++)
        {
            this._TextLine[x] = fragment.charAt(y);
        }
    }

    /**
     * This method allows a string to be inserted into _TextLine at a 
     * specific index. If the index is out of bounds, the an exception will
     * be thrown.
     * 
     * @param index     where the string will be inserted in _TextLine
     * @param fragment  the string that will be inserted in _TextLine
     * @throws TextLineIndexOutOfBoundsException(index)    thrown when the index requested is out of bounds
     */
    public void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException
    {
        if (index > this.stringLength || index < 0)  //if index is out of bounds, throw exception
            throw new TextLineIndexOutOfBoundsException(index);
        else if (index == this.stringLength)
            append(fragment);   //if trying to insert at the end, just append the string
        else
        {
            TextLineCopy();     //copy the character array to a temporary char array
            this.stringLength += fragment.length();     //change the string length
            TextLineCopyBack(); //copy the character array back with new stringLength and new capacity size

            // move characters in string at index to after the inserted fragment length
            for (int i = index, x = index + fragment.length(); x < this.stringLength; i++, x++)
            {
                this._TextLine[x] = this._TempTextLine[i];
            }

            // insert the fragment at index
            for (int i = index, y = 0; y < fragment.length(); i++, y++)
            {
                    this._TextLine[i] = fragment.charAt(y);
            }        
        }
    }

    /**
     * Remove characters from start to end, then call insert method to insert
     * the fragment.
     *
     * @param start     index at which to start replacing at
     * @param end       index at which to end the replacing at
     * @param fragment  the string to insert into the _TextLine
     * @throws TextLineIndexOutOfBoundsException    is thrown if index is out of bounds
     */
    public void replace(int start, int end, String fragment) throws TextLineIndexOutOfBoundsException
    {
        // if start is greater than the last index
        // ALSO, can't append in replace which is when start = strengthLength
        // however, can replace a letter and append the rest if needed
        // since directions say the capacity size can increase after calling replace
        TextLineCopy();
        if (end >= this.stringLength || start >= this.stringLength || end < 0 || start < 0)
            throw new TextLineIndexOutOfBoundsException();

        //temporarily hold the new stringLength
        int stringLengthTemp = this.stringLength - (end - start + 1) + fragment.length();

        //check if the _TextArray needs to be resized
        if (stringLengthTemp > this.capacitySize)
        {
            this.stringLength = this.stringLength - (end - start + 1) + (fragment.length());
            this.capacitySize += DEFAULT_SIZE;
            TextLineCopyBack();
        }

        //remove the character from index start to index end
       for (int i = start; i <= end; i++)
        {
            for (int x = start; x < this.stringLength; x++)
            {
                this._TextLine[x] = this._TextLine[x+1];
            }
        }

        //determine if stringLength changed
        if (((end - start + 1) > fragment.length()) || ((end - start + 1) < fragment.length()))
            this.stringLength = this.stringLength - (end - start + 1) + (fragment.length());

        //resize _TextLine and reinitalize it
        TextLineCopyBack();

        //call the insert method to insert the fragment
        insert(start, "abc");
    }
}
