import java.util.*;

public class P02Driver
{
  public static void main(String[] args)
  {
    System.out.println("Creating the list...");
    CM307ArrayList<String> list1=new CM307ArrayList<String>();

    System.out.println("Size of list is "+list1.size());
    System.out.println("isEmpty() returns "+list1.isEmpty());
    System.out.println("Adding strings to list...");
    list1.add("Leela");
    list1.add("Hermes");
    list1.add("Zoidberg");
    list1.add("Bender");
    list1.add("Fry");
    list1.add("Scratchy");
    list1.add("Itchy");
    list1.add("Bart");
    list1.add("Lisa");
    list1.add("Homer");

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.println("Size of list is "+list1.size());
    System.out.println("isEmpty() returns "+list1.isEmpty());

    System.out.println("Getting first element...");
    System.out.println("Got "+list1.get(0));

    System.out.println("Getting element at position 5...");
    System.out.println("Got "+list1.get(5));

    System.out.println("Getting last element...");
    System.out.println("Got "+list1.get(list1.size()-1));

    System.out.println("Getting element at position -1...");
    System.out.println("Got "+list1.get(-1));

    System.out.println("Getting element at position "+list1.size()+"...");
    System.out.println("Got "+list1.get(list1.size()));

    System.out.println("Removing element at position 0...");
    System.out.println("Removed "+list1.remove(0));

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.println("Removing last element...");
    System.out.println("Removed "+list1.remove(list1.size()-1));

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.println("Removing element at position 5...");
    System.out.println("Removed "+list1.remove(5));

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.println("Removing element at -1...");
    System.out.println("Removed "+list1.remove(-1));

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.println("Removing element at "+list1.size()+"...");
    System.out.println("Removed "+list1.remove(list1.size()));

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.print("inserting \"Kyle\" at position 0...");
    if(list1.insert(0,"Kyle")) System.out.println("success");
    else System.out.println("failed");

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.print("inserting \"Stan\" at position 3...");
    if(list1.insert(3,"Stan")) System.out.println("success");
    else System.out.println("failed");

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.print("inserting \"Cartman\" at position "+list1.size()+"...");
    if(list1.insert(list1.size(),"Cartman")) System.out.println("success");
    else System.out.println("failed");

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.print("inserting \"Kenny\" at position -1...");
    if(list1.insert(-1,"Kenny")) System.out.println("success");
    else System.out.println("failed");

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.print("inserting \"Chef\" at position "+(list1.size()+1)+"...");
    if(list1.insert(list1.size()+1,"Chef")) System.out.println("success");
    else System.out.println("failed");

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");
 
    System.out.println("Removing element at position 5...");
    System.out.println("Removed "+list1.remove(5));

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.print("inserting \"Snowball\" at position 3...");
    if(list1.insert(3,"Snowball")) System.out.println("success");
    else System.out.println("failed");

    System.out.println("----------------");
    System.out.println(list1);
    System.out.println("----------------");

    System.out.println("Getting element at position 7...");
    System.out.println("Got "+list1.get(7));
  }
}
