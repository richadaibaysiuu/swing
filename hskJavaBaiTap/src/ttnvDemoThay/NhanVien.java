package ttnvDemoThay;

import java.util.Objects;

public class NhanVien 
{
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return maNV == other.maNV;
	}
	/**
	 * @return the maNV
	 */
	public int getMaNV() {
		return maNV;
	}
	/**
	 * @param maNV the maNV to set
	 */
	public void setMaNV(int maNV) 
	{
		if(maNV>0)
			this.maNV = maNV;
		else
			this.maNV=0;
	}
	/**
	 * @return the tuoi
	 */
	public int getTuoi() {
		return tuoi;
	}
	/**
	 * @param tuoi the tuoi to set
	 */
	public void setTuoi(int tuoi)
	{
		if(tuoi>20||tuoi >80)
			this.tuoi = tuoi;
		else
			this.tuoi=10;
	}
	/**
	 * @return the ho
	 */
	public String getHo() {
		return ho;
	}
	/**
	 * @param ho the ho to set
	 */
	public void setHo(String ho) 
	{
		if(ho.trim().equals(""))
			this.ho="Null";
		else
			this.ho = ho;
	}
	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) 
	{
		if(ten.trim().equals(""))
			this.ho="Null";
		else
			this.ten = ten;
	}
	/**
	 * @return the phai
	 */
	public boolean isPhai() {
		return phai;
	}
	/**
	 * @param phai the phai to set
	 */
	public void setPhai(boolean phai) 
	{
		this.phai = phai;
	}
	/**
	 * @return the tienLuong
	 */
	public double getTienLuong() {
		return tienLuong;
	}
	/**
	 * @param tienLuong the tienLuong to set
	 */
	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}
	private int maNV, tuoi;
	private String ho,ten;
	private boolean phai;
	private double tienLuong;
	public NhanVien(int maNV, int tuoi, String ho, String ten, boolean phai, double tienLuong) 
	{
		setHo(ho);
		setMaNV(maNV);
		setPhai(phai);
		setTen(ten);
		setTienLuong(tienLuong);
		setTuoi(tuoi);
	}
	public String toString()
	{
		return maNV+";"+ho+";"+ten+";"+phai+";"+tuoi+";"+tienLuong;
	}
	
}
