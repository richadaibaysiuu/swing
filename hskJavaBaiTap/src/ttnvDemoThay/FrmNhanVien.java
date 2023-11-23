package ttnvDemoThay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmNhanVien extends JFrame implements ActionListener, MouseListener {
	private DanhSachNhanVien dao;// phai co
	private List<NhanVien> list;// phai co
	private JTable table;
	private JTextField txtMaNV, txtHo, txtTen, txtTuoi, txtTienLuong, txtTim;
	private JRadioButton radNu;
	private JButton btnTim, btnThem, btnXoa, btnXoaTrang, btnLuu, btnSua;
	private DefaultTableModel tableModel;

	public FrmNhanVien(DanhSachNhanVien dao)// xua li su kien mang dong tren JFrame
	{
		setTitle("^-^");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		this.dao = dao;// set dao
		list = dao.getList();
		// tao khung North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);// add Panel North vao JFrame lon
		JLabel lblTieuDe;
		pnlNorth.add(lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.BLUE);

		Box b = Box.createVerticalBox();// tao box hang doc

		Box b1, b2, b3, b4, b5;
		JLabel lblMaNV, lblHo, lblTen, lblTuoi, lblPhai, lblTienLuong;

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b1.add(lblMaNV = new JLabel("Mã nhân viên"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtMaNV = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b2.add(lblHo = new JLabel("Họ"));
		b2.add(txtHo = new JTextField());
		b2.add(lblTen = new JLabel("Tên nhân viên"));
		b2.add(txtTen = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b3.add(lblTuoi = new JLabel("Tuổi"));
		b3.add(txtTuoi = new JTextField());
		b3.add(lblPhai = new JLabel("Phái"));
		b3.add(radNu = new JRadioButton("Nữ"));

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String[] phong = { "Phòng tổ chức", "Phòng kĩ thuật", "Phòng nhân sự", "Phòng tài vụ" };

		b4.add(lblTienLuong = new JLabel("Tiền Lương"));
		b4.add(txtTienLuong = new JTextField());

		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhai.setPreferredSize(lblMaNV.getPreferredSize());
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());// xếp hàng căn theo lblMaNV

		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String[] headers = "MaNV;Ho;Ten;Phai;Tuoi;TienLuong".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);

		b5.add(scroll);
		add(b, BorderLayout.CENTER);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.SOUTH);
		JPanel pnLeft, pnRight;
		split.add(pnLeft = new JPanel());
		split.add(pnRight = new JPanel());

		pnLeft.add(new JLabel("Nhập mã số cần tìm:"));
		pnLeft.add(txtTim = new JTextField(10));
		pnLeft.add(btnTim = new JButton("Tìm"));

		pnRight.add(btnThem = new JButton("Thêm"));
		pnRight.add(btnXoa = new JButton("Xoá"));
		pnRight.add(btnXoaTrang = new JButton("Xoá trắng"));
		pnRight.add(btnSua = new JButton("Sửa"));
		pnRight.add(btnLuu = new JButton("Lưu"));

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTim.addActionListener(this);
		btnLuu.addActionListener(this);

		table.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaNV.setText(table.getValueAt(row, 0).toString());// lay dong dang chon tren table
		txtHo.setText(table.getValueAt(row, 1).toString());
		txtTen.setText(table.getValueAt(row, 2).toString());
		radNu.setSelected(false);
		if (table.getValueAt(row, 3).toString().equalsIgnoreCase("true"))
			radNu.setSelected(true);
		txtTuoi.setText(table.getValueAt(row, 4).toString());
		txtTienLuong.setText(table.getValueAt(row, 5).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void xoaTrangActions() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTim.setText("");
		txtTienLuong.setText("");
		radNu.setSelected(false);
		txtMaNV.requestFocus();
	}

	private String gioiTinh() {
		boolean phai = (radNu.isSelected()) ? true : false;
		if (phai == true)
			return "Nữ";
		else
			return "Nam";
	}

	private void themActions() {
		try {
			int maNV = Integer.parseInt(txtMaNV.getText());
			String ho = txtHo.getText();
			String ten = txtTen.getText();
			boolean phai = (radNu.isSelected()) ? true : false;
			int tuoi = Integer.parseInt(txtTuoi.getText());
			double tienLuong = Double.parseDouble(txtTienLuong.getText());

			NhanVien nv = new NhanVien(maNV, tuoi, ho, ten, phai, tienLuong);
			if (dao.themNhanVien(nv)) {
				String[] row = { Integer.toString(maNV), ho, ten, gioiTinh(), Integer.toString(tuoi),
						Double.toString(tienLuong) + "" };
				tableModel.addRow(row);
				xoaTrangActions();
			} else {
				JOptionPane.showMessageDialog(null, "Trùng mã nhân viên");
				txtMaNV.selectAll();
				txtMaNV.requestFocus();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
			return;
		}
	}

	private void xoaActions() {
		int row = table.getSelectedRow();
		if (row != -1) {
			int maNV = Integer.parseInt((String) table.getModel().getValueAt(row, 0));
			int kTra = JOptionPane.showConfirmDialog(this, "Chắc chắn xoá không", "Chú ý", JOptionPane.YES_NO_OPTION);
			if (kTra == JOptionPane.YES_OPTION) {
				if (dao.xoaNhanVien(maNV))
					tableModel.removeRow(row);
			}
		}
	}

	private void timActions() {
		try {
			// int a=table.getRowCount();
			// int maCanTim=Integer.parseInt(txtTim.getText());
			String maCanTim = txtTim.getText();
			for (int i = 0; i < table.getRowCount(); i++) {
				for (int j = 0; j < table.getColumnCount(); j++) {
					if (table.getValueAt(i, j).toString().equals(maCanTim)) {
						table.setRowSelectionInterval(i, i);
					}
				}

			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
		}
	}

	private void luuActions(String tep) {
		try {

			FileWriter writer = new FileWriter(tep);
			PrintWriter out = new PrintWriter(writer);

			// Ghi tiêu đề của các cột
			for (int i = 0; i < table.getColumnCount(); i++) {
				out.print(table.getColumnName(i) + "\t");
			}
			out.println();

			// Ghi dữ liệu từ các hàng
			for (int i = 0; i < table.getRowCount(); i++) {
				for (int j = 0; j < table.getColumnCount(); j++) {
					out.print(table.getValueAt(i, j).toString() + "\t");
				}
				out.println();
			}
			out.close();
			JOptionPane.showMessageDialog(null, "Đã ghi file");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Lỗi file");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem))
			themActions();
		if (o.equals(btnXoa))
			xoaActions();
		if (o.equals(btnXoaTrang))
			xoaTrangActions();
		if (o.equals(btnTim))
			timActions();

		if (o.equals(btnLuu)) {
			luuActions("thongTinNhanVien.txt");
		}
	}
}
