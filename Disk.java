/*
 * Disk.java
 *
 * TCSS 142 – Spring 2016
 * Programming Assignment 3  
*/


/**  
 *  This program deefines and constucts an object Disk. 
 * 
 *  @author Yaro Salo 
 *  @version 25th May 2016  
*/
public class Disk{
   /**
    *Store the number of disks
    */
   private int size;
   
   /**  
   *  Constructor method that constructs a Disk based on the size that passed.  
   *    
   *  @param size is the size of the biggest disk to be constructed.  
   */
   public Disk(int size){
      this.size = size;
   }
   
   /**  
   *  This method sets the size.  
   *    
   *  @param size is the size.  
   */   
   public void setSize(int size){
      this.size = size;
   }
   
   /**  
   *  This method return the size.  
   *    
   *  @return returns the size.  
   */
   public int getSize(){
      return size;
   }
}