package org.itstep;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bank_account")
public class BankAccount {

	@Id
	@Column(name="id")
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="second_name")
	private String secondName;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="carrency")
	private Double carrency;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="amount_of_credit")
	private Double amountOfCredit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getCarrency() {
		return carrency;
	}
	public void setCarrency(Double carrency) {
		this.carrency = carrency;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getAmountOfCredit() {
		return amountOfCredit;
	}
	public void setAmountOfCredit(Double amountOfCredit) {
		this.amountOfCredit = amountOfCredit;
	}
	public BankAccount(String firstName, String secondName, String telephone, String email, Double carrency, Double amount, Double amountOfCredit) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.telephone = telephone;
		this.email = email;
		this.carrency = carrency;
		this.amount = amount;
		this.amountOfCredit = amountOfCredit;
	}
	
	public BankAccount() {
		super();
	}
}
