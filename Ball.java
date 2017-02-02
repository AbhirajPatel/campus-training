class Ball{
	private float x;
	private float y;
	private float xDelta;
	private float yDelta;
	private int radius;

	public Ball(float x,float y,int radius,int speed,float direction){
     this.x=x;
     this.y=y;
     this.radius=radius;
     xDelta=(float)(speed*(Math.cos(direction)));
     yDelta=-(float)(speed*(Math.sin(direction)));
	}
	public float getX()
	{ return x;}
	public void setX(float x)
	{ this.x=x;}
	public float getY()
	{ return y;}
	public void setY(float y)
	{ this.y=y;}
	public int getRadius()
	{ return radius;}
	public float getXDelta()
	{ return xDelta;}
	public void setXDelta(float xDelta)
	{this.xDelta=xDelta;}
	public float getYDelta()
	{ return yDelta;}
	public void setYDelta(float yDelta)
	{this.yDelta=yDelta;}
	public void move()
	{
		x+=xDelta;
		y+=yDelta;
	}
	public void reflectionHorizontal()
	{xDelta=-xDelta;}
	public void reflectionVertical()
	{yDelta=-yDelta;}
	public String toString()
	{ return "Ball[("+x+","+y+"),speed=("+xDelta+","+xDelta+")]";}

}
class Container {
private int x1;
private int y1;
private int x2;
private int y2;

public Container(int x,int y,int width,int height)
{
  x1=x;
  y1=y;
  x2=x1+width-1;
  y2=y2+height-1;
}
public int getX()
{ return x1;}
public int getY()
{ return y1;}
public int getWidth()
{ return x2-x1;}
public int getHeight()
{ return y2-y1;}
public String toString()
{
	return "Container[("+x1+","+y1+"),("+x2+","+y2+")]";
}
public boolean collides(Ball ball)
{
	if (ball.getX() - ball.getRadius() <= this.x1 ||
       ball.getX() - ball.getRadius() >= this.x2) {
      ball.reflectionHorizontal();
      return true;
  }
  else return false;
}
public static void main(String[] args)
{
	Ball ball = new Ball(50, 50, 5, 10, 30);
Container box = new Container(0, 0, 100, 100);
for (int step = 0; step < 100; ++step) {
   ball.move();
   box.collides(ball);
   System.out.println(ball);
}
}
	
}

