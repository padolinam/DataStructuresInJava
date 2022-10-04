public class LinkedList {
   private Node head, tail;
   private int length;
   
   //interclass || nested class
   class Node {  
      int value;
      Node next;
   
      Node(int value){
         this.value = value;   
      }
   }
   
   //LinkedList constructor
   public LinkedList(int value){
      Node newNode = new Node(value);
      head = newNode;
      tail = newNode;
      length = 1;
   }
   
   //prints the LinkedList   
   public void printList(){
      Node temp = head;
      while (temp != null){
         System.out.println(temp.value);
         temp = temp.next;
      }
   }
   
   //helper methods
   public void getHead(){
      System.out.println("Head: " + head.value);
   }
   public void getTail(){
      System.out.println("Tail: " + tail.value);
   }
   public void getLength(){
      System.out.println("Length: " + length);
   }
   
   //adds item to the end of the list
   public void append(int value){
      Node newNode = new Node(value);
    
      if(length == 0) {
         head = newNode;
         tail = newNode;
      } else {
         tail.next = newNode;
         tail = newNode;
      }
      length++;
      
   }// end of append
   
   //removes item from the end of the list
   public Node removeLast(){
      if(length == 0) return null;
      Node temp = head;
      Node pre = head;
      
      while(temp.next != null){
         pre = temp;
         temp = temp.next;
      }
      tail = pre;
      tail.next = null;
      length--; 
      
      if(length == 0){
         head = null;
         tail = null;
      }
      
      return temp;
   }// end of remove last
   
   //adds item to the beginning of the list
   public void prepend(int value) {
      Node newNode = new Node(value);
      if(length == 0){
         head = newNode;
         tail = newNode;
      } else {
         newNode.next = head;
         head = newNode;
      }
      length++;
   }//end of prepend
   
   //removes the first item
   public Node removeFirst(){
      if(length==0){
         return null;
      }
      
      Node temp = head;
      head = head.next;
      temp.next = null;
      length--;
      
      if(length==0){
         tail = null;
      }
      return temp;
   } 
   
   //gets a Node at a particular index
   public Node get(int index){
      if(index < 0 || index >= length){
         return null;
      }
      Node temp = head;
      for(int i = 0; i < index; i++){
         temp = temp.next;
      }
      return temp;
   }
   
   //sets the value of a Node at a particular index
   public boolean set(int index, int value){
      Node temp = get(index);
      if (temp != null){
         temp.value = value;
         return true;
      }
      return false;
   }
   
   //insert a value at a particular index
   public boolean insert(int index, int value){
      if(index < 0 || index > length) return false;
      if(index == 0){
         prepend(value);
         return true;
      }
      if(index == length){
         append(value);
         return true;
      }
      Node newNode = new Node(value);
      Node temp = get(index - 1);
      newNode.next = temp.next;
      temp.next = newNode;
      length++;
      return true;
   }
   
   //removes a value from a specific index
   public Node remove(int index){
      if(index < 0 || index >= length) return null;
      if(index == 0) return removeFirst();
      if(index == length-1) return removeLast();
      
      Node prev = get(index-1);
      Node temp = prev.next;
      prev.next = temp.next;
      temp.next = null;
      length--;
      return temp;
   }
   
   //reverse the linked list
   public void reverse(){
      Node temp = head;
      head = tail;
      tail = temp;
      Node after = temp.next;
      Node before = null;
      
      for(int i = 0; i < length; i++){
         after = temp.next;
         temp.next = before;
         before = temp;
         temp = after;
      }
   }
   
}
