package hr.web.aplikacije.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="STUDOMAT.KORISNIK")
public class Korisnik {
	
	@Id
	@Column(name="KORISNIK_ID")
	@GeneratedValue
	private int id;
	
	@Column(name="KORISNICKO_IME")
	private String userName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "STUDOMAT.UPIS",
	joinColumns = @JoinColumn(name = "KORSINIK_ID"),
	inverseJoinColumns = @JoinColumn(name = "KOLEGIJ_ID"))
	private Set<Kolegij> kolegiji = new HashSet<Kolegij>();
	
	
	public Set<Kolegij> getKolegiji() {
		return kolegiji;
	}

	public void setKolegiji(Set<Kolegij> kolegiji) {
		this.kolegiji = kolegiji;
	}

	public Korisnik(){}
	
	public Korisnik(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
