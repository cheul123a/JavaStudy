package chapter05;

public class ShopService {

	private ShopService() {
	}
	static ShopService shop = new ShopService();
	public static ShopService getInstance() {
		
		return shop;
	}
}
