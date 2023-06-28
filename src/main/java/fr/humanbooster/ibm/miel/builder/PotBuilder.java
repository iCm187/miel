package fr.humanbooster.ibm.miel.builder;


import fr.humanbooster.ibm.miel.business.Pot;

public interface PotBuilder {

	PotBuilder choisirMiel(String typeMiel);

    PotBuilder choisirPoids(Integer poids);

    PotBuilder ajouterEtiquette(String etiquette);

    Pot build();

	Pot getPot();

}
