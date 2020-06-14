package toolPack;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class PersonalComboBoxUI extends BasicComboBoxUI {
	
	Color background;
	
	public void setColorBack(Color background) {
		this.background = background;
	}
	
	public static ComponentUI createUI (JComponent c) {
		return new PersonalComboBoxUI();
	}
	
	@Override
	public void installUI (JComponent c) {
		super.installUI(c);
		
		JComboBox<?> comboBox =(JComboBox<?>) c;
		comboBox.setBackground(background);
		comboBox.setForeground(background);
		comboBox.setBorder(new LineBorder(background));
		comboBox.setLightWeightPopupEnabled(true);
	}
	
	@Override
	protected JButton createArrowButton() {
		Icon icon = UIManager.getIcon("ComboBox.buttonIcon");
		JButton button;
		
		if(icon != null) {
			button = new JButton(icon);
			
		} else {
			button = new BasicArrowButton(SwingConstants.SOUTH);
		}
		
		button.setOpaque(true);
		button.setBackground(background);
		button.setBorder(BorderFactory.createLineBorder(background));
		
		return button;
		
	}

//	@Override
//	protected ListCellRenderer createRenderer() {
//		PersonalComboBoxRenderer pr = new PersonalComboBoxRenderer();
//		pr.setColorBack(background);
//		return pr;
//	}

}
