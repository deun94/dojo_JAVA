package com.moon.bankaccount;

public class TestBankAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		
		account1.makeDeposit("checking", 100);
		account1.makeDeposit("saving", 700);
		account1.makeDeposit("checking", 200);
		
		account2.makeDeposit("checking", 300);
		account2.makeDeposit("saving", 2000);
		
		account1.makeWithdrawal("saving", 100);
		
		System.out.println(BankAccount.numberOfAccounts);
//		System.out.println(account1.displayTotalBalance());

	}

}
