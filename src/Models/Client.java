package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
    public IntegerProperty id_client,tel;
    public StringProperty email,nom_prenom,adress,ville ;

    public Client(int id_client, String email, String nom_prenom, int tel, String adress, String ville) {
        this.id_client =new SimpleIntegerProperty(id_client);
        this.tel = new SimpleIntegerProperty(tel);
        this.email = new SimpleStringProperty(email);
        this.nom_prenom = new SimpleStringProperty(nom_prenom);
        this.adress = new SimpleStringProperty(adress);
        this.ville = new SimpleStringProperty(ville);
    }

    public int getId_client() {
        return id_client.get();
    }

    public int getTel() {
        return tel.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getNom_prenom() {
        return nom_prenom.get();
    }

    public String getAdresse() {
        return adress.get();
    }
    
    public String getVille() {
        return ville.get();
    }

    public void setId_client(int id_client) {
        this.id_client.set(id_client);;
    }

    public void setTel(int tel) {
        this.tel.set(tel);;
    }

    public void setEmail(String email) {
        this.email.set(email);;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom.set(nom_prenom);;
    }

    public void setAdresse(String adress) {
        this.adress.set(adress);;
    }
    public void setVille(String ville) {
        this.ville.set(ville);;
    }
    public IntegerProperty id_clientProperty() {
		return id_client;
		}
    public IntegerProperty telProperty() {
		return tel;
		}
    public StringProperty emailProperty() {
		return email;
		}
    public StringProperty nom_prenomProperty() {
		return nom_prenom;
		}
    public StringProperty adressProperty() {
		return adress;
		}
    public StringProperty villeProperty() {
		return ville;
		}
}
