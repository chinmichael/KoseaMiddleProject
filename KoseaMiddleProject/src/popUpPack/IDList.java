package popUpPack;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connPack.AccFindDB;
import toolPack.DragMoveDialog;
import toolPack.ImageInput;
import toolPack.SizeTool;

public class IDList extends JDialog {
	
	static String findID;
	
	Container contentP = getContentPane();
	ImageInput imageEdit = new ImageInput();
	
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	Object[] record = new Object[2];
	TableColumnModel tcm;
	
	public String getID() {
		return findID;
	}
	
	public void openList(ArrayList<AccFindDB> idFind) {
		IDList dialog = new IDList(idFind);
		dialog.setVisible(true);
	}
	
	public IDList() {
		
	}
	
	public IDList(ArrayList<AccFindDB> idFind) {
		setSize(400, 240); // 2400, 1450
		setResizable(false);
		SizeTool st = new SizeTool();
		setLocation(st.setCenterX(400), st.setCenterY(240) - 100);
		setUndecorated(true);
		setModal(true);
		addMouseMotionListener(new DragMoveDialog());
		contentP.setLayout(null);
		
		String[] title = {"ID", "생성일" };
		model = new DefaultTableModel(title, 0);
		table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		sp = new JScrollPane(table);
		sp.setBounds(20, 100, 360, 120);
		imageEdit.tableSet(table, sp);
		
		DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		tcm = table.getColumnModel();
		tcm.getColumn(0).setCellRenderer(mid);
		tcm.getColumn(1).setCellRenderer(mid);
		
		for(int i = 0; i < idFind.size(); i++) {
			AccFindDB data = (AccFindDB) idFind.get(i);
			record[0] = data.getFid();
			record[1] = data.getFDate();
			model.addRow(record);
		}
		table.getColumn("ID").setPreferredWidth(180);
		table.getColumn("생성일").setPreferredWidth(220);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				findID = (String)table.getModel().getValueAt(row, 0);
				dispose();
			}	
		});
		
		contentP.add(sp);
		
		JLabel lblNewLabel = new JLabel("검색결과입니다");
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 50, 360, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		contentP.add(lblNewLabel);
		
		ImageIcon xnormal = new ImageIcon("src\\warningImage\\Wxbutton1.jpg");
		ImageIcon xaction = new ImageIcon("src\\warningImage\\Wxbutton2.jpg");
		JButton xButton = new JButton();
		xButton.setBounds(365, 10, 16, 15);
		getContentPane().add(xButton);
		imageEdit.setButtonImage(xButton, xnormal, xaction);
		xButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		ImageIcon panelImage = new ImageIcon("src\\warningImage\\ResultBG.jpg");
		JPanel backG = imageEdit.panelPaint(panelImage);
		backG.setBounds(0, 0, 400, 240);
		
		contentP.add(backG);
	}
}
