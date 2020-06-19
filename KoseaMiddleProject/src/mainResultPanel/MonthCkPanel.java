package mainResultPanel;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connPack.AccountDB;
import connPack.DisMCDB;
import connPack.DisMCQ;
import connPack.DisMCUpdate;

public class MonthCkPanel extends BasicRMP {
	
	AccountDB ad = new AccountDB();
//	String shopID = ad.getUshop();
	String shopID = "SG85"; // 실험용
	
	private JTable table;
	DefaultTableModel model;
	JScrollPane sp;
	Object[] record = new Object[4];
	TableColumnModel tcm;
	
	DisMCQ dm = new DisMCQ();
	
	public MonthCkPanel() {
		
		String[] title = { "No.", "상품명", "폐기횟수", "저장타입" };
		model = new DefaultTableModel(title, 0) {
			public boolean isCellEditable(int row, int column) {
					return false;
			}
		};
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 420, 330);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumn("No.").setPreferredWidth(15);
		table.getColumn("상품명").setPreferredWidth(200);
		table.getColumn("폐기횟수").setPreferredWidth(30);
		table.getColumn("저장타입").setPreferredWidth(40);
		
		DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		
		tcm = table.getColumnModel();
		tcm.getColumn(0).setCellRenderer(mid);
		tcm.getColumn(1).setCellRenderer(mid);
		tcm.getColumn(2).setCellRenderer(mid);
		tcm.getColumn(3).setCellRenderer(mid);
		
		
		DisMCUpdate du = new DisMCUpdate();
		du.updateMonth(shopID);
		
		ArrayList<DisMCDB> list = dm.showCNT(shopID);
		
		for(int i  = 0; i < list.size(); i++) {
			DisMCDB data = list.get(i);
			
			record[0] = data.getSerial();
			record[1] = data.getPName();
			record[2] = data.getDisCnt();
			record[3] = data.getEType();
			
			model.addRow(record);
		}
		
		
		add(sp);
	}
}
