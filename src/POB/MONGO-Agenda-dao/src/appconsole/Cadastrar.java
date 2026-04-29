/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

import regras_negocio.Fachada;

public class Cadastrar {

	public Cadastrar(){
		try {
			System.out.println("cadastrando pessoa...");
			Fachada.inicializar();
			
			Fachada.criarPessoa("joao", "01/01/1990",carregarFoto("m1.jpg"), 
					new String[]{"jo", "joaozinho", "jojo"});
			Fachada.criarPessoa("maria","01/01/2000",carregarFoto("f1.jpg"), 
					new String[]{"mary", "mar"});
			Fachada.criarPessoa("jose", "01/01/2010",carregarFoto("m2.jpg"), 
					new String[]{"zezinho", "zezao"});
			Fachada.criarPessoa("paulo","01/01/1990",null, 
					new String[] {});
			
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}

		try {
			Fachada.criarTelefone("joao","988880000");
			Fachada.criarTelefone("joao","988881111");	
			Fachada.criarTelefone("maria","987882222");
			Fachada.criarTelefone("maria","988883333");
			Fachada.criarTelefone("maria","32471234");
			Fachada.criarTelefone("jose","987884444");
			Fachada.criarTelefone("paulo","988885555");
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	/*
	 * leitura da foto de arquivo e conversao para byte[]
	 */
	public byte[] carregarFoto(String arquivo) {
		//usar arquivos da pastas /fotos
		try {
			URL url = Fachada.class.getResource("/fotos/"+arquivo);
			File f = new File(url.toURI());				// pasta src/fotos (interna)
			BufferedImage buffer = ImageIO.read(f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(buffer, "jpg", baos );
			byte[] bytesfoto = baos.toByteArray();
			baos.close();
			return bytesfoto;
		} catch (IOException e) {
			throw new RuntimeException("arquivo invalido:"+arquivo);
		} catch (URISyntaxException e) {
			throw new RuntimeException("arquivo invalido:"+arquivo);
		}	
	}

	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


