package quanLySach;

import java.util.ArrayList;

import ttnvDemoThay.NhanVien;

public class ListSach 
{
	/**
	 * @return the list
	 */
	public ArrayList<Sach> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Sach> list) {
		this.list = list;
	}

	private ArrayList<Sach> list;
	public ListSach()
	{
		setList(new ArrayList<Sach>());
	}
	public boolean themSach(Sach s)
	{
		if(list.contains(s))
		{
			return false;
		}
		else
		{
			list.add(s);
			return true;
		}
	}
	public Sach timKiem(String maSach)
	{
		for(Sach s:list)
		{
			if(s.getMaSach().equalsIgnoreCase(maSach))
				return s;
		}
		return null;
	}
	public boolean xoaSach(String maCanXoa)
	{
		Sach s=timKiem(maCanXoa);
		if(list!=null)
		{
			list.remove(s);
			return true;
		}
		return false;
	}
	public boolean capNhatSach(String maOld,Sach sachNew)
	{
		Sach sachOld=timKiem(maOld);
		if(list.contains(sachOld))
		{
			sachOld=list.get(list.indexOf(sachOld));
			sachOld.setTacGia(sachOld.getTacGia());
			sachOld.setDonGia(sachOld.getDonGia());
			sachOld.setISBN(sachOld.getISBN());
			sachOld.setNamXuatBan(sachOld.getNamXuatBan());
			sachOld.setSoTrang(sachOld.getSoTrang());
			sachOld.setNhaXuatBan(sachOld.getNhaXuatBan());
			sachOld.setTuaSach(sachOld.getTuaSach());
			return true;
			
		}
		return false;
	}
}
