package frontiere;

import java.util.Scanner;

public class BoundaryLeVillage {

	private BoundaryPrendreEtal boundaryChercherEtal;
	private BoundaryLibererEtal boundaryLibererEtal;
	private Scanner scan = new Scanner(System.in);
	private BoundaryAfficherMarche boundaryAfficherMarche;
	private BoundaryAcheterProduit boundaryAcheterProduit;
	private BoundaryEmmenager boundaryEmmenager;
	private BoundaryAfficherVillage boundaryAfficherVillage;

	public BoundaryLeVillage(BoundaryAfficherVillage boundaryAfficherVillageois,
			BoundaryEmmenager boundaryEmmenager,
			BoundaryPrendreEtal boundaryChercherEtal,
			BoundaryLibererEtal boundaryLibererEtal,
			BoundaryAfficherMarche boundaryAfficherMarche,
			BoundaryAcheterProduit boundaryAcheterProduit) {
		this.boundaryChercherEtal = boundaryChercherEtal;
		this.boundaryLibererEtal = boundaryLibererEtal;
		this.boundaryAfficherMarche = boundaryAfficherMarche;
		this.boundaryAcheterProduit = boundaryAcheterProduit;
		this.boundaryAfficherVillage = boundaryAfficherVillageois;
		this.boundaryEmmenager = boundaryEmmenager;
	}

	public void menu() {
		int choixUtilisateur;
		boundaryAfficherVillage.afficherVillage();
		do {
			StringBuilder question = new StringBuilder();
			question.append("Qui êtes-vous ?\n");
			question.append("1 - un voyageur\n");
			question.append("2 - un marchand\n");
			question.append("3 - un client du marche\n");
			question.append("4 - quitter l'application");
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			if (choixUtilisateur > 0 && choixUtilisateur < 4) {
				System.out.println("Quel est votre nom ?");
				String nom = scan.next();
				switch (choixUtilisateur) {
				case 1:
					menuVoyageur(nom);
					break;
				case 2:
					menuMarchand(nom);
					break;
				case 3:
					menuClient(nom);
					break;
				case 4:
					System.out.println("Sortie de l'application");
					break;
				default:
					System.out.println(
							"Vous devez entrer un chiffre entre 1 et 4");
					break;
				}
			}
		} while (choixUtilisateur != 4);
	}

	private void menuVoyageur(String nom) {
		int choixUtilisateur;
		do {
			StringBuilder question = new StringBuilder();
			question.append(
					"1 - je souhaite que vous me présentiez votre village.\n");
			question.append("2 - je voudrais emménager dans votre village.\n");
			question.append("3 - quitter l'application.");
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			switch (choixUtilisateur) {
			case 1:
				boundaryAfficherVillage.afficherVillage();
				break;
			case 2:
				boundaryEmmenager.emmenager(nom);
				break;
			case 3:
				System.out.println("Au revoir voyageur " + nom);
				break;
			default:
				System.out.println("Vous devez entrer un chiffre entre 1 et 3");
				break;
			}
			System.out.println();
		} while (choixUtilisateur != 3);
	}

	private void menuMarchand(String nom) {
		int choixUtilisateur = 0;
		do {
			StringBuilder question = new StringBuilder();
			question.append("1 - je cherche un étal.\n");
			question.append("2 - je veux libérer mon étal.\n");
			question.append("3 - quitter l'application.");
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			switch (choixUtilisateur) {
			case 1:
				boundaryChercherEtal.prendreEtal(nom);
				break;
			case 2:
				boundaryLibererEtal.libererEtal(nom);
				break;
			case 3:
				System.out.println("Au revoir marchand " + nom);
				break;
			default:
				System.out.println("Vous devez entrer un chiffre entre 1 et 3");
				break;
			}
			System.out.println();
		} while (choixUtilisateur != 3);
	}

	private void menuClient(String nom) {
		int choixUtilisateur = 0;
		do {
			StringBuilder question = new StringBuilder();
			question.append("1 - je veux acheter un produit.\n");
			question.append(
					"2 - je veux avoir une vue d'ensemble du marché.\n");
			question.append("3 - quitter l'application.");
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			switch (choixUtilisateur) {
			case 1:
				boundaryAcheterProduit.acheterProduit(nom);
				break;
			case 2:
				boundaryAfficherMarche.afficherMarche(nom);
				break;
			case 3:
				System.out.println("Au revoir client " + nom);
				break;
			default:
				System.out.println("Vous devez entrer un chiffre entre 1 et 3");
				break;
			}
			System.out.println();
		} while (choixUtilisateur != 3);
	}

}
