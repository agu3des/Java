package Atividades.Carro;

public class CarroTeste {

	public static void main(String[] args) {
		Motor motor = new Motor("Zetec", 1.0);
		Motorista motorista = new Motorista("1111");
		Carro carro1 = new Carro("AAA1234", motor, motorista);

		Carro carro2 = new Carro("BBB5678", 
				new Motor("Fire", 1.5),
				new Motorista("2222"));
		
		Carro carro3 = new Carro("CCC9012");
		carro3.setMotor(new Motor("Zetec", 1.0));
		carro3.setMotorista(new Motorista("1111"));

		System.out.println(motor);
		System.out.println(motorista);
		System.out.println(carro1);
		System.out.println(carro2);
		System.out.println(carro3);
		
		
		//navegar pelo grafo
		System.out.println("Potencia antes: "+carro1.getMotor().getPotencia());//1.0
		carro1.getMotor().setPotencia(1.4);//do carro eu puxo o motor e aí sim posso alterar
		System.out.println("Potencia depois: "+carro1.getMotor().getPotencia());//1.4
		
		System.out.println("Cnh antes: "+carro3.getMotorista().getCnh());//1111
		carro3.getMotorista().setCnh("3333");
		System.out.println("Cnh depois: "+carro3.getMotorista().getCnh());//3333
	
		Carro carro4 = new Carro("DDD3456",
				new Motor("Fire",1.6), carro1.getMotorista()); //utilizar um motorista já existente
	
		//após alteracoes
		System.out.println(carro1);
		System.out.println(carro2);
		System.out.println(carro3);
		System.out.println(carro4);
		
		carro1.getMotorista().setCnh("2222");
		//System.out.println(carro4.getMotorista().getCnh());
		
		carro1.setMotorista(null); //apagar um relacionamento
		//System.out.println(carro4.getMotorista().getCnh());
		//System.out.println(carro1.getMotorista().getCnh());
		carro4.setMotorista(null);
		
		carro1.setMotorista(new Motorista("1111"));
		carro4.setMotorista(new Motorista("4444"));
		
		//após alteracoes
		System.out.println(carro1);
		System.out.println(carro2);
		System.out.println(carro3);
		System.out.println(carro4);
	}

}
