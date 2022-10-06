public class Main{
   public static void main(String[] args){
      DoublyLinkedList myDLL = new DoublyLinkedList(1);
      myDLL.append(2);
      myDLL.append(20);
      myDLL.remove(2);
      myDLL.printList();    
   }   
}
