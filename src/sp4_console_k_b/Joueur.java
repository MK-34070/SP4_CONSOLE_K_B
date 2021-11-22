/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_k_b;

/**
 *
 * @author mario
 */
public class Joueur {
    String Nom;
    String Couleur;
    Jeton ListeJetons[] = new Jeton[21]; //creation d'un tableau du type Jeton contenant 21 jetons
    int nombreDesintegrateurs;// nombre de désintégrateurs actuellement en possession
    int nombreJetonsRestants = 21; //initialement 21 jetons, évolue au cours de la partie
    

    //constructeur initialisant le nom du joueur avec son paramètre
    public Joueur(String name) {
        Nom = name;
        nombreDesintegrateurs = 0;
        nombreJetonsRestants = 0;
    }

    //affecte la couleur en paramètre au joueur
    public void affecterCouleur(String Color) {
        Couleur = Color;
        //System.out.println("La couleur " + Couleur+" a été affecté à "+Nom);
    }

    //ajoute le jeton passé en paramètre à la liste des jetons
    public boolean ajouterJeton(Jeton unjeton ) {
        ListeJetons[nombreJetonsRestants++] = unjeton;
        //System.out.println("un jeton a été ajouté au joueur "+Nom);
        return false;
    // pourquoi avoir un boolean en sortie? que veut on savoir?
    //si la liste de jeton est pleine --> return true?
    }
    //incrémente le nombre de désintégrateurs du joueur
    public void obtenirDesintegrateur() {
        nombreDesintegrateurs += 1;
    }

    //décrémente le nombre de désintégrateurs et confirme l’utilisation de ce dernier,
    //ou renvoie faux s’il ne restait plus de désintégrateurs.
    public boolean utiliserDesintegrateur() {
        //vérifie que le joueur possède au moins un désintégrateur
        if (nombreDesintegrateurs > 0) {
            nombreDesintegrateurs -= 1; //retire un désintégrateur
            System.out.println("Désintégrateur utilisé. "); //mess confirmation utilisation désintégrateur
            return true;
        } else {
            System.out.println("Vous ne possédez plus de désintégrateur. ");
            return false;
        }
    }
}