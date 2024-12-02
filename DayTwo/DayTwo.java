import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DayTwo{
    public static void main(String[] args){
        int nextInt = 0;
        int currentInt = 0;
        int safe = 0;
        int difference = 0;
        boolean positive;
        boolean isSafe;
        int[][] allReports = new int[1000][];
        try{
            File file = new File("/workspaces/advent-of-code-2024/DayTwo/inputDayTwo.txt");
            Scanner scanner = new Scanner(file);
            for(int i = 0 ; i < allReports.length ; i++){
                String line = scanner.nextLine();
                String[] strArray = line.split(" ");
                int[] intArray = new int[strArray.length];
                for(int j = 0 ; j < strArray.length ; j++){
                    intArray[j] = Integer.parseInt(strArray[j]);
                }
                allReports[i] = intArray;

            }
            //First Part Solution
            // for(int i = 0 ; i < allReports.length ; i++){
            //     int[] tempArray = allReports[i];
            //     isSafe = true;
            //     for(int j = 0; j < tempArray.length -1 ; j++){
            //         positive = isPositive(tempArray[1] - tempArray[0]);
            //         currentInt = tempArray[j];
            //         nextInt = tempArray[j + 1];
            //         difference = nextInt - currentInt;
            //         System.out.print(currentInt + " " + nextInt + " " + difference);
            //         System.out.println();
            //         if(positive){
            //             if(difference>3 || difference <1){
            //                 isSafe = false;
            //             }
            //         }
            //         else{
            //             if(difference<-3 || difference>-1){
            //                 isSafe = false;
            //             }
            //         }

            //     }
            //     if(isSafe){
            //         safe++;
            //     }

            // }

            //Second Part
            for(int i = 0 ; i < allReports.length ; i++){
                int[] tempArray = allReports[i];
                isSafe = true;
                for(int j = 0; j < tempArray.length -1 ; j++){
                    positive = isPositive(tempArray[1] - tempArray[0]);
                    currentInt = tempArray[j];
                    nextInt = tempArray[j + 1];
                    difference = nextInt - currentInt;
                    if(positive){
                        if(difference>3 || difference <1){
                            isSafe = false;
                            
                        }
                    }
                    else{
                        if(difference<-3 || difference>-1){
                            isSafe = false;
                        }
                    }

                }

                if(!isSafe){
                    for(int k = 0; k < tempArray.length -2 ; k++){
                        int[] newTempArray = new int[tempArray.length-1];
                        int toRemove = k+1;
                        for (int m = 0 ; m < tempArray.length - 1  ; m ++){
                            newTempArray[m] = tempArray[m];
                            if( m == toRemove){
                                newTempArray[m] = tempArray[m+1];
                            }
                        }
                        for(int m = 0 ; m < newTempArray.length - 1 ; m ++){
                            isSafe = true;
                            positive = isPositive(newTempArray[1] - newTempArray[0]);
                            currentInt = newTempArray[m];
                            nextInt = newTempArray[m + 1];
                            difference = nextInt - currentInt;
                            if(positive){
                                if(difference>3 || difference <1){
                                    isSafe = false;
                                }
                            }
                            else{
                                if(difference>3 || difference <1){
                                    isSafe = false;
                                }
                            }
                        }
                    }
                }

                if(isSafe){
                    safe++;
                }

            }
            System.out.println("Total Safe Reports: " + safe);
            scanner.close();

            
        }

        catch(FileNotFoundException e){
            System.out.println("File Not Found: " + e.getMessage());
        }

    }

    public static boolean isPositive(int difference){
        if(difference >= 0){
            return true;
        }
        return false;
    }
}