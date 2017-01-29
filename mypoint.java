class mypoint{
private int x;
private int y;
public mypoint(int x,int y)
{
this.x=x;
this.y=y;
}
public mypoint(){
this.x=0;
this.y=0; }
public int getX(){
return x;}
public void setX(int x){
this.x=x;}
public int getY(){
return y;}
public void setY(int Y){
this.y=y;}
//---return 2 array;
public void setXY(int x,int y){
this.x=x;
this.y=y;}
public String toString()
{ return ""+x+"  ,   "+y+""; }
public double distance(int a,int b)
{ return Math.sqrt((x-a)*(x-a) + (y-b)*(y-b));}
public double distance(mypoint another)
{ return Math.sqrt((x-another.getX())*(x-another.getX()) +(y-another.getY())*(y-another.getY()));}
public double distance(){
return Math.sqrt(x*x + y*y); }
}

