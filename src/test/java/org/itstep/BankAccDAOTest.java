package org.itstep;
 
import static org.junit.Assert.*;

import javax.persistence.NoResultException;

import org.itstep.BankAccount;
import org.itstep.BankAccountDAO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccDAOTest {
	static BankAccount bankAccount;
	static BankAccountDAO bankAccountDAO = new BankAccountDAO();
	
	@BeforeClass
	public static void setUp() throws Exception {
		bankAccount = new BankAccount("Alex", "Pupkin", "(099)999-99-99", "pupkin@ukr.net", 1000.0, 500.0, 500.0);		
		bankAccountDAO.saveBankAccount(bankAccount);
	}


	@Test
	public void testSaveBankAccount() {
		BankAccount newBankAccount = new BankAccount("Alex1", "Pupkin1", "(098)333-99-99", "pupkin@ukr1.net", 2000.0, 100.0, 100.0);//сохраняем нового пользователя
		bankAccountDAO.saveBankAccount(newBankAccount);
		
		BankAccount result = bankAccountDAO.getBankAccountByFirstNameAndSecondName("Alex1", "Pupkin1");
		
		assertEquals("Alex1", result.getFirstName());
		assertEquals("Pupkin1", result.getSecondName());
		assertEquals("(098)333-99-99", result.getTelephone());
		assertEquals("pupkin@ukr1.net", result.getEmail());
		assertEquals(Double.valueOf(2000.0), result.getCarrency());
		assertEquals(Double.valueOf(100.0), result.getAmount());
		assertEquals(Double.valueOf(100.0), result.getAmountOfCredit());
		
		bankAccountDAO.deleteBankAccount(newBankAccount);
	}
	
	@Test
	public void testUpdateBankAccount() {
		bankAccount.setFirstName("Alex2");
		bankAccount.setSecondName("Pupkin2");
		bankAccount.setTelephone("(098)222-22-22");
		bankAccount.setEmail("pupkin@ukr2.net");
		bankAccount.setCarrency(4000.0);
		bankAccount.setAmount(600.0);
		bankAccount.setAmountOfCredit(600.0);
		
		bankAccountDAO.updateBankAccount(bankAccount);
		
		bankAccount = bankAccountDAO.getBankAccountByFirstNameAndSecondName("Alex2", "Pupkin2");
		
		assertNotNull(bankAccount);
	}	
	
	@Test
	public void testGetBankAccountByFirstNameAndSecondName() {
		BankAccount result = bankAccountDAO.getBankAccountByFirstNameAndSecondName("Alex", "Pupkin");
		
		assertNotNull(result);	
		assertEquals("Alex", result.getFirstName());
		assertEquals("Pupkin", result.getSecondName());
	}
	
	@Test(expected = NoResultException.class)
	public void testDeleteBankAccount() {
		bankAccountDAO.deleteBankAccount(bankAccount);
		bankAccount = null;
		BankAccount result = bankAccountDAO.getBankAccountByFirstNameAndSecondName("Alex2", "Pupkin2");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if (bankAccount != null) {
			bankAccountDAO.deleteBankAccount(bankAccount);
		}
	}
}
