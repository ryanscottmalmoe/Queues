//Ryan Malmoe | Prof: Tom Capaul | CSCD300 12:00
import java.util.*;

public class Queue
{
   private class Node
   {
      private Node next;
      private Object data;
      
      private Node(Object data, Node next)
      {
         this.data = data;
         this.next = next;
      }
   }
   
   private Node tail;
   
   public Queue()
   {
      
      this.tail = null;
   }
   
   public boolean isEmpty()
   {
      return this.tail == null;
   }

   public void enqueue(Object data)
   {
      Node newNode = new Node(data, null);
      if(isEmpty())
      {
         this.tail = newNode;
         this.tail.next = this.tail;
      }
      else
      {
         newNode.next = this.tail.next;
         this.tail.next = newNode;
         this.tail = newNode;
      }
   }
   
   public Object dequeue() throws Exception
   {
      if(isEmpty())
         throw new Exception("dequeue on an empty queue");
      Object data = this.tail.next.data;
      if(this.tail.next == this.tail)
         this.tail = null;
      else
      {
         this.tail.next = this.tail.next.next;
      }
      return data;
   }
   
   public Object peek() throws Exception
   {
      if(isEmpty())
         throw new Exception("cannot peek on an empty queue");
      return this.tail.next.data;
   }
   
}