package thongTinCountry_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SQLServerConnectionTest {
    public static void main(String[] args) {
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=Ministop";
		String username = "sa";
		String password = "123";
		Connection conn = null;

		try {
			// Kết nối tới cơ sở dữ liệu
			conn = DriverManager.getConnection(url, username, password);
			JOptionPane.showMessageDialog(null, "Kết nối thành công");
			System.out.println("SIUUUU");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Kết nối thất bại");
		}
    }
}

