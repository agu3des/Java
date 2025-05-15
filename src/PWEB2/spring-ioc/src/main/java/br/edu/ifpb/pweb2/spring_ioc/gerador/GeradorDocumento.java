package br.edu.ifpb.pweb2.spring_ioc.gerador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.spring_ioc.paragrafo.GeradorParagrafoIntf;

@Component 
public class  GeradorDocumento implements GeradorDocumentoIntf {

    @Autowired
    @Qualifier("genPDF")
    GeradorParagrafoIntf genParagrafo;

    @Override 
    public void addTexto(String texto) {
        genParagrafo.addParagrafo(texto);
    }

} 