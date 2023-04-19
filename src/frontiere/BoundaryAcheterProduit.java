package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis desole "+nomAcheteur+" mais il faut etre un habitant de notre village pour commercer ici.\n");
		} else {
			String produit;
			String marchandProduit;
			String resultat;
			int numeroMarchand;
			int nbProduit;
			boolean possedeProduit;
			System.out.println("Quel produit voulez vous acheter ?");
			produit = scan.next();
			possedeProduit = controlAcheterProduit.possedeProduits(produit);
			if (possedeProduit) {
				System.out.println("Desole mais personne ne vend ce produit au marche.\n");
			} else {
				marchandProduit = controlAcheterProduit.afficherEtalProduit(produit);
				String nomVendeur;
				numeroMarchand = Clavier
						.entrerEntier("Chez quel commercant voulez vous acheter des " + produit + " ?\n" + marchandProduit);
				nomVendeur = controlAcheterProduit.nomVendeur(produit, numeroMarchand);
				System.out.println(nomAcheteur + " se deplace jusqu a l etal du vendeur " + nomVendeur);
				nbProduit = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez vous ?\n");
				resultat = controlAcheterProduit.acheterProduit(produit, numeroMarchand, nbProduit, nomAcheteur);
				System.out.println(resultat + "\n");
			}
		}
	}
}
