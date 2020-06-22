package mainResultPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import connPack.MainAccountQ;
import connPack.ProductSearchDB;
import connPack.RankIDList;
import loginPack.LoginRegist;
import loginPack.LoginRegist.RadioSelect;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;

public class RankChangePanel extends BasicRMP {
	
	private JTextField nameTF;
	String rankF;
	JRadioButton rankS1, rankS2;
	
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	Object[] record = new Object[4];
	TableColumnModel tcm;
	
	MainAccountQ maq = new MainAccountQ();
	
	public RankChangePanel() {
		
		nameTF = tc.textClean();
		nameTF.setBounds(140, 17, 158, 21);
		add(nameTF);
		nameTF.setColumns(10);

		String[] title = { "", "아이디", "직급", "생성일" };
		model = new DefaultTableModel(title, 0) {

			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if(columnIndex == 0) {
					return Boolean.class;
				} else {
					return String.class;
				}	
			}
		};
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(25, 67, 370, 200);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		imageEdit.tableSet(table, sp);
		
		table.getColumn("").setPreferredWidth(35);
		table.getColumn("아이디").setPreferredWidth(110);
		table.getColumn("직급").setPreferredWidth(110);
		table.getColumn("생성일").setPreferredWidth(140);
		
		DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		tcm = table.getColumnModel();
		tcm.getColumn(1).setCellRenderer(mid);
		tcm.getColumn(2).setCellRenderer(mid);
		tcm.getColumn(3).setCellRenderer(mid);

		RadioSelect radioS = new RadioSelect();

		rankS1 = new JRadioButton(" 아르바이트");
		setRadio(rankS1);
		rankS1.setBounds(96, 295, 115, 23);
		add(rankS1);
		rankS1.addActionListener(radioS);

		rankS2 = new JRadioButton(" 매니저");
		setRadio(rankS2);
		rankS2.setBounds(233, 295, 85, 23);
		add(rankS2);
		rankS2.addActionListener(radioS);

		ButtonGroup rankG = new ButtonGroup();
		rankG.add(rankS1);
		rankG.add(rankS2);
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel nameArea = new JLabel("New label");
		nameArea.setBounds(130, 10, 184, 35);
		imageEdit.setPaintLabel(nameArea, labelBack);
		add(nameArea);
		
		JLabel lblNewLabel_1 = new JLabel("사원명  :  ");
		lblNewLabel_1.setForeground(new Color(102, 51, 0));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(22, 12, 96, 35);
		add(lblNewLabel_1);

		ImageIcon reg3 = new ImageIcon("src\\loginImage\\RegButton3.jpg");

		JButton searchButton = new JButton();
		searchButton.setBounds(320, 10, 50, 35);
		imageEdit.setOneImage(searchButton, reg3);
		add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!nameTF.getText().isBlank()) {

					ArrayList<RankIDList> list = maq.rankIDSearch(shopID, nameTF.getText());

					if (maq.getFlg()) {
						maq.setFlg(false);
						
						model.setNumRows(0);

						for (int i = 0; i < list.size(); i++) {
							RankIDList data = list.get(i);

							record[0] = false;
							record[1] = data.getID();
							record[2] = data.getType();
							record[3] = data.getDate();

							model.addRow(record);
						}

					} else {
						cm.printMsg("검색결과가 없습니다");
					}

				} else {
					cm.printMsg("사원명을 입력해주세요");
				}
			}
		});
		
		nameTF.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {  //keyCode() == 9 는 Tab, 10은 Enter
					Toolkit.getDefaultToolkit().beep(); 

			        searchButton.doClick();
				}
			}
		});
		
		ImageIcon saveNormal = new ImageIcon("src\\mainIcon\\saveB1.jpg");
		ImageIcon saveAction = new ImageIcon("src\\mainIcon\\saveB2.jpg");
		
		JButton saveButton = new JButton();
		saveButton.setBounds(180, 340, 60, 60);
		imageEdit.setButtonImage(saveButton, saveNormal, saveAction);
		add(saveButton);
		
		saveButton.addMouseListener(new MouseAdapter () {
			
			public void mouseClicked (MouseEvent e) {
				
				if(rankF == null) {
					cm.printMsg("변경하실 직급을 선택해주세요");
					
				} else {
					
					for (int i = 0; i < table.getRowCount(); i++) {
						if ((boolean) table.getModel().getValueAt(i, 0)) {

							String rankID = (String) table.getModel().getValueAt(i, 1);
							maq.rankChange(rankID, rankF);
							
							if(maq.getFlg()) {
								maq.setFlg(false);
								rm.printMsg("변경사항이 저장되었습니다");
							}
						}
					}
				}
			}
		});
		
		add(sp);
		
	}
	
	public void setRadio(JRadioButton jr) {
		jr.setIcon(new ImageIcon(LoginRegist.class.getResource("/loginImage/LRaidoB1.png")));
		jr.setSelectedIcon(new ImageIcon(LoginRegist.class.getResource("/loginImage/LRaidoB2.png")));
		jr.setFocusable(false);
		jr.setOpaque(false);
	}
	
	public class RadioSelect implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(rankS1.isSelected()) {
				rankF = "아르바이트";
//				System.out.println(rankF); 확인용
			}
			if(rankS2.isSelected()) {
				rankF = "매니저";
			}
			
		}
	}
}
