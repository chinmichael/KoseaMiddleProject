// https://www.python2.net/questions-58172.htm

package mainResultPanel;
import javax.swing.JLabel;
import javax.swing.plaf.ColorUIResource;

import connPack.TypeList;
import connPack.TypeList2;
import toolPack.PersonalComboBoxUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class StockSearchPanel extends BasicRMP {
	
	TypeList tl = new TypeList();
	
	public StockSearchPanel() {
		
		ImageIcon labelBack = new ImageIcon("src\\mainIcon\\menuBar.jpg");
		
		JLabel codeArea = new JLabel("New label");
		codeArea.setBounds(125, 10, 220, 40);
		imageEdit.setPaintLabel(codeArea, labelBack);
		add(codeArea);
		
		JLabel nameArea = new JLabel("New label");
		nameArea.setBounds(125, 75, 220, 40);
		imageEdit.setPaintLabel(nameArea, labelBack);
		add(nameArea);
		
		JLabel brandArea = new JLabel("New label");
		brandArea.setBounds(125, 140, 220, 40);
		imageEdit.setPaintLabel(brandArea, labelBack);
		add(brandArea);
		
		Color CB = new ColorUIResource (255,238,208);
		Color SB = new ColorUIResource(242,183,113);
		
		PersonalComboBoxUI pu = new PersonalComboBoxUI();
		pu.setColorBack(CB, SB);
		PersonalComboBoxUI pu2 = new PersonalComboBoxUI();
		pu2.setColorBack(CB, SB);
		
		JComboBox typeSmall = new JComboBox();
		typeSmall.setFont(new Font("돋움", Font.PLAIN, 13));
		typeSmall.addItem("소분류");
		typeSmall.setFocusTraversalKeysEnabled(false);
		typeSmall.setFocusable(false);
		pu2.installUI(typeSmall);
		typeSmall.setBounds(125, 265, 220, 35);
		add(typeSmall);
		
		JComboBox typeBig = new JComboBox(tl.list());
		typeBig.setFocusTraversalKeysEnabled(false);
		typeBig.setFocusable(false);
		pu.installUI(typeBig);
		typeBig.setFont(new Font("돋움", Font.PLAIN, 13));
		typeBig.setBounds(125, 205, 220, 35);
		add(typeBig);
		typeBig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String type = (String) typeBig.getSelectedItem();
				
				if(type.equals("대분류")) {
					typeSmall.removeAllItems();
					typeSmall.addItem("소분류");
					
				} else {
					TypeList2 tl2 = new TypeList2();
					String[] type2 = tl2.list(type);
					typeSmall.removeAllItems();
					
					for(int i = 0; i < type2.length; i++) {
						typeSmall.addItem(type2[i]);
					}
				}
			}
		});
		
		
		ImageIcon searchNormal = new ImageIcon("src\\mainIcon\\searchNB1.jpg");
		ImageIcon searchAction = new ImageIcon("src\\mainIcon\\searchNB2.jpg");
		
		JButton searchB = new JButton();
		searchB.setBounds(180, 340, 60, 60);
		imageEdit.setButtonImage(searchB, searchNormal, searchAction);
		add(searchB);
		
		
	}
}
