package Module2_bai11;

public class CongNhan {
	private String mHo;
	private String mTen;
	private int mSoSP;
	
	public CongNhan(String mHo, String mTen, int mSoSP) {
		this.mHo = mHo;
		this.mTen = mTen;
		this.mSoSP = mSoSP;
	}
	public CongNhan() {
		
	}
	public String getmHo() {
		return mHo;
	}
	public void setmHo(String mHo) {
		this.mHo = mHo;
	}
	public String getmTen() {
		return mTen;
	}
	public void setmTen(String mTen) {
		this.mTen = mTen;
	}
	public int getmSoSP() {
		return mSoSP;
	}
	public void setmSoSP(int mSoSP) {
		this.mSoSP = mSoSP;
	}
	
	public double tinhLuong() {
		if(getmSoSP() <= 199 && getmSoSP() >= 1)
			return 0.5 * getmSoSP();
		if(getmSoSP() >= 200 && getmSoSP() <= 399)
			return 0.55 * getmSoSP();
		if(getmSoSP() >= 400 && getmSoSP() <= 599)
			return 0.6 * getmSoSP();
		if(getmSoSP() >= 600)
			return 0.65 * getmSoSP();
		return 0;
	}
	@Override
	public String toString() {
		return String.format("HO va ten: %s %s. So luong SP: %d\n", getmHo(), getmTen(), getmSoSP());
	}
	
	
	
}
