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

import connPack.ProductSearchDB;
import connPack.SearchStockDB;
import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.SizeTool;

public class ProductSearchPop extends JDialog {

	Container contentP = getContentPane();
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	Object[] record = new Object[7];
	TableColumnModel tcm;
	
	public void openList(ArrayList<ProductSearchDB> list) {
		ProductSearchPop psp = new ProductSearchPop(list);
		psp.setVisible(true);
		
	}
	
	public ProductSearchPop () {
		
	}
	
	public ProductSearchPop (ArrayList<ProductSearchDB> list) {
		
		setSize(660, 725);
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(660), st.setCenterY(725) - 100);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		
		
		ImageInput imageEdit = new ImageInput();
		ImageIcon panelImage = new ImageIcon("src\\mainIcon\\BG4.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 660, 725);
		
		ImageIcon xnormal = new ImageIcon("src\\mainIcon\\mainXB1.jpg");
		ImageIcon xaction = new ImageIcon("src\\mainIcon\\mainXB2.jpg");
		JButton xButton = new JButton();
		xButton.setBounds(628, 13, 21, 20);
		getContentPane().add(xButton);
		imageEdit.setButtonImage(xButton, xnormal, xaction);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		
		String[] title = { "상품코드", "상품명", "가격", "브랜드",  "대분류", "소분류", "저장" };
		model = new DefaultTableModel(title, 0) {	
			public boolean isCellEditable(int row, int column) {
					return false;
			}
		};
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(10, 60, 640, 635);
		imageEdit.tableSet(table, sp);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getColumn("상품코드").setPreferredWidth(110);
		table.getColumn("상품명").setPreferredWidth(150);
		table.getColumn("가격").setPreferredWidth(35);
		table.getColumn("브랜드").setPreferredWidth(110);
		table.getColumn("대분류").setPreferredWidth(120);
		table.getColumn("소분류").setPreferredWidth(90);
		table.getColumn("저장").setPreferredWidth(40);
		
		DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.RIGHT);
		tcm = table.getColumnModel();
		
		for(int i = 0; i < 7; i++) {
			if(i == 2) {
				tcm.getColumn(i).setCellRenderer(right);
			} else {
				tcm.getColumn(i).setCellRenderer(mid);
			}	
		}
		
		for(int i = 0; i < list.size(); i++) {
			ProductSearchDB data = list.get(i);
			
			record[0] = data.getCode();
			record[1] = data.getName();
			record[2] = data.getPrice();
			record[3] = data.getCom();
			record[4] = data.getTypeB();
			record[5] = data.getTypeS();
			record[6] = data.getTypeE();
			
			model.addRow(record);
		}
		
		
		contentP.add(sp);
		contentP.add(backG);
		
	}

}
