package mainResultPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class StockSearchPanel extends BasicRMP {
	public StockSearchPanel() {
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(102, 10, 220, 35);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(102, 75, 220, 35);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 149, 100, 23);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(225, 149, 97, 23);
		add(comboBox_1);
	}
}
