	package fr.humanbooster.ibm.miel.business;

import fr.humanbooster.ibm.miel.decorator.PotDecorator;

public class HuileEssentielleDeCitronVert extends PotDecorator {

	private static final float PRIX = 1.2f;

	public HuileEssentielleDeCitronVert(Pot pot) {
		super(pot);
		super.setPrix(pot.getPrix() + PRIX);
		super.setNom(pot.getNom() + " " + this.getClass().getSimpleName());
		super.setEtiquette(pot.getEtiquette());
		super.setPoids(pot.getPoids());
		super.setMiel(pot.getMiel());
	}

}