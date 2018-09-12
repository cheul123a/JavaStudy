package chapter05;

public class BankAccount {

	private int balance;
	private String ano;
	private String name;

	public BankAccount(String ano, String name, int balance) {
		this.ano = ano;
		this.name = name;
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
