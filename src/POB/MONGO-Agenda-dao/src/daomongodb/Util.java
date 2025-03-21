/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */


import java.util.Properties;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.log4j.spi.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Util {
	private static EntityManager manager;
	private static EntityManagerFactory factory;

	// gravar mensagens no arquivo log4j.log
	private static final Logger logger = Logger.getLogger(Util.class);
	
	public static EntityManager conectarBanco() {
		//desativar as mensagens de Log na console  do java-mongo-driver 
		ch.qos.logback.classic.Logger log2 = ((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("org.mongodb.driver");
		log2.setLevel(Level.OFF);
		        
		if (manager == null) {
			try {
				// ler dados do arquivo dados.properties
				Properties dados = new Properties();
				logger.info("Util.conectar - lendo arquivo util.properties: ");
				dados.load(Util.class.getResourceAsStream("/daomongodb/util.properties")); // dentro de src

				String banco = dados.getProperty("banco");
				String ip = dados.getProperty("ip"); // escolha ip1,ip2,ip3

				logger.info("Util.conectar - banco => " + banco);
				logger.info("Util.conectar - ip => " + ip);

				// reconfigurar algumas propriedades do persistence.xml
				Properties configuracoes = new Properties();
				configuracoes.setProperty("eclipselink.nosql.property.mongo.host", ip);
				configuracoes.setProperty("eclipselink.nosql.property.mongo.db", banco);
				factory = Persistence.createEntityManagerFactory("eclipselink-mongodb", configuracoes);
				manager = factory.createEntityManager();
				logger.info("Util.conectar - criou manager");
			} catch (Exception e) {
				logger.info("Util.conectar - problema de configuracao: " + e.getMessage());
				System.exit(0);
			}
		}
		return manager;
	}

	public static void fecharBanco() {
		if (manager != null && manager.isOpen()) {
			manager.close();
			factory.close();
			manager = null;
		}
	}
}
