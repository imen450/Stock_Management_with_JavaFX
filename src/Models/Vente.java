package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vente {
    public IntegerProperty N_vente,idc ,idp,qt;
    public StringProperty date;

    public  Vente(int N_vente,int idc , int idp, int qt, String date) {
        this.N_vente=new SimpleIntegerProperty(N_vente);
    	this.idc = new SimpleIntegerProperty(idc);
        this.idp = new SimpleIntegerProperty(idp);
        this.qt = new SimpleIntegerProperty(qt);
        this.date = new SimpleStringProperty( date);
    }
    public int getN_vente() {
        return N_vente.get() ;
    }
    public int getIdc() {
        return idc.get() ;
    }

    public int getIdp() {
        return idp.get() ;
    }

    public int getQt() {
        return qt.get();
    }

    public String getDate() {
        return date.get();
    }

    public void setIdc(int idc) {
        this.idc.set(idc);;
    }

    public void setIdp(int idp) {
        this.idp.set(idp);;
    }

    public void setQt(int qt) {
        this.qt.set(qt);;
    }
    public void setDate(String date) {
        this.date.set(date);;
    }
    public void setN_vente(int N_vente) {
        this.N_vente.set(N_vente);
    }
    public IntegerProperty N_venteProperty() {
		return N_vente;
		}
	public IntegerProperty idcProperty() {
		return idc;
		} 
	public IntegerProperty idpProperty() {
		return idp;
		}
	public IntegerProperty qtProperty() {
		return qt;
		}
	public StringProperty dateProperty() {
        return date ;
    }
    
    
}