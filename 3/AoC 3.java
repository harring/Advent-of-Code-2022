import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
    //Compare chars to find until you find the common char and return its value
    static int compareStrings(String lineStringFirstHalf, String lineStringSecondHalf) {
        int upperCaseCorrection = -38; //the chars inherent value in java compared to the tasks value
        int lowerCaseCorrection = -96; //the chars inherent value in java compared to the tasks value

        for (int i = 0; i < (lineStringFirstHalf.length()); i++) {
            for(int j = 0; j < (lineStringFirstHalf.length()); j++) {
                if (lineStringFirstHalf.charAt(i) == lineStringSecondHalf.charAt(j)) {
                     if (Character.isUpperCase(lineStringFirstHalf.charAt(i))) {
                         return (int)lineStringFirstHalf.charAt(i) + upperCaseCorrection;
                     } else {
                         return (int)lineStringFirstHalf.charAt(i) + lowerCaseCorrection;
                     }
                }
            }   
        }
        return 0;
    }

    //Compare chars to find until you find the common char and return its value
    static int findBadge(String firstBackpack, String secondBackpack, String thirdBackpack) {
        int upperCaseCorrection = -38; //the chars inherent value in java compared to the tasks value
        int lowerCaseCorrection = -96; //the chars inherent value in java compared to the tasks value

        for (int x = 0; x < firstBackpack.length(); x++) {
            for(int y = 0; y < secondBackpack.length(); y++) {
                for(int z = 0; z < thirdBackpack.length(); z++) {
                    if (firstBackpack.charAt(x) == secondBackpack.charAt(y) && firstBackpack.charAt(x) == thirdBackpack.charAt(z) ) {
                        if (Character.isUpperCase(firstBackpack.charAt(x))) {
                            return (int)firstBackpack.charAt(x) + upperCaseCorrection;
                        } else {
                            return (int)firstBackpack.charAt(x) + lowerCaseCorrection;
                        } 
                }
            }
        }   
    }
        return 0;
        
    }
            
        
    public static void main(String[] args) {

        String lineString = "";
        String lineStringFirstHalf = "";
        String lineStringSecondHalf = "";
        int lineLenght = 0;
        int totalValue = 0;

        try {
            Scanner scanner = new Scanner(new File(".\\input.txt"));
             //read line and split into two strings      
             while (scanner.hasNextLine()) {
                 lineString = scanner.nextLine();
                 lineLenght = lineString.length();
                 lineStringFirstHalf = lineString.substring(0, lineLenght/2);
                 lineStringSecondHalf = lineString.substring((lineLenght/2), lineLenght); 
                 totalValue = totalValue + compareStrings(lineStringFirstHalf, lineStringSecondHalf);        
               } 
            scanner.close();
           }catch (FileNotFoundException e) {
                   e.printStackTrace();
           }         
           System.out.println(totalValue);             
           
            //Part two

            totalValue = 0;
            lineString = "";
            String lineStringTwo = "";
            String lineStringThree = "";
           try {
            Scanner scanner = new Scanner(new File(".\\input.txt"));
            //read three lines and use the method to compare 
             while (scanner.hasNextLine()) {
                 lineString = scanner.nextLine();
                 lineStringTwo = scanner.nextLine();
                 lineStringThree = scanner.nextLine();
          
                 totalValue = totalValue + findBadge(lineString, lineStringTwo, lineStringThree);
                 
               } 
            scanner.close();
           }catch (FileNotFoundException e) {
                   e.printStackTrace();
           }    
           System.out.println(totalValue);     
    }  
}