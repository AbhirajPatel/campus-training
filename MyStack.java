import java.util.Scanner;
class MyIntStack {
   private int[] contents;
   private int tos;    

   public MyIntStack(int capacity) {
      contents = new int[capacity];
      tos = 0;
   }
 
   public boolean push(int element) {
      if(this.isFull())
         { System.out.println("stack is full");
          return false;}
      else
      {contents[tos++] = element;
         return true;}
   }
 
   public int pop() {
      return contents[--tos];
   }
 
   public int peek() {
      return contents[tos];
   }
 
   public boolean isEmpty() {
      return tos <= 0;
   }
 
   public boolean isFull() {
      return tos == contents.length;
   }
   public static void main(String[] args) {
      int n;
      Scanner in=new Scanner(System.in);
      System.out.println("enter the size of stack");
      n=in.nextInt();
      MyIntStack my=new MyIntStack(n);
      
      int a;
      //my.push(3);
      while(!my.isFull())
      {
         a=in.nextInt();
         my.push(a);
      }
      while(!my.isEmpty())
      {
         System.out.println(my.pop());

      }

      
   }
}

