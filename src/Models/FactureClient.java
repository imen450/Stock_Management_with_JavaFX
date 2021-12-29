package Models ;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class FactureClient extends Facture  {
	public IntegerProperty id_clt;
	 

	    public FactureClient(int N_fact, float Montant,  float TVA,int id_clt) {
	       super (N_fact,Montant,TVA);
	        this.id_clt=new SimpleIntegerProperty(id_clt);}
	    
	    
	    public int getId_clt() {
	        return id_clt.get() ;
	    }
	    public IntegerProperty id_cltProperty() {
			return id_clt;
			}

	  }
	      