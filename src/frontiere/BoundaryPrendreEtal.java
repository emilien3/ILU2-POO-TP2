package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis desolee " + nomVendeur
					+ " mais il faut etre un habitant de notre village pour commencer ici.\n");
		} else {
			boolean etalDisponible;
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un etal.\n");
			etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Desole " + nomVendeur + " je n ai plus d etal qui ne soit pas deja occupe.\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit;
		int nbProduit, numeroEtal;
		System.out.println("C est parfait il me reste un etal pour vous !\n");
		System.out.println("Il me faudrait quelque renseignements :");
		System.out.println("Quel produit souhaitez vous vendre ?\n");
		produit = scan.next();
		nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?\n");
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s est installer a l etal n " + numeroEtal);
		}
	}
}
