package dbproject1;

/****************************************************************************************
 * @file  Table.java
 *
 * @author   John Miller
 * @version  0.9, Mon Aug 16 13:56:42 EDT 2010
 */
import java.io.Serializable;
import static java.lang.Boolean.*;
import static java.lang.System.out;
import java.util.*;

/****************************************************************************************
 * This class implements relational database tables (including attribute names, domains
 * and a list of tuples.  Five basic relational algebra operators are provided: project,
 * select, union, minus and join.  The insert data manipulation operator is also provided.
 * Missing are update and delete data manipulation operators.
 */
public class Table implements Serializable, Cloneable {

    /** Counter for naming temporary tables.
     */
    private static int count = 0;
    /** Table name.
     */
    private final String name;
    /** Array of attribute names.
     */
    private final String[] attribute;
    /** Array of attribute domains: a domain may be
     *  integer types: Long, Integer, Short, Byte
     *  real types: Double, Float
     *  string types: Character, String
     */
    private final Class[] domain;
    /** Collection of tuples (data storage).
     */
    private final List<Comparable[]> tuples;
    /** Primary key.
     */
    private final String[] key;
    /** Index into tuples (maps key to tuple).
     */
    private final Map<KeyType, Comparable[]> index;

    /************************************************************************************
     * Construct an empty table from the meta-data specifications.
     * @param _name       the name of the relation
     * @param _attribute  the string containing attributes names
     * @param _domain     the string containing attribute domains (data types)
     * @param _key        the primary key
     */
    public Table(String _name, String[] _attribute, Class[] _domain, String[] _key) {
        name = _name;
        attribute = _attribute;
        domain = _domain;
        key = _key;
        tuples = new ArrayList<Comparable[]>();         // also try FileList, see below
//      tuples    = new FileList (this, tupleSize ());
        index = new TreeMap<KeyType, Comparable[]>();  // also try BPTreeMap, LinHash or ExtHash
    } // Table

    
    /************************************************************************************
     * Construct an empty table from the raw string specifications.
     * @param name        the name of the relation
     * @param attributes  the string containing attributes names
     * @param domains     the string containing attribute domains (data types)
     * @param _key        the primary key
     */
    public Table(String name, String attributes, String domains, String _key) {
        this(name, attributes.split(" "), findClass(domains.split(" ")), _key.split(" "));

        out.println("DDL> create table " + name + " (" + attributes + ")");
    } // Table


    /************************************************************************************
     * Construct an empty table using the meta-data of an existing table.
     * @param tab     the table supplying the meta-data
     * @param suffix  the suffix appended to create new table name
     */
    public Table(Table tab, String suffix) {
        this(tab.name + suffix, tab.attribute, tab.domain, tab.key);
    } // Table


    /************************************************************************************
     * Project the tuples onto a lower dimension by keeping only the given attributes.
     * Check whether the original key is included in the projection.
     * #usage movie.project ("title year studioNo")
     * @author: Kristin Ottofy
     * @param attributeList  the attributes to project onto
     * @return  a table of projected tuples
     */
    public Table project(String attributeList) {
        out.println("RA> " + name + ".project (" + attributeList + ")");

        String[] pAttribute = attributeList.split(" ");
        Class[] colDomain = extractDom(match(pAttribute), domain);
        int tupSize = pAttribute.length;
        int keySize = key.length;
        String[] newKey = key; // original key if included, otherwise all atributes.

        if (tupSize != keySize) 
            newKey = pAttribute;
        else {
            for (int i = 0; i < tupSize; i++) {
                if (!pAttribute[i].equals(key[i])){ //attributes are not the same
                    newKey = pAttribute;
                    break;
                }
            }
        }

        keySize = newKey.length;
        KeyType tempKey = new KeyType(newKey);
        Table result = new Table(name + count++, pAttribute, colDomain, newKey);

        for (int i = 0; i < tuples.size(); i++) {
            // if t[k'] does not exist in tuples then
            //   result.tuples.add(i);
            //add to index store (t[k'], t[x])

            //creating this tuples current key
            String[] currentTupStr = new String[keySize];

            for (int n = 0; n < newKey.length; n++) {
                int colPos = columnPos(newKey[n]);
                currentTupStr[n] = tuples.get(i)[colPos].toString();
            }

            KeyType currentTupKey = new KeyType(currentTupStr);
            Comparable[] tup = currentTupStr;

            if (!result.index.containsKey(currentTupKey)) {
                result.tuples.add(tup);
                result.index.put(currentTupKey, tup);
            }
        }
        return result;
    } // project


    /************************************************************************************
     * Select the tuples satisfying the given condition.
     * A condition is written as infix expression consists of
     *   6 comparison operators: "==", "!=", "<", "<=", ">", ">="
     *   2 Boolean operators:    "&", "|"  (from high to low precedence)
     * #usage movie.select ("1979 < year & year < 1990")
     * @param condition  the check condition for tuples
     * @return  a table with tuples satisfying the condition
     */
    public Table select(String condition) {
        out.println("RA> " + name + ".select (" + condition + ")");

        Table result = new Table(name + count++, attribute, domain, key);

        String[] postfix = infix2postfix(condition);

        for (Comparable[] tup : tuples) {
            if (evalTup(postfix, tup)) {
                result.tuples.add(tup);

            } // if
        } // for
        return result;
    } // select

    /************************************************************************************
     * Union this table and table2.  Check that the two tables are compatible.
     * #usage movie.union (show)
     * @author Kristin Ottofy
     * @param table2  the rhs table in the union operation
     * @return  a table representing the union
     */
    public Table union(Table table2) {
        out.println("RA> " + name + ".union (" + table2.name + ")");

        /*
         * A table is union compatible if
         *      1) both relations have the same number of columns
         *      2) the names of the attributes are the same in both relations
         *      3) attributes with the same name in both relations have the same domain
         */

        int tuplesSize = tuples.size();

        Table result = new Table(name + count++, attribute, domain, key);

        //if compatible(r1, r2) then
        if (!this.compatible(table2)) //checks num of attributes and domains
        {
            out.println(this.name + " is not compatible with " + table2.name);
            return result;
        }
        else {
            //for every tuple in r
            for (int i = 0; i < tuplesSize; i++) {
                Comparable[] tup = tuples.get(i);
                int keySize = key.length;
                String[] currentTupStr = new String[keySize];

                for (int b = 0; b < keySize; b++) {
                    int colPos = columnPos(key[b]);
                    currentTupStr[b] = tup[colPos].toString();
                }

                KeyType tempKey = new KeyType(currentTupStr);

                if (!result.index.containsKey(tempKey)) {
                    result.tuples.add(tup);
                    result.index.put(tempKey, tup);
                }
            }

            //for t belongs r2, do
            for (int i = 0; i < table2.tuples.size(); i++) {
                Comparable[] tup = table2.tuples.get(i);
                int keySize = table2.key.length;
                String[] currentTupStr = new String[keySize];

                for (int b = 0; b < keySize; b++) {
                    int colPos = columnPos(key[b]);
                    currentTupStr[b] = tup[colPos].toString();
                }

                KeyType tempKey = new KeyType(currentTupStr);

                if (!result.index.containsKey(tempKey)) {
                    result.tuples.add(tup);
                    result.index.put(tempKey, tup);
                }
            }
        }

        return result;
    } // union


    /************************************************************************************
     * Take the difference of this table and table2.  Check that the two tables are
     * compatible.
     * #usage movie.minus (show)
     * @author: Kendal Brown
     * @param table2  The rhs table in the minus operation
     * @return  a table representing the difference
     */
    public Table minus(Table table2) {
        out.println("RA> " + name + ".minus (" + table2.name + ")");

        Table result = new Table(name + count++, attribute, domain, key);

        if (!this.compatible(table2)) {
            out.println(this.name + " is not compatible with " + table2.name);
        }
        else //this table and table2 are compatible
        {
            int tupSize = this.tuples.size();

            for (int i = 0; i < tupSize; i++) {
                Comparable[] tup = tuples.get(i);
                int keySize = key.length;
                String[] currentTupStr = new String[keySize];

                for (int b = 0; b < keySize; b++) {
                    int colPos = columnPos(key[b]);
                    currentTupStr[b] = tup[colPos].toString();
                }

                KeyType tempKey = new KeyType(currentTupStr);

                if (!table2.index.containsKey(tempKey)) {
                    result.tuples.add(tup);
                    result.index.put(tempKey, tup);
                }
            }
        }
        return result;
    } // minus


    /************************************************************************************
     * Join this table and table2.  If an attribute name appears in both tables,
     * assume it is from the first table unless it is qualified with the first letter
     * of the second table's name (e.g., "s.").
     * In the result, disambiguate the attribute names in a similar way
     * (e.g., prefix the second occurrence with "s_").
     * Caveat: the key parameter assumes joining the table with the foreign key (this)
     * to the table containing the primary key (table2).
     * #usage movie.join ("studioNo == name", studio);
     * #usage movieStar.join ("name == s.name", starsIn);
     * @param condition  the join condition for tuples
     * @param table2     the rhs table in the join operation
     * @return  a table representing the join
     */
    public Table join(String condition, Table table2) {
        out.println("RA> " + name + ".join (" + condition + ", " + table2.name + ")");

        Table result = new Table(name + count++, new String[0], new Class[0], key);

        //-----------------\\
        // TO BE IMPLEMENTED \\
        //---------------------\\

        return result;
    } // join


    /************************************************************************************
     * Insert a tuple to the table.
     * #usage movie.insert ("'Star_Wars'", 1977, 124, "T", "Fox", 12345)
     * @param tup  the array of attribute values forming the tuple
     * @return  whether insertion was successful
     */
    public boolean insert(Comparable[] tup) {
        //pull values from tuple at key columns for key value
        out.println("DML> insert into " + name + " values ( " + Arrays.toString(tup) + " )");

        if (typeCheck(tup)) {
            tuples.add(tup);

            int keySize = key.length;
            String[] currentTupStr = new String[keySize];

            for (int b = 0; b < keySize; b++) {
                int colPos = columnPos(key[b]);
                currentTupStr[b] = tup[colPos].toString();
            }

            KeyType tempKey = new KeyType(currentTupStr);

            index.put(tempKey, tup);
            return true;
        } else {
            return false;
        } // if
    } // insert

    
    /************************************************************************************
     * Get the name of the table.
     * @return  the table's name
     */
    public String getName() {
        return name;
    } // getName


    /************************************************************************************
     * Print the table.
     */
    public void print() {
        out.println("\n Table " + name);
        out.print("|-");
        for (int i = 0; i < attribute.length; i++) {
            out.print("---------------");
        }
        out.println("-|");
        out.print("| ");
        for (String a : attribute) {
            out.printf("%15s", a);
        }
        out.println(" |");
        out.print("|-");
        for (int i = 0; i < attribute.length; i++) {
            out.print("---------------");
        }
        out.println("-|");
        for (Comparable[] tup : tuples) {
            out.print("| ");
            for (Comparable attr : tup) {
                out.printf("%15s", attr);
            }
            out.println(" |");
        } // for
        out.print("|-");
        for (int i = 0; i < attribute.length; i++) {
            out.print("---------------");
        }
        out.println("-|");
    } // print


    /*
     * Determine whether the two tables (this and table2) are compatible, i.e., have
     * the same number of attributes each with the same corresponding domain.
     * @author Kendal Brown
     * @param table2  the rhs table
     * @return  whether the two tables are compatible
     */
    private boolean compatible(Table table2) {
        
        if (table2.attribute.length != this.attribute.length) 
            return false;

        for (int i = 0; i < attribute.length; i++) {
            if (!domain[i].getName().equalsIgnoreCase(table2.domain[i].getName()))
                return false;
        }

        return true;
    } // compatible


    /************************************************************************************
     * Get the column position for the given attribute name.
     * @param attr  the given attribute name
     * @return  a column position
     */
    private int columnPos(String attr) {
        for (int i = 0; i < attribute.length; i++) {
            if (attr.equals(attribute[i])) {
                return i;
            }
        } // for

        return -1;  // not found
    } // columnPos


    /************************************************************************************
     * Check whether the tuple satisfies the condition.  Use a stack-based postfix
     * expression evaluation algorithm.
     * @author Kendal Brown
     * @param condition  the postfix expression for the condition
     * @param tup        the tuple to check
     * @return  whether to keep the tuple
     */
    private boolean evalTup(String[] postfix, Comparable[] tup) {
        if (postfix == null) {
            return false;
        }

        String a = "==";
        String b = "!=";
        String c = ">";
        String d = "<=";
        String e = ">";
        String f = ">=";
        String g = "&";
        String h = "|";
        Stack<Comparable<?>> s = new Stack<Comparable<?>>();
        Stack reversedStack = new Stack();

        for (int i = (postfix.length - 1); i >= 0; i--) {
            reversedStack.push(postfix[i]);
        }

        for (;;) {

            String attribute = (String) reversedStack.pop();
            String searchy = (String) reversedStack.pop();
            searchy = searchy.replace("\'", "");            //gets rid of single quotes
            String operator = (String) reversedStack.pop();
            int columnPosition = columnPos(attribute);

            /*
            System.out.println("attribute: "+ attribute);
            System.out.println("searchy: "+ searchy);
            System.out.println("operator: "+ operator);
            System.out.println("columnPosition: "+ columnPosition);
             *
             */

            if (searchy.equals(tup[columnPosition])) {
                s.push(true);
            } else {
                s.push(false);
            }

            try{
                if ((reversedStack.peek().equals(g)) || (reversedStack.peek().equals(h))) {
                    if (reversedStack.peek().equals(g)) {
                        String and = (String) reversedStack.pop();
                        Comparable<?> first = s.pop();
                        Comparable<?> second = s.pop();

                        //AND truth table evaluation
                        if ((first.equals(false) && second.equals(false))) {
                            s.push(false);
                        } else {
                            s.push(true);
                        }
                    }

                    try {
                        if (reversedStack.peek().equals(h)) {
                            String or = (String) reversedStack.pop();
                            Comparable<?> first = s.pop();
                            Comparable<?> second = s.pop();

                            //OR truth table evaluation
                            if ((first.equals(true) && second.equals(true))) {
                                s.push(true);
                            } else {
                                s.push(false);
                            }
                        }
                    } catch (Exception q) {
                    }
                }
            }catch(Exception y){}


            if (reversedStack.isEmpty()) {
                break;
            }
        }

        return (Boolean) s.pop();

    } // evalTup


    /************************************************************************************
      * Convert an untokenized infix expression to a tokenized postfixexpression.
      * This implementation does not handle parentheses ( ).
      * Ex: "1979 < year & year < 1990" --> { "1979", "year", "<","year", "1990", "<", "&" }
      * A condition is written as infix expression consists of
      *   6 comparison operators: "==", "!=", "<", "<=", ">", ">="
      *   2 Boolean operators:    "&", "|"  (from high to low precedence)
      * @author: Kristin Ottofy
      * @param condition  the untokenized infix condition
      * @return  a resultant tokenized postfix expression
      */
     private String[] infix2postfix(String condition)
     {
         if (condition == null || condition.trim() == "")
         {
             return null;
         }

         String[] infix = condition.split(" ");        // tokenize theinfix
         int size = infix.length;
         String[] postfix = new String[size];    // same size, since no ( )
         Stack stack = new Stack();
         String a = "==";
         String b = "!=";
         String c = ">";
         String d = "<=";
         String e = ">";
         String f = ">=";
         String g = "&";
         String h = "|";

         for (int i = 0, p = 0; i < size; i++)
         {

             //if word, add to postfix[]
             if (!infix[i].equals(a) && !infix[i].equals(b)
                     && !infix[i].equals(c) && !infix[i].equals(d)
                     && !infix[i].equals(e) && !infix[i].equals(f)
                     && !infix[i].equals(g) && !infix[i].equals(h))
             {
                 //out.println(infix[i] + " is NOT an operator");
                 postfix[p] = infix[i];  //add to postfix
                 //out.println("postfix[" + p + "]: " + postfix[p]);
                 p++;
             }
             else // it is an operator
             {

                 //if lesser operator, add to stack, get next word,add to postfix
                 if (!infix[i].equals(g) && !infix[i].equals(h))
                 {
                     stack.push(infix[i]);
                     i++;
                     postfix[p] = infix[i];
                     p++;

                     postfix[p] = (String)stack.pop();
                     p++;
                 }
                 else if (infix[i].equals(g))    // if &, add topostfix[p+3], p++
                 {
                     stack.push(infix[i]);   //push &
                     i++;
                     postfix[p] = infix[i];  //get next word
                     p++; i++;
                     stack.push(infix[i]);   //push operator
                     i++;
                     postfix[p] = infix[i];  //add next word
                     p++;
                     postfix[p] = (String)stack.pop();   //pop operator
                     p++;
                     postfix[p] = (String)stack.pop();   //pop &
                     p++;
                 }
                 else    //|
                 {
                     stack.push(infix[i]);
                 }
                 if (i + 1 >= size)
                     {
                         while (!stack.isEmpty())
                         {
                             postfix[p] = (String) stack.pop();
                             p++;
                         }
                     }
             }
         }

         /*out.print("\npostfix: ");
         for (int i = 0; i < infix.length; i++)
         {
             out.print(postfix[i] + " ");
         }

         out.println("\n");*/
         return postfix;
     } // infix2postfix


    /************************************************************************************
     * Match the column and attribute names to determine the domains.
     * @param column  the array of column names
     * @return  an array of column index position
     */
    private int[] match(String[] column) {
        int[] colPos = new int[column.length];

        for (int j = 0; j < column.length; j++) {
            boolean matched = false;
            for (int k = 0; k < attribute.length; k++) {
                if (column[j].equals(attribute[k])) {
                    matched = true;
                    colPos[j] = k;
                } // for
            } // for
            if (!matched) {
                out.println("match: domain not found for " + column[j]);
            } // if
        } // for

        return colPos;
    } // match


    /************************************************************************************
     * Check the size of the tuple (number of elements in list) as well as the type of
     * each value to ensure it is from the right domain.
     * @author Kristin Ottofy
     * @param tup  The tuple as a list of attribute values
     * @return  whether the tuple has the right size and values that comply
     *          with the given domains
     */
    private boolean typeCheck(Comparable[] tup) {
   
        if (tup.length != this.attribute.length) {
            out.println("Type check failed because number of attributes is incorrect.\n");
            return false;
        }

        for (int i = 0; i < this.attribute.length; i++) {
            if (domain[i] != tup[i].getClass()) {
                if ((domain[i] == Float.class) && tup[i].getClass() == Double.class) //let pass??????
                {
                    continue;
                } else if ((domain[i] == Float.class) && tup[i].getClass() == Long.class) {
                    continue;
                }

                out.println("Type check failed because tuple does not have correct domain.\n");
                return false;
            }
        }

        return true;
    } // typeCheck


    /************************************************************************************
     * Find the classes in the "java.lang" package with given names.
     * @param className  the array of class name (e.g., {"Integer", "String"})
     * @return  an array of Java classes
     */
    private static Class[] findClass(String[] className) {
        Class[] classArray = new Class[className.length];

        for (int i = 0; i < className.length; i++) {
            try {
                classArray[i] = Class.forName("java.lang." + className[i]);
            } catch (ClassNotFoundException ex) {
                out.println("findClass: " + ex);
            } // try
        } // for

        return classArray;
    } // findClass


    /************************************************************************************
     * Extract the corresponding domains.
     * @param colPos the column positions to extract.
     * @param group  wHere to extract from
     * @return  the extracted domains
     */
    private Class[] extractDom(int[] colPos, Class[] group) {
        Class[] obj = new Class[colPos.length];

        for (int j = 0; j < colPos.length; j++) {
            obj[j] = group[colPos[j]];
        } // for

        return obj;
    } // extractDom

    /************************************************************************************
     * Pack tuple tup into a record/byte-buffer (array of bytes).
     * @param tup  the array of attribute values forming the tuple
     * @return  a tuple packed into a record/byte-buffer

    byte[] pack(Comparable[] tup){
        byte[] record = new byte[tupleSize()];
        byte[] b = null;
        int s = 0;
        int i = 0;

        for (int j = 0; j < domain.length; j++)
        {
            if (domain[j].getName().equals("java.lang.Integer"))
            {
                b = Conversions.int2ByteArray((Integer) tup[j]);
                s = 4;
            }
            else if (domain[j].getName().equals("java.lang.String"))
            {
                b = ((String) tup[j]).getBytes();
                s = 32;

                    //-----------------\\
                    // TO BE IMPLEMENTED \\
                    //---------------------\\

            } // if
            if (b == null)
            {
                out.println("Table.pack: byte array b is null");
                return null;
            } // if

            for (int k = 0; k < s; k++)
            {
                record[i++] = b[k];
            }
         } // for
        return record;
    } // pack

    /************************************************************************************
     * Unpack the record/byte-buffer (array of bytes) to reconstruct a tuple.
     * @param record  the byte-buffer in which the tuple is packed
     * @return  an unpacked tuple

    Comparable[] unpack(byte[] record)
    {
        //-----------------\\
        // TO BE IMPLEMENTED \\
        //---------------------\\

    return null;
    } // unpack

     */
    /************************************************************************************
     * Determine the size of tuples in this table in terms of the number of bytes required
     * to store it in a record/byte-buffer.
     * @author Kristin Ottofy
     * @return  the size of packed-tuples in bytes
     */
    /*
    private int tupleSize()
    {
        int s = 0;

        for (int j = 0; j < domain.length; j++)
        {
            if (domain[j].getName().equals("java.lang.Integer"))
            {
                s += 4;
            }
            else if (domain[j].getName().equals("java.lang.String"))
            {
                s += 32;

                //-----------------\\
                // TO BE IMPLEMENTED \\
                //---------------------\\

        } // if
        } // for

        return s;
    } // tupleSize
     */
} // Table class

