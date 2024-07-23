import java.io.*;
abstract class Account
{
int account_id;
int customer_id;
abstract double deposit(int account_id,double amount);
abstract double withdraw(int account_id,double amount);
Account(int account_id,int customer_id)
{
this.account_id=account_id;
this.customer_id=customer_id;
}
}

class SavingAccount extends Account
{
double balance;
SavingAccount(int account_id,int customer_id,double balance)
{
super(account_id,customer_id);
this.balance=balance;
System.out.println("Account Number :"+account_id+ " with inital Balance:"+ balance+"Opened Successfully");
}

double deposit(int account_id,double amount)
{
if(this.account_id==account_id)
{
System.out.println("Old Balance:"+balance);
balance=balance + amount;
return balance;
}
else
return -1D;
}

double withdraw(int account_id,double amount)
{
if(this.account_id==account_id)
{
if(balance >= amount)
{
System.out.println("Old Balance:"+balance);
balance=balance-amount;
return balance;
}
else
return -1;
}
else 
return -2;
}
}
class AccountDriver
{
public static void main(String args[])throws IOException
{
int cust_id=100;
int acc_id=1;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int aid;
double balance;
double amount;
int choice;
Double a;
SavingAccount sa=null;
do
{
System.out.println(" 1 Create new Account:");
System.out.println(" 2 Deposit");
System.out.println(" 3.withdraw");
System.out.println(" 4.Exit");
System.out.println("Enter your choice:");
choice=Integer.parseInt(br.readLine());
switch(choice)
{
case 1:
  System.out.println("NEW ACCOUNT");
  System.out.println("Enter an inital balance to create an account:");
  balance=Double.parseDouble(br.readLine());
  sa=new SavingAccount(acc_id,cust_id,balance);
  System.out.println("Your Accountid is:" +acc_id);
  System.out.println("Your Customer_id is:"+cust_id);
  cust_id++;
  acc_id++;
  break;
case 2:
  System.out.println("DEPOSIT");
  System.out.println("Enter Account id:");
  aid=Integer.parseInt(br.readLine());
  System.out.println("Enter amount to deposit:");
  amount=Double.parseDouble(br.readLine());
  a=sa.deposit(aid,amount);
  if(a.equals(-1D))
  System.out.println("Invalid Account:");
  else
  System.out.println("your Current_Balance:"+a); 
  break;
case 3:
  System.out.println("WITHDRAW");
  System.out.println("Enter account_id for transaction");
  aid=Integer.parseInt(br.readLine());
  System.out.println("Enter amount to withdraw:");
  amount=Double.parseDouble(br.readLine());
  a=sa.withdraw(aid,amount);
 if(a.equals(-1D))
 System.out.println("InsufficientBalance");
 else if(a.equals(-2D))
 System.out.println("Invalid Id");
else
  System.out.println("Your balance after withdraw:"+a);;
  break;
case 4:
 System.out.println("Exited!!!!!");
 break;
default:
 System.out.println("Enter valid choice:");
}
}while(choice!=4);
} 
}
  
  



