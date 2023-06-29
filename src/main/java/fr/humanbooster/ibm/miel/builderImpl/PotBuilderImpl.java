package fr.humanbooster.ibm.miel.builderImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import fr.humanbooster.ibm.miel.builder.PotBuilder;
import fr.humanbooster.ibm.miel.business.Miel;
import fr.humanbooster.ibm.miel.business.Poids;
import fr.humanbooster.ibm.miel.business.Pot;
import fr.humanbooster.ibm.miel.business.Prix;
import fr.humanbooster.ibm.miel.factories.EtiquetteFactory;

public class PotBuilderImpl implements PotBuilder {

	private Pot pot;
	private static EtiquetteFactory etiquetteFactory = EtiquetteFactory.getInstance();

	private static Set<Poids> poids = new HashSet<>();
	private static Set<Miel> miels = new HashSet<>();
	private static List<Prix> prix = new ArrayList<>();

	public PotBuilderImpl() {
		
		pot = new Pot();
		pot.setNom("POT");
		
		Poids p250 = new Poids("250 gr", 250f);
		Poids p500 = new Poids("500 gr", 500f);
		Poids p1000 = new Poids("1 kg", 1000f);
		
		poids.add(p250);
		poids.add(p500);
		poids.add(p1000);
		
		Miel acacia = new Miel("Acacia");
		Miel chataignier = new Miel("Chataignier");
		Miel lavande = new Miel("Lavande");
		Miel thym = new Miel("Thym");
		Miel litchi = new Miel("Litchi");
		Miel toutesFleurs = new Miel("Toutes Fleurs");
		miels.add(acacia);
		miels.add(chataignier);
		miels.add(lavande);
		miels.add(thym);
		miels.add(litchi);
		miels.add(toutesFleurs);

		// 18 prix
		prix.add(new Prix(p250, acacia, 9f));
		prix.add(new Prix(p500, acacia, 12.5f));
		prix.add(new Prix(p1000, acacia, 17f));

		prix.add(new Prix(p250, chataignier, 8.2f));
		prix.add(new Prix(p500, chataignier, 12f));
		prix.add(new Prix(p1000, chataignier, 16f));

		prix.add(new Prix(p250, lavande, 8.2f));
		prix.add(new Prix(p500, lavande, 12f));
		prix.add(new Prix(p1000, lavande, 16f));

		prix.add(new Prix(p250, thym, 8.2f));
		prix.add(new Prix(p500, thym, 12f));
		prix.add(new Prix(p1000, thym, 16f));

		prix.add(new Prix(p250, litchi, 9.75f));
		prix.add(new Prix(p500, litchi, 14.5f));
		prix.add(new Prix(p1000, litchi, 20f));

		prix.add(new Prix(p250, toutesFleurs, 9.75f));
		prix.add(new Prix(p500, toutesFleurs, 14.5f));
		prix.add(new Prix(p1000, toutesFleurs, 20f));
		
	}

	public Pot getPot() {
		return pot;
	}

	public void setPot(Pot pot) {
		this.pot = pot;
	}


	public PotBuilder choisirPoids(Integer poids) {
		pot.setPoids(recupererPoids(poids));
		return this;
	}
	
	public PotBuilder choisirMiel(String nom) {
		pot.setMiel(recupererMiel(nom));
		if (Objects.isNull(pot.getNom())) {
			pot.setNom(nom);
		}
		
		else {
			
		}
		return this;
	}

	public PotBuilder ajouterEtiquette(String message) {
		pot.setEtiquette(etiquetteFactory.fabriquerEtiquette(message));
		return this;
	}

	public Pot build() {
		Prix prixObj = recupererPrix(pot.getPoids(), pot.getMiel());
		if (prixObj == null) {
			Miel miel = recupererMiel("Acacia");
			Poids poids = recupererPoids(250);
			pot.setMiel(miel);
			pot.setPoids(poids);
			prixObj = recupererPrix(poids, miel);
		}
		pot.setPrix(pot.getPrix() + prixObj.getPrix());
		return pot;
	}
	
	private Miel recupererMiel(String nomRecherche) {
		for (Miel miel : miels) {
			if (miel.getNom().equals(nomRecherche)) {
				return miel;
			}
		}
		return null;
	}
	
	private Poids recupererPoids(float poidsRecherche) {
		for (Poids poids : poids) {
			if (poids.getPoids() == poidsRecherche) {
				return poids;
			}
		}
		return null;
	}

	private Prix recupererPrix(Poids poids, Miel miel) {
		for (Prix prixObj : prix) {
			if (prixObj.getPoids().equals(poids) && prixObj.getMiel().equals(miel)) {
				return prixObj;
			}
		}
		return null;
	}

}
