package mainResultPanel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import connPack.AccountDB;
import popUpPack.CationMsg;
import popUpPack.CheckMsg;
import popUpPack.ResultMsg;
import toolPack.ImageInput;
import toolPack.TextClear;

public class BasicRMP extends JPanel {
	
	AccountDB ad = new AccountDB();
	String shopID = ad.getUshop();
//	String shopID = "SG85"; // ½ÇÇè¿ë
	
	TextClear tc = new TextClear();
	ImageInput imageEdit = new ImageInput();
	Color BG = new ColorUIResource (254, 251, 245);
	CationMsg cm = new CationMsg();
	CheckMsg ck = new CheckMsg();
	ResultMsg rm = new ResultMsg();
	
	public BasicRMP() {
		setBackground(BG); //
		setSize(420, 415); //setBound at 0, 85
		setLayout(null);
		
	}

}
