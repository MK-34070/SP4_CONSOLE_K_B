/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_k_b;

/**
 *
 * @author mario
 */

//TEST FONCTIONNEL
public class Jeton {
    //couleur affectée au joueur --> "Jaune" ou "Rouge"
    String Couleur;

    //Méthode : constructeur initialisant la couleur du jeton avec le paramètre Color en atttribut
    public Jeton(String Color) {
        Couleur = Color ;
        }


    //Méthode : renvoie la couleur du jeton
    public String lireCouleur() {
        return Couleur;
    }
    
}
