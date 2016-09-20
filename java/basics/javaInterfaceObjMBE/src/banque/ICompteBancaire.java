package banque;

public interface ICompteBancaire {
	
	double getSolde();
	boolean retirer(double montant);
	void deposer(double montant);

}
