class mytraingle{
private mypoint v1;
private mypoint v2;
private mypoint v3;

public mytraingle(int x1,int y1, int x2,int y2,int x3,int y3)
{
this.v1.setX(x1);
this.v1.setY(y1);
this.v2.setX(x2);
this.v2.setY(y2);
this.v3.setX(x3);
this.v3.setY(y3);
}
public mytraingle(mypoint v1,mypoint v2,mypoint v3){
this.v1 = new mypoint();
this.v1.setXY(v1.getX(),v1.getY());
this.v2 = new mypoint();
this.v2.setXY(v2.getX(),v2.getY());
this.v3 = new mypoint();
this.v3.setXY(v3.getX(),v3.getY());
}
public String toString()
{//return "Hari";
return "mytraingle[v1=("+v1.getX()+","+v1.getY()+"),v2=("+v2.getX()+","+v2.getY()+"),v3=("+v3.getX()+","+v3.getY()+")]";
}
public double getperimeter()
{
return v1.distance(v2)+v2.distance(v3)+v3.distance(v1);}
public String gettype()
{
if(v1.distance(v2)==v2.distance(v3) && v2.distance(v3)==v3.distance(v1))
return "Equilateral";
else if(v1.distance(v2)==v2.distance(v3) || v2.distance(v3)==v3.distance(v1)) 
return "isosceles";
else 
return "Scalene";
}
public static void main(String[] args)
{
mypoint v1=new mypoint(0,4);
System.out.println(v1);
mypoint v2=new mypoint(4,0);
mypoint v3=new mypoint();
mytraingle t=new mytraingle(v1,v2,v3);
System.out.println(t);
System.out.println(t.getperimeter());
System.out.println(t.gettype());
}
}
