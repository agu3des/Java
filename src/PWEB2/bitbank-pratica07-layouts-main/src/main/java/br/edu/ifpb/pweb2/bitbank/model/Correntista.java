package br.edu.ifpb.pweb2.bitbank.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Correntista implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="Campo obrigatório")
    private String nome;

    @NotBlank(message="Campo obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message="Campo obrigatório")
    @Size(min = 5, max = 70, message = "A senha deve ter entre 5 e 70 caracteres")
    private String senha;

    private boolean admin;
}