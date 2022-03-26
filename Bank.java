/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.activity;

import java.util.Scanner;
/**
 *
 * @author Jonah Otukei 2020/ITS/DAY/0285
 */
public class Bank {
        double balance;
    double monthlyCharge;
    double annualCharge;
    double interest;
    double penalty;
    double chargeRate;
    double interestRate;
    double penaltyRate;
    int pin;
    public static int option;
    public String accountName;
    
    void setPin(){ //good practice
      
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your account");
        System.out.println("Please set your pin:");
        pin=scan.nextInt();
      
        System.out.println("Welcome to " +accountName);
     
        
    }
    void showBalance(){
        System.out.println("Dear Customer, your current balance is " +balance);
       }
    double calculateCharge(){
    monthlyCharge=0.1*balance;
    annualCharge=monthlyCharge*12;
    System.out.println("Monthly charges: " +monthlyCharge);
    System.out.println("Annual charges: " +annualCharge);
    return annualCharge;  
    }
    double calculateInterest(){
       interest=(interestRate*balance);
       if(interestRate==0.07){
       System.out.println("\nMonthly interest is: " +interest);
       System.out.print("which accumulates to " +interest*12);
       System.out.print(" yearly");
       }
       else
         System.out.println("Your annual interest is: " +interest); 
       return interest;
    }
    double calculatePenalty(){
        if(option==1||option==3){
      penalty=(penaltyRate*balance);
      System.out.println("If your balance falls below ");
      System.out.print(balance);
      System.out.print(" You will be charged a monthly penalty of " +penalty);
      System.out.print(" that amounts to " +penalty*12);
      System.out.print(" annually");
        }
      if(option==4){  
         System.out.println("Any withdrow made before 12 months is");
         System.out.print(" charged an amount of " +0.2*balance); 
         System.out.print("                          ");
      }    
      return penalty;
    }
        //Constructor for the class. It creates instances
    //public Bank(){}
    
    
    public static void main(String[] args){
      
        //We shall create 4 objects to utilize the methods of the main class
        Bank regularAccount=new Bank();
        Bank interestAccount=new Bank();
        Bank checkingAccount=new Bank();
        Bank cDAccount=new Bank();
    
        Scanner scn=new Scanner(System.in);
        
        
        //Let's initialise values for the different instances of the main class
        
        regularAccount.accountName="RegularAccount";
        interestAccount.accountName="InterestAccount";
        checkingAccount.accountName="CheckingAccount";
        cDAccount.accountName="CDAccount";
        
        //We are setting account balances randomly to default to match the cases in the question
        regularAccount.balance=50000.00;
        interestAccount.balance=120000.00;
        checkingAccount.balance=10000.00;
        cDAccount.balance=70000.00;
        

        System.out.println("Welcome to BANK XYZ");
        
        System.out.println("Please select your account type");
                  System.out.println("1.Regular Account");
                  System.out.println("2.Interest Account");
                  System.out.println("3.Checking Account");
                  System.out.println("4.CD Account");
                 
                  
                  System.out.println("Enter option for your account:");
                  option=scn.nextInt();
        //Here we shall test the different cases for the accounts      
        
          switch (option){
              case 1:
             
                  regularAccount.setPin();
                  regularAccount.showBalance();
                  regularAccount.calculateCharge();
                  regularAccount.calculatePenalty();
                  System.out.println("This account is chargd a fee of 10% par month");
                  System.out.println("This account does no have any interest");
                  System.out.println("There is a penalty of 10.00 if 11the balance falls below a minimum of 50000.00");
                  break;
              
              case 2:
               
                  interestAccount.setPin();
                  interestAccount.showBalance();
                  interestAccount.calculateCharge();
                  interestAccount.calculateInterest();
                  System.out.println("This account is chargd a fee of 10% par month");
                  System.out.println("This account has 7% monthly interest");
                  System.out.println("There is no minimum balance required");
                  break;
              case 3:
                 
                  checkingAccount.setPin();
                  checkingAccount.showBalance();
                  checkingAccount.calculateCharge();
                  checkingAccount.calculatePenalty();
                  checkingAccount.calculateInterest();
                   System.out.println("This account is chargd a fee of 10% par month");
                  System.out.println("This account has 7% monthly interest");
                  System.out.println("There is a penalty of 10.00 if the balance falls below a minimum of 10000.00");
                  System.out.println("A charge of 0.10 for each transaction");
                  
                  break;
              case 4: 
                  
                  cDAccount.setPin(); //nice 
                  cDAccount.showBalance();
                  cDAccount.calculateCharge();
                  cDAccount.calculateInterest();
                  cDAccount.calculatePenalty();
                  System.out.println("This account is chargd a fee of 10% par month");
                  System.out.println("This account has 15% interest paid yearly");
                  System.out.println("A penalty of 10.00 if the balance falls below a minimum of 10000.00.");
                  System.out.println("There is no minimum balance required");
                  break;
              default:
                  System.out.println("Please enter correct option");
                        }
    }
    
}
