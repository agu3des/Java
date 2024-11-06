public class String {
	public static void main(String[] args) {
		public boolean equals(String s);
		public boolean equalsIgnoreCase(String s);
		public int compareTo(String s);
		public int compareToIgnoreCase(String s);
		if ("maria".compareTo("ana") > 0);
		if ("joao".compareTo("paulo") < 0);
		if ("ze".compareToIgnoreCase("ZE") == 0);
		if ("ze".equals("ZE"));
        String nome = "joao da silva";
		System.out.println(nome.length()); //13
		System.out.println(nome.contains("jo")); //true
		System.out.println(nome.startsWith("joao")); //true
		System.out.println(nome.endsWith("va")); //true
		int i = nome.indexOf("da"); //5
		System.out.println(nome.replace("joao","joana"));//joana da silva
		String frase = " muitos brancos ";
		System.out.println(frase.trim()); //"muitos brancos"
		String nome ="joao"+"cruz"; //"joaocruz"
		String termo ="2" + "2"; //"22"
		String local = "sala" + 100; //"sala100"
		//substring(inicio, fim+1)
		String palavra = "linguagem";
		String s1 = palavra.substring(0,3); //”lin”
		String texto;
		texto = "11-01-2021";
		String[] partes = texto.split("-"); //[”11”,“01”,“2021”]
		texto = "joao";
		String[] letras = texto.split(""); //[“j”,“o”,“a”,“o”]
		texto = String.join("/", partes); // “11/01/2021“
		texto = String.join("", letras); // “joao”
        String s = "JOAO";
		//obter copia em minusculas
		System.out.println(s); //JOAO 
		System.out.println(s.toLowerCase());//joao
		System.out.println(s.toUpperCase());//JOAO
		//guardar a copia
		s = s.toLowerCase();
		StringBuffer buffer = new StringBuffer("");
		buffer.append("joao"); // ”joao”
		buffer.append("silva"); // ”joaosilva”
		buffer.insert(4," da "); // ”joao da silva”
		buffer.replace(8,12,"sousa"); // ”joao da sousa”
		String s = buffer.toString(); // ”joao da sousa”
		
	}
}
