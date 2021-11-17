/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_k_b;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mario
 */
public class Partie {
    //création ListeJoueurs : tableau des deux joueurs de la partie
    Joueur [] ListeJoueurs = new Joueur[2];
    
    //création joueurCourant : désigne le joueur courant à tout moment de la partie
    Joueur joueurCourant;
    
    //création grilleJeu : désigne la grille de jeu - sans doute l’objet le plus important de ce projet.
    //Tout y est fait : ajout de jetons, et vérification de la grille
    Grille grilleJeu = new Grille();
        
    
    // Méthode : attribution aléatoire des couleurs aux joueurs
    public void attribuerCouleursAuxJoueurs() {
        //creation tableau contenant les deux couleurs
        String uneCouleur[] = new String[2];
        uneCouleur[0] = "Jaune";
        uneCouleur[1] = "Rouge";
        //Tirage aléatoire d'une couleur de jeton
        Random rand = new Random();
        int i = rand.nextInt(2);
        ListeJoueurs[0].Couleur = uneCouleur[i]; //on attribu cette 1ere couleur aléatoire au joueur1
        int a;
        if (i == 0) {
            a = 1;
        }
        else {
            a = 0;
        }
        ListeJoueurs[1].Couleur = uneCouleur[a]; //on attribu l'autre couleur au joueur2
    }

    // Méthode : changer de joueur - tour du suivant
    public void JoueurSuivant() {
        if (joueurCourant == ListeJoueurs[1]){
            joueurCourant = ListeJoueurs[0];
        }
        else {
            joueurCourant = ListeJoueurs[1];
        }
    }
    
    
    // Méthode : créé la grille, créé les jetons et les attribue aux joueurs correspondants
    //Place les trous noirs (version 2) et les téléporteurs (version 3)
    public void initialiserPartie() {
        grilleJeu.viderGrille(); //creation de la grille
        
        //affectation des noms aux joueurs
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur 1 - Entrez votre nom : ");
        Joueur joueur1 = new Joueur(sc.nextLine());
        System.out.println("Joueur 2 - Entrez votre nom : ");
        Joueur joueur2 = new Joueur(sc.nextLine());
        
        //affectations des joueurs 1 & 2 au tableau de joueurs
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
        
        //attribution des couleurs aux joueurs
        attribuerCouleursAuxJoueurs();
        System.out.println(joueur1+" possède les jetons de couleur "+joueur1.Couleur);
        System.out.println(joueur2+" possède les jetons de couleur "+joueur2.Couleur);
       
        //creation des jetons & attribution des jetons correpondants aux joueurs
        for (int i = 0; i < 20; i++) {
            Jeton unJeton1 = new Jeton(joueur1.Couleur); //creation jetons joueur1
            joueur1.ajouterJeton(unJeton1);
            Jeton unJeton2 = new Jeton(joueur2.Couleur); //creation jetons joueur2
            joueur2.ajouterJeton(unJeton2);
        }
        
        //Définition aléatoire du joueur qui commence à jouer
        Random rand = new Random(); // définition aléatoire du joueur qui commence à jouer
        boolean premier;
        premier = rand.nextBoolean(); //affectation aléatoire du premier joueur
        if (premier == true){
            System.out.println(joueur1.Nom + " commence à jouer. ");
            joueurCourant = joueur1; //affectation du joueur courant
        }
        else {
            System.out.println(joueur2.Nom + " commence à jouer. ");
            joueurCourant = joueur2; //affectation du joueur courant
        }
        
        //placement des trous noirs (v.2)
        //placement des téléporteurs (v.3)
        
        grilleJeu.afficherGrilleSurConsole(); //affichage grille sur console
        System.out.println("La partie va commencer !\nVous pouvez placer un jeton. ");
    }

    public void jouerJeton() {
        //Choix colonne
        int ChoixCol = 0; //initilisation variable choix de colonne entrée par joueur
        Scanner sc = new Scanner(System.in); //joueur entre la colonne voulue
        System.out.println("Entrez une colonne où vous voulez placer votre jeton. ");
        ChoixCol = sc.nextInt() -1 ; //on retire 1 au choix de la colonne car l'indice column du tableau est de 0 à 6 (or le joueur pense que les colonnes sont de 1 à 7)
        while (0 < ChoixCol || ChoixCol > 7) {
            System.out.println("Attention : Choisissez une colonne entre 1 et 7. ");
            ChoixCol = sc.nextInt() -1; //le joueur entre à nouveau une colonne
        }
        if (grilleJeu.colonneRemplie(ChoixCol)==true) {
            //La colonne est déjà remplie
            ChoixCol = sc.nextInt() - 1;
            System.out.println("Erreur : Colonne déjà remplie - Choisissez une autre colonne");
        }
        else { //REVOIR ICI :
            Jeton JetonCourant = joueurCourant.enleverJeton(); //on retire le jeton courant au joueur (-1)
            grilleJeu.ajouterJetonDansColonne(JetonCourant, ChoixCol); //On ajoute le Jeton dans la colonne choisie sur la grille
            System.out.println("Le jeton a bien été placé dans la colonne : "+ChoixCol);
        }
    }
    
    // Méthode : Lancement de la partie
    public void debuterPartie() {
        initialiserPartie(); //création du plateau
        
        //Boucle d'une partie
        for (int i=0; i<42; i++) { //dans tous les cas, la partie se termine lorsque les 42 cellules sont remplies (cas le plus long)
            //dans la version 1 --> 1 seule option : jouer un jeton
            jouerJeton();

            //au tour du joueur gagnant de jouer
            grilleJeu.etreGagnantePourJoueur(joueurCourant);
            System.out.println("Au tour de " + joueurCourant.Nom);

            //détection du joueur gagnant à chaque partie
            if (grilleJeu.etreGagnantePourJoueur(joueurCourant)==true) {
                System.out.println(joueurCourant.Nom + " a gagné la partie! ");
            }
            //on continue la partie
            else {
                JoueurSuivant(); //on passe au joueur suivant
            }
            i++;
        }
    }
}


//une partie n’est finalement qu’une grande boucle : à chaque tour un joueur joue, puis l’autre,
//et on recommence ainsi tant qu’il n’y a pas de joueur gagnant ou que la grille n’est pas remplie.


