import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class DayOne{
  public static void main(String[] args){
    int[] Array1 = new int[1000];
    int[] Array2 = new int[1000];
    int count = 0;
    int i = 0;
    try{
      File file = new File("/workspaces/advent-of-code-2024/DayOne/input.txt");
      Scanner scanner = new Scanner(file);

      while(scanner.hasNextInt()){
        int tempNumber = scanner.nextInt();
        if(count%2 == 0){
          Array1[i] = tempNumber;
        }
        else{
          Array2[i] = tempNumber;
          i++;
        }
        count ++;
      }
      scanner.close();
    }
    catch(FileNotFoundException e){
      System.out.println("File Not Found: " + e.getMessage());
    }

    MyQuickSort sorter = new MyQuickSort();
    sorter.sort(Array1);
    sorter.sort(Array2);

    int total = 0;
    for(int j = 0 ; j < 1000 ; j++){
      total += Math.abs(Array1[j] - Array2[j]);
    }
    System.out.println("Total Distance: "+String.valueOf(total));


    HashMap<Integer,Integer> timesRepeated = new HashMap<Integer,Integer>();
    int numRepeated = 0;
    int similarity = 0;
    int tempSimilarity = 0; 
    for(int k = 0; k < Array1.length ; k++){
      for(int l = 0 ; l < Array1.length; l++){
        if(Array1[k] == Array2[l]){
          numRepeated += 1;
        }
      }
      timesRepeated.put(Array1[k], numRepeated);
      numRepeated = 0;
      tempSimilarity = Array1[k] * timesRepeated.get(Array1[k]);
      similarity = tempSimilarity + similarity;
    }
    System.out.println("Similartiy between the Lists: " + String.valueOf(similarity));


  }
}