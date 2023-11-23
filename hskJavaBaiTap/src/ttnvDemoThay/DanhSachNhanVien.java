package ttnvDemoThay;

import java.util.ArrayList;



public class DanhSachNhanVien 
{
	/**
	 * @return the list
	 */
	public ArrayList<NhanVien> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<NhanVien> list) 
	{
		this.list = list;
	}
	private ArrayList<NhanVien> list;
	public DanhSachNhanVien()
	{
		setList(new ArrayList<NhanVien>());
	}
	public boolean themNhanVien(NhanVien nv)
	{
		if(list.contains(nv))
		{
			return false;
		}
		else
		{
			list.add(nv);
			return true;
		}
	}
	public NhanVien timKiem(int maNV)
	{
		for(NhanVien nv:list)
		{
			if(nv.getMaNV()==maNV)
				return nv;
		}
		return null;
	}
	public boolean xoaNhanVien(int maNV)
	{
		NhanVien nv=timKiem(maNV);
		if(list!=null)
		{
			list.remove(nv);
			return true;
		}
		return false;
	}
	public boolean timKiemNhanVien(int maCanTim)
	{
		NhanVien nv=timKiem(maCanTim);
		if(nv!=null)
			return true;
		else
			return false;
	}
	
}
