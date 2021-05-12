package br.maua.models;

import br.maua.enums.Estado;
import br.maua.enums.FormaPagamento;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe do Sistema principal da aplicação.
 *      Tem por objetivo manter a interface rodando até onde o usuário desejar, gera, verfica e altera os pedidos da pizzaria
 *      com segurança de senha para quem tentar gerar ou alterar os pedidos.
 * @author Gabriel de Godoy Braz - 17.00163-3 - gabriel.godoybz@hotmail.com
 * @since 18/06/2020
 * @version 1.0
 */
public class Sistema {
    public static void run() {

        Usuario usuario = new Usuario("Ratata TheGreatest", "ratatamelhorpokemon@ratoqueri.com.br");

        ArrayList<Pedidos> pedidos = new ArrayList<>();



        int interacao = 1;


        do {
            System.out.println("Pizzaria o Rato que Ri: ");
            System.out.println("1 - Nova venda");
            System.out.println("2 - Verificar pedidos");
            System.out.println("3 - Alterar pedidos");
            System.out.println("0 - Sair");

            Scanner scanner = new Scanner(System.in);
            interacao = scanner.nextInt();
            Scanner scanner1 = new Scanner(System.in);

            switch(interacao){
                case 0:
                    break;
                case 1:
                    if(usuario.checkUser()) {
                        System.out.println("Descrição da venda: ");
                        String descricao = scanner1.nextLine();
                        System.out.println("Valor da venda: ");
                        Double valor = scanner.nextDouble();
                        System.out.println("Forma de Pagamento: ");
                        System.out.println("0 - Dinheiro");
                        System.out.println("1 - Debito");
                        System.out.println("2 - Credito");
                        System.out.println("3 - Vale Alimentação");
                        System.out.println("4 - Vale Refeição");
                        int pagamento = scanner.nextInt();
                        if (pagamento == 0) {
                            pedidos.add(new Pedidos(descricao, valor, FormaPagamento.DINHEIRO));
                        } else if (pagamento == 1) {
                            pedidos.add(new Pedidos(descricao, valor, FormaPagamento.DEBITO));
                        } else if (pagamento == 2) {
                            pedidos.add(new Pedidos(descricao, valor, FormaPagamento.CREDITO));
                        } else if (pagamento == 3) {
                            pedidos.add(new Pedidos(descricao, valor, FormaPagamento.VALE_ALIMENTACAO));
                        } else {
                            pedidos.add(new Pedidos(descricao, valor, FormaPagamento.VALE_REFEICAO));
                        }
                    }else{
                        System.out.println("Senha incorreta.");
                    }
                    break;

                case 2:
                    checarPedidos(pedidos);
                    break;

                case 3:
                    if(usuario.checkUser()) {
                        System.out.println("Escolha qual pedido quer alterar (ID): ");

                        checarPedidos(pedidos);

                        String escolha = scanner.next();

                        for (int i = 0; i < pedidos.size(); i++) {
                            if (escolha.equals(pedidos.get(i).getId())) {
                                System.out.println("Escolha um novo Estado para o pedido " + escolha + ":");
                                System.out.println("0 - Preparação");
                                System.out.println("1 - Saiu para entrega");
                                System.out.println("2 - Entregue");
                                System.out.println("3 - Devolvido");

                                int novoEstado = scanner.nextInt();

                                if (novoEstado == 0) {
                                    pedidos.get(i).setEstado(Estado.PREPARACAO);
                                } else if (novoEstado == 1) {
                                    pedidos.get(i).setEstado(Estado.SAIU_PARA_ENTREGA);
                                } else if (novoEstado == 2) {
                                    pedidos.get(i).setEstado(Estado.ENTREGUE);
                                } else if (novoEstado == 3) {
                                    pedidos.get(i).setEstado(Estado.DEVOLVIDO);
                                }
                            } else
                                System.out.println("ID inválido.");
                        }
                    } else
                        System.out.println("Senha incorreta.");
                    break;
            }
        }while(interacao != 0);
    }

    /**
     * @param pedidos Define qual ArrayList de pedidos deve ser utilizada para verificação dos pedidos.
     */
    private static void checarPedidos(ArrayList<Pedidos> pedidos) {
        for (Pedidos item : pedidos) {
            System.out.println(item.toString());
        }
    }
}

