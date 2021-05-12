package br.maua.models;

import br.maua.enums.Estado;
import br.maua.enums.FormaPagamento;

import java.util.Random;

/**
 * Classe de pedidos para serem adicionados a uma lista de pedidos no Sistema principal.
 * @author Gabriel de Godoy Braz - 17.00163-3 - gabriel.godoybz@hotmail.com.
 * @since 18/06/2020
 * @version 1.0
 */
public class Pedidos {
    private String id;
    private String descricao;
    private double valor;
    private FormaPagamento formaPagamento;
    private Estado estado;

    /**
     * @param descricao Descrição do pedido.
     * @param valor Valor do pedido.
     * @param formaPagamento Forma de pagamento do pedido.
     */
    public Pedidos(String descricao, double valor, FormaPagamento formaPagamento) {
        this.id = geradorId();
        this.descricao = descricao;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.estado = Estado.REALIZADO;
    }

    /**
     * @return Getter para a enumeração do Id do pedido.
     */
    public String getId() {
        return id;
    }

    /**
     * @return Getter para a enumeração da Descrição do pedido.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return Getter para a enumeração do Valor do pedido.
     */
    public double getValor() {
        return valor;
    }

    /**
     * @return Getter para a enumeração da Forma de pagamento do pedido.
     */
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @return Getter para a enumeração do Estado do pedido.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado Setter para mudança de estado do pedido durante realização/preparação/entrega/devolução.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return  Método gerador ramdomico de ID para os pedidos serem melhor organizados.
     */
    private String geradorId() {
        Random random = new Random();
        String idGerado = "";
        for (int i=0; i < 3; i++)
            idGerado += random.nextInt(10);
        return idGerado;
    }


    /**
     * @return Método para mostrar a situação dos pedidos.
     */
    @Override
    public String toString() {
        return "ID: " + getId() + "  │  " +
                "Descrição: " + getDescricao() + "  │  " +
                "Valor: " + getValor() + "  │  " +
                "Forma de Pagamento: " + getFormaPagamento() + "  │  "+
                "Estado: " + getEstado() + "\n";
    }
}
