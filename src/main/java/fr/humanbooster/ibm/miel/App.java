package fr.humanbooster.ibm.miel;

import fr.humanbooster.ibm.miel.builder.PotBuilder;
import fr.humanbooster.ibm.miel.builderImpl.PotBuilderImpl;
import fr.humanbooster.ibm.miel.business.BrisuresDeTruffesNoires;
import fr.humanbooster.ibm.miel.business.GeleeRoyale;
import fr.humanbooster.ibm.miel.business.HuileEssentielleDeCitronVert;
import fr.humanbooster.ibm.miel.business.Pollen;
import fr.humanbooster.ibm.miel.business.Pot;
import fr.humanbooster.ibm.miel.business.Propolis;
import fr.humanbooster.ibm.miel.business.Rayon;

/**
 * Hello world!
 *
 */
import java.util.Scanner;

public class App {

	private static Scanner scanner = new Scanner(System.in);
	private static PotBuilder potBuilder = new PotBuilderImpl();

	public static void main(String[] args) {
		Pot pot = potBuilder.choisirMiel("Lavande").choisirPoids(500).ajouterEtiquette("CDA 20").build();
		System.out.println(pot);

		ajouterIngredient();
	}

	private static void ajouterIngredient() {
		boolean continuer = true;
		int choix = 0;

		do {
			Pot pot = potBuilder.getPot();
			afficherOptions();
			choix = demanderChoix("Choisissez le numéro de l'option : ", 1, 6);

			switch (choix) {
			case 1:
				pot = new Propolis(pot);
				break;
			case 2:
				pot = new Rayon(pot);
				break;
			case 3:
				pot = new GeleeRoyale(pot);
				break;
			case 4:
				pot = new HuileEssentielleDeCitronVert(pot);
				break;
			case 5:
				pot = new Pollen(pot);
				break;
			case 6:
				pot = new BrisuresDeTruffesNoires(pot);
				break;
			default:
				System.out.println("Saisie incorrecte, merci de saisir un nombre compris entre 1 et 6");
				break;
			}
			System.out.println(
					"Voici les options de votre pot : " + pot.getNom() + ". Prix total: " + pot.getPrix() + "\n");

			System.out.println("Souhaitez-vous ajouter une nouvelle option (O/N) ?");
			String reponse = "";
			boolean erreur = false;
			do {
				reponse = scanner.nextLine();
				reponse = reponse.toUpperCase();
				if (!reponse.equals("O") && !(reponse.equals("N"))) {
					erreur = true;
				} else {
					erreur = false;
				}
			} while (erreur);
			switch (reponse) {
			case "O":
				continuer = true;
				break;
			case "N":
				continuer = false;
				break;
			default:
				break;
			}
		} while (continuer);

	}

	private static int demanderChoix(String message, int borneMin, int borneMax) {
		int valeur = borneMin - 1;
		do {
			System.out.print(message);
			try {
				String saisie = scanner.nextLine();
				valeur = Integer.parseInt(saisie);
				if (valeur < borneMin || valeur > borneMax) {
					System.out.println("Merci de saisir un nombre compris entre " + borneMin + " et " + borneMax);
				}
			} catch (Exception e) {
				System.out.println("Merci de saisir un nombre");
			}

		} while (!(valeur >= borneMin && valeur <= borneMax));
		return valeur;
	}

	private static void afficherOptions() {
		System.out.println("1) Ajouter Propolis");
		System.out.println("2) Ajouter Rayon");
		System.out.println("3) Ajouter Gelée Royale");
		System.out.println("4) Ajouter Huile essentielle citron vert");
		System.out.println("5) Ajouter Pollen");
		System.out.println("6) Ajouter Brisures de truffes noires");

	}
}

