package jTreeTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PhongKyThuat extends JFrame
{
	public PhongKyThuat()
	{
		setTitle("Phòng kĩ thuật");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(500, 300);
	    setVisible(true);
	    setLocationRelativeTo(null);
	    String[][] data = { 
	            { "0212", "Nguyễn", "Tân","Nam","25","3000 $" }, 
	            { "0223", "Lê", "Ngọc","Nữ","27","7000 $" }, 
	            { "0244", "Trần", "Bình","Nam","30","4500 $" }, 
	         };
	    String[] columnNames = {"Mã","Họ","Tên","Phái","Tuổi","Tiền lương" };
	 // Tạo một JTable với dữ liệu và tiêu đề cột được cung cấp
	      JTable table = new JTable(data, columnNames);

	      // Đặt JTable trong một JScrollPane để cho phép cuộn trang khi cần thiết
	      JScrollPane scrollPane = new JScrollPane(table);

	      // Đặt JScrollPane vào JPanel
	      JPanel panel = new JPanel();
	      panel.add(scrollPane);

	      // Đặt JPanel vào JFrame và hiển thị nó
	      setContentPane(panel);
	}
}
