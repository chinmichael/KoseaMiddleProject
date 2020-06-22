package mainPopUp;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connPack.SearchStockDB;
import connPack.StockQ;
import popUpPack.CationMsg;
import popUpPack.CheckMsg;
import popUpPack.ResultMsg;
import toolPack.DateTool;
import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.SizeTool;

public class StockSearchPop extends JDialog {

	Container contentP = getContentPane();
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	Object[] record = new Object[12];
	TableColumnModel tcm;
	
	DateTool dt = new DateTool();
	CationMsg cm = new CationMsg();
	CheckMsg ck = new CheckMsg();
	ResultMsg rm = new ResultMsg();
	StockQ sud = new StockQ();
	ImageInput imageEdit = new ImageInput();
	
	public void openList(ArrayList<SearchStockDB> list) {
		StockSearchPop ssp = new StockSearchPop(list);
		ssp.setVisible(true);
	}
	
	public StockSearchPop() {
	
	}
	
	public StockSearchPop(ArrayList<SearchStockDB> list) {
		setSize(1100, 550);
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(1100), st.setCenterY(550) - 50);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		
		ImageIcon panelImage = new ImageIcon("src\\mainIcon\\BG5.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 1100, 550);
		
		String[] title = { "", "No.", "��ǰ�ڵ�", "��ǰ��", "����", "������ġ", "���", "�������", "�귣��", "��з�", "�Һз�", "����" };
		model = new DefaultTableModel(title, 0) {
			
			public boolean isCellEditable(int row, int column) {
				if ( (5 <= column && column <= 7) || column == 0 ) {
					return true;
				} else {
					return false;
				}
				
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if(columnIndex == 0) {
					return Boolean.class;
				} else if (columnIndex == 6) {
					return Integer.class;
				} else {
					return String.class;
				}	
			}
		};
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(15, 60, 1070, 400);
		imageEdit.tableSet(table, sp);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getColumn("").setPreferredWidth(25);
		table.getColumn("No.").setPreferredWidth(40);
		table.getColumn("��ǰ�ڵ�").setPreferredWidth(125);
		table.getColumn("��ǰ��").setPreferredWidth(200);
		table.getColumn("����").setPreferredWidth(40);
		table.getColumn("���").setPreferredWidth(40);
		table.getColumn("�������").setPreferredWidth(100);
		table.getColumn("�귣��").setPreferredWidth(125);
		table.getColumn("��з�").setPreferredWidth(150);
		table.getColumn("�Һз�").setPreferredWidth(100);
		table.getColumn("����").setPreferredWidth(50);
		
		DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.RIGHT);
		tcm = table.getColumnModel();
		
		for(int i = 1; i < 12; i++) {
			if(i == 1 || i == 4 || i == 6) {
				tcm.getColumn(i).setCellRenderer(right);
			} else {
				tcm.getColumn(i).setCellRenderer(mid);
			}	
		}
		
		for(int i = 0; i < list.size(); i++) {
			SearchStockDB data = list.get(i);
			
			record[0] = false;
			record[1] = data.getSerial();
			record[2] = data.getCode();
			record[3] = data.getName();
			record[4] = data.getPrice();
			record[5] = data.getLoc();
			record[6] = data.getStock();
			record[7] = data.getExp();
			record[8] = data.getCom();
			record[9] = data.getT1();
			record[10] = data.getT2();
			record[11] = data.getT3();
			
			model.addRow(record);
			
		}
		
		ImageIcon xnormal = new ImageIcon("src\\mainIcon\\mainXB1.jpg");
		ImageIcon xaction = new ImageIcon("src\\mainIcon\\mainXB2.jpg");
		JButton xButton = new JButton();
		xButton.setBounds(1063, 12, 21, 20);
		getContentPane().add(xButton);
		imageEdit.setButtonImage(xButton, xnormal, xaction);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		ImageIcon saveNormal = new ImageIcon("src\\mainIcon\\saveB1.jpg");
		ImageIcon saveAction = new ImageIcon("src\\mainIcon\\saveB2.jpg");
		JButton saveButton = new JButton();
		saveButton.setBounds(520, 473, 60, 60);
		imageEdit.setButtonImage(saveButton, saveNormal, saveAction);
		add(saveButton);
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ck.printMsg("��������� �����Ͻðڽ��ϱ�", "����");
				
				if(ck.getFlg()) {
					ck.setFlg(false);
					boolean flg = true;
					
					for(int i = 0; i < table.getRowCount(); i++) {
						if((boolean) table.getModel().getValueAt(i, 0)) {
							
							if((int) table.getModel().getValueAt(i, 6) < 0) {
								cm.printMsg("��������� ��ȿ���� �ʽ��ϴ�");
								flg = false;
								break;
							}
							
							if (!dt.vildationDate((String) table.getModel().getValueAt(i, 7))) {
								cm.printMsg("��ȿ�Ⱓ�� �Է������� �����ּ���");
								flg = false;
								break;
							}
						}
					}
					
					if(flg) {
						for(int i = 0; i < table.getRowCount(); i++) {
							if((boolean) table.getModel().getValueAt(i, 0)) {
								
								int serial = (int) table.getModel().getValueAt(i, 1);
								String location = (String) table.getModel().getValueAt(i, 5);
								int stock = (int) table.getModel().getValueAt(i, 6);
								String date = (String) table.getModel().getValueAt(i, 7);
								
								sud.stockChange(serial, location, stock, date);
							}
						}
					}
					
					if(sud.getFlg()) {
						sud.setFlg(false);
						rm.printMsg("��������� �����߽��ϴ�");
					}
					
				}
				
			}
			
		});
			
		contentP.add(sp);
		contentP.add(backG);
		
	}
	
}