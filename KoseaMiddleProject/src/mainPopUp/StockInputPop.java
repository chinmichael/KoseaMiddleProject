package mainPopUp;

import java.awt.Container;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connPack.ProIDList;
import connPack.SearchStockDB;
import connPack.StockQ;
import popUpPack.CationMsg;
import popUpPack.CheckMsg;
import popUpPack.ResultMsg;
import toolPack.DateTool;
import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.SizeTool;

public class StockInputPop extends JDialog {
	
	static String codeP;

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
	
	public String getCodeP() {
		return codeP;
	}
	
	public void openList(ArrayList<ProIDList> list) {
		StockInputPop ssp = new StockInputPop(list);
		ssp.setVisible(true);
	}
	
	public StockInputPop() {
	
	}
	
	public StockInputPop(ArrayList<ProIDList> list) {
		setSize(600, 400);
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(600), st.setCenterY(400) - 100);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		
		ImageInput imageEdit = new ImageInput();
		ImageIcon panelImage = new ImageIcon("src\\mainIcon\\BG3.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 600, 400);
		
		String[] title = { "상품코드", "상품명", "브랜드"};
		model = new DefaultTableModel(title, 0) {
			
			public boolean isCellEditable(int row, int column) {
				return false;	
			}
		};
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(10, 40, 580, 350);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getColumn("상품코드").setPreferredWidth(180);
		table.getColumn("상품명").setPreferredWidth(200);
		table.getColumn("브랜드").setPreferredWidth(200);
		
		DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		tcm = table.getColumnModel();
		
		for (int i = 0; i < 3; i++) {
			tcm.getColumn(i).setCellRenderer(mid);
		}
		
		for(int i = 0; i < list.size(); i++) {
			ProIDList data = list.get(i);
			
			record[0] = data.getCode();
			record[1] = data.getName();
			record[2] = data.getCom();
			
			model.addRow(record);
		}
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				codeP = (String)table.getModel().getValueAt(row, 0);
				dispose();
			}	
		});
		
		ImageIcon xnormal = new ImageIcon("src\\mainIcon\\mainXB1.jpg");
		ImageIcon xaction = new ImageIcon("src\\mainIcon\\mainXB2.jpg");
		JButton xButton = new JButton();
		xButton.setBounds(570, 8, 17, 16);
		getContentPane().add(xButton);
		imageEdit.setButtonImage(xButton, xnormal, xaction);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
			
		contentP.add(sp);
		contentP.add(backG);
		
	}
	
}
