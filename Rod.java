/*
 * Rod.java
 *
 * TCSS 142 – Spring 2016
 * Programming Assignment 3  
*/
import java.util.*;

/**  
 *  This program deefines and constucts an object Rod. 
 * 
 *  @author Yaro Salo 
 *  @version 25th May 2016  
*/
public class Rod{
    /**
    *Store the contents of the rod.
    */
   private ArrayList<Integer> pole = new ArrayList<Integer>();
    /**
    *Keep track of how many disks we need to add.
    */
   private int count;
   
    /**
    *A string that will be used to display the rod.
    */
   private String display;
   
   
   /**  
   *  Constructor method that constructs a Rod object based on the number of disks passed.  
   *    
   *  @param disk is the number of disks that should be on the rod.  
   */
   public Rod(int disks){
      count = disks;
      for(int i = 0; i < disks; i++){
         pole.add(count);
         count -= 1;
      }
   }
   /**  
   *  This method sets the size.  
   *    
   *  @return returns and ArrayList of integers representing the pole.  
   */
   public ArrayList<Integer> getRod(){
      return pole;
   }
   
   /**  
   *  This method removes a disk from the end of array rod and return it's representation.  
   *    
   *  @return returns and ArrayList of integers representing the pole.  
   */
   public int getDisk(){
      int size = pole.size() - 1;
      return pole.remove(size);
   }
   /**  
   *  This method adds a disk to the front of the array.  
   *    
   *  @param disk is the disk that should be added.  
   */
   public void addDisk(int disk){
      pole.add(disk);
      
   }
   /**  
   *  Overrides the java default toString method and returns a string representation of the array rod.  
   *    
   *  @return return the string representation of the rod.  
   */
   public String toString(){
      display = "";
      for(int i = 0; i < pole.size(); i++){
         display += pole.get(i);
         display += " "; 
      }    
      return display;   
   }
   
}