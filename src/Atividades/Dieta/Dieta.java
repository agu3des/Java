package Atividades.Dieta;

import java.util.ArrayList;

public class Dieta {
	
	private String cpf;
	private double peso;
	private double meta;
	private int meses;
	private ArrayList<Double> pesosPerdidos;
	
	public Dieta (String cpf, double peso, double meta) throws Exception {
		meses = 0;
		pesosPerdidos = new ArrayList();
		
		if (meta >= peso || peso < 50) {
			throw new Exception("Dados inválidos.");			
		} else {
			while (peso >= meta) {
				peso = peso - 3;
				meses++;
				pesosPerdidos.add(peso);
			}
		}
		
	}
	
	public int getMeses() {
		return meses;
	}
	
	
	public double getPerdaTotal() {
		return meses * 3;
	}

	public ArrayList<Double> getListaPesosPerdidos() {
		// TODO Auto-generated method stub
		return pesosPerdidos;
	}
	
	
}
