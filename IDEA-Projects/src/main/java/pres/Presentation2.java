package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.Idao;
import metier.IMetier;

public class Presentation2 {

	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		//Injection des d�pendances
		
		//Instanciation Dinamique
		
		String pathname = "config.txt";
		Scanner sc=new Scanner(new File(pathname));
		
		String daoClassName= sc.nextLine();
		Class<?> cDao=Class.forName(daoClassName); //Charger la classe en m�moire 
		Idao dao = (Idao) cDao.getDeclaredConstructor().newInstance();
		
		String metierClassName= sc.nextLine();
		Class<?> cMetier=Class.forName(metierClassName); //Charger la classe en m�moire 
		IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();
		
		//Assosociation
		Method method=cMetier.getMethod("setDao",Idao.class);
		method.invoke(metier,dao);
		System.out.println("Resultat: " + metier.Calcul());
	}
}
