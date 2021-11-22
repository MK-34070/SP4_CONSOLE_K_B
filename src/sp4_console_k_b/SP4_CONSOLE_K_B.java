/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_k_b;

/**
 *
 * @author mario
 */
public class SP4_CONSOLE_K_B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        //EFFECTUER DES TESTS
        
        //TEST JETON.JAVA - Fonctionnel
        Jeton testjeton = new Jeton("Jaune");
        System.out.println(testjeton.lireCouleur());
        
        
        //TEST JOUEUR.JAVA - Fonctionnel
        Joueur theplayer = new Joueur("PLAYERname");
        System.out.println();
        theplayer.affecterCouleur("Rouge");
        theplayer.ajouterJeton(testjeton);
        
        //TEST CELLULE.JAVA - Fonctionnel
        Cellule c = new Cellule();
        c.lireCouleurDuJeton();
        c.affecterJeton(testjeton);
        c.recupererJeton();
        c.supprimerJeton();
        c.enleverJeton();
        c.recupererDesintegrateur();
        c.activerTrouNoir();
        c.placerDesintegrateur();
        c.placerTrouNoir();
        c.presenceDesintegrateur();
        c.presenceTrouNoir();
        
        
        //TEST GRILLE.JAVA --> vérifier placerTrouNoir & placerDésintégrateur
        Grille g = new Grille();
        g.ajouterJetonDansColonne(testjeton, 0);
        g.etreremplie();
        g.viderGrille();
        g.recupererJeton(0, 0);
        g.celluleOccupee(1, 1);
        g.colonneRemplie(1);
        g.etreGagnantePourJoueur(theplayer); 
        g.lireCouleurDuJeton(3, 2);
        g.tasserGrille(4, 6);
        g.placerDesintegrateur(2, 1);
        g.supprimerJeton(3, 2);
        g.afficherGrilleSurConsole();
        */
        
        //TEST PARTIE.JAVA
        System.out.println("Vous entrez dans le jeu Super Puissance 4 !");
        Partie unepartie = new Partie();
        unepartie.debuterPartie();
    }
}
