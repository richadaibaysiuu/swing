package Module2_bai11;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DSCongNhan lst = new DSCongNhan(new CongNhan[3], 3);
		if(lst.addCongNhan(new CongNhan("nguyen", "linh", 250)))
			System.out.println("Them thanh cong");
		else {
			System.out.println("Them ko thanh cong");
		}
		if(lst.addCongNhan(new CongNhan("nguyen", "nam", 300)))
			System.out.println("Them thanh cong");
		else {
			System.out.println("THem ko thanh cong");
		}
		if(lst.addCongNhan(new CongNhan("a", "e", 150)))
			System.out.println("Them thanh cong");
		else {
			System.out.println("Them ko thanh cong");
		}
		
		System.out.println(lst.layDSCongNhan());
		System.out.println("SAP XEP THEO SL GIAM DAN\n");
		System.out.println(lst.sapxepgiamdan());
		System.out.println("DS CONG NHAN LAM TREN 200 SP\n");
		System.out.println(lst.DSCongNhanTren200());
		
		
	}

}
