package ttnvDemoThay;

public class Starting 
{
	
	public static void main(String[] args)
	{
		DanhSachNhanVien dao=new DanhSachNhanVien();
		new FrmNhanVien(dao).setVisible(true);
		
	}

}
