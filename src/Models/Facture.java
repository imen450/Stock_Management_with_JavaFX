package Models;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Facture 
{
    IntegerProperty N_fact;
    FloatProperty Montant ,TVA ;

    public Facture(int N_fact,  float Montant,float TVA) {
        this.N_fact = new SimpleIntegerProperty(N_fact);
        this.Montant =new SimpleFloatProperty( Montant);
        this.TVA =new SimpleFloatProperty( TVA);
    }

    public int getN_fact() {
        return N_fact.get() ; 
    }

    public float getMontant() {
        return Montant.get() ;
    }

    public float getTVA() {
        return TVA.get() ;
    }
    public IntegerProperty N_factProperty() {
		return N_fact;
		}
    public FloatProperty MontantProperty() {
    	return Montant;
		}
    public FloatProperty TVAProperty() {
		return TVA;}
    
}