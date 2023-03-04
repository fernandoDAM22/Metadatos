package controller;

import org.checkerframework.checker.units.qual.C;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Esta clase nos permite cambiar el color de las filas de una tabla
 * @author Fernando
 */
public class MyCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        table.setEnabled(false);
        if (row % 2 == 0) {
            c.setBackground(new Color(216, 219, 226));
        } else {
            c.setBackground(Color.WHITE);
        }
        if (isSelected) {
            c.setForeground(Color.RED);
        } else {
            c.setForeground(table.getForeground());
        }
        return c;
    }
}

