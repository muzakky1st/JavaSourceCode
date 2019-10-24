package com.example.Spring;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_fitness")
public class Fitness {
	private long id;
	private String nama_peserta;
	private String dept;
	private String tgl_pendaftaran;
	private Long biaya;

	protected Fitness() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public String getNama_peserta() {
		return nama_peserta;
	}
	public void setNama_peserta(String nama_peserta) {
		this.nama_peserta = nama_peserta;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getTgl_pendaftaran() {
		return tgl_pendaftaran;
	}
	public void setTgl_pendaftaran(String tgl_pendaftaran) {
		this.tgl_pendaftaran = tgl_pendaftaran;
	}
	public Long getBiaya() {
		return biaya;
	}
	public void setBiaya(Long biaya) {
		this.biaya = biaya;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
