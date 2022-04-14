package metier;

import dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {

	@Autowired
	@Qualifier("dao")
	//objet null
	private Idao dao;
	
	@Override
	public double Calcul(){
		//Couplage Faible
		
		double tmp=dao.getData();
		double resultat=tmp*500/Math.cos(tmp*Math.PI);
		return resultat;
	}
	
	/* Injecter dans la variable dao un objet d'une classe
	   qui impl�mente l'interface Idao
	 */
	
	public void setDao(Idao dao) {
		this.dao=dao;
	}
}
