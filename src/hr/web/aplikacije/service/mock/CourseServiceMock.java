package hr.web.aplikacije.service.mock;

import java.util.ArrayList;
import java.util.List;

import hr.web.aplikacije.domain.Kolegij;
import hr.web.aplikacije.service.CourseService;
import static org.mockito.Mockito.mock;

public class CourseServiceMock implements CourseService{

	@Override
	public List<Kolegij> fetchAllKolegijList() {
		List<Kolegij> listaKolegija = new ArrayList<Kolegij>();
		for (int i = 0; i < 10; i++) {
			listaKolegija.add(mock(Kolegij.class));
		}
		return listaKolegija;
		
	}

	@Override
	public void insertKolegijResults(Integer korisnikId, Integer kolegijId) {
		
		
	}

	@Override
	public Integer retriveKorisnikId(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kolegij> fetchAllKolegijListUpisani(Integer id) {
		List<Kolegij> listaKolegija = new ArrayList<Kolegij>();
		listaKolegija.add(mock(Kolegij.class));
		listaKolegija.add(mock(Kolegij.class));
		listaKolegija.add(mock(Kolegij.class));
		return listaKolegija;
	}

	@Override
	public int insertKolegij(Kolegij kolegij) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteKolegij(Kolegij kolegij) {
		// TODO Auto-generated method stub
		
	}

}
