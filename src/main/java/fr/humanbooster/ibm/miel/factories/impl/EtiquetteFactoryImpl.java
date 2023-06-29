package fr.humanbooster.ibm.miel.factories.impl;


import fr.humanbooster.ibm.miel.business.Etiquette;
import fr.humanbooster.ibm.miel.factories.EtiquetteFactory;

public class EtiquetteFactoryImpl implements EtiquetteFactory {

    private static EtiquetteFactory etiquetteFactory;
    private int nbEtiquettesDisponibles = 100;


    // Constructeur privé
    protected EtiquetteFactoryImpl() {
    }

    public static EtiquetteFactory getInstance() {
        if (etiquetteFactory == null) {
            etiquetteFactory = new EtiquetteFactoryImpl();
        }
        return etiquetteFactory;
    }


    @Override
    public Etiquette fabriquerEtiquette(String message) {
        if (message == null) {
            return null;
        }
        if (nbEtiquettesDisponibles == 0) {
            return null;
        }
        nbEtiquettesDisponibles--;
        return new Etiquette(message);
    }

}
