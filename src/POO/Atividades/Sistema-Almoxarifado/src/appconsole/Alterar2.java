package appconsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO
 * Prof. Fausto Maranhão Ayres
 **********************************/

public class Alterar2 {

	public Alterar2(){
		try{
			//Fachada.esvaziarPrateleira(1);		//nao implementado
			//System.out.println("prateleira 1 esvaziada");
		}
		catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}


	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new Alterar2();

	}

}
