import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int onGnome = 1;
    int topThreeGnomes = 0;
    int caloriesGnomes[] = new int[999];
    String lineString = "";
    int lineInt = 0;
    int topGnome = 0;
    try {
      Scanner scanner = new Scanner(new File(".\\inputData.txt"));
      System.out.println("file read");

      
      while (scanner.hasNextLine()) {
        lineString = scanner.nextLine();
        if (lineString.isEmpty()) {
          lineString = "0";
        }
        lineInt = Integer.parseInt(lineString);

        if (lineInt > 0) {
          caloriesGnomes[onGnome] = caloriesGnomes[onGnome] + lineInt;   
          //System.out.println(onGnome + "has " + caloriesGnomes[onGnome] + " in the backpack.");
        } else if (lineInt < 1) {
          onGnome++; 
        } 
      }
    }catch (FileNotFoundException e) {
			e.printStackTrace();
    }
    for(int i = 0; i <= onGnome; i++) {
     // System.out.println("Gnome" + i + " carries " + caloriesGnomes[i] + " calories");
      if (caloriesGnomes[i] > caloriesGnomes[topGnome]) {
        topGnome = i;
      }
    }
    System.out.println("Gnome " + topGnome + " carries the most, it carries " + caloriesGnomes[topGnome] + " calories.");
    topThreeGnomes = topThreeGnomes + caloriesGnomes[topGnome];
    caloriesGnomes[topGnome] = 0;


    for(int i = 0; i <= onGnome; i++) {
      if (caloriesGnomes[i] > caloriesGnomes[topGnome]) {
        topGnome = i;
      }
    }
    System.out.println("Gnome " + topGnome + " carries the second most, it carries " + caloriesGnomes[topGnome] + " calories.");

    topThreeGnomes = topThreeGnomes + caloriesGnomes[topGnome];
    caloriesGnomes[topGnome] = 0;

    for(int i = 0; i <= onGnome; i++) {
      if (caloriesGnomes[i] > caloriesGnomes[topGnome]) {
        topGnome = i;
      }
    }
    System.out.println("Gnome " + topGnome + " carries the third most, it carries " + caloriesGnomes[topGnome] + " calories.");

    topThreeGnomes = topThreeGnomes + caloriesGnomes[topGnome];
    System.out.println("The three top carriers together carry " + topThreeGnomes + " calories");
  }
}