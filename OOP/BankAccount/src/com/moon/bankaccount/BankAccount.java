package com.moon.bankaccount;

public class BankAccount {
	//member var
	private double checkingBalance;
	private double savingsBalance;
//	private long accountNumber;
	
	//static var
	public static int numberOfAccounts = 0;
	public static double totalBalance = 0.0;
	
	//constructor
	//overload to set default
	public BankAccount() {
		this(0.0, 0.0);
	}
	//constructor method
	
	public BankAccount(double checkingBalance, double savingsBalance) {
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
//		this.accountNumber = accountNumber;
		numberOfAccounts ++;
	}
	
	//getter
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	//deposit method
	
	public void makeDeposit(String account, double amount) {
		if (account == "checking") {
			this.checkingBalance += amount;
			totalBalance += amount;
			System.out.printf("Your have deposited %s to the checkings account", amount);
		}
		else if (account == "saving") {
			this.savingsBalance += amount;
			totalBalance += amount;
			System.out.printf("Your have deposited %s to the savings account", amount);
		}
	}
	//withdrawal method
	
	public void makeWithdrawal(String account, double amount) {
		if (account == "checking") {
			if(this.checkingBalance <= 0.0) {
				System.out.println("Insufficient funds in the checkings account!");
			}
			else {
				this.checkingBalance -= amount;
				totalBalance -= amount;
				System.out.printf("Your have withdrawed $ %s from the checkings account", amount);
			}
		}
			
		else if (account == "saving") {
			if(this.savingsBalance <= 0.0) {
				System.out.println("Insufficient funds in the savings account!");
			}
			else {
				this.savingsBalance -= amount;
				totalBalance -= amount;
				System.out.printf("Your have withdrawed %s from the savings account", amount);
			}
			
		}
	}
	
	//see total balance
	public void displayTotalBalance() {

		System.out.printf("Your total balance is %s", totalBalance);
	}
	
}
