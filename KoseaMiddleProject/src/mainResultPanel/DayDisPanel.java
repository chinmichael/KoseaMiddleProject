package mainResultPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connPack.AccountDB;
import connPack.DisDBShort;
import connPack.DisQ;
import connPack.DisUpdateQ;
import toolPack.DateTool;

public class DayDisPanel extends BasicRMP {
	
	AccountDB ad = new AccountDB();
//	String shopID = ad.getUshop();
	String shopID = "SG85"; // 실험용

	private JTable table;
	DefaultTableModel model;
	JScrollPane sp;
	Object[] record = new Object[5];
	TableColumnModel tcm;
	
	DateTool dt = new DateTool();
	
	DisUpdateQ du = new DisUpdateQ();

	public DayDisPanel() {

		String[] title = { "", "No.", "상품명", "재고", "유통기한" };
		model = new DefaultTableModel(title, 0) {
			public boolean isCellEditable(int row, int column) {
				if (column == 1 || column == 2) {
					return false;
				} else {
					return true;
				}
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == 0) {
					return Boolean.class;
				} else if (columnIndex == 3) {
					return Integer.class;
				} else {
					return String.class;
				}
			}

		};
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 420, 330);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getColumn("").setPreferredWidth(10);
		table.getColumn("No.").setPreferredWidth(25);
		table.getColumn("상품명").setPreferredWidth(200);
		table.getColumn("재고").setPreferredWidth(25);
		table.getColumn("유통기한").setPreferredWidth(80);
		
		DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.RIGHT);

		
		tcm = table.getColumnModel();
		tcm.getColumn(1).setCellRenderer(mid);
		tcm.getColumn(2).setCellRenderer(mid);
		tcm.getColumn(4).setCellRenderer(mid);
		
		tcm.getColumn(3).setCellRenderer(right);

		setData();
		
		add(sp);
		
		ImageIcon saveNormal = new ImageIcon("src\\mainIcon\\saveB1.jpg");
		ImageIcon saveAction = new ImageIcon("src\\mainIcon\\saveB2.jpg");
		ImageIcon backNormal = new ImageIcon("src\\mainIcon\\backB1.jpg");
		ImageIcon backAction = new ImageIcon("src\\mainIcon\\backB2.jpg");
		
		JButton saveButton = new JButton();
		saveButton.setBounds(0, 355, 60, 60);
		imageEdit.setButtonImage(saveButton, saveNormal, saveAction);
		add(saveButton);
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean flg1 = true;
				boolean flg2 = true;
				
				for (int i = 0; i < table.getRowCount(); i++) {
					if ((boolean) table.getModel().getValueAt(i, 0)) {

						if ((int) table.getModel().getValueAt(i, 3) < 0) {
							cm.printMsg("재고수량이 유효하지 않습니다");
							flg1 = false;
						} 
					}
				}
				
				if (flg1) {

					for (int i = 0; i < table.getRowCount(); i++) {
						if ((boolean) table.getModel().getValueAt(i, 0)) {

							if (!dt.vildationDate((String) table.getModel().getValueAt(i, 4))) {
								cm.printMsg("유효기간을 입력형식을 맞춰주세요");
								flg2 = false;
							}
						}
					}
				}

				if (flg1 && flg2) {
					for (int i = 0; i < table.getRowCount(); i++) {
						if ((boolean) table.getModel().getValueAt(i, 0)) {

							int serial = (int) table.getModel().getValueAt(i, 1);
							String date = (String) table.getModel().getValueAt(i, 4);
							int stock = (int) table.getModel().getValueAt(i, 3);
							

							du.disChange(serial, date, stock);

						}
					}
					
					if(du.getFlg()) {
						du.setFlg(false);
						rm.printMsg("변경사항을 저장했습니다");
					}
				}
			}

		});
		
		JButton refreshButton = new JButton();
		refreshButton.setBounds(360, 355, 60, 60);
		imageEdit.setButtonImage(refreshButton, backNormal, backAction);
		add(refreshButton);
		refreshButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ck.printMsg("마지막 저장 상태로 되돌리시겠습니까?", "확인");

				if (ck.getFlg()) {
					setData();
				}
			}
		});
		
	}
	
	public void setData() {
		
		DisQ dq = new DisQ();
		ArrayList<DisDBShort> list = dq.disSearchDay(shopID);
		
		model.setNumRows(0);

		for (int i = 0; i < list.size(); i++) {
			DisDBShort data = list.get(i);
			record[0] = false;
			record[1] = data.getNum();
			record[2] = data.getName();
			record[3] = data.getStock();
			record[4] = data.getDate();
			model.addRow(record);
			
		}
	}
}
