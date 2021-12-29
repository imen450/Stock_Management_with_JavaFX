package Models ;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class FactureFourni extends Facture  {
	public IntegerProperty id_fourni;
	 

	    public FactureFourni(int N_fact, float Montant,  float TVA,int id_fourni) {
	       super (N_fact,Montant,TVA);
	        this.id_fourni=new SimpleIntegerProperty(id_fourni);}
	    
	    
	    public int getId_fourni() {
	        return id_fourni.get() ;
	    }
	    public IntegerProperty id_fourniProperty() {
			return id_fourni;
			}

	  }
	      