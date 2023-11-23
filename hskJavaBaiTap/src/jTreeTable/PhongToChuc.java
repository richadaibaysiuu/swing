package jTreeTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PhongToChuc extends JFrame
{
	public PhongToChuc()
	{
		setTitle("Phòng tổ chức");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(500, 300);
	    setVisible(true);
	    setLocationRelativeTo(null);
	    String[][] data = { 
	            { "0111", "Nguyễn", "An","Nam","25","3000 $" }, 
	            { "0222", "Lê", "Dung","Nữ","27","7000 $" }, 
	            { "0444", "Hoàng", "Bình","Nam","25","4500 $" }, 
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
