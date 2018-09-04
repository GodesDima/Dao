 package org.itstep;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class BankAccountDAO {

	private Session session;

	public void saveBankAccount(BankAccount bankAccount) {//метод который сохраняет объект типа БанкАккаунт в БД
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(bankAccount);
		session.getTransaction().commit();
		session.close();
	}

	public void updateBankAccount(BankAccount bankAccount) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.update(bankAccount);
		session.getTransaction().commit();
		session.close();
	}

	public BankAccount getBankAccount(Long id) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		BankAccount bankAccount = session.get(BankAccount.class, id);
		session.getTransaction().commit();
		session.close();
		return bankAccount;
	}

	public void deleteBankAccount(BankAccount bankAccount) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.delete(bankAccount);
		session.getTransaction().commit();
		session.close();
	}
	
	public BankAccount getBankAccountByFirstNameAndSecondName(String firstName, String secondName) {//находит объект из БД и возвращает
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createNativeQuery("SELECT * FROM bank_account WHERE first_name=:first_name AND second_name=:second_name", BankAccount.class);
		query.setParameter("first_name", firstName);
		query.setParameter("second_name", secondName);
	
		BankAccount bankAccount = (BankAccount) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return bankAccount;
	}
	
	public List<BankAccount> getBankAccountByTelephone(String telephone) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createNativeQuery("SELECT * FROM bank_account WHERE telephone=:telephone", BankAccount.class);
		query.setParameter("telephone", telephone);
		List<BankAccount> bankAccounts = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return bankAccounts;
	}

	public List<BankAccount> getStudentToSecondName(String email) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createNativeQuery("SELECT * FROM student WHERE email=:email", BankAccount.class);
		query.setParameter("email", email);
		List<BankAccount> bankAccounts = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return bankAccounts;
	}

}
