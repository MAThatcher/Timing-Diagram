import java.util.*;
public class SRT{
  private Task[] tasks;
  private int time = 0;
  private String[][] output;
  
  //our constructor
  public SRT (Task[] ourProcesses){
    tasks = ourProcesses;

    // How long is our graph going to be
    for (int i = 0; i < tasks.length; i++){
      time += tasks[i].getServiceTime();
    }
    
    // create output with the proper dimentions
    // output[Y][X]
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

    for (int i = 1 ; i < output[0].length ; i++){
      int k = 0;
      for (int indexK = 0 ; indexK < tasks.length ; indexK++){  
        if (tasks[indexK].getServiceTimeRemaning() > tasks[k].getServiceTimeRemaning()){
          k = indexK;
        }
      }
      
      //  this for loop determines who will be processed next.
      // ie, who has shortest remaning time of all tasks. Also must have arrived
      for (int indexK = 0 ; indexK < tasks.length ; indexK++){          
        if (tasks[indexK].getArrival() <= i-1 && tasks[indexK].getServiceTimeRemaning() < tasks[k].getServiceTimeRemaning() && tasks[indexK].getServiceTimeRemaning() != 0){
          k = indexK;
        }
        else if (tasks[indexK].getArrival() <= i-1 && tasks[indexK].getServiceTimeRemaning() == tasks[k].getServiceTimeRemaning() && tasks[indexK].getServiceTimeRemaning() != 0){
          if (tasks[indexK].getExternalPriority() < tasks[k].getExternalPriority()){
            k = indexK;
          }
        }
      }
      for (int j = 0 ; j < output.length ; j++){
        if (tasks[k].getServiceTimeRemaning() != 0 && tasks[k].getName() == output[j][0]){
          output[j][i] = "X";
          tasks[k].processRan();
          if (tasks[k].getServiceTimeRemaning() == 0){
            output[j][i] = String.valueOf(i);
          }
        }        
      }
    }
    for (int i = 0 ; i < tasks.length ; i++){
      tasks[i].setServiceTimeRemaning(tasks[i].getServiceTime());
    }
  }
  

  
  public void showOutput()
  {
    System.out.println("SHORTEST REMANING TIME");
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