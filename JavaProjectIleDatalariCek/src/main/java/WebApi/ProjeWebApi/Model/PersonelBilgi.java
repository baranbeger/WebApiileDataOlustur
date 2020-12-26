package WebApi.ProjeWebApi.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PersonelBilgi {
	
	private String adi;
	private String soyadi;
	private String tcno;
	private String telno;
	public PersonelBilgi() {
		// TODO Auto-generated constructor stub
	}

	public PersonelBilgi(String adi, String soyadi, String tcno, String telno) {
		super();
		this.adi = adi;
		this.soyadi = soyadi;
		this.tcno = tcno;
		this.telno = telno;
	}

	public String getAdi() {
		return adi;
	}
	
	@XmlElement
	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}
	@XmlElement
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getTcno() {
		return tcno;
	}
	@XmlElement
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getTelno() {
		return telno;
	}
	@XmlElement
	public void setTelno(String telno) {
		this.telno = telno;
	}
	
	
	
	

}
