package popUpPack;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import toolPack.*;

public class InputCheck extends JDialog {

	Container contentP = getContentPane();

//	public static void main(String[] args) {
//		try {
//			InputCheck frame = new InputCheck();
//			frame.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void printMsg(boolean flg) {
		InputCheck frame = new InputCheck(flg);
		frame.setVisible(true);
	}

	public InputCheck(boolean flg) {
		
		
	}

}
