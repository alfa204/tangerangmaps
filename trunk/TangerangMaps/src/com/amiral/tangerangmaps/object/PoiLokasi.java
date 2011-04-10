/**
* Created by: Muhammad Amiral
* Feb 19, 2011
*/

package com.amiral.tangerangmaps.object;


public class PoiLokasi {

	public String ID;
	public String idKategori;
	public String nama;
	public String alamat;
	public String idKecamatan;
	public String idKelurahan;
	public String telp;
	public String fax;
	public String email;
	public String website;
	public String keterangan;
	public String lat;
	public String lon;
	public String imageUrl;
	public String tanggalInput;
	
	
	public PoiLokasi() {
		super();
	}
	public PoiLokasi(String iD, String idKategori, String nama, String alamat,
			String idKecamatan, String idKelurahan, String telp, String fax,
			String email, String website, String keterangan, String lat,
			String lon, String imageUrl, String tanggalInput) {
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
	
	
}
