package giaiPtBac2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaoDienPTBac2 extends JFrame implements ActionListener
{

	private JButton buttonGiai, buttonXoaRong, buttonThoat;
	private JTextField textA, textB, textC, textKQ;
	
	public GiaoDienPTBac2()
	{
		//5 ham set
		setTitle("^-^");
		setSize(500,400);
		taoGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	}
	private void taoGUI()
	{
		//tao khung tren
		JPanel panelNorth;
		add(panelNorth=new JPanel(),BorderLayout.NORTH);
		panelNorth.setBackground(Color.CYAN);
		//tao tieu de
		JLabel tieuDe;
		panelNorth.add(tieuDe=new JLabel("GIAI PHUONG TRINH BAC 2"));
		tieuDe.setFont(new Font("Times new Roman",Font.BOLD,20));//Font(phong chu,kieu chu, co chu)
		//tao khung giua
		JPanel panelCenter;
		add(panelCenter=new JPanel(),BorderLayout.CENTER);
		//tao chu
		JLabel nhapA, nhapB, nhapC, ketQua;
		int x=35;
		panelCenter.add(nhapA=new JLabel("Nhập a:"));
		panelCenter.add(textA=new JTextField(x));
		
		panelCenter.add(nhapB=new JLabel("Nhập b:")); 
		panelCenter.add(textB=new JTextField(x));
		
		panelCenter.add(nhapC=new JLabel("Nhập c:"));
		panelCenter.add(textC=new JTextField(x));
			
		panelCenter.add(ketQua=new JLabel("Kết quả:")); 
		panelCenter.add(textKQ=new JTextField(x));
		textKQ.setEditable(false);//ko cho nhap
		//tao khung duoi
		JPanel panelSouth;
		add(panelSouth=new JPanel(), BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Chon tác vụ"));
		//Dung FlowLayout dinh dang
		panelSouth.add(buttonGiai=new JButton("Giải"));
		panelSouth.add(buttonXoaRong=new JButton("Xoá"));
		panelSouth.add(buttonThoat=new JButton("Thoát"));
		//ham xu li su kien
		buttonGiai.addActionListener(this);
		buttonXoaRong.addActionListener(this);
		buttonThoat.addActionListener(this);
		
	}
	public static void main(String[] args) 
	{
		new GiaoDienPTBac2();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == buttonGiai) 
        {
            // Get the input values
            double a = Double.parseDouble(textA.getText());
            double b = Double.parseDouble(textB.getText());
            double c = Double.parseDouble(textC.getText());

            // Calculate the solutions
            double delta = b * b - 4 * a * c;
            if (delta < 0) 
            {
                textKQ.setText("Phương trình vô nghiệm");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                textKQ.setText("x="+Double.toString(x));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                textKQ.setText("x1="+Double.toString(x1)+"x2="+Double.toString(x2));
            }
        } 
		else 
        {
			if (e.getSource() == buttonXoaRong) 
			{
				textA.setText("");
	            textB.setText("");
	            textC.setText("");
	            textKQ.setText("");// Clear the input and output fields
			}
			else
			{
				if (e.getSource() == buttonThoat) 
				{
					System.exit(0);
				}
			}
            
        }
		
	}

}
