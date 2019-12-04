/*
 * TODO:
 * Order by Priority breaks into an infinite loop 
 * if EVERY SINGLE TASK arrives AT THE EXACT SAME TIME
 * Order by Priority works correctly if at least one arrives at a different time
 */

import java.util.*;
public class FIFO{
  private Task[] tasks;
  private int time = 0;
  private String[][] output;
  private Queue<Task> order = new LinkedList<Task>();
  
  //our constructor
  public FIFO (Task[] ourProcesses){
    tasks = ourProcesses;

    // How long is the total run time of all tasks. 
    for (int i = 0; i < tasks.length; i++){
      time += tasks[i].getServiceTime();
    }
    
    // create output with the proper dimentions
    // output[Y-axis][X-axis]
    
    output = new String[tasks.length][ time +1];
    
    //format our output
    for(int i = 0 ; i < output.length ; i++){
      for (int j = 0 ; j < output[i].length ; j++){
        output[i][j] = " ";
      }
    }
    for(int i = 0 ; i < tasks.length ; i++){
      output[i][0] = tasks[i].getName();
    }
    //output formatting done
    
    
    
    //Set up queue and order by arrival time. Ignoring priority
    for (int i = 0 ; i < output[0].length ; i++){
      for (int j = 0 ; j < tasks.length ; j++){
        if (tasks[j].getArrival() == i){
          order.add(tasks[j]);
        }
      }
    } 
    
    // orders our queue by priority should any two or more tasks arrive at the same time
    // !!Works on the condition that not EVERY task arrives AT THE SAME TIME!!
    Boolean change = true;
    while (change == true){
      change = false;
      for (int i = 0 ; i < order.size() ; i++){
        Task temp = order.remove();
        if (temp.getArrival() == order.peek().getArrival()){
          if (temp.getExternalPriority() > order.peek().getExternalPriority()){
            //System.out.println("Swapping:" + temp.getName() + " and " + order.peek().getName());
            order.add(order.remove());
            order.add(temp);
            change = true;
            i++;
          }
          else{
              order.add(temp);
          }
        }
        else{
          order.add(temp);
        }
      }
    }
    
    
    // Run through queue and Fill our output
    for (int i = 1 ; i < output[0].length ; i++){ //increment along X-Axis  
      for (int j = 0 ; j < output.length ; j++){ // look at each Y-Axis        
        if (order.peek().getServiceTimeRemaning() != 0 && order.peek().getName() == output[j][0]){
          output[j][i] = "X";
          order.peek().processRan();
        }
        if (order.peek().getServiceTimeRemaning() == 0 && order.peek().getName() == output[j][0]){
          output[j][i] = String.valueOf(i);
          order.remove();
          j = output.length +1;
        }
      }     
    }
    
    for (int i = 0 ; i < tasks.length ; i++){
      tasks[i].setServiceTimeRemaning(tasks[i].getServiceTime());
    }    
  }

  public void showOutput()
  {
    System.out.println("FIRST IN FIRST OUT");
    for(int i = output.length -1 ; i >= 0; i--)
    {
      for (int j = 0 ; j < output[i].length ; j++)
      {
        System.out.print(output[i][j] + " ");
      }
      System.out.println("");
    }
  }
  
}