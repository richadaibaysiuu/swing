package Module2_bai11;


public class DSCongNhan {
	private CongNhan[] listCongNhan;
	private int slCN;
	private static int count = 0;

	public DSCongNhan(CongNhan[] listCongNhan, int slCN) {
		this.listCongNhan = listCongNhan;
		this.slCN = slCN;
	}

	public CongNhan[] getListCongNhan() {
		return listCongNhan;
	}

	public void setListCongNhan(CongNhan[] listCongNhan) {
		this.listCongNhan = listCongNhan;
	}
	

	public int getSlCN() {
		return slCN;
	}

	public void setSlCN(int slCN) {
		this.slCN = slCN;
	}
	
	public boolean addCongNhan(CongNhan cn) {
		if(count > slCN - 1)
			return false;
		else {
			listCongNhan[count] = cn;
			count++;
			return true;
		}
	}
	public String layDSCongNhan() {
		String output = "";
		for(CongNhan cn : listCongNhan) {
			output += cn.toString();
		}
		return output;
	}
	public String DSCongNhanTren200() {
		String output = "";
		for(CongNhan cNhan : listCongNhan) {
			if(cNhan.getmSoSP() >= 200)
				output += cNhan.toString();
		}
		return output;
	}
	public String sapxepgiamdan() {
		CongNhan temp;
		for(int i = 0; i < count; i++)
			for(int j = i; j < count; j++) {
				if(listCongNhan[i].getmSoSP() < listCongNhan[j].getmSoSP()) {
					temp = listCongNhan[i];
					listCongNhan[i] = listCongNhan[j];
					listCongNhan[j] = temp;
				}
			}
		String output="";
		for(CongNhan cn: listCongNhan) {
			output += cn.toString();
		}
		return output;
	}
}
