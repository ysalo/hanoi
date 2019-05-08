/*
 * Hanoi.java
 *
 * TCSS 142 – Spring 2016
 * Programming Assignment 3  
*/
import java.util.*;

/**  
 *  This program find the solution to the Towers of Hanoi puzzle and displays each step. 
 * 
 *  @author Yaro Salo 
 *  @version 25th May 2016  
*/

public class Hanoi{
   
   private static Rod a;
   private static Rod b;
   private static Rod c;
   
   /**
   *Driver method of the class to solve the puzzle.
   *
   *@param args command line input. 
   */
   public static void main(String[] args){
    
     System.out.print("Enter the number of disks in rod A:");
     /**
     *Instance of the scanner object to get user input.
     */
     //Call the function to get an integer value of at least 0
     Scanner input = new Scanner(System.in);
     /**
     *Holds the number of disks in the A rod.
     */
     int numDisks = getInteger(input);
     /**
     *An instance of the Rod Class with the size the user passed in.
     */
     a = new Rod(numDisks);
     /**
     *An instance of the Rod Class with the size 0.
     */
     b = new Rod(0);
     /**
     *An instance of the Rod Class with the size 0.
     */
     c = new Rod(0);
     //Print the initial status of the game.
     printStatus();
     System.out.println();
     recursiveTOH(numDisks, "A" , "B" , "C" , a, b, c);
     
     
   }
   /**
   * This method displays a representation of the Towers of Hanoi.
   *    
   */
   public static void printStatus(){
      /**
      *Get the String representations of my rods.
      */
      String aString = a.toString();
      String bString = b.toString();
      String cString = c.toString();
      /**
      *Split the strings and get arrays.
      */
      String[] asplit = aString.split("\\s+");
      String[] bsplit = bString.split("\\s+");
      String[] csplit = cString.split("\\s+");
      
      int size;
      /**
      *Find which array is biggest.
      */
      if(asplit.length > bsplit.length && asplit.length > csplit.length){
         size = asplit.length;
      }else if(bsplit.length > asplit.length && bsplit.length > csplit.length){
         size = bsplit.length;
      }else{
         size = csplit.length;
      }
      
      /**
      *Loop from the size of the biggest array to zero exclusivly and print correspoding output.
      */
      for(int i = size; i > 0; i--){
         if(asplit.length >= i){
            System.out.print(asplit[i-1]);
            System.out.print("\t");
            
            
         }else{
            System.out.print(" ");
            System.out.print("\t");
         }
         
         if(bsplit.length >= i){
            System.out.print(bsplit[i-1]);
            System.out.print("\t");
             
         }else{
            System.out.print(" ");
            System.out.print("\t");
         }
         if(csplit.length >= i){
            System.out.print(csplit[i-1]);
            
           
         }else{
            System.out.print(" ");
            System.out.print("\t");
         }
         
         
         System.out.println();
         
       
      }
      //print the A B and C to represent the rods.
      System.out.print("A");
      System.out.print("\t");
      System.out.print("B");
      System.out.print("\t");
      System.out.print("C");
      System.out.print("\t");
      System.out.println();
      
   }
   /**
   * This method finds all the steps to solve the Towers of Hanoi problem recursivly.
   *   
   * @param numDisks is the number of disks. 
   * @param rodStart is a string that represents where we start.
   * @param rodMid is a string that represents the middle rod.
   * @param rodEnd is a stirng that represents the end rod.
   * @param a is an instance of the Rod object representing the first rod. 
   * @param b is an instance of the Rod object representing the second rod.
   * @param c is an instance of the Rod object representing the third rod. 
   */
   public static void recursiveTOH(int numDisks , String rodStart, String rodMid,  String rodEnd, Rod a, Rod b, Rod c){
     //Base Case
     if (numDisks == 1) {
           //Move the disk from one rod to another.
           move(a, c);
           //Print the status of the game after the move.
           printStatus();
           //Print which move should be made
           System.out.println("Move Disk from " + rodStart + " to rod " + rodEnd);
          
     //Recursive Case      
     } else {
           //Method call to itself with reduced number of disk and switch parameters.
           recursiveTOH(numDisks - 1, rodStart, rodEnd, rodMid, a, c, b);
           //Move the disks
           move(a, c);
           //Print the status after the move.
           printStatus();
           //Print which move should be made.
           System.out.println("Move Disk from rod " + rodStart + " to rod " + rodEnd);
           //Method call to itself with reduced number of disk and switch parameters.
           recursiveTOH(numDisks - 1, rodMid, rodStart, rodEnd, b,a,c);     
       }    
   }
   
  /**
  * This method removes a disk from the end of one rod and moves it to the from of another.
  *   
  * @param moveFrom is an instance of the Rod object representing the rod that from which the disk is supposed to be moved. 
  * @param moveTo is an instance of the Rod object representing the rod to which the disk needs to be added.
  */
  public static void move(Rod moveFrom , Rod moveTo){
      int temp = moveFrom.getDisk();
      moveTo.addDisk(temp);
  }
  
  
  /**
  * This method returns and integer bigger or equal than 0.
  *   
  * @param input is a Scanner object to read user input. 
  * @return returns an integer value bigger or equal 0
  0.
  */ 
  public static int getInteger(Scanner input){
   boolean flag = false;
      int value = 0;
      while(!flag){
         while(!input.hasNextInt()){
            input.next();
            System.out.print("Enter positive integers only: ");
         }
         value = input.nextInt();
         if(value > 0){
            flag = true;
         }
         if(!flag){
            System.out.print("Enter integer greater than 0: ");
         }
      }
      return value;   
   }   
   
}