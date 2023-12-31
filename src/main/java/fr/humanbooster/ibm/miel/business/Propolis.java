package fr.humanbooster.ibm.miel.business;

import fr.humanbooster.ibm.miel.decorator.PotDecorator;

public class Propolis extends PotDecorator {

	private static final float PRIX = 0.8f;
	//private static final float QAUNTITE_EN_GRAMME = 80;
	
	public Propolis(Pot pot) {
		super(pot);
		super.setPrix(pot.getPrix() + PRIX);
		super.setNom(pot.getNom() + " " + this.getClass().getSimpleName());
		super.setEtiquette(pot.getEtiquette());
		super.setPoids(pot.getPoids());
		super.setMiel(pot.getMiel());
	}
}