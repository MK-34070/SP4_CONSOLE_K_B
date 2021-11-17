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
        
        
        //EFFECTUER DES TESTS
        
        //TEST JETON.JAVA - Fonctionnel
        Jeton testjeton = new Jeton("Jaune");
        System.out.println(testjeton.lireCouleur());
        
        
        //TEST JOUEUR.JAVA - Fonctionnel
        Joueur theplayer = new Joueur("PLAYERname");
        System.out.println();
        theplayer.affecterCouleur("Rouge");
        theplayer.ajouterJeton(testjeton);
        
        //TEST CELLULE.JAVA
        Cellule c = new Cellule();
        c.lireCouleurDuJeton(); //OK
        c.affecterJeton(testjeton); //OK
        c.recupererJeton(); //OK
        c.supprimerJeton(); //OK
        c.enleverJeton();//OK
        
        //TEST GRILLE.JAVA
        Grille g = new Grille();
        //g.afficherGrilleSurConsole();
        //g.ajouterJetonDansColonne(testjeton, 0);
        //g.celluleOccupee(0, 0);
        //g.colonneRemplie(0);
        //g.etreGagnantePourJoueur(theplayer);
        //g.etreremplie();
        //g.lireCouleurDuJeton(0, 0);
        
        //TEST PARTIE.JAVA
        
        
    }
    
}
