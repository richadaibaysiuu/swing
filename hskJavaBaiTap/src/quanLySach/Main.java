package quanLySach;



public class Main {

	public static void main(String[] args) 
	{
		
		ListSach dao=new ListSach();
		new FrmSach(dao).setVisible(true);
	}

}
