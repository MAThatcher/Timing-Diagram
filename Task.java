import java.util.*;
public class Task
{
  private String name;
  private int arrival;
  private int serviceTime;
  private int externalPriority;
  private int serviceTimeRemaning;
  
  // Constructor
  public Task (String inName, int inArrival, int inServiceTime, int inExternalPriority)
  {
    name = inName;
    arrival = inArrival;
    serviceTime = inServiceTime;
    externalPriority = inExternalPriority;
    serviceTimeRemaning = serviceTime;
  }
  
  //getters and setters
  public void setName(String inName)
  {
    name = inName;
  }
  public void setArrival(int inArrival)
  {
    arrival = inArrival;
  }
  public void setServiceTime(int inServiceTime)
  {
    serviceTime = inServiceTime;
  }
  public void setExternalPriority(int inExternalPriority)
  {
    externalPriority = inExternalPriority;
  }
  public void setServiceTimeRemaning(int inServiceTimeRemaning)
  {
    serviceTimeRemaning = inServiceTimeRemaning;
  }
  public String getName()
  {
    return name;
  }
  public int getArrival()
  {
    return arrival;
  }
  public int getServiceTime()
  {
    return serviceTime;
  }
  public int getExternalPriority()
  {
    return externalPriority;
  }
  public int getServiceTimeRemaning()
  {
    return serviceTimeRemaning;
  }
  
  public void processRan()
  {
    serviceTimeRemaning--;
  }
  
  // Function to display contents of class
  public void stringOut ()
  {
    System.out.println ("Name: " + name);
    System.out.println ("Arrival: " + String.valueOf(arrival));
    System.out.println ("Service Time: " + String.valueOf(serviceTime));
    System.out.println ("External Priority: " + String.valueOf(externalPriority));
  }   
  
}