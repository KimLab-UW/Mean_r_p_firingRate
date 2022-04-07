// find r and p firingRate 

import java.io.*;
import java.util.*;

public class StatsForPETHVSpeed{
   public static void main(String[]args) throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      System.out.print("file name (put .txt at end of file name): "); //have to add .txt to end of file name 
      String filename = console.next();
      Scanner file = new Scanner(new File(filename));
      System.out.println();
      
      PrintStream output = new PrintStream(new File("r_p.txt"));
      
      int numberOfCols = getNumCols(file);      
      double[][] firingRate = new double[20][numberOfCols];
      double[][] speed = new double[20][numberOfCols];
      getArray(file, firingRate, speed, numberOfCols); // get firingRate and speed arrays
      
      double[] meanFiringRate = new double[numberOfCols];
      double[] meanSpeed = new double[numberOfCols];          
      average(firingRate, meanFiringRate, numberOfCols); //averages firingRate datas
      average(speed, meanSpeed, numberOfCols); //averages speed datas
   }
   
   public static int getNumCols(Scanner file){
      Scanner lineScanner = new Scanner(file.nextLine());
      int numberOfCols = 0;
      while (lineScanner.hasNext()) {
         lineScanner.next();
         numberOfCols++;
      }
      return numberOfCols;
   }
   
   public static void getArray(Scanner file, double[][] firingRate, double[][] speed, int numberOfCols){
      for (int i = 0; i < 20; i++) {
         Scanner lineScanner = new Scanner(file.nextLine());
         for (int j = 0; j < numberOfCols ; j++){
            firingRate[i][j] = lineScanner.nextDouble();
         }
      }
      for (int i = 0; i < 20; i++) {
         Scanner lineScanner = new Scanner(file.nextLine());
         if (lineScanner.hasNextDouble()) {
            for (int j = 0; j < numberOfCols ; j++){
               speed[i][j] = lineScanner.nextDouble();
            }
         } else {
            i = 0;
         }
      }
   }
   
   public static void average(double[][] raw, double[] mean, int numberOfCols){ 
      for (int i = 0; i < numberOfCols; i++) {
         double sum = 0;
         for (int j = 0; j < 20; j++) {
            sum += raw[j][i];
         }
         mean[i] = sum / 20;
      }
      System.out.println(Arrays.toString(mean));
   }
} 