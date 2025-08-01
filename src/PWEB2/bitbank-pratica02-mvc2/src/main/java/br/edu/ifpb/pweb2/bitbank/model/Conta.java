package br.edu.ifpb.pweb2.bitbank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String numero;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private Set<Transacao> transacoes = new HashSet<Transacao>();

    private Correntista correntista;

    public Conta(Correntista correntista) {
        this.correntista = correntista;
    }

    public BigDecimal getSaldo() {
        BigDecimal total = BigDecimal.ZERO;
        for (Transacao t : this.transacoes) {
            total = total.add(t.getValor());
        }
        return total;
    }
}