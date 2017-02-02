class Shape{
	private String color;
	private  boolean filled;

	public Shape()
	{
		color="red";
		filled=true;
	}
	public Shape(String color,boolean filled)
	{
		this.color=color;
		this.filled=filled;
	}
	public void setColor(String color)
	{ this.color=color;}
	public String getColor()
	{ return color;}
	public boolean isFilled()
	{ return filled;}
	public void setFilled(boolean filled)
	{ this.filled=filled;}
	public String toString()
	{ return "color="+color+",filled="+filled+"";}
}
class Circle extends Shape{
	private double radius;

	public Circle()
	{ radius=1.0;}
	public Circle(double radius)
	{ this.radius=radius;}
	public Circle(double radius, String color,boolean filled)
    {
    super(color,filled); 
   	this.radius=radius;
    }
    public double getRadius()
    { return radius;}
    public void setRadius(double radius)
    { this.radius=radius;}
    public double getArea()
    { return radius*radius*Math.PI;}
    public double getPerimeter()
    { return 2*radius*Math.PI;}
    public String toString()
    { return "radius="+radius+""+super.toString()+"";}
}
class Rectangle extends Shape{
	private double width;
	private double length;

	public Rectangle()
	{
	width=1.0;
	length=1.0; 
	}
	public Rectangle(double width,double lenght)
	{
		this.width=width;
		this.length=length;
	}
	public Rectangle(double width,double lenght, String color,boolean filled)
    {
    	super(color,filled);
    	this.width=width;
    	this.length=length;
    }
    public double getWidth()
    { return width;}
    public void setWidth(double width)
    { this.width=width;}
    public double getLength()
    { return length;}
    public void setLength(double length)
    { this.length=length;}
    public double getPerimeter()
    { return 2*(length+width);}
    public double getArea()
    { return length*width;}
    public String toString()
    { return "Rectangle[width="+width+",height"+length+","+super.toString()+"";}
}
class Square extends Rectangle{
	public Square()
	{ super();}
	public void setSide(double side)
	{
		setLength(side);
		setWidth(side);

	}
	public Square(double side,String color,boolean filled)
	{
		super(side,side,color,filled);
	}
	public double getSide()
	{ return getLength();}
	public String toString()
	{ return ""+super.toString()+"";}
	
}
class testshape{
	public static void  main(String[] args) {
		Shape s=new Shape();
		Circle c=new Circle();
		Rectangle r=new Rectangle();
		Square sq=new Square();
		System.out.println(s);
	    System.out.println(c);
	  	System.out.println(r);
	  	System.out.println(sq);
	}
}
