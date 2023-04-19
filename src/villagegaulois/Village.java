package villagegaulois;

//TP2
import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtal) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(nbEtal);
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		Gaulois gaulois = null;
		if (nomGaulois.equals(chef.getNom())) {
			gaulois = chef;
		} else {
			for (int i = 0; i < nbVillageois; i++) {
				Gaulois habitant = villageois[i];
				if (habitant.getNom().equals(nomGaulois)) {
					gaulois = habitant;
				}
			}
		}
		return gaulois;
	}

	public String[] donnerVillageois() {
		String[] donnees = new String[nbVillageois + 1];
		donnees[0] = chef.getNom();
		for (int i = 0; i < nbVillageois; i++) {
			if (villageois[i] instanceof Druide) {
				donnees[i + 1] = "le druide " + villageois[i].getNom();
			} else {
				donnees[i + 1] = villageois[i].getNom();
			}
		}
		return donnees;
	}

	////////////////////// GESTION classe interne ///////////////////////
	public int donnerNbEtal() {
		return marche.getNbEtal();
	}

	/**
	 * 
	 * @param vendeur   : un gaulois habitant le village
	 * @param produit   : nom du produit à vendre
	 * @param nbProduit : nombre de produit à vendre
	 * @return le numéro de l'étal où c'est installé le vendeur ou -1 s'il n'en
	 *         a pas trouvé
	 */
	public int installerVendeur(Gaulois vendeur, String produit,
			int nbProduit) {
		int indiceEtal = marche.trouverEtalLibre();
		if (indiceEtal >= 0) {
			marche.utiliserEtal(indiceEtal, vendeur, produit, nbProduit);
		}
		return indiceEtal;
	}

	public void partirVendeur(Gaulois vendeur) {
		Etal etal = marche.trouverVendeur(vendeur);
		if (etal != null) {
			etal.libererEtal();
		}
	}

	public boolean rechercherEtalVide() {
		return marche.trouverEtalLibre() != -1;
	}

	public Gaulois[] rechercherVendeursProduit(String produit) {
		Gaulois[] vendeurs = null;
		Etal[] etalsProduit = marche.trouverEtals(produit);
		if (etalsProduit != null) {
			vendeurs = new Gaulois[etalsProduit.length];
			for (int i = 0; i < etalsProduit.length; i++) {
				vendeurs[i] = etalsProduit[i].getVendeur();
			}
		}
		return vendeurs;
	}

	public Etal rechercherEtal(Gaulois vendeur) {
		return marche.trouverVendeur(vendeur);
	}

	public String[] donnerEtatMarche() {
		return marche.donnerEtat();
	}

	////////////////////// Classe Interne ///////////////////////
	private static class Marche {
		private Etal[] etals;

		private Marche(int nbEtals) {
			etals = new Etal[nbEtals];
			for (int i = 0; i < nbEtals; i++) {
				etals[i] = new Etal();
			}
		}

		private void utiliserEtal(int indiceEtal, Gaulois vendeur,
				String produit, int nbProduit) {
			if (indiceEtal >= 0 && indiceEtal < etals.length) {
				etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
			}
		}

		/**
		 * 
		 * @return le numéro de l'étal où c'est installé le vendeur ou -1 s'il
		 *         n'en a pas trouvé
		 */
		private int trouverEtalLibre() {
			int indiceEtalLibre = -1;
			for (int i = 0; i < etals.length && indiceEtalLibre < 0; i++) {
				if (!etals[i].isEtalOccupe()) {
					indiceEtalLibre = i;
				}
			}
			return indiceEtalLibre;
		}

		private Etal[] trouverEtals(String produit) {
			int nbEtal = 0;
			for (Etal etal : etals) {
				if (etal.isEtalOccupe() && etal.contientProduit(produit)) {
					nbEtal++;
				}
			}
			Etal[] etalsProduitsRecherche = null;
			if (nbEtal > 0) {
				etalsProduitsRecherche = new Etal[nbEtal];
				int nbEtalTrouve = 0;
				for (int i = 0; i < etals.length
						&& nbEtalTrouve < nbEtal; i++) {
					if (etals[i].isEtalOccupe()
							&& etals[i].contientProduit(produit)) {
						etalsProduitsRecherche[nbEtalTrouve] = etals[i];
						nbEtalTrouve++;
					}
				}
			}
			return etalsProduitsRecherche;
		}

		private Etal trouverVendeur(Gaulois gaulois) {
			boolean vendeurTrouve = false;
			Etal etalVendeur = null;
			for (int i = 0; i < etals.length && !vendeurTrouve; i++) {
				Gaulois vendeur = etals[i].getVendeur();
				if (vendeur != null) {
					vendeurTrouve = vendeur.getNom().equals(gaulois.getNom());
					if (vendeurTrouve) {
						etalVendeur = etals[i];
					}
				}
			}
			return etalVendeur;
		}

		private int getNbEtal() {
			return etals.length;
		}

		private int getNbEtalsOccupe() {
			int nbEtal = 0;
			for (Etal etal : etals) {
				if (etal.isEtalOccupe()) {
					nbEtal++;
				}
			}
			return nbEtal;
		}

		/**
		 * 
		 * @return renvoie un tableau contenant les informations de tous les
		 *         étals du marché. Chaque étal est décrit sur 3 cases du
		 *         tableau successives : le nom du vendeur, le nombre de produit
		 *         qu'il lui reste à vendre, le type de produit à vendre
		 */
		private String[] donnerEtat() {
			int tailleTableau = getNbEtalsOccupe() * 3;
			String[] donnees = new String[tailleTableau];
			int j = 0;
			for (int i = 0; i < etals.length; i++) {
				Etal etal = etals[i];
				if (etal.isEtalOccupe()) {
					Gaulois vendeur = etal.getVendeur();
					int nbProduit = etal.getQuantite();
					donnees[j] = vendeur.getNom();
					j++;
					donnees[j] = String.valueOf(nbProduit);
					j++;
					donnees[j] = etal.getProduit();
					j++;
				}
			}
			return donnees;
		}
	}

}
