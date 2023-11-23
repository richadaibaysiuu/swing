package tableTTNV;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ThongTin extends JFrame implements ActionListener
{
	JPanel pnNorth, pnCenter, pnSouth;
	DefaultTableModel model;
	JTable table;
	Box b2;
	JTextField txtManv, txtHo, txtTenNV, txtTuoi, txtTienLuong, txtTimKiem;
	JLabel lbManv, lbHo, lbTen, lbTuoi, lbPhai, lbTienLuong;
	JButton btnThem, btnXoaTrang, btnXoa, btnLuu, btnTim, btnSua;
	JRadioButton radNam, radNu;
	public ThongTin()
	{
		setTitle("^-^"); 
		setSize(1000,700);
		taoGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	public void taoGUI()
	{
		JPanel pnBorder=new JPanel();
		pnBorder.setLayout(new BorderLayout());
		//tao tieu de
		JPanel pnNorth=new JPanel();
		JLabel lbTitle=new JLabel("THONG TIN NHAN VIEN");
		lbTitle.setForeground(Color.BLUE);
		lbTitle.setFont(new Font("Arial",Font.BOLD,20));
		pnNorth.add(lbTitle);
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		add(pnBorder);
		//Center
		pnCenter=new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
		Box b=Box.createVerticalBox();
		Box b1=Box.createHorizontalBox();
		Box b2=Box.createHorizontalBox();
		Box b3=Box.createHorizontalBox();
		Box b4=Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		pnCenter.add(b);
		pnCenter.add(Box.createVerticalStrut(10));
		lbManv= new JLabel("Ma nhan vien:");
		lbHo= new JLabel("Ho:");
		lbTen= new JLabel("Ten nhan vien:");
		lbPhai= new JLabel("Tuoi:");
		lbManv= new JLabel("Phai:");
		lbTienLuong=new JLabel("Tien Luong");
		//tao text
		//Dong 1
		txtManv=new JTextField();
		b1.add(lbManv);
		b1.add(txtManv);
		//Dong 2
		txtHo= new JTextField();
		txtTenNV= new JTextField();
		b2.add(lbManv);
		b2.add(txtManv);
		b2.add(lbTen);
		b2.add(txtTenNV);
		lbHo.setPreferredSize(lbManv.getPreferredSize());//set cung size
		//Dong 3
		txtTuoi=new JTextField();
		
		radNam=new JRadioButton("Nam",true);
		radNam.setEnabled(true);
		radNu=new JRadioButton("Nu");
		ButtonGroup group=new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		b3.add(lbTuoi);
		b3.add(txtTuoi);
		b3.add(lbPhai);
		b3.add(radNam);
		b3.add(radNu);
		//Dong 4
		b4.add(lbTienLuong);
		txtTienLuong=new JTextField();
		//setPreferredSize
		lbTuoi.setPreferredSize(lbManv.getPreferredSize());
		lbPhai.setPreferredSize(lbManv.getPreferredSize());
		lbTienLuong.setPreferredSize(lbManv.getPreferredSize());
		pnBorder.add(pnCenter,BorderLayout.CENTER);
	//	taoBang();
	}
	public void taoBang()
	{
		JPanel pnTable=new JPanel();
		model=new DefaultTableModel();
		table=new JTable(model);
		model.addColumn("Ma NV");
		model.addColumn("Ho");
		model.addColumn("Ten");
		model.addColumn("Phai");
		model.addColumn("Tuoi");
		model.addColumn("Tien Luong");
		//tao du lieu con
		TableColumn phaicolumn= table.getColumnModel().getColumn(3);
		JComboBox comboBox=new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nu");
		phaicolumn.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn column=new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer=new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center=new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		//tao thanh scroll
		JScrollPane sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(650,250));
		pnCenter.add(sp);
		//chuc nang
		JSplitPane split; 
		
	}
	public static void main(String[] args) 
	{
		new ThongTin();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}

}
