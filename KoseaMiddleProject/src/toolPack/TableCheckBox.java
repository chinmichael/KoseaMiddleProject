//https://aiden1004.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%8A%A4%EC%9C%99-%ED%85%8C%EC%9D%B4%EB%B8%94%EC%97%90-%EB%B2%84%ED%8A%BC-%EC%9E%85%EB%A0%A5%EC%B2%B4%ED%81%AC%EB%B0%95%EC%8A%A4-%ED%9B%84-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%B2%98%EB%A6%AC

package toolPack;

import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableCheckBox extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	
	JCheckBox jc;
	
//	public TableCheckBox {
//		
//		JCheckBox jc = JCheckBox();
//		
//		jc.addMouseListener(new MouseAdapter {
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//		});
//	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}

}
