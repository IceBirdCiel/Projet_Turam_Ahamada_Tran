public class Main {

	/**
 	* Classe servant à la boucle de traitement des commandes (interface)
 	* @param args
 	*/
	public static void main(String[] args) {
		DBManager.getInstance().init();
		INSTANCE.init();
		/** TODO
		 * Appel de la méthode init
		 * Boucle de gestion des commandes
		 * if getCommande().equals("exit") -> DBManager.finish()
		 */
	}
}