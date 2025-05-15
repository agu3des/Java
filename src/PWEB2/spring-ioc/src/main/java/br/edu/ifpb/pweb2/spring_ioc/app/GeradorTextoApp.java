package br.edu.ifpb.pweb2.spring_ioc.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.ifpb.pweb2.spring_ioc.configuration.DocumentGenerationConf;
import br.edu.ifpb.pweb2.spring_ioc.gerador.GeradorDocumentoIntf;


public class GeradorTextoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DocumentGenerationConf.class);
        GeradorDocumentoIntf gerador = context.getBean(GeradorDocumentoIntf.class);

        gerador.addTexto("As fronteiras da minha linguagem são as fronteiras do meu mundo.");
        gerador.addTexto("Sobre o que não se pode falar, deve-se calar.");
        gerador.addTexto("--- Ludwing Wittgenstein");

        context.close();
    }
}
