package Models;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Stock {
    public IntegerProperty id_prod;
    public StringProperty nom;
    public StringProperty categorie;
    public IntegerProperty qt_tot;
    public FloatProperty prix;
    public Stock( int id_prod , String nom,String categorie, int qt_tot, float prix) {
        this.id_prod=new SimpleIntegerProperty(id_prod);
        this.nom = new SimpleStringProperty(nom);
        this.categorie = new SimpleStringProperty(categorie);
        this.qt_tot = new SimpleIntegerProperty(qt_tot);
        this.prix = new SimpleFloatProperty(prix) ;
    }

    
    public int getId_prod() {
        return id_prod.get();
    }


    public String getNom() {
        return nom.get();
    }

    public int getQt_tot() {
        return qt_tot.get();
    }

    public String getCategorie() {
        return categorie.get();
    }

  
    public float getPrix() {
        return prix.get();
    }

    
    public void setId_prod(int id_prod) {
        this.id_prod.set(id_prod);;
    }

    public void setNom(String nom) {
        this.nom.set(nom);;
    }

    public void setQt_tot(int qt_tot) {
        this.qt_tot.set(qt_tot);;
    } 
    
    public void setCategorie(String categorie) {
        this.categorie.set(categorie);;
    }

   
    public void setPrix(float prix) {
        this.prix.set(prix);;
    }
    public IntegerProperty id_prodProperty() {
		return id_prod;
		}
    public IntegerProperty qt_totProperty() {
		return qt_tot;
		}
    public StringProperty nomProperty() {
		return nom;
		}
    public StringProperty categorieProperty() {
		return categorie;
		}
    public FloatProperty prixProperty() {
		return prix;
		}
    
}