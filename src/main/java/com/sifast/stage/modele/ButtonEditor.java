package com.sifast.stage.classe;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import com.sifast.stage.ihm.Disponibilite;

public class ButtonEditor extends DefaultCellEditor {
	
	private static final long serialVersionUID = 1L;

	protected JButton button;
	private String label;
	public Preference preference;

	// constructeur 
	
	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disponibilite frame = new Disponibilite();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				preference=frame.getPreference();
			}
		});
	}
	
	// methodes 

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		button.setForeground(table.getSelectionForeground());
		button.setBackground(table.getSelectionBackground());
		button.setForeground(table.getForeground());
		button.setBackground(table.getBackground());
		label = (value == null) ? "afficher disponibilit�" : value.toString();
		button.setText(label);
		return button;
	}

	public Object getCellEditorValue() {

		return new String(label);
	}

}
