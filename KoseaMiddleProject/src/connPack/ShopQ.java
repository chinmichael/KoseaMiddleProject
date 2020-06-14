package connPack;

import java.util.ArrayList;
import popUpPack.*;

public class ShopQ {

	public ArrayList<ShopDB> list(String shopName) {
		ArrayList<ShopDB> list = new ArrayList<ShopDB>();

		try {
			ConnDB c = new ConnDB();

			String query = "SELECT * FROM SHOP WHERE shop_name LIKE '%" + shopName + "%'";

			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			c.getRS().previous();
			while (c.getRS().next()) {
				String shop_id = c.getRS().getString("shop_id");
				String shop_name = c.getRS().getString("shop_name");
				String shop_location = c.getRS().getString("shop_location");

				ShopDB data = new ShopDB(shop_id, shop_name, shop_location);

				list.add(data);
			}

			c.getCon().close();
			c.getRS().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
