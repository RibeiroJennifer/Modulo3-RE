package crud;

import java.util.Scanner;
import dao.ComprasDAO;
import modelos.Compras;
import modelos.Usuarios;
import modelos.Destinos;

public class ComprasCRUD {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ComprasDAO comprasDAO = new ComprasDAO();

        int opcao = 0;

        do {
            System.out.println("\n================== Compras ==============\n");
            System.out.println("1- CRIAR  2-CONSULTAR  3-ATUALIZAR  4-DELETAR  5-CONSULTAR POR ID  0-SAIR");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID do Destino:");
                    int destinoID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o ID do Usuário:");
                    int usuarioID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a data da compra (yyyy-MM-dd):");
                    String dataCompra = scanner.nextLine();

                    System.out.println("Digite a data de ida (yyyy-MM-dd):");
                    String dataIda = scanner.nextLine();

                    System.out.println("Digite a data de volta (yyyy-MM-dd):");
                    String dataVolta = scanner.nextLine();

                    System.out.println("Digite o valor total:");
                    double total = scanner.nextDouble();
                    scanner.nextLine();

                    Usuarios usuario = new Usuarios(usuarioID, "", "", "", "");
                    Destinos destino = new Destinos(destinoID, "", "", "", "", 0.0);
                    Compras compra = new Compras(dataCompra, dataIda, dataVolta, total, usuario, destino);

                    comprasDAO.create(compra);
                    System.out.println("Compra criada com sucesso.");
                    break;

                case 2:
                    System.out.println("Lista de Compras:");
                    for (Compras c : comprasDAO.read()) {
                        System.out.println(c.toString());
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID da compra que deseja atualizar:");
                    int compraID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o ID do Destino:");
                    destinoID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o ID do Usuário:");
                    usuarioID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a data da compra (yyyy-MM-dd):");
                    dataCompra = scanner.nextLine();

                    System.out.println("Digite a data de ida (yyyy-MM-dd):");
                    dataIda = scanner.nextLine();

                    System.out.println("Digite a data de volta (yyyy-MM-dd):");
                    dataVolta = scanner.nextLine();

                    System.out.println("Digite o valor total:");
                    total = scanner.nextDouble();
                    scanner.nextLine();

                    usuario = new Usuarios(usuarioID, "", "", "", "");
                    destino = new Destinos(destinoID, "", "", "", "", 0.0);
                    Compras compraAtualizada = new Compras(compraID, dataCompra, dataIda, dataVolta, total, usuario, destino);

                    comprasDAO.update(compraAtualizada);
                    System.out.println("Compra atualizada com sucesso.");
                    break;

                case 4:
                    System.out.println("Digite o ID da compra que deseja excluir:");
                    compraID = scanner.nextInt();
                    scanner.nextLine();

                    comprasDAO.delete(compraID);
                    System.out.println("Compra excluída com sucesso.");
                    break;

                case 5:
                    System.out.println("Digite o ID da compra que deseja consultar:");
                    compraID = scanner.nextInt();
                    scanner.nextLine();

                    Compras compraConsultada = comprasDAO.readByID(compraID);

                    if (compraConsultada != null) {
                        System.out.println("Detalhes da Compra:");
                        System.out.println(compraConsultada.toString());
                    } else {
                        System.out.println("Compra não encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
