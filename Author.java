class Author{
private String name;
private String email;
private char gender;

public Author(String name, String email,char gender)
{
this.name=name;
this.email=email;
this.gender=gender;
}
public String getname(){
return name;}
public String getemail(){
return email;} 
public void setemail(String email)
{ this.email=email;}
public char getgender()
{ return gender;}
public String toString()
{ return "name= "+name+" email="+email+" gender="+gender+"" ;}
}
class Book{
private String name;
private Author author;
private double price;
private int qty;

public Book(String name, Author author,double price){
this.name=name;
this.price= price;
this.author=author;
}
public Book(String name, Author author,double price,int qty){
this.name=name;
this.price= price;
this.author=author;
this.qty=qty;
}
public String getname()
{ return name;}
public Author getAuthor()
{ return author;}
public double getprice()
{ return price;}
public void setprice(double price)
{ this.price=price;}
public int getqty()
{ return qty;}
public void setqty(int qty)
{ this.qty=qty;}
public String toString()
{ return "name= " +name+ "author.toString"+ "price "+price+ " qty="+qty+"";}
}
class testbook
{
public static void main(String[] args)
{

Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
System.out.println(ahTeck);  

Book dummyBook = new Book("Java for dummy", ahTeck, 19.95, 99);  

System.out.println(dummyBook);  

dummyBook.setprice(29.95);
dummyBook.setqty(28);
System.out.println("name is: " + dummyBook.getname());
System.out.println("price is: " + dummyBook.getprice());
System.out.println("qty is: " + dummyBook.getqty());
System.out.println("Author is: " + dummyBook.getAuthor());  

System.out.println("Author's name is: " + dummyBook.getAuthor().getname());
System.out.println("Author's email is: " + dummyBook.getAuthor().getemail());


Book anotherBook = new Book("more Java", 
      new Author("Paul Tan", "paul@somewhere.com", 'm'), 29.95);
System.out.println(anotherBook); 
}
}

