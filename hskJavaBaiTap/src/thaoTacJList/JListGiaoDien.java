package thaoTacJList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class JListGiaoDien extends JFrame implements ActionListener
{
	JLabel lblTitle;
	JButton btnChan, btnLe, btnTo, btnXoa, btnNhap;
	JTextField txtNhap;
	JCheckBox chkAm;
	DefaultListModel <Integer> lstmodel;
	JSplitPane split;
	public JListGiaoDien()
	{
		
		setTitle("Thao tác trên JList");
		split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		//North
		JPanel pNorth=new JPanel();
		pNorth.add(lblTitle=new JLabel("Thao tác trên JList-CheckBox"));
		lblTitle.setFont(new Font("Times new Roman",Font.BOLD,30));
		lblTitle.setForeground(Color.BLUE);
		add(pNorth,BorderLayout.NORTH);
		//Center vùng center tách 2 thành left và right
		//left
		JPanel pleft=new JPanel();
		pleft.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red),"Chọn tác vụ"));
		pleft.setLayout(new BoxLayout(pleft,BoxLayout.X_AXIS));
		//
		
		pleft.add(btnChan=new JButton("Tô đen số chẵn"));
	
		pleft.add(btnChan=new JButton("Tô đen số lẻ"));

		pleft.add(btnChan=new JButton("Tô đen số nguyên tố"));
		pleft.add(Box.createVerticalStrut(5));
		pleft.add(btnChan=new JButton("Bỏ tô đen"));
	
		pleft.add(btnChan=new JButton("Xoá các giá trị tô đen"));

		pleft.add(btnChan=new JButton("Tổng các giá trị trong JList"));
		pleft.setLayout(new BoxLayout(pleft, BoxLayout.Y_AXIS));
		//right
		lstmodel=new DefaultListModel<Integer>();
		JList<Integer> lstds = new JList<Integer>(lstmodel);
		lstds.setVisibleRowCount(19);
		lstds.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JPanel pright,p1;
		pright=new JPanel();
		pright.setLayout(new BorderLayout());
		pright.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red),"Nhập thông tin"));
		//
		p1=new JPanel();
		p1.add(btnNhap=new JButton("Nhập"));
		p1.add(txtNhap=new JTextField(20));
		p1.add(chkAm=new JCheckBox("Cho nhập số âm"));
		
		pright.add(p1,BorderLayout.NORTH);
		pright.add(new JScrollPane(lstds),BorderLayout.CENTER);
		//tạo thanh kéo
		split.setRightComponent(pright);
		split.setLeftComponent(pleft);
		add(split, BorderLayout.CENTER);
		//South
		JPanel psouth=new JPanel();
		JButton btnDong=new JButton("Đóng chương trình");
		btnDong.setAlignmentX(CENTER_ALIGNMENT);
		psouth.add(btnDong);
		pright.setBorder(BorderFactory.createTitledBorder(""));
		pright.setBorder(BorderFactory.createLineBorder(Color.RED));
		pright.setBackground(Color.gray);
		add(psouth,BorderLayout.SOUTH);
		
		setSize(650,500);
		setVisible(true);
	//	setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public boolean KTNT(int n)
	{
		int i=2;
		while(n%i!=0)
		{
			i++;
		}
		if(i==n)
			return true;
		return false;
	}
	public static void main(String[] args) 
	{
		new JListGiaoDien();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String nhap;
		Object obj=e.getSource();
		nhap=txtNhap.getText();
		if(obj.equals(btnNhap))
		{
			if(nhap.trim().equals(""))//kiem tra nhap rong
			{
				JOptionPane.showMessageDialog(this,"ERROR INPUT");
			}
			else
			{
				try
				{
					lstmodel.addElement(Integer.parseInt(txtNhap.getText()));
					txtNhap.setText("");
					txtNhap.requestFocus();//dua con tro len text dau tien
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(this,"ERROR FONT");
					txtNhap.selectAll();
					txtNhap.requestFocus();
				}
			}
			if(obj.equals(btnChan))
			{
			
			}
			else
			{
				
			}
		}
	}
}
