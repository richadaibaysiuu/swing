package thaoTacJList;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JListCheckBox extends JFrame implements ActionListener
{
	public JListCheckBox()
	{
		setTitle("Thao tac tren JList");
		setSize(400,300);
		taoGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	public void taoGUI()
	{
		JPanel panelNorth;
		add(panelNorth=new JPanel(),BorderLayout.NORTH);
		JLabel tieuDe;
		panelNorth.add(tieuDe=new JLabel("Thao tac tren JList - Checkbox"));
		tieuDe.setFont(new Font("VNI-Times",Font.BOLD,20));
	}
	public static void main(String[] args) 
	{
		new JListCheckBox();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}

}
