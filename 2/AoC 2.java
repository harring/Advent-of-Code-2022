import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) {
//X A rock        1p
//Y B paper       2p
//Z C scissor     3p
//loss          0p
//draw          3p
//win           6p

//part 2 
//X = lose
//Y = draw
//Z = win
        String lineString = "";
        int points = 0;
        int pointsPartTwo = 0;
        String firstThreeChars = "";

try {
    Scanner scanner = new Scanner(new File(".\\input.txt"));
    System.out.println("file read");

    
    while (scanner.hasNextLine()) {
        lineString = scanner.nextLine();
        firstThreeChars = lineString.substring(0,3);

        switch(firstThreeChars) {
            case "A X":
                points = points + 4;                
                pointsPartTwo = pointsPartTwo + 3;
                break;
            case "A Y":
                points = points + 8;
                pointsPartTwo = pointsPartTwo + 4;
                break;
            case "A Z":
                points = points + 3;
                pointsPartTwo = pointsPartTwo + 8;
                break;
            case "B X":
                points = points + 1;
                pointsPartTwo = pointsPartTwo + 1;
                break;
            case "B Y":
                points = points + 5;
                pointsPartTwo = pointsPartTwo + 5;
                break;
            case "B Z":
                points = points + 9;
                pointsPartTwo = pointsPartTwo + 9;
                break;
            case "C X":
                points = points + 7;
                pointsPartTwo = pointsPartTwo + 2;
                break;
            case "C Y":
                points = points + 2;
                pointsPartTwo = pointsPartTwo + 6;
                break;
            case "C Z":
                points = points + 6;
                pointsPartTwo = pointsPartTwo + 7;
                break;
            default:
                System.out.println("no good");
        }  
    }
    System.out.println(points + " points for part 1.");
    System.out.println(pointsPartTwo + " points for part 1.");

  }catch (FileNotFoundException e) {
          e.printStackTrace();
  }
    }
}
