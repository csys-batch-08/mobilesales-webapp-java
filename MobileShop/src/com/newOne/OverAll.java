package com.newOne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;



public class OverAll {

public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
System.out.println(" Welcome Administrator ");
System.out.println("1.login\nEnter your choice");

int choice=Integer.parseInt(sc.nextLine());
char correct='y';
boolean admin=false;
if(choice==1) {

while(correct=='y') {
String emailId=null;
do {
System.out.println("enter emailId:");
emailId=sc.nextLine();

if(emailId.isEmpty()) {
System.out.println("emsail cant be empty");
}
}while(!emailId.matches("([a-z][a-z0-9}+[@][a-z]+[.][a-z]+)"));
String password=null;
do {
System.out.println("enter password");
password=sc.nextLine();
if(!password.matches("[A-Za-z0-9@#]"))
{
System.out.println("password must include (A-Za-z0-9@#)");
}
if(password.isEmpty())
{
System.out.println("password cant be empty");
}
}while(!password.matches("[A-Za-z0-9@#]"));
//
//Admin user=new Admin(emailId,password);
//AdminDao userDao=new AdminDao();
//admin=userDao.validateAdmin(user);

if(admin!=false) {

System.out.println("Welcome Admin");
System.out.println("\n1.Add new employee\n2.Add new Department\n3.Add new grade"
+ "\n4.Employee grade details\n5.prepare monthly salary\n6.Generate report\nEnter ur choice");
int adminChoice=Integer.parseInt(sc.nextLine());

switch(adminChoice) {

case 1:

System.out.println("enter empId");
int empId=Integer.parseInt(sc.nextLine());
System.out.println("enter empName");
String empName=sc.nextLine();
System.out.println("enter EmpDob");
Date empDob=null;
Date empDoj=null;
try {
empDob=sdf.parse(sc.nextLine());
System.out.println("enter EmpDoj");
empDoj=sdf.parse(sc.nextLine());

}
catch (ParseException e) {

e.printStackTrace();
}
System.out.println("enter empAddress");
String empAddress=sc.nextLine();
System.out.println("enter empCity");
String empCity=sc.nextLine();

System.out.println("enter empPincode");
String empPincode=sc.nextLine();
System.out.println("enter empMobileNo");
Long empMobileNo=Long.parseLong(sc.nextLine());
System.out.println("enter empState");
String empState=sc.nextLine();
System.out.println("enter empEmailId");
String empEmailId=sc.nextLine();
System.out.println("enter panNumber");
Long empPanNo=Long.parseLong(sc.nextLine());

//Employee emp=new Employee(empId,empName,empDob,empDoj,empAddress,empCity,empPincode,empMobileNo, empState,empEmailId,empPanNo);
//EmployeeDao empDao=new EmployeeDao();
//empDao.insertEmp(emp);    
//empDao.validateEmp(empId);
break;
default :
System.out.println("enter the correct choice:");
adminChoice=Integer.parseInt(sc.nextLine());


}

}
else {
System.out.println("re-enter userName and Password:");
System.out.println("Do you want to continue y/n");
correct=sc.nextLine().charAt(0);

}

}


}
else
{

System.out.println("invalid choice");
}
}
}