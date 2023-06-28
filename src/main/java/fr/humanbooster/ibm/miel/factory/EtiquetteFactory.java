package fr.humanbooster.ibm.miel.factory;

import fr.humanbooster.ibm.miel.business.Etiquette;

public class EtiquetteFactory {

	private static EtiquetteFactory instance = new EtiquetteFactory();

	private EtiquetteFactory() {
	}

	public Etiquette ecrireEtiquette(String message) {
		return new Etiquette(message);
	}

	public static EtiquetteFactory getInstance() {
		return instance;
	}
}
