package soNguyenTo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HienThiSNT extends JFrame implements ActionListener 
{
	private JTextField textNumber;
	private JButton btnGenerate;
	private JTextArea textArea;
	public HienThiSNT()
	{
		setTitle("Primes");
		setSize(400,300);
		taoGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	private void taoGUI()
	{
		JPanel panelNorth,panelCenter;
		add(panelNorth=new JPanel(),BorderLayout.NORTH);
		panelNorth.add(textNumber=new JTextField(17));
		panelNorth.add(btnGenerate=new JButton("Generate"));
		//center
		add(panelCenter=new JPanel());
		panelCenter.add(textArea=new JTextArea(10,25));
		panelCenter.setFocusable(false);
		btnGenerate.addActionListener(this);
	}
	

	public static void main(String[] args) 
	{
		new HienThiSNT();
	}
	public boolean isPrime(int a) 
	{
	    if (a < 2) {
	        return false;
	    }
	    for (int i = 2; i <= Math.sqrt(a); i++) {
	        if (a % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object o=e.getSource();
		if(o.equals(btnGenerate))
		{
			 int a = Integer.parseInt(textNumber.getText());
			 if(isPrime(a))
			 {
				 textArea.append(Integer.toString(a)+"\n");
			 }
		}
		
	}

}
