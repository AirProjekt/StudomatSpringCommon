package hr.web.aplikacije.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SupportedLanguages {
	/**
	* Vra�a listu podr�anih jezika za web aplikaciju.
	*
	* @return Lista podr�anih jezika.
	*/
	public List<Locale> getLangs() {
		List<Locale> langs = new ArrayList<Locale>();
		langs.add(new Locale("hr"));
		langs.add(new Locale("en"));
		return langs;
	}
}

