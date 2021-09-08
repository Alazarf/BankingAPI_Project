package dev.alazar.models;

import org.apache.log4j.Logger;

public class Account {

	static final Logger log = Logger.getLogger(Account.class);

	int id;
	int clientId;
	int balance;
	int amount;
	boolean checkingAccount;
	boolean savingsAccount;

	public Account() {
		super();
	}

	public Account(int id, int c_id, int balance, int amount, boolean checkingAccount, boolean savingsAccount) {
		super();
		log.info("Setting Account Values");
		this.balance = balance;
		this.id = id;
		this.clientId = c_id;
		this.amount = amount;
		this.checkingAccount = checkingAccount;
		this.savingsAccount = savingsAccount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return clientId;
	}

	public void setCid(int cid) {
		clientId = cid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(boolean checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public boolean isSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(boolean savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", c_id= " + clientId + ", balance=" + balance + ", amount=" + amount
				+ ", checkingAccount=" + checkingAccount + ", savingsAccount=" + savingsAccount + "]";
	}

}
