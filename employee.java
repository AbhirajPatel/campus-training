class employee
{
private int id;
private String firstname;
private String lastname;
private int salary;

public employee()
{
id=12345;
firstname = "Abhiraj";
lastname = "Patel";
salary = 50000;
}
public int getID()
{ return id;}
public String getfirstname()
{ return firstname;}
public String getlastname()
{ return lastname;}
public String getname()
{ return firstname + lastname;}
public int getsalary()
{ return salary;}
public void setSalary(int salary)
{
this.salary= salary;}
public void raisesalary(int precent)
{
System.out.println("salary is rasied by"+precent);
}
public String toString()
{ return " id="+id+"  name="+firstname+lastname+"  salary="+salary+""; }
public static void main(String[] args)
{
employee e=new employee();
e.setSalary(60000);
System.out.println(e);
}
}
