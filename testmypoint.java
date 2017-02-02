class testmypoint
{
public static void main(String[] args)
{
mypoint p1=new mypoint(3,4);
System.out.println(p1.distance(5, 6));
mypoint p2 = new mypoint(5, 6);
System.out.println(p1.distance(p2));
}
}
