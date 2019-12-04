import java.util.*;

public class Run
{
  
  public static void main (String[] args)
  { 
    // Task (Name, Arrival, Service Time, Priority)
    Task task1 = new Task("A",0,8,5);
    Task task2 = new Task("B",3,4,3);
    Task task3 = new Task("C",6,4,2);
    Task task4 = new Task("D",8,5,2);
    Task task5 = new Task("E",9,7,4);
    Task task6 = new Task("F",6,5,1);
    Task[] listOfTasks = {task1,task2,task3,task4,task5/*,task6*/};
    /*
    FIFO firstInFirstOut = new FIFO(listOfTasks);
    firstInFirstOut.showOutput();
    
    SJN shortestJobNext = new SJN(listOfTasks);
    shortestJobNext.showOutput();   
    */
    SRT shortestRemaningTime = new SRT(listOfTasks);
    shortestRemaningTime.showOutput();
    /*
    Priority priority = new Priority(listOfTasks);
    priority.showOutput();
    */
  }
}