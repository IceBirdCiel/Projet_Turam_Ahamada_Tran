package manager;

import manager.RelDef;
import java.util.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * TP1.H
 */
public class DBManager {
	/**
 	* Singleton : une seule instance
  	*/
	private DBManager() {
	}
	private static DBManager INSTANCE = new DBManager();
	public static DBManager getInstance(){
		return INSTANCE;
	}
	
	public RelDef createRelation (String nomRel,int nbCol, String [] typeCol, int fileIdx, int recordSize, int slotCount) {
		RelDef relation = new RelDef(nomRel,nbCol,typeCol, fileIdx,recordSize, slotCount);
		return relation;
	}
	
	public void init() {
		/*
		 * saisie();
		 */
		DBDef.getInstance().init();
	}
	
	public void finish() {
		DBDef.getInstance().finish();
	}
	
	public void processCommand(String s) { //ptt return String plus tard

		StringTokenizer st = new StringTokenizer(s," ");
		String token = st.nextToken();
		if (token.equals("exit")){ //finish
		}
		else {
			switch(token){
			case "create" :
				// Bien verifier que les arguments sont de bons types
				/*
				 * if hasmoretoken error ( on peut le mettre dès l'entrée du nb de colonne)
				 * appeler le constructeur de reldef
				 * stocker dans des cases differentes les RelDef
				 */
				String nomRelation = st.nextToken();
				// Chaine de caractere de taille fixe TP1 J1
				int nbColonne = Integer.parseInt(st.nextToken());
				String[] typeCol = new String[nbColonne];
				for (int i=0;i<nbColonne;i++) {
					typeCol[i]=st.nextToken();
				}
				int fileIdx = Integer.parseInt(st.nextToken());
				int recordSize = 0;
				int slotCount = recordSize/fileIdx;
				RelDef create = createRelation (nomRelation,nbColonne,typeCol,fileIdx,recordSize,slotCount);
				break;
			case "delete" ://
				break;
			default : System.out.println("Erreur vous n'avez entrez aucune instuction valide.")
				;
			}
		}
		
	}

	public static int recordSize(String[] s){
        int recordSize = 0;
        for(int i =0;i<s.length;i++){

            if (s[i].charAt(0) == 'i') {
                recordSize+=4;
            }
            if (s[i].charAt(0) == 'f') {
                int w = s[i].charAt(s[i].length() - 1);
                recordSize+=4*w;
            }
            if (s[i].charAt(0) == 's') {
                recordSize+=4;
            }
        }
        return recordSize;
    }
    
    //Calcul du nombre de slot qu'on peut mettre dans un record
    public static long slotCount(String[] s){
        return Constants.pageSize/recordSize(s);
    }
}