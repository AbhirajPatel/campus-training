class circle{

private double radius;
private String color;
private double area;

public circle()
{
radius=1.0;
color="red";
}
public circle(double b)
{
radius=b;
color="red";
}
public double getRadius()
{ return radius;}
public double getArea()
{ return radius*radius*Math.PI;}
public void setRadius( double r)
{ radius=r;}
public void setColor(String b)
{
color = b;
}
public String toString() {
   return "Circle[radius=" + radius + " color=" + color + "]";
}
public static void main(String[] args)
{
circle c=new circle();
System.out.println(c);
}

}
class testCircle{
public static void main(String[] args)
{

circle c=new circle(2.0);

System.out.println(c.getArea());
}
}
