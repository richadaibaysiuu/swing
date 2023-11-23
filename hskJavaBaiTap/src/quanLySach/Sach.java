package quanLySach;

import java.time.LocalDate;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Sach 
{
	/**
	 * @return the soTrang
	 */
	public int getSoTrang() {
		return soTrang;
	}
	/**
	 * @param soTrang the soTrang to set
	 */
	public void setSoTrang(int soTrang) 
	{
		if(soTrang>0)
			this.soTrang = soTrang;
		else
			this.soTrang=0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}
	/**
	 * @return the maSach
	 */
	public String getMaSach() {
		return maSach;
	}
	/**
	 * @param maSach the maSach to set
	 */
	public static boolean isNumericString(String s) 
	{
	    for (int i = 1; i < s.length(); i++) 
	    {
	        if (!Character.isDigit(s.charAt(i))) 
	        {
	            return false;
	        }
	    }
	    return true;
	}
	public void setMaSach(String maSach) 
	{
		if(!maSach.trim().equals("") && Character.isUpperCase(maSach.charAt(0)) && maSach.length()==4 && isNumericString(maSach)==true)
			this.maSach = maSach;
		else
			JOptionPane.showMessageDialog(null,"Lỗi chuoi");
	}
	
	/**
	 * @return the tuaSach
	 */
	public String getTuaSach() {
		return tuaSach;
	}
	/**
	 * @param tuaSach the tuaSach to set
	 */
	public void setTuaSach(String tuaSach) 
	{
		if(tuaSach.trim().equals(""))
			JOptionPane.showMessageDialog(null,"Lỗi chuỗi");
		else
			this.tuaSach = tuaSach;
	}
	/**
	 * @return the tacGia
	 */
	public String getTacGia() {
		return tacGia;
	}
	/**
	 * @param tacGia the tacGia to set
	 */
	public void setTacGia(String tacGia)
	{
		
		if(tacGia.trim().equals(""))
			JOptionPane.showMessageDialog(null,"Lỗi chuoi");
		else
			this.tacGia = tacGia;
	}
	/**
	 * @return the nhaXuatBan
	 */
	public String getNhaXuatBan() 
	{
		return nhaXuatBan;
	}
	/**
	 * @param nhaXuatBan the nhaXuatBan to set
	 */
	public void setNhaXuatBan(String nhaXuatBan) 
	{
		if(nhaXuatBan.trim().equals(""))
			this.nhaXuatBan="null";
		else
			this.nhaXuatBan = nhaXuatBan;
	}
	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return iSBN;
	}
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		this.iSBN = iSBN;
	}
	/**
	 * @return the namXuatBan
	 */
	public int getNamXuatBan() {
		return namXuatBan;
	}
	/**
	 * @param namXuatBan the namXuatBan to set
	 */
	LocalDate today=LocalDate.now();
	public void setNamXuatBan(int namXuatBan) 
	{
		if(namXuatBan>=1900 && namXuatBan<=today.getYear())
			this.namXuatBan = namXuatBan;
		else
			JOptionPane.showMessageDialog(null,"Lỗi năm");
	}
	/**
	 * @return the donGia
	 */
	public double getDonGia() {
		return donGia;
	}
	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(double donGia) 
	{
		if(donGia>0)
			this.donGia = donGia;
		else
			this.donGia=0;
	}
	private String maSach, tuaSach, tacGia, nhaXuatBan, iSBN;
	private int namXuatBan, soTrang;
	private double donGia;
	public Sach(String maSach, String tuaSach, String tacGia, int namXuatBan, String nhaXuatBan,int soTrang, double donGia, String iSBN)
	{
		setDonGia(donGia);
		setISBN(iSBN);
		setMaSach(maSach);
		setNamXuatBan(namXuatBan);
		setNhaXuatBan(nhaXuatBan);
		setSoTrang(soTrang);
		setTacGia(tacGia);
		setTuaSach(tuaSach);
	}
	public String toString()
	{
		return maSach+";"+tuaSach+";"+tacGia+";"+namXuatBan+";"+nhaXuatBan+";"+soTrang+";"+donGia+";"+iSBN;
	}
}
