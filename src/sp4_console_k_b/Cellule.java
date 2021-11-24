/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_k_b;

/**
 *
 * @author mario
 */
public class Cellule {
    Jeton jetonCourant; //référence vers le jeton occupant la cellule, ou null
    boolean trouNoir; //indique ou non la présence d’un trou noir
    boolean desintegrateur; //indique ou non la présence d’un désintégrateur
    
     
    // Constructeur : initialisant les attributs avec des valeurs par défaut
    public Cellule() {
        jetonCourant = null ; // case vide donc pas de jeton dans la case
        trouNoir = false;
        desintegrateur = false;
    }
    
    //enleve le jeton courant de la variable jetoncourant
    public void enleverJeton() {
        jetonCourant = null;
        System.out.println("enleverJeton OK. ");
    }
    
    //ajoute le jeton en paramètre à la cellule, et retourne vrai si
    //l’ajout s’est bien passé, sinon faux
    public boolean affecterJeton(Jeton unjeton) {
       
        if (jetonCourant == null) {
            jetonCourant = unjeton;
            // si un trou noir est présent sur la cellule où est joué le jeton, on l'active
            if (presenceTrouNoir() == true){
                activerTrouNoir();
            }
            if(presenceDesintegrateur() == true){
                recupererDesintegrateur();
                
            }
            return true; //jeton bien affecté à la cellule du jetonCourant
            }
        else {
            return false; //jetonCourant déjà présent sur la cellule
            }
        }
    
    //renvoie une référence vers le jeton de la cellule
    /*public Jeton recupererJeton(){
        Jeton jetonRetour = jetonCourant; // variable pour jeton que l'on veut récupérer
        jetonCourant = null; // on réintialise la cellule, maintenant vide puisque jeton récupéré
        System.out.println("Jeton récupéré");
        return jetonRetour ; // on renvoie le jeton récupéré
    }*/

    //supprime le jeton et renvoie vrai si la suppression s’est bien
    //passée, ou faux autrement (ex : pas de jeton présent)
    public boolean supprimerJeton() {
        if ( jetonCourant== null) {
            System.out.println("la case est vide");
            return false; 
        }
        else {
            jetonCourant = null ; //on supprime le jetonCourant placé dans la cellule
            System.out.println("supprimerJeton OK. ");
            return true; //la suppression s'est bien passée
        }
    }

    public boolean placerTrouNoir(){
    // renvoie true et ajoute un trou noir si il n'a a pas déjà de trou noir présent, false sinon
       if (trouNoir = false){
            trouNoir = true ;
            System.out.println("Ajout de Trou Noir effectué");
        return true;
        }
        else {
          System.out.println("Trou Noir déja présent"); 
          return false;
        }
    }

public boolean placerDesintegrateur(){
    //Renvoie true et place in desintegrateur si il n'y en a pas déjà un, false et ne fait rien dans le cas contraire
    if (desintegrateur = false){ // si il n'y a pas de desintegrateur
        desintegrateur = true ; //on change sa valeur
        System.out.println("Ajout de Désintégrateur effectué");
       return true; //retour désignant que l'ajout a été fait
    }
    else {
      System.out.println("Désintégrateur déjà présent"); 
      return false; //sinon, on ne fait rien et on renvoie false
    }
}

public boolean presenceTrouNoir(){
    // indique si un trou noir est présent ou pas (renvoie true si oui, false sinon)
    if (trouNoir == true){
        //System.out.println("Trou Noir présent");
        return true;
    }
    else {
        //System.out.println("Trou Noir absent");
        return false;
    }
}

public boolean presenceDesintegrateur(){
    // indique si un desintegrateur est présent ou pas(renvoie true si oui, false sinon)
    if (desintegrateur == true){
       // System.out.println("Désintégrateur présent");
        return true;
    }
    else {
        //System.out.println("Désintégrateur absent");
        return false;
    }
}

public String lireCouleurDuJeton(){
    //si la cellule ne contient pas de jeton, renvoie qu'elle est vide, sinon renvoie la couleur du jeton l'occupant
    if (jetonCourant == null){
        //System.out.println("vide");
        return "vide";
    }
    else{
        return jetonCourant.Couleur;
    }
}


public boolean recupererDesintegrateur(){
    // si il y a un desintegrateur, le supprime et renvoie true, sinon renvoie false et ne fait rien
    if(desintegrateur =! false){
        desintegrateur = false;
        System.out.println("Suppression du Désintegrateur effectuée");  
        
        return true;  
    }
    else{
         System.out.println("Pas de Désintégrateur présent");
         return false;   
    } 
}

// si il y a un trou noir alors vide la cellule et fait disparaitre le trou noir, sinon ne fait rien
public boolean activerTrouNoir(){
    if(trouNoir == true){
        jetonCourant=null; // vide la cellule
        trouNoir = false; // disparition du Trou Noir
        System.out.println("Activation Trou Noir effectuée, cellule vidée");
        return true;
    }
    else{
        System.out.println("Pas de Trou Noir présent");
        return false;
    }
}
    
}
