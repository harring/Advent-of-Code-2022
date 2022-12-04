import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) {
        String lineString = "";
        int totalValue = 0;
        int totalValueTwo = 0;

        try {
            Scanner scanner = new Scanner(new File(".\\input.txt"));
            while (scanner.hasNextLine()) {
                lineString = scanner.nextLine();
                String[] parts = lineString.split(",");
                String[] partsOne = parts[0].split("-");
                String[] partsTwo = parts[1].split("-");

                totalValueTwo = totalValueTwo + ifPartlyInside(Integer.parseInt(partsOne[0]), Integer.parseInt(partsOne[1]),
                                    Integer.parseInt(partsTwo[0]), Integer.parseInt(partsTwo[1]));

                //can propably do without most of this part but I am not interested in going back to try
                if ((Integer.parseInt(partsOne[1]) - Integer.parseInt(partsOne[0])) > (Integer.parseInt(partsTwo[1])
                        - Integer.parseInt(partsTwo[0]))) {
                    totalValue = totalValue
                            + ifCompletelyInside(Integer.parseInt(partsTwo[0]), Integer.parseInt(partsTwo[1]),
                                    Integer.parseInt(partsOne[0]), Integer.parseInt(partsOne[1]));
                } else if ((Integer.parseInt(partsOne[1])
                        - Integer.parseInt(partsOne[0])) < (Integer.parseInt(partsTwo[1])
                                - Integer.parseInt(partsTwo[0]))) {
                    totalValue = totalValue
                            + ifCompletelyInside(Integer.parseInt(partsOne[0]), Integer.parseInt(partsOne[1]),
                                    Integer.parseInt(partsTwo[0]), Integer.parseInt(partsTwo[1]));
                    
                } else {
                    if (Integer.parseInt(partsOne[0]) == Integer.parseInt(partsTwo[0])) {
                        totalValue = totalValue + 1;
                    }
                    
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(totalValue);
        System.out.println(totalValueTwo);
    }

    static int ifCompletelyInside(Integer shortNumberLow, Integer shortNumberHigh, Integer longNumberLow,
            Integer longNumberHigh) {
        if (shortNumberLow >= longNumberLow && shortNumberHigh <= longNumberHigh) {
            return 1;
        }
        return 0;
    }

    static int ifPartlyInside(Integer firstNumberOne, Integer firstNumberTwo, Integer secondNumberOne,
            Integer secondNumberTwo) {
        if (firstNumberOne >= secondNumberOne && firstNumberOne <= secondNumberTwo) {
            System.out.println("Success: " + firstNumberOne + " " + firstNumberTwo + " " + secondNumberOne + " " + secondNumberTwo);
            return 1;
        } else if (firstNumberTwo >= secondNumberOne && firstNumberTwo <= secondNumberTwo) {
            System.out.println("Success: " + firstNumberOne + " " + firstNumberTwo + " " + secondNumberOne + " " + secondNumberTwo);
            return 1;
        } else if (firstNumberOne < secondNumberOne && firstNumberTwo > secondNumberTwo ) {
            return 1; 
        }
        return 0;
    }
}