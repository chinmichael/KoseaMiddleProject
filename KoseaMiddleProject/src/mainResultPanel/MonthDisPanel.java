//https://m.blog.naver.com/PostView.nhn?blogId=kdy0573&logNo=150158901889&proxyReferer=https:%2F%2Fwww.google.com%2F
//https://hashcode.co.kr/questions/2488/jtable%EC%97%90%EC%84%9C-%EC%97%AC%EB%9F%AC-%EA%B0%9C%EC%9D%98-%EC%97%B4-%EC%84%A0%ED%83%9D%ED%95%98%EA%B8%B0
//https://m.blog.naver.com/PostView.nhn?blogId=kdy0573&logNo=150158901889&proxyReferer=https:%2F%2Fwww.google.com%2F
//http://blog.daum.net/janustop/70
//https://kimsaemjava.tistory.com/61
//https://cordingtime.tistory.com/72

package mainResultPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import popUpPack.CationMsg;
import toolPack.DateTool;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MonthDisPanel extends BasicRMP {

	AccountDB ad = new AccountDB();
//	String shopID = ad.getUshop();
	String shopID = "SG85"; // �����

	private JTable table;
	DefaultTableModel model;
	JScrollPane sp;
	Object[] record = new Object[5];
	TableColumnModel tcm;
	
	DateTool dt = new DateTool();
	CationMsg cm = new CationMsg();
	DisQ dq = new DisQ();
	DisUpdateQ du = new DisUpdateQ();

	public MonthDisPanel() {

		String[] title = { "", "No.", "��ǰ��", "���", "�������" };
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
		
		table.getColumn("").setPreferredWidth(10);
		table.getColumn("No.").setPreferredWidth(25);
		table.getColumn("��ǰ��").setPreferredWidth(200);
		table.getColumn("���").setPreferredWidth(25);
		table.getColumn("�������").setPreferredWidth(80);
		
		DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tcm = table.getColumnModel();
		tcm.getColumn(1).setCellRenderer(mid);
		tcm.getColumn(2).setCellRenderer(mid);
		tcm.getColumn(4).setCellRenderer(mid);
		
		tcm.getColumn(3).setCellRenderer(right);


		ArrayList<DisDBShort> list = dq.disSearchMonth(shopID);
//		System.out.println("db����");
		

		for (int i = 0; i < list.size(); i++) {
			DisDBShort data = list.get(i);
			record[0] = false;
			record[1] = data.getNum();
			record[2] = data.getName();
			record[3] = data.getStock();
			record[4] = data.getDate();
			model.addRow(record);
			
		}
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
				boolean flg = true;
				
				for (int i = 0; i < table.getRowCount(); i++) {
					if ((boolean) table.getModel().getValueAt(i, 0)) {

						if (!dt.vildationDate((String) table.getModel().getValueAt(i, 4))) {
							cm.printMsg("��ȿ�Ⱓ�� �Է������� �����ּ���");
							flg = false;
						} 
					}
				}
				
				if (flg) {
					for (int i = 0; i < table.getRowCount(); i++) {
						if ((boolean) table.getModel().getValueAt(i, 0)) {

							int serial = (int) table.getModel().getValueAt(i, 1);
							String date = (String) table.getModel().getValueAt(i, 4);
							int stock = (int) table.getModel().getValueAt(i, 3);
							

							du.disChange(serial, date, stock);

						}

					}
				}
			}

		});
		
		JButton refreshButton = new JButton();
		refreshButton.setBounds(360, 355, 60, 60);
		imageEdit.setButtonImage(refreshButton, backNormal, backAction);
		add(refreshButton);
		
	}
}