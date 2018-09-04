package org.itstep;


public class AppRunner {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount("Alex", "Pupkin", "(099)999-99-99", "pupkin@ukr.net", 1000.0, 500.0, 500.0);
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		bankAccountDAO.saveBankAccount(bankAccount);
	}

}
