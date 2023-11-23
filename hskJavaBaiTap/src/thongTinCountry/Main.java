package thongTinCountry;

import javax.swing.JFrame;

import ttnvDemoThay.DanhSachNhanVien;

public class Main extends JFrame {

	public static void main(String[] args) {
		ListCountry dao = new ListCountry();
		new FrmCountry(dao).setVisible(true);
	}

}
