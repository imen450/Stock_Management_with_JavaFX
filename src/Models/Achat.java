package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Achat {
    public IntegerProperty N_achat, id_fourn ,id_prod,quantit�;
    public StringProperty date;
    
    public Achat(int N_achat, int id_fourn,int id_prod,int quantit�, String date) {
		this.N_achat = new SimpleIntegerProperty(N_achat);
		this.id_fourn = new SimpleIntegerProperty(id_fourn);
		this.id_prod = new SimpleIntegerProperty(id_prod);
		this.quantit� = new SimpleIntegerProperty(quantit�);
		this.date = new SimpleStringProperty(date);}
		



	public int getN_achat() {
        return N_achat.get() ;
    }
    public int getId_fourn() {
        return id_fourn.get() ;
    }

    public int getId_prod() {
        return id_prod.get() ;
    }

    public int getQuantit�() {
        return quantit�.get();
    }

    public String getDate() {
        return date.get();
    }

    public void setId_fourn(int idf) {
        this.id_fourn.set(idf);;
    }

    public void setId_prod(int id_prod) {
        this.id_prod.set(id_prod); ;
    }

    public void setQuantit�(int qt) {
        this.quantit�.set(qt);;
    }
    public void setDate(String date) {
        this.date.set(date);;
    }
    public void setN_achat(int N_achat ) {
        this.N_achat.set(N_achat);;
    }
	public IntegerProperty N_achatProperty() {
		return N_achat;
		}
	public IntegerProperty id_fournProperty() {
		return id_fourn;
		} 
	public IntegerProperty id_prodProperty() {
		return id_prod;
		}
	public IntegerProperty quantit�Property() {
		return quantit�;
		}
	public StringProperty dateProperty() {
        return date ;
    }
	
    }


	
    
