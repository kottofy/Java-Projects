/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * PlayingWithStrings.java
 * @author Kristin Ottofy
 * Last Edited: 01-28-1009
 */
public class PlayingWithStrings {

    public static void main(String[]args)

    {

        String bestSwimmer = "MICHAEL F. WHELPS";

        String replaceW = bestSwimmer.replace('W', 'P');

        String firstName = replaceW.substring(0, 7);

        String middleInitial = replaceW.substring(8,10);

        String lastName = replaceW.substring(11,17);

        String firstNameLower = firstName.toLowerCase();

        String lastNameLower = lastName.toLowerCase();

        String firstNameFin = firstNameLower.replaceFirst("m","M");

        String lastNameFin = lastNameLower.replaceFirst("p","P");

        String reservedName = lastNameFin + ", " + firstNameFin + " " + middleInitial;

        System.out.println(reservedName + "-, June 30, 1985, Baltimore, Maryland.");

        System.out.print(firstNameFin + " " + middleInitial + " " + lastNameFin);
        System.out.print(" is an American swimmer." + lastNameFin + " has won 14");
        System.out.print(" career Olympic gold medals, the most by any Olympian. ");
        System.out.print(lastNameFin + " went a perfect 8-for-8 in Beijing, ");
        System.out.print("breaking Mark Spitz's single-Games record for gold medals. ");
        System.out.print("As of September 2008, " + firstNameFin + " " + lastNameFin);
        System.out.println(" holds seven world records in swimming.");



    }

}
