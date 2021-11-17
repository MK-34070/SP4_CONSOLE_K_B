/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_k_b;

/**
 *
 * @author mario
 */
public class Grille {
    Cellule CellulesJeu[][] = new Cellule[6][7];
    //création du tableau à 2 dimensionsavec des objets cellules.
    public Grille(){ //on construit une référence objet de classe cellule (42 fois)
        for (int line=0; line<6; line++){
            for (int column=0; column<7; column++){
                CellulesJeu[line][column] = new Cellule();
            }
        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton unjeton, int column ){
        for (int line=0; line<6;line ++){
            if (CellulesJeu[line][column].jetonCourant==null){
                CellulesJeu[line][column].affecterJeton(unjeton);//appel de la méthode pour affecter un jeton a la cellule
                return true;
            } 
        }
     return false;
     //la colonne est remplie
    }
    
    public boolean etreremplie(){
        for (int line=0;line<6;line++){
            for (int column=0;column<7;column ++){
                if(CellulesJeu[line][column]==null){
                    return false ;
                }
            }
        }
        return true;
        // le tableau sera bien remplie car toutes les cases on été parcourues
        
    }
    public void viderGrille(){
        for (int line=0;line<6;line++){
            for (int column=0;column<7;column ++){
                    CellulesJeu[line][column].jetonCourant=null;
                    CellulesJeu[line][column].trouNoir = false;
                    CellulesJeu[line][column].desintegrateur = false;
                
            }
        }
    }
    
    public void  afficherGrilleSurConsole() {
    // affiche la grille dans la console

        for (int line=5; line>=0; line--){ // boucle décrémentée car l'affichage conventionnel et celui pris par les tableaux est inversé
            for (int column=0; column<7; column++){
                if (CellulesJeu[line][column].trouNoir == true){
                    System.out.print("T"); // T sur la cellule pour signifier la présence d'un trou Noir
                }
                else if ((CellulesJeu[line][column].lireCouleurDuJeton())== "Rouge"){
                        System.out.print("R");
                     }
                else{
                        System.out.print("J");
                    }

            }
            System.out.println(" " + (line+1)); // affichage des numéros de lignes (l+1) car tableau commence à 0
        }// revoir l'aafichage des numéros de lignes et colonnes
        for (int column=0; column<7; column++){
            System.out.print((column+1)); // affichage des colonnes (c+1) car tableau commence à 0
        }
        System.out.println(); // affichage global du tableau
}

    public boolean celluleOccupee(int line , int column){
        if (CellulesJeu[line][column].jetonCourant==null){
            return false;
        }
        else{
            System.out.println("il y a un jeton a la ligne " + line + "de colonne "+ column );
            return true;
        }
    }
    public String lireCouleurDuJeton(int line , int column) {
        String couleur=CellulesJeu[line][column].lireCouleurDuJeton();
        return couleur;
    }
    
    public boolean etreGagnantePourJoueur(Joueur player){
        //verifier si il y a 4 pions au minimum sur une ligne
        String Colorplayer=player.Couleur;
        int jetonwin=0;
        int cellules=42;
        while(jetonwin!=0 && )
        for (int line=0;line<6; line ++){
            for (int column=0; column<4 ; column++){
                if (CellulesJeu[line][column].lireCouleurDuJeton()==Colorplayer){
                    jetonwin+=1;
                    cellules-=
                }
                else{
                    jetonwin=0;
                }
            }
        }
    }
    
    public void  tasserGrille(int line, int column){
    // fais descendre de 1 ligne la colonne lorsque celle ci est impacté par l'activation d'un desintegrateur ou trou noir
 
    for (int i=line; i<6; i++){
        if (i==5){
            CellulesJeu[i][column].jetonCourant = null; // si on est sur la plus haute ligne du tableau, cela ne décale rien. On initialise juste la cellule
        }
        else{
            CellulesJeu[i][column].jetonCourant = CellulesJeu[i+1][column].jetonCourant; // sinon on affecte à chaque ligne de la colonne fixée la valeur du jeton au-dessus de lui
        }
    }
}
    
  public boolean  colonneRemplie(int column){
    //Renvoie true si la colonne est remplie, false sinon
 
    for (int line=0; line <6; line++){
        if (CellulesJeu[line][column].jetonCourant==null){ // si cellule vide alors colonne non remplie
            return false ;
        }
    }
    return true ; // colonne remplie
}  
    
    public boolean  placerDesintegrateur(int line, int column){
    // si il y a déjà un desintegrateur de présent, renvoie false, true sinon
 
    if (CellulesJeu[line][column].desintegrateur == false){
        CellulesJeu[line][column].desintegrateur = true;
        System.out.println("Désintégrateur placé");
        return true;
    }
    System.out.println("Désintégrateur déjà présent");
    return false;
}
    
//renvoie vrai si la grille est gagnante pour le 
//joueur passé en paramètre, c’est-à-dire que 4 pions de sa couleur sont alignés en 
//ligne, en colonne ou en diagonale.

    // ajoute un trou noir à l’endroit indiqué et retourne vrai 
//si l’ajout s’est bien passé, ou faux sinon (exemple : trou noir déjà présent)
    public boolean placerTrouNoir(int line , int column){
        if (CellulesJeu[line][column].trouNoir==false){
            CellulesJeu[line][column].trouNoir = true;
            System.out.println("Trou Noir bien placé");
            return true;
        }
        System.out.println("trou Noir déjà présent");
        return false;  
        
    }
    public boolean supprimerJeton(int line, int column){
    //Supprime le jeton si il y en a un dans la cellule
 
        if (CellulesJeu[line][column].jetonCourant == null){
            System.out.println("Pas de Jeton");
            return false;
        }
        else {
            CellulesJeu[line][column].jetonCourant = null;
            System.out.println("Suppression Jeton effectuée");
            return true;
        }
    }

    public Jeton  recupererJeton(int line, int column){
        //recupere le jeton de la coordonnée saisie
        Jeton JetonRecup = CellulesJeu[line][column].jetonCourant; 
        CellulesJeu[line][column].jetonCourant = null;
        return JetonRecup;
    }
}
