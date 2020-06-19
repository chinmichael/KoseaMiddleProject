package toolPack;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class PersonalComboBoxRenderer extends BasicComboBoxRenderer {
	
	Color background;
	Color selectground;
	
	public void setColorBack(Color background, Color selectground) {
		this.background = background;
		this.selectground = selectground;
	}
	
	@Override
	public Component getListCellRendererComponent (JList list, Object value, int index, boolean inSelected, boolean cellHasFocus) {
		
		JComponent component = (JComponent) super.getListCellRendererComponent(list, value, index, inSelected, cellHasFocus);
		component.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		component.setBackground(inSelected || cellHasFocus ? selectground : background);
		
		return component;
	}
	
}
