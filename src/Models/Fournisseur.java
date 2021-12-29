package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fournisseur {
    public IntegerProperty id_fourni,telf;
    public StringProperty emailf,nom_prenomf,adressf,villef ;

    public Fournisseur(int id_fourni, int telf, String emailf, String nom_prenomf, String adressf, String villef) {
        this.id_fourni =new SimpleIntegerProperty( id_fourni);
        this.telf = new SimpleIntegerProperty(telf);
        this.emailf = new SimpleStringProperty(emailf);
        this.nom_prenomf = new SimpleStringProperty(nom_prenomf);
        this.adressf = new SimpleStringProperty(adressf);
        this.villef = new SimpleStringProperty(villef);
    }

    public int getId_fourni() {
        return id_fourni.get() ;
    }

    public int getTelf() {
        return telf.get();
    }

    public String getEmailf() {
        return emailf.get();
    }

    public String getNom_prenomf() {
        return nom_prenomf.get();
    }

    public String getAdressf() {
        return adressf.get() ;
    }
    
    public String getVillef() {
        return villef.get();
    }

    public void setId_fourni(int id_fourni) {
        this.id_fourni.set(id_fourni);;
    }

    public void setTelf(int telf) {
        this.telf.set(telf);;
    }

    public void setEmailf(String emailf) {
        this.emailf.set(emailf);;
    }

    public void setNom_prenomf(String nom_prenomf) {
        this.nom_prenomf.set(nom_prenomf);;
    }

    public void setAdressf(String adressf) {
        this.adressf.set(adressf);;
    }
    public void setVillef(String villef) {
        this.villef.set(villef);;
    }
    public IntegerProperty id_fourniProperty() {
		return id_fourni;
		}
    public IntegerProperty telfProperty() {
		return telf;
		}
    public StringProperty emailfProperty() {
		return emailf;
		}
    public StringProperty nom_prenomfProperty() {
		return nom_prenomf;
		}
    public StringProperty adressfProperty() {
		return adressf;
		}
    public StringProperty villefProperty() {
		return villef;
		}
    
}
