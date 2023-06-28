package fr.humanbooster.ibm.miel.decorator;

import fr.humanbooster.ibm.miel.business.Pot;

public abstract class PotDecorator extends Pot {
	
protected Pot Pot;
	
	protected PotDecorator(Pot Pot) {
		super();
		this.Pot = Pot;
	}

}
