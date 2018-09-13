package chapter05;

public class Book {

	private String name;
	private String writer;
	private int bno;
	private boolean stock;

	public Book(int bno, String name, String writer) {
		this.bno = bno + 1;
		this.name = name;
		this.writer = writer;
		stock = true;

	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
