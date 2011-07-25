/**
* Created by: Muhammad Amiral
* Feb 19, 2011
*/

package com.tangerangmaps.object;

import android.os.Parcel;
import android.os.Parcelable;


public class PoiLokasi implements Parcelable{

	private String ID;
	private String idKategori;
	private String nama;
	private String alamat;
	private String idKecamatan;
	private String idKelurahan;
	private String telp;
	private String fax;
	private String email;
	private String website;
	private String keterangan;
	private String lat;
	private String lon;
	private String imageUrl;
	private String tanggalInput;
	private String kontribName;
	private String kontribEMail;
	private double jarak;
	
	
	public PoiLokasi() {
		super();
	}
	public PoiLokasi(String iD, String idKategori, String nama, String alamat,
			String idKecamatan, String idKelurahan, String telp, String fax,
			String email, String website, String keterangan, String lat,
			String lon, String imageUrl, String tanggalInput, String kontribName, String kontribEmail) {
		super();
		ID = iD;
		this.idKategori = idKategori;
		this.nama = nama;
		this.alamat = alamat;
		this.idKecamatan = idKecamatan;
		this.idKelurahan = idKelurahan;
		this.telp = telp;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.keterangan = keterangan;
		this.lat = lat;
		this.lon = lon;
		this.imageUrl = imageUrl;
		this.tanggalInput = tanggalInput;
		this.kontribName = kontribName;
		this.kontribEMail = kontribEmail;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getIdKategori() {
		return idKategori;
	}
	public void setIdKategori(String idKategori) {
		this.idKategori = idKategori;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getIdKecamatan() {
		return idKecamatan;
	}
	public void setIdKecamatan(String idKecamatan) {
		this.idKecamatan = idKecamatan;
	}
	public String getIdKelurahan() {
		return idKelurahan;
	}
	public void setIdKelurahan(String idKelurahan) {
		this.idKelurahan = idKelurahan;
	}
	public String getTelp() {
		return telp;
	}
	public void setTelp(String telp) {
		this.telp = telp;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTanggalInput() {
		return tanggalInput;
	}
	public void setTanggalInput(String tanggalInput) {
		this.tanggalInput = tanggalInput;
	}
	public String getKontribName() {
		return kontribName;
	}
	public void setKontribName(String kontribName) {
		this.kontribName = kontribName;
	}
	public String getKontribEMail() {
		return kontribEMail;
	}
	public void setKontribEMail(String kontribEMail) {
		this.kontribEMail = kontribEMail;
	}

	public double getJarak() {
		return jarak;
	}
	public void setJarak(double jarak) {
		this.jarak = jarak;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(ID);
		dest.writeString(idKategori);
		dest.writeString(nama);
		dest.writeString(alamat);
		dest.writeString(tanggalInput);
		dest.writeString(idKecamatan);
		dest.writeString(idKelurahan);
		dest.writeString(telp);
		dest.writeString(fax);
		dest.writeString(email);
		dest.writeString(website);
		dest.writeString(keterangan);
		dest.writeString(lat);
		dest.writeString(lon);
		dest.writeString(imageUrl);
		dest.writeString(kontribName);
		dest.writeString(kontribEMail);
		dest.writeDouble(jarak);
	}
	
	public static final Parcelable.Creator<PoiLokasi> CREATOR = new Parcelable.Creator<PoiLokasi>() {
        public PoiLokasi createFromParcel(Parcel in) {
            return new PoiLokasi(in);
        }

        public PoiLokasi[] newArray(int size) {
            return new PoiLokasi[size];
        }
    };
    
 // example constructor that takes a Parcel and gives you an object populated with it's values
    private PoiLokasi(Parcel in) {
    	ID = in.readString();
    	idKategori = in.readString();
    	nama = in.readString();
    	alamat = in.readString();
    	tanggalInput = in.readString();
    	idKecamatan = in.readString();
    	idKelurahan = in.readString();
    	telp = in.readString();
    	fax = in.readString();
    	email = in.readString();
    	website = in.readString();
    	keterangan = in.readString();
    	lat = in.readString();
    	lon = in.readString();
    	imageUrl = in.readString();
    	kontribName = in.readString();
    	kontribEMail = in.readString();
    	jarak = in.readDouble();
    }

}
