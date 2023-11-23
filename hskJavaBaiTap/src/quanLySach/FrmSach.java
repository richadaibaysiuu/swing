package quanLySach;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ttnvDemoThay.NhanVien;



public class FrmSach extends JFrame implements ActionListener, MouseListener
{

	private ListSach dao;
	private List<Sach> list;
	private JTable table;
	private JTextField txtMaSach, txtTuaSach, txtTacGia, txtNamXuatBan, txtNhaXuatBan, txtSoTrang, txtDonGia,txtISBN;
	private JComboBox<String> comboBox;
	private DefaultTableModel tableModel;
	private JButton btnThem,btnXoa,btnXoaRong,btnSua,btnLuu, btnLuuSQL;
	public FrmSach(ListSach dao)
	{
		setTitle("Quan li sach");
		setSize(800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		this.dao=dao;//set dao
		list=dao.getList();
	//	this.dao=dao;//set dao
	//	list=dao.getList();
		JPanel pnNorth,pnCenter,pnSouth;
		
		add(pnNorth=new JPanel(), BorderLayout.NORTH);
		add(pnCenter=new JPanel(), BorderLayout.CENTER);
		add(pnSouth=new JPanel(), BorderLayout.SOUTH);
		pnNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		Box b=Box.createVerticalBox();
		Box bb=Box.createVerticalBox();
		JPanel pnWest, pnEast;
		pnNorth.add(pnWest=new JPanel(), BorderLayout.WEST);
		pnNorth.add(pnEast=new JPanel(), BorderLayout.EAST);
		Box b1,b2,b3,b4,b5;
		Box b6,b7,b8,b9,b10;
		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXuatBan, lblNhaXuatBan, lblSoTrang, lblDonGia,lblISBN;
		
		b.add(b1=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(5));
		b1.add(lblMaSach=new JLabel("Mã sách:"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtMaSach=new JTextField(20));
		
		b.add(b2=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(5));
		b2.add(lblTuaSach=new JLabel("Tựa sách:"));
		b2.add(Box.createHorizontalStrut(30));
		b2.add(txtTuaSach=new JTextField());
	//	b2.add(lblTacGia=new JLabel("Tac gia:"));
	//	b2.add(txtTacGia=new JTextField());
		
		b.add(b3=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(5));
		b3.add(lblNamXuatBan=new JLabel("Năm xuất bản:"));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtNamXuatBan=new JTextField());
//		b3.add(lblNhaXuatBan=new JLabel("Nha xuat ban:"));
	//	b3.add(txtNhaXuatBan=new JTextField());
		
		b.add(b4=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(5));
		b4.add(lblSoTrang=new JLabel("Số trang:"));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtSoTrang=new JTextField());
	//	b4.add(lblDonGia=new JLabel("Don gia:"));
	//	b4.add(txtDonGia=new JTextField());
		
		b.add(b5=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(5));
		b5.add(lblISBN=new JLabel("International Standard Book Number:"));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtISBN=new JTextField());
		pnWest.add(b);
		
		bb.add(b6=Box.createHorizontalBox());
		bb.add(Box.createVerticalStrut(5));
		b6.add(lblTacGia=new JLabel("Tác giả:"));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(txtTacGia=new JTextField(20));
		
		bb.add(b7=Box.createHorizontalBox());
		bb.add(Box.createVerticalStrut(5));
		b7.add(lblNhaXuatBan=new JLabel("Nhà xuất bản:"));
		b7.add(Box.createHorizontalStrut(20));
		b7.add(txtNhaXuatBan=new JTextField());
		
		bb.add(b8=Box.createHorizontalBox());
		bb.add(Box.createVerticalStrut(5));
		b8.add(lblDonGia=new JLabel("Đơn giá:"));
		b8.add(Box.createHorizontalStrut(20));
		b8.add(txtDonGia=new JTextField());
		pnEast.add(bb);
		
	/*	lblTuaSach.setPreferredSize(lblMaSach.getPreferredSize());
		lblNamXuatBan.setPreferredSize(lblMaSach.getPreferredSize());
		lblISBN.setPreferredSize(lblMaSach.getPreferredSize());
		lblSoTrang.setPreferredSize(lblMaSach.getPreferredSize());//xếp hàng căn theo lblMaNV
		
		
		lblNhaXuatBan.setPreferredSize(lblTacGia.getPreferredSize());
		lblDonGia.setPreferredSize(lblTacGia.getPreferredSize());*/
	//	lblSoTrang.setPreferredSize(lblMaSach.getPreferredSize());//xếp hàng căn theo lblMaNV
		
		JLabel tim;
		pnCenter.add(btnThem=new JButton("Thêm"));
		pnCenter.add(btnXoa=new JButton("Xoá"));
		pnCenter.add(btnXoaRong=new JButton("Xoá rỗng"));
		pnCenter.add(btnSua=new JButton("Sửa"));
		pnCenter.add(btnLuu=new JButton("Lưu"));
		pnCenter.add(btnLuuSQL=new JButton("Lưu vào SQL"));
		pnCenter.add(tim=new JLabel("Tìm theo mã sách:"));
		//south
		pnSouth.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		
		
		pnCenter.add(comboBox=new JComboBox<>());
	//	String[] sach= {"MaSach","TuaSach","TacGia","NamXuatBan","NhaXuatBan","SoTrang","DonGia","ISBN"};
		String[] headers="MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");
		tableModel=new DefaultTableModel(headers,0);
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(table=new JTable(tableModel));
		
		table.setRowHeight(25);
		

		pnSouth.add(scroll);
		
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLuuSQL.addActionListener(this);
		table.addMouseListener(this);
		comboBox.addActionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		int row=table.getSelectedRow();
		txtMaSach.setText(table.getValueAt(row, 0).toString());//lay dong dang chon tren table
		txtTuaSach.setText(table.getValueAt(row, 1).toString());
		txtTacGia.setText(table.getValueAt(row, 2).toString());
		txtNamXuatBan.setText(table.getValueAt(row, 3).toString());
		txtNhaXuatBan.setText(table.getValueAt(row, 4).toString());
		txtSoTrang.setText(table.getValueAt(row,5).toString());
		txtDonGia.setText(table.getValueAt(row,6).toString());
		txtISBN.setText(table.getValueAt(row,7).toString());
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
	private void themActions()
	{
		try
		{
			String maSach=txtMaSach.getText();
			String tuaSach=txtTuaSach.getText();
			String tacGia=txtTacGia.getText();
			int namXuatBan=Integer.parseInt(txtNamXuatBan.getText());	
			String nhaXuatBan=txtNhaXuatBan.getText();
			int soTrang=Integer.parseInt(txtSoTrang.getText());
			double donGia=Double.parseDouble(txtDonGia.getText());
			String iSBN=txtISBN.getText();
			Sach sach=new Sach(maSach,tuaSach,tacGia,namXuatBan,nhaXuatBan,soTrang,donGia,iSBN);
			if(dao.themSach(sach))
			{
				String[] row ={maSach,tuaSach,tacGia,Integer.toString(namXuatBan),nhaXuatBan,Integer.toString(soTrang),Double.toString(donGia),iSBN+""};
				tableModel.addRow(row);
				xoaTrangActions();
				comboBox.addItem(maSach);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Trùng mã sách");
				txtMaSach.selectAll();
				txtMaSach.requestFocus();
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Lỗi nhập liệu");
			return;
		}
	}
	private void xoaActions()
	{
		int row=table.getSelectedRow();
		if(row!=-1)
		{
			String maCanXoa=((String) table.getModel().getValueAt(row,0));
			int kTra=JOptionPane.showConfirmDialog(this, "Chắc chắn xoá không","Chú ý",JOptionPane.YES_NO_OPTION);
			if (kTra==JOptionPane.YES_OPTION)
			{
				if(dao.xoaSach(maCanXoa))
					tableModel.removeRow(row);
			}
		}
	}
	private void xoaTrangActions()
	{
		txtMaSach.setText("");//lay dong dang chon tren table
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamXuatBan.setText("");
		txtNhaXuatBan.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMaSach.requestFocus();
	}
	private void timActions()
	{
		String maCanTim= (String) comboBox.getSelectedItem();
		try
		{
			int a=table.getRowCount();
	//		int maCanTim=Integer.parseInt(txtTim.getText());
			
//		String maCanTim=txtTim.getText();
			for (int i = 0; i < table.getRowCount(); i++) 
			{
				for (int j = 0; j < table.getColumnCount(); j++) 
				{
					if(table.getValueAt(i, j).toString().equals(maCanTim)) 
					{
						table.setRowSelectionInterval(i, i);
					}
				}
			
			}	
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Lỗi nhập liệu");
		}
	}
	private void luuActions()
	{
		try {
	           
            FileWriter writer = new FileWriter("thongTinSach.txt");
            PrintWriter out = new PrintWriter(writer);

            // Ghi tiêu đề của các cột
            for (int i = 0; i < table.getColumnCount(); i++) {
                out.print(table.getColumnName(i) + "\t");
            }
            out.println();

            // Ghi dữ liệu từ các hàng
            for (int i = 0; i < table.getRowCount(); i++) 
            {
                for (int j = 0; j < table.getColumnCount(); j++) 
                {
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
	private void suaActions()
	{
		String maSach=txtMaSach.getText();
		String tuaSach=txtTuaSach.getText();
		String tacGia=txtTacGia.getText();
		int namXuatBan=Integer.parseInt(txtNamXuatBan.getText());	
		String nhaXuatBan=txtNhaXuatBan.getText();
		int soTrang=Integer.parseInt(txtSoTrang.getText());
		double donGia=Double.parseDouble(txtDonGia.getText());
		String iSBN=txtISBN.getText();
		Sach sach=new Sach(maSach,tuaSach,tacGia,namXuatBan,nhaXuatBan,soTrang,donGia,iSBN);
		dao.capNhatSach(maSach, sach);
		int index=table.getSelectedRow();
		tableModel.setValueAt(tuaSach, index,1);
		tableModel.setValueAt(tacGia, index,2);
		tableModel.setValueAt(namXuatBan, index,3);
		tableModel.setValueAt(nhaXuatBan, index,4);
		tableModel.setValueAt(soTrang, index,5);
		tableModel.setValueAt(donGia, index,6);
		tableModel.setValueAt(iSBN, index,7);
		
		JOptionPane.showMessageDialog(this, "UPDATE COMPELETE");
		txtMaSach.setEditable(true);
		table.setCellSelectionEnabled(false);
//		btnSua.setEnabled(false);
		xoaTrangActions();
	}
	private void luuSQLActions()
	{
		Connection conn=null;
		try {
            // Kết nối tới cơ sở dữ liệu
            String url = "jdbc:sqlserver://localhost:3000;databaseName=Sach";
            String username = "siu";
            String password = "messivodichworldcupUCL0981";
            conn = DriverManager.getConnection(url, username, password);
    
            
            Statement stmt = conn.createStatement();
            String sql="";
            for (int i = 0; i < table.getRowCount(); i++) 
            {
                sql += "INSERT INTO thongTinSach (maSach,tuaSach,tacGia,namXuatBan,nhaXuatBan,soTrang,donGia,iSBN) VALUES ('" +
                      table.getValueAt(i, 0) + "','" +
                      table.getValueAt(i, 1) + "','" +
                      table.getValueAt(i, 2) + "','" +
                      table.getValueAt(i, 3) + "','" +
                      table.getValueAt(i, 4) + "','" +
                      table.getValueAt(i, 5) + "','" +
                      table.getValueAt(i, 6) + "','" +
                      table.getValueAt(i, 7) + 
                      "')";
                
            }
            stmt.executeUpdate(sql);
            // Đóng kết nối
            stmt.close();
            conn.close();
            
            JOptionPane.showMessageDialog(this,"Dữ liệu đã được lưu vào cơ sở dữ liệu!");
        } catch (SQLException e) 
		{
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Dữ liệu không lưu vào cơ sở dữ liệu do bị lỗi!");
        }
	}
	public void actionPerformed(ActionEvent e) 
	{
		Object o=e.getSource();
		timActions();
		if(o.equals(btnThem))
			themActions();
		if(o.equals(btnXoa))
			xoaActions();
		if(o.equals(btnXoaRong))
			xoaTrangActions();	
		if(o.equals(btnSua))
			suaActions();
		if(o.equals(btnLuu))
			luuActions();
		if(o.equals(btnLuuSQL))
			luuSQLActions();
		
	}

}
