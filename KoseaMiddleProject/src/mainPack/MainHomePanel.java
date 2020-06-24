package mainPack;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import popUpPack.CheckMsg;

public class MainHomePanel extends BasicMP {
	
	JTextArea noticeWriting;
	CheckMsg ck = new CheckMsg();

	public MainHomePanel() {
		
		JLabel explain = new JLabel("저장");
		explain.setBounds(64, 440, 45, 20);
		imageEdit.setHint(explain);
		add(explain);
		
		JLabel explain2 = new JLabel("뒤로");
		explain2.setBounds(309, 440, 45, 20);
		imageEdit.setHint(explain2);
		add(explain2);
		
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				explain.setVisible(false);
				explain2.setVisible(false);

			}
		});

		noticeWriting = new JTextArea();
		noticeWriting.setBorder(new EmptyBorder(0, 0, 0, 0));
		noticeWriting.setOpaque(false);
		JScrollPane sp = new JScrollPane(noticeWriting);
		sp.setBorder(new EmptyBorder(0, 0, 0, 0));
		sp.setBounds(15, 15, 390, 390);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
		add(sp);
		
		loadFile();

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
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ck.printMsg("변경사항을 저장하시겠습니까?", "저장");

				if (ck.getFlg()) {
					try {
						OutputStream output = new FileOutputStream("C:\\hrchinDB\\DisNotice.txt");
						byte[] notice = noticeWriting.getText().getBytes();
						output.write(notice);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			
			public void mouseEntered(MouseEvent e) {
				explain.setVisible(true);

			}
		});

		JButton backButton = new JButton();
		backButton.setBounds(360, 440, 60, 60);
		imageEdit.setButtonImage(backButton, backNormal, backAction);
		add(backButton);
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ck.printMsg("마지막 저장 상태로 되돌리시겠습니까?", "확인");

				if (ck.getFlg()) {
					loadFile();
				}
			}
			
			public void mouseEntered(MouseEvent e) {
				explain2.setVisible(true);

			}
		});

	}

	public void loadFile() {
		try {
			File file = new File("C:\\hrchinDB\\DisNotice.txt"); // https://coding-factory.tistory.com/282
			FileReader reader = new FileReader(file);
			int cur = 0;
			String notice = "";
			while((cur = reader.read()) != -1) {
				String text = Character.toString((char)cur);
				notice = notice + text;
			}
			reader.close();
			
			noticeWriting.setText(notice);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
