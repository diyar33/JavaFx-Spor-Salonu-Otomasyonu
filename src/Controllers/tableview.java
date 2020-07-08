package Controllers;

public class tableview {
	private String ad;
	private String amac;
	private String soyad;
	private String tel;
	private String tarih;
	private int id;
	
	public tableview(String ad,String amac,String soyad,String tel,String tarih,int id) {
		this.ad=ad;
		this.amac=amac;
		this.soyad=soyad;
		this.tel=tel;
		this.tarih=tarih;
		this.id=id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public String getAmac() {
		return amac;
	}

	public String getSoyad() {
		return soyad;
	}

	public String getTel() {
		return tel;
	}

	public String getTarih() {
		return tarih;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public void setAmac(String amac) {
		this.amac = amac;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

}
