package mainPack;

import javax.swing.JPanel;

import toolPack.ImageInput;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MainHomePanel extends JPanel {
	
	ImageInput imageEdit = new ImageInput();

	public MainHomePanel() {
		setBackground(Color.WHITE);
		setSize(420, 500); //setBound at 40, 185
		setLayout(null);
		
		JTextArea noticeWriting = new JTextArea();
		noticeWriting.setBorder(new EmptyBorder(0, 0, 0, 0));
		noticeWriting.setOpaque(false);
		JScrollPane sp = new JScrollPane(noticeWriting);
		sp.setBorder(new EmptyBorder(0, 0, 0, 0));
		sp.setBounds(15, 15, 390, 390);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
		add(sp);
		
		ImageIcon noticeBack = new ImageIcon("src\\mainIcon\\notice.jpg");
		
		JLabel noticeArea = new JLabel("New label");
		noticeArea.setBounds(0, 0, 420, 420);
		imageEdit.setPaintLabel(noticeArea, noticeBack);
		add(noticeArea);
		
		ImageIcon saveNormal = new ImageIcon("src\\mainIcon\\saveB1.jpg");
		ImageIcon saveAction = new ImageIcon("src\\mainIcon\\saveB2.jpg");
		ImageIcon backNormal = new ImageIcon("src\\mainIcon\\backB1.jpg");
		ImageIcon backAction = new ImageIcon("src\\mainIcon\\backB2.jpg");
		
		JButton saveButton = new JButton();
		saveButton.setBounds(0, 440, 60, 60);
		imageEdit.setButtonImage(saveButton, saveNormal, saveAction);
		add(saveButton);
		
		JButton backButton = new JButton();
		backButton.setBounds(360, 440, 60, 60);
		imageEdit.setButtonImage(backButton, backNormal, backAction);
		add(backButton);
		
		

	}
}
