package tableTTNV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckboxInTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkbox in JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Dữ liệu mẫu
        Object[][] data = {
            {false, "Row 1", "Data 1"},
            {true, "Row 2", "Data 2"},
            {false, "Row 3", "Data 3"},
        };

        // Tiêu đề cột
        String[] columnNames = {"Select", "Row Name", "Data"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        // Đặt renderer và editor cho cột "Select" (cột đầu tiên)
        table.getColumnModel().getColumn(0).setCellRenderer(new CheckboxRenderer());
        table.getColumnModel().getColumn(0).setCellEditor(new CheckboxEditor());

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    static class CheckboxRenderer extends JCheckBox implements TableCellRenderer {
        public CheckboxRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setSelected((Boolean) value);
            return this;
        }
    }

    static class CheckboxEditor extends DefaultCellEditor {
        private JCheckBox checkBox;

        public CheckboxEditor() {
            super(new JCheckBox());
            checkBox = (JCheckBox) getComponent();
            checkBox.setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            checkBox.setSelected((Boolean) value);
            return checkBox;
        }
    }
}



