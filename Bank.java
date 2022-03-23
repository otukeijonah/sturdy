/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import java.util.Scanner;
/**
 *
 * @author Jonah Otukei 2020/ITS/DAY/0285
 */
public class Bank {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    
    void setPin(){
      
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your account");
        System.out.print("S1et your pin:");
        pin=scan.nextInt();
      
        System.out.println("Welcome to " +accountName);

     
        
    }
    void showBalance(){
        System.out.println("Dear Customer, your balance is " +balance);
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
       System.out.println("\n Monthly interest is: " +interest);
       System.out.println("which amounts to " +interest*12);
       System.out.println(" annually");
       }
       else
         System.out.println("Your annual interest is: " +interest); 
       return interest;
    }
    double calculatePenalty(){
        if(option==1||option==3){
      penalty=(penaltyRate*balance);
      System.out.println("Note that if your balance gets below ");
      System.out.print(balance);
      System.out.println("You will be charged a monthly penalty of " +penalty);
      System.out.println(" that accumulates to " +penalty*12);
      System.out.println(" yearly");
        }
      if(option==4){  
         System.out.println("any withdrow made before 12 months is charged");
         System.out.println(" an amount of " +0.2*balance); 
         System.out.println("                          ");
      }    
      return penalty;
    }

    //Constructor for the class creates instances
    //public Bank(){}
    
    
    public static void main(String[] args) {
      
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
        
        System.out.println("Welcome to BANK  XYZ");
        
        System.out.println("Please select your prefered account type");
                  System.out.println("1.Regular Account");
                  System.out.println("2.Interest Account");
                  System.out.println("3.Checking Account");
                  System.out.println("4.CD Account");
                  
                  
                  System.out.print("Enter option for your account type:");
                  option=scn.nextInt();
        //Here we shall test the different cases for the accounts      
        
          switch(option){
              case 1:
                  regularAccount.penaltyRate=0.1;
                  regularAccount.setPin();
                  regularAccount.showBalance();
                  regularAccount.calculateCharge();
                  System.out.println("There is no interest");
                  regularAccount.calculatePenalty();
                 
                  break;
              
              case 2:
                  interestAccount.interestRate=0.07;
                  interestAccount.setPin();
                  interestAccount.showBalance();
                  interestAccount.calculateCharge();
                  interestAccount.calculateInterest();
                  System.out.println("There is no minimum balance required");
                  break;
              case 3:
                  checkingAccount.interestRate=0.07;
                  checkingAccount.penaltyRate=0.1;
                  checkingAccount.setPin();
                  checkingAccount.showBalance();
                  checkingAccount.calculateCharge();
                  checkingAccount.calculatePenalty();
                  checkingAccount.calculateInterest();
                  break;
              case 4:
                  cDAccount.interestRate=0.15;
                  cDAccount.penaltyRate=0.2;
                  cDAccount.setPin();
                  cDAccount.showBalance();
                  cDAccount.calculateCharge();
                  cDAccount.calculateInterest();
                  cDAccount.calculatePenalty();
                  break;
              default:
                  System.out.println("Please enter correct option");
                        }
    }
}


