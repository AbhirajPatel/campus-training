import java.lang.*;

class  mycomplex{
	private double real;
	private double imag;

	public mycomplex()
	{
		this.real=0.0;
		this.imag=0.0;
	}
	public mycomplex(double real,double imag)
	{
		this.real=real;
		this.imag=image;
	}
	public double getReal()
	{return real;}
	public double getImag()
	{return imag;}
	public void setReal(double real)
	{
		this.real=real;
	}
	public void setImag(double imag)
	{
		this.imag=imag;
	}
	public void setValue(double real,double imag)
	{
		this.real=real;
		this.imag=imag;
	}
	public String toString()
	{
        return "("+rela+" + i"+imag+")";}
	}
	public boolean isReal()
	{
		if(this.imag==0)
			return true;
		else 
			return false;
	}
	public boolean isImaginary()
	{
		if(this.real==0)
			return true;
		else 
			return false;
	}
	public boolean equals(double real,double imag)
	{
		if(this.real==real && this.imag==imag)
			return true;
		else
			return false;
	}
	public boolean equals(mycomplex another)
	{
		if(this.real==another.real && this.imag==another.imag)
			return true;
		else
			return false;
	}
	public double magnitude()
	{
		return Math.sqrt(real*real + imag*imag);
	}
	public mycomplex add(mycomplex right)
	{
		this.real=this.real + right.real;
		this.imag=this.imag + right.imag;
		return this;

	}
	public mycomplex addNew(mycomplex right)
	{
		this.real=this.real + right.real;
		this.imag=this.imag + right.imag;
		return this;

	}
	public mycomplex subtract(mycomplex right)
	{
		this.real=this.real + right.real;
		this.imag=this.imag + right.imag;
		return this;

	}
	public mycomplex subtractNew(mycomplex right)
	{
		this.real=this.real + right.real;
		this.imag=this.imag + right.imag;
		return this;

	}
	public mycomplex multyply(mycomplex right)
	{
		this.real=this.real*right.real - this.imag*right.imag;
		this.imag=this.imag*right.real + this.real*right.imag;
		return this;

	}
	public mycompex divide(mycomplex right)
	{
		int a;
		a=Math.sqrt(right.real*right.real + right.imag*right.imag);
		right.real=right.real/a;
		right.imag=-(right.imag/a);
		this.real=this.real*right.real - this.imag*right.imag;
		this.imag=this.imag*right.real + this.real*right.imag;
		return this;
	}
    public mycomplex conjugate()
    {
    	this.imag=-this.imag;
    	return this;
    }
    public static void main(String[] args)
    {
    	System.out.println("yes");
    }



}