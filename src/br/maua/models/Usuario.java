package br.maua.models;

import br.maua.interfaces.ChecarUsuario;

import java.util.Scanner;

/**
 * Classe de um usuário único criado para a primeira implementação do sistema da pizzaria para gerar segurança por senha.
 *      Esta classe utiliza-se da interface ChecarUsuario.java para cheacr se a senha do usuario cadastrado esta correta
 *      e poder continuar a fazer/alterar pedidos.
 * @author Gabriel de Godoy Braz - 17.00163-3 - gabriel.godoybz@hotmail.com.
 * @since 18/06/2020
 * @version 1.0
 */
public class Usuario implements ChecarUsuario {
    private String nome;
    private String email;
    private String senha;

    /**
     * @param nome Nome do usuário que será cadastrado
     * @param email Email do usuário que será cadastrado.
     */
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.senha = "123456";
    }

    /**
     * @return Getter para a senha do usuário cadastrado.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return Método sobrescrito da interface ChecarUsuario.java que garante que a senha inserida corresponde a senha cadastrada.
     */
    @Override
    public boolean checkUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a senha do usuário: ");
        String senha = scanner.next();
        if(senha.equals(this.getSenha()))
            return true;
        return false;
    }
}
