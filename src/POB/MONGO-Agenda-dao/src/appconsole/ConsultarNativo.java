/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;


public class ConsultarNativo {

	public ConsultarNativo() {
		//desativar as mensagens de Log na console
		((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("org.mongodb.driver").setLevel(Level.OFF);

		//----acesso localhost
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		
		MongoClient cliente = MongoClients.create(settings);
		MongoDatabase banco = cliente.getDatabase("agenda");
		MongoCollection<Document> pessoas = banco.getCollection("PESSOA");
		MongoCollection<Document> telefones = banco.getCollection("TELEFONE");
		System.out.println("Conectado com Sucesso!");

		List<Document> resultados;
		BasicDBObject regexQuery ;

		System.out.println("----Lista de pessoas ordenada por nome");
		resultados = pessoas.find()
				.sort(Sorts.ascending("NOME"))
				.into(new ArrayList<>());
		for(Document d : resultados) 
			System.out.println("documento="+d);


		System.out.println("\n----Lista de telefones");
		resultados = telefones.find()
				.into(new ArrayList<>());
		for(Document d : resultados) 
			System.out.println("documento="+d);

		System.out.println("\n----Total de telefones:"+telefones.countDocuments());

		System.out.println("\n---- consultar joao");
		resultados = pessoas.find( and(eq("NOME", "joao")))
				.projection(fields(include("NOME", "APELIDOS"),excludeId()))
				.into(new ArrayList<>());
		if(resultados.size()>0) {
			Document d = resultados.get(0);
			System.out.println(d.getString("NOME")+", "+ d.getList("APELIDOS", String.class));
		}

		System.out.println("\n----Pessoas like jo");
		regexQuery = new BasicDBObject();
		regexQuery.put("NOME",new BasicDBObject("$regex", "jo.*").append("$options", "i")); //insensitive
		resultados = pessoas.find(regexQuery)
				.projection(fields(include("NOME", "APELIDOS"), excludeId()))
				.into(new ArrayList<>());
		
		for(Document d : resultados) 
			System.out.println("json="+d.toJson());


		System.out.println("\n----Telefones q comecam com 3");
		regexQuery = new BasicDBObject();
		regexQuery.put("NUMERO",new BasicDBObject("$regex", "^3"));  //^ = inicia
		resultados = telefones.find(regexQuery)
				.projection(fields(include("NUMERO"), excludeId()))
				.into(new ArrayList<>());
		for(Document d : resultados) 
			System.out.println("json="+d.toJson());

		
		System.out.println("\n----Telefones q terminam com 2");
		regexQuery = new BasicDBObject();
		regexQuery.put("NUMERO",new BasicDBObject("$regex", "2$"));  //$ = termina
		resultados = telefones.find(regexQuery)
				.projection(fields(include("NUMERO"), excludeId()))
				.into(new ArrayList<>());
		for(Document d : resultados) 
			System.out.println("json="+d.toJson());
	}

	public static void main(String[] args) {
		new ConsultarNativo();
	}
}

