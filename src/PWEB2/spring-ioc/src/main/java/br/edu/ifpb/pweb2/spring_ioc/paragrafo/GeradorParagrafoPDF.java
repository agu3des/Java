package br.edu.ifpb.pweb2.spring_ioc.paragrafo;

import org.springframework.stereotype.Component;

@Component
public class GeradorParagrafoPDF implements GeradorParagrafoIntf {
    @Override 
    public void addParagrafo(String texto) {

        System.out.println("{PDF}"+ texto + "{/PDF}");
    }
}