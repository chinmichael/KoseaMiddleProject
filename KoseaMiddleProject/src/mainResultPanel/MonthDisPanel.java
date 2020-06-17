//https://m.blog.naver.com/PostView.nhn?blogId=kdy0573&logNo=150158901889&proxyReferer=https:%2F%2Fwww.google.com%2F
//https://aiden1004.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%8A%A4%EC%9C%99-%ED%85%8C%EC%9D%B4%EB%B8%94%EC%97%90-%EB%B2%84%ED%8A%BC-%EC%9E%85%EB%A0%A5%EC%B2%B4%ED%81%AC%EB%B0%95%EC%8A%A4-%ED%9B%84-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%B2%98%EB%A6%AC
//https://krvision.tistory.com/entry/Swing-JTable

package mainResultPanel;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import connPack.AccountDB;
import connPack.DisDBShort;
import connPack.DisQ;

public class MonthDisPanel extends BasicRMP {
	
	AccountDB ad = new AccountDB();
//	String shopID = ad.getUshop();
	String shopID = "SG85";  //실험용
	
	private JTable table;
	DefaultTableModel model;
	JScrollPane sp;
	Object[] record = new Object[3];
	
	public MonthDisPanel() {

		String[] title = { "상품명", "재고", "유통기한" };
		model = new DefaultTableModel(title, 0);
		table = new JTable(model) {

		};
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 420, 350);

		DisQ dq = new DisQ();
		ArrayList<DisDBShort> list = dq.disSearchMonth(shopID);
//		System.out.println("db실행");

		for (int i = 0; i < list.size(); i++) {
			DisDBShort data = list.get(i);
			record[0] = data.getName();
			record[1] = data.getStock();
			record[2] = data.getDate();
			model.addRow(record);
		}

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(sp);

	}
}
