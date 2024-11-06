package Atividades.Dieta;

import java.util.ArrayList;

public class DietaTeste { 
	 public static void main (String[] args){
		try{
			Dieta d1 = new Dieta("123456", 100.0, 90.0); //atributos cpf, peso(kg) e meta(kg)
			System.out.println(d1.getMeses()); //4
			ArrayList<Double> lista = d1.getListaPesosPerdidos();
			System.out.println(lista); //[97, 94, 91, 88]
			System.out.println(d1.getPerdaTotal()); //12.0 (100 – 88)
			Dieta d2 = new Dieta("223344", 95.0, 80.0); //atributos cpf, peso(kg) e meta(kg)
			System.out.println(d2.getMeses()); //5
			lista = d2.getListaPesosPerdidos();
			System.out.println(lista); //[92, 89, 86, 83, 80]
			System.out.println(d2.getPerdaTotal()); //15.0 (95 – 80)
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
