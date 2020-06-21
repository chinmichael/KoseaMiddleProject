package connPack;


public class TypeList {
	
	
	public String[] listB () {
		
		ConnDB c = new ConnDB();
		
		String[] types;
		
		try {
			String query = "SELECT DISTINCT type_name1 FROM category";
			
			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();
			
			int i = 1;
			types = new String[c.getRS().getRow() + 1];
			types[0] = "´ëºÐ·ù";
			
			c.getRS().beforeFirst();
			
			while(c.getRS().next()) {
				
				types[i] = c.getRS().getString("type_name1");
				
				i++;
			}
			
			c.getCon().close();
			c.getRS().close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
			types = new String[0];
		}
		
		return types;
		
	}

	public String[] listS(String type1) {

		ConnDB c = new ConnDB();

		String[] types;

		try {
			String query = "SELECT type_name2 FROM category WHERE type_name1 = '" + type1 + "'";

			c.setRS(c.getST().executeQuery(query));
			c.getRS().last();

			int i = 0;
			types = new String[c.getRS().getRow()];

			c.getRS().beforeFirst();

			while (c.getRS().next()) {
				types[i] = c.getRS().getString("type_name2");

				i++;
			}

			c.getCon().close();
			c.getRS().close();

		} catch (Exception e) {
			e.printStackTrace();
			types = new String[0];
		}

		return types;
	}
	

}