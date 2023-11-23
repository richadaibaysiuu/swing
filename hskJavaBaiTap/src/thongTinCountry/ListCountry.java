package thongTinCountry;

import java.util.ArrayList;

import ttnvDemoThay.NhanVien;

public class ListCountry 
{
	/**
	 * @return the list
	 */
	public ArrayList<Country> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Country> list) {
		this.list = list;
	}

	private ArrayList<Country> list;
	public ListCountry()
	{
		setList(new ArrayList<Country>());
	}
	public boolean themCountry(Country c)
	{
		if(!list.contains(c))
		{
			list.add(c);
			return true;
		}
		return false;
	}
	public Country timKiem(String country)
	{
		for(Country c:list)
		{
			if(c.getCountry().equalsIgnoreCase(country))
				return c;
		}
		return null;
	}
	public boolean xoaCountry(String country)
	{
		Country c=timKiem(country);
		if(list!=null)
		{
			list.remove(c);
			return true;
		}
		return false;
	}
}
