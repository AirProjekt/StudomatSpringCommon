package hr.web.aplikacije.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="STUDOMAT.KOLEGIJ")
public class Kolegij implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7420820532969121713L;
	public static final int VRSTA_KOLEGIJA_OBVEZNI_ID = 1;
	public static final int VRSTA_KOLEGIJA_IZBORNI_ID = 2;
	
	@Id
	@Column(name="KOLEGIJ_ID")
	@GeneratedValue
	private int id;
	
	@Column(name="NAZIV")
	@NotNull(message="Naziv kolegija se mora obvezno ispuniti!")
	@Size(min=1, max=30, message="Duljina teksta mora biti izmeðu 1 i 30")
	private String nazivKolegija;
	
	@Column(name = "VRSTA_KOLEGIJA")
	@Enumerated(EnumType.ORDINAL)
	@JoinTable(name = "STUDOMAT.VRSTA_KOLEGIJA", joinColumns = @JoinColumn(name = "NAZIV"))
	private VrstaKolegija vrstaKolegija;
	
	@Column(name="ECTS")
	@Min(value = 3, message = "Broj ECTS-a mora biti najmanje 3")
	@Max(value = 10, message = "Broj ECTS-a može biti maksimalno 10")
	@NotNull(message="Broj ECTS-a se mora obvezno ispuniti!")
	private Integer ects;
	
	@Transient
	private boolean odabran;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "STUDOMAT.UPIS",
	joinColumns = @JoinColumn(name = "KOLEGIJ_ID"),
	inverseJoinColumns = @JoinColumn(name = "KORISNIK_ID"))
	private Set<Korisnik> korisnici = new HashSet<Korisnik>();
	
	
	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	
	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	
	
	
	public Kolegij(){
		
	}
	
	
	public Kolegij(int id, String nazivKolegija, VrstaKolegija vrstaKolegija, int ects) {
		this.id = id;
		this.nazivKolegija = nazivKolegija;
		this.vrstaKolegija = vrstaKolegija;
		this.ects = ects;
	}
	public VrstaKolegija getVrstaKolegija() {
		return vrstaKolegija;
	}


	public void setVrstaKolegija(VrstaKolegija vrstaKolegija) {
		this.vrstaKolegija = vrstaKolegija;
	}


	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNazivKolegija() {
		return nazivKolegija;
	}
	
	public void setNazivKolegija(String nazivKolegija) {
		this.nazivKolegija = nazivKolegija;
	}
	
	public Integer getEcts() {
		return ects;
	}
	
	public void setEcts(Integer ects) {
		this.ects = ects;
	}
	
	public boolean isOdabran() {
		return odabran;
	}
	
	public void setOdabran(boolean odabran) {
		this.odabran = odabran;
	}
	
	
	

}
