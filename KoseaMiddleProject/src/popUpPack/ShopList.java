package popUpPack;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connPack.ShopDB;
import connPack.ShopQ;
import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.SizeTool;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ShopList extends JDialog {
	
	static String shopCode;
	static boolean flg = false;
	
	Container contentP = getContentPane();
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	Object[] record = new Object[3];

	public String getCode() {
		return shopCode;
	}
	
	public boolean getFlg() {
		return flg;
	}
	
	public void setFlg(boolean flg) {
		this.flg= flg;
	}
	
	public void openList(ArrayList<ShopDB> list, String name) {
		ShopList dialog = new ShopList(list, name);
		dialog.setVisible(true);
	}
	
	public ShopList() {
		
	}

	public ShopList(ArrayList<ShopDB> list, String name) {
		setSize(480, 290); // 2400, 1450
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(480), st.setCenterY(290) - 100);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		
		ImageInput imageEdit = new ImageInput();
		ImageIcon panelImage = new ImageIcon("src\\warningImage\\ResultBG.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 480, 290);
		
		String[] title = {"점포코드", "점포명", "점포위치"};
		model = new DefaultTableModel(title, 0);
		table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		sp = new JScrollPane(table);
		sp.setBounds(25, 137, 430, 130);
		
		for(int i = 0; i < list.size(); i++) {
			ShopDB data = (ShopDB) list.get(i);
			record[0] = data.getShopID();
			record[1] = data.getShopName();
			record[2] = data.getShopLoc();
			model.addRow(record);
			}
		
		table.getColumn("점포코드").setPreferredWidth(70);
		table.getColumn("점포명").setPreferredWidth(160);
		table.getColumn("점포위치").setPreferredWidth(200);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				shopCode = (String)table.getModel().getValueAt(row, 0);
				flg = true;
				dispose();
			}	
		});
		
		contentP.add(sp);
		
		ImageIcon xnormal = new ImageIcon("src\\warningImage\\Wxbutton1.jpg");
		ImageIcon xaction = new ImageIcon("src\\warningImage\\Wxbutton2.jpg");
		JButton xButton = new JButton();
		xButton.setBounds(443, 13, 18, 17);
		getContentPane().add(xButton);
		imageEdit.setButtonImage(xButton, xnormal, xaction);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		String resultA = "'" + name + "'" + "의 검색결과입니다";
		JLabel lblNewLabel = new JLabel(resultA);
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 70, 440, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		contentP.add(lblNewLabel);
		
		contentP.add(backG);
		
	}

}
