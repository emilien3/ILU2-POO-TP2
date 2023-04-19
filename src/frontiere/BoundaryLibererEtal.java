package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu;
		vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n etes pas inscrits sur notre marche aujourd'hui !");
		} else {
			String[] donneesEtal = null;
			boolean etalOccupe;
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			etalOccupe = donneesEtal[0].equalsIgnoreCase("true");
			if (etalOccupe) {
				System.out.println(
						"Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ".\n");
				System.out.println("Au revoir " + nomVendeur + " , passez une bonne journee.\n");
			}
		}
	}

}
