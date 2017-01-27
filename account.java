class account{
private String id;
private String name;
private int balance;

 public account()
{ id= "Abh33156776774";
  name= "Abhiraj";
  balance= 8000;
}
 public account(String name, String id,int balance)
{
this.id= id;
this.name= name;
this.balance= balance;
}
public String getid()
{ return id;}
public String getname()
{ return name;}
public int getbalance()
{ return balance;}
public int credit(int amount)
{ balance += amount;
return balance; }
public int debit(int amount)
{ 
 if(amount < balance)
  balance  -= balance-amount;
 else
 System.out.println("Amount Exceed balance");

return balance; }
public int transfer(account another, int amount)
{
System.out.println("amount to be transfer="+amount+"   "+ balance);
if(amount < balance)
{ 
  balance = balance-amount;
  another.credit(amount);
}
else
System.out.println("Amount Exceed balance");

return balance;
}
public String toString()
{
return "id="+id+" name=" + name+ " balance=" +balance+"";
}
public static void main(String[] args)
{
account abhi= new account();
account another= new account("unknown","SBI33156776774",2000);
System.out.println(abhi);
System.out.println(another);
abhi.transfer(another, 4000);
System.out.println("after transfering");
System.out.println(abhi);
System.out.println(another);
}
}

