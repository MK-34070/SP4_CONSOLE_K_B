/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_k_b;

import java.util.Arrays;

/**
 *
 * @author mario
 */
public class Grille {

    Cellule CellulesJeu[][] = new Cellule[6][7];

    //int[] indiceCol = new int[6];
    //création du tableau à 2 dimensionsavec des objets cellules.
    public Grille() { //on construit une référence objet de classe cellule (42 fois)
        for (int line = 0; line < 6; line++) {
            for (int column = 0; column < 7; column++) {
                CellulesJeu[line][column] = new Cellule();
            }
        }
        /*//construction tableau indice des col pour résoudre pb dans la méthode ColonneRemplie
        for (int m = 0; m < 7; m++) {
            indiceCol [m] = m+1;
        }*/
    }

    //mettre de la couleur sur grille
    public class ConsoleColors {

        public static final String RED = "\033[0;31m";   // RED
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
        public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    }

    //ajoute le jeton dans la colonne ciblée, sur
    //la cellule vide la plus basse. Renvoie faux si la colonne était pleine.
    public boolean ajouterJetonDansColonne(Jeton unjeton, int column) {
        if (colonneRemplie(column) == false) {
            for (int line = 0; line < 6; line++) {
                if (CellulesJeu[line][column].jetonCourant == null) {
                    CellulesJeu[line][column].affecterJeton(unjeton); //on remplie la cellule vide la plus basse
                    return true;
                }
            }
        }
        return false; //la colonne est remplie
    }

    //renvoie vrai si la grille est pleine
    public boolean etreremplie() {
        for (int line = 0; line < 6; line++) {
            for (int column = 0; column < 7; column++) {
                if (CellulesJeu[line][column] == null) {
                    //System.out.println("La grille n'est pas encore pleine");
                    return false;
                }
            }
        }
        System.out.println("La grille est pleine");
        return true;
        // le tableau sera bien remplie car toutes les cases on été parcourues 
    }

    //vide la grille
    public void viderGrille() {
        for (int line = 0; line < 6; line++) {
            for (int column = 0; column < 7; column++) {
                CellulesJeu[line][column].jetonCourant = null;
                CellulesJeu[line][column].trouNoir = false;
                CellulesJeu[line][column].desintegrateur = false;
            }
        }
        System.out.println("Grille vidée");
    }

    //fonction d’affichage de la grille sur la console. Doit
    //faire apparaitre les couleurs, et les trous noirs.
    public void  afficherGrilleSurConsole() {
    // affiche la grille dans la console
    System.out.println(ConsoleColors.CYAN_BACKGROUND+"| 1  | 2  | 3 |  4 |  5 |  6 |  7 |");
    for (int line=5; line>=0; line--){ // boucle décrémentée car l'affichage conventionnel et celui pris par les tableaux est inversé
        for (int column=0; column<7; column++){
           
            if (CellulesJeu[line][column].presenceTrouNoir() == true){
                System.out.print(ConsoleColors.WHITE_BACKGROUND+"| T |");    
            }
            else if (CellulesJeu[line][column].presenceDesintegrateur() == true){
                System.out.print(ConsoleColors.WHITE_BACKGROUND+"| D |");    
            }
            else if(CellulesJeu[line][column].jetonCourant == null){
               System.out.print(ConsoleColors.WHITE_BACKGROUND+"| V |");
            }
            else if ((CellulesJeu[line][column].jetonCourant.Couleur)!= "Rouge"){
                    System.out.print("| J |"); //ConsoleColors.YELLOW+
                } else {
                    System.out.print("| R |"); //ConsoleColors.RED+
                }
            }
            System.out.println(ConsoleColors.CYAN_BACKGROUND + " | " + (line + 1) + " | " + ConsoleColors.CYAN_BACKGROUND); // affichage des numéros de lignes (l+1) car tableau commence à 0
        }
        System.out.println(); // affichage global du tableau 
    }

    //renvoie vrai si la cellule de coordonnées données est occupée par un jeton.
    public boolean celluleOccupee(int line, int column) {
        if (CellulesJeu[line][column].jetonCourant == null) {
            //System.out.println("cellule vide");
            return false;
        } else {
            //System.out.println("il y a un jeton a la ligne  " + line + "  de colonne "+ column );
            return true;
        }
    }

    //renvoie la couleur du jeton de la cellule ciblée.
    public String lireCouleurDuJeton(int line, int column) {
        String couleur = CellulesJeu[line][column].lireCouleurDuJeton();
        //System.out.println("lecture couleur du jeton");
        return couleur;
    }

    //renvoie vrai si la grille est gagnante pour le joueur passé en paramètre,
    //c’est-à-dire que 4 pions de sa couleur sont alignés en ligne, en colonne ou en diagonale.
    public boolean etreGagnantePourJoueur(Joueur player) {
        String Colorplayer = player.Couleur; //on récupere la couleur des jetons du joueur courant dans la variable Colorplayer
        
        //Vérifier s'il y a une ligne gagnante pour le joueur
        for (int line = 0; line < 3; line ++) {
            for (int column = 0; column < 5; column ++) {
                if ((CellulesJeu[line][column].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line][column+1].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line][column+2].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line][column+3].lireCouleurDuJeton() == Colorplayer)) {
                    System.out.println("4 pions sont alignés sur une ligne");
                    return true;
                }
            }
        }
        //Vérifier s'il y a une colonne gagnante pour le joueur
        for (int line = 0; line < 3; line ++) {
            for (int column = 0; column < 7; column ++) {
                if ((CellulesJeu[line][column].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line+1][column].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line+2][column].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line+3][column].lireCouleurDuJeton() == Colorplayer)) {
                    System.out.println("4 pions sont alignés sur une colonne");
                    return true;
                }
            }
        }
        
        // verifier s'il y a 4 poins sur une diagonale montante
        for (int line = 0; line < 2; line++) {
            for (int column = 0; column < 3; column++) {
                if ((CellulesJeu[line][column].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line + 1][column + 1].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line + 2][column + 2].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line + 3][column + 3].lireCouleurDuJeton() == Colorplayer)) {
                    System.out.println("4 pions sont alignés sur la diagonale montante");
                    return true;
                }
            }
        }
        // verifier s'il y a 4 pions sur une diagonale descendante
        for (int line = 3; line < 6; line++) {
            for (int column = 0; column < 3; column++) {
                if ((CellulesJeu[line][column].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line - 1][column + 1].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line - 2][column + 2].lireCouleurDuJeton() == Colorplayer)
                        && (CellulesJeu[line - 3][column + 3].lireCouleurDuJeton() == Colorplayer)) {
                    System.out.println("4 pions sont alignés sur la diagonale descendante");
                    return true;
                }
            }
        }
        //sinon aucun gagnant
        return false;
    }
        
    //lorsqu’un jeton est capturé ou détruit, tasse la grille en
    //décalant de une ligne les jetons situés au dessus de la cellule libérée.
    public void tasserGrille(int line, int column) {
        // fais descendre de 1 ligne la colonne lorsque celle ci est impacté par l'activation d'un desintegrateur ou trou noir
        for (int i = line; i < 6; i++) {
            if (i == 5) {
                CellulesJeu[i][column].jetonCourant = null; // si on est sur la plus haute ligne du tableau, cela ne décale rien. On initialise juste la cellule
                System.out.println("Impossible de tassée la grille (plus haute ligne du tableau)");
            } else {
                CellulesJeu[i][column].jetonCourant = CellulesJeu[i + 1][column].jetonCourant; // sinon on affecte à chaque ligne de la colonne fixée la valeur du jeton au-dessus de lui
                System.out.println("Grille tassée");
            }
        }
    }

    //renvoie vrai si la colonne est remplie (on ne peut y jouer un Jeton)
    public boolean colonneRemplie(int column) {
        if (CellulesJeu[5][column].jetonCourant != null) {
            System.out.println("colonne remplie, choisissez une autre colonne");
            //indiceCol[column] = 0; //on dit que la colonne est remplise
            //System.out.println(Arrays.toString(indiceCol));
            return true;
        } else {
            return false;
        }
    }

    //ajoute un désintégrateur à l’endroit indiqué et retourne vrai si l’ajout s’est bien passé,
    //ou faux sinon (exemple : désintégrateur déjà présent)
    public boolean placerDesintegrateur(int line, int column) {
        // si il y a déjà un desintegrateur de présent, renvoie false, true sinon

        if (CellulesJeu[line][column].desintegrateur == false) {
            if (CellulesJeu[line][column].trouNoir == false){
                CellulesJeu[line][column].desintegrateur = true;
                //System.out.println("Désintégrateur placé");
                return true;
            }
            else{
                return false;
            }
        }
        System.out.println("Désintégrateur déjà présent");
        return false;
    }

//renvoie vrai si la grille est gagnante pour le 
//joueur passé en paramètre, c’est-à-dire que 4 pions de sa couleur sont alignés en 
//ligne, en colonne ou en diagonale.
    // ajoute un trou noir à l’endroit indiqué et retourne vrai 
    //si l’ajout s’est bien passé, ou faux sinon (exemple : trou noir déjà présent)
    public boolean placerTrouNoir(int line, int column) {
        if (CellulesJeu[line][column].trouNoir == false) {
            CellulesJeu[line][column].trouNoir = true;
            //System.out.println("Trou Noir bien placé");
            return true;
        }
        //System.out.println("trou Noir déjà présent");
        return false;
    }

    // supprime le jeton de la cellule visée. Renvoie vrai si
    //la suppression s’est bien déroulée, ou faux autrement (jeton absent)
    public boolean supprimerJeton(int line, int column) {
        //Supprime le jeton si il y en a un dans la cellule
        if (CellulesJeu[line][column].jetonCourant == null) {
            System.out.println("Pas de Jeton");
            return false;
        } else {
            CellulesJeu[line][column].jetonCourant = null;
            System.out.println("Suppression Jeton effectuée");
            return true;
        }
    }

    //Version 3.0 : lors de son tour de jeu, le joueur doit saisir s’il souhaite jouer un jeton
    //ou récupérer un jeton. Selon le choix opéré, il saisira simplement le numéro de ligne
    //dans laquelle ajouter un jeton, ou les coordonnées du jeton à récupérer
    public Jeton recupererJeton(int line, int column) {
        //recupere le jeton de la coordonnée saisie
        Jeton JetonRecup = CellulesJeu[line][column].jetonCourant;
        CellulesJeu[line][column].jetonCourant = null; //on appel la méthode qui vide la cellule où le jeton a été récupéré
        System.out.println("Jeton récupéré");
        tasserGrille(line,column); //une fois le jeton récupéré, on tasse la grille en faisant appel à la fonction prévue
        return JetonRecup;
    }
}
