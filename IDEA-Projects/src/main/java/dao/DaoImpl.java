package dao;

import org.springframework.stereotype.Component;

@Component ("dao")
public class DaoImpl implements Idao {
	@Override
	public double getData() {
		/* Version Base De Donn�es */
		double temp=Math.random()*40;
		System.out.println("Version base de donnees :");
		return temp;
	}
}
