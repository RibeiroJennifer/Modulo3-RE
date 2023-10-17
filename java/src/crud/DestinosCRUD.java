package crud;

import java.util.InputMismatchException;
import java.util.Scanner;

import dao.DestinosDAO;
import modelos.Destinos;

public class DestinosCRUD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DestinosDAO destinoDAO = new DestinosDAO();

        int opcao = 0;

        String nome = "", pais = "", estado = "", cidade = "";
        double preco;

        do {
            System.out.println("\n================== Destinos ==============\n");
            System.out.println("1- CRIAR  2- CONSULTAR  3- ATUALIZAR  4- DELETAR  5- CONSULTAR POR ID  0- SAIR");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do destino, EX: Disney Orlando:");
                    nome = s.nextLine();

                    System.out.println("Digite o País do destino:");
                    pais = s.nextLine();

                    System.out.println("Digite o Estado do destino:");
                    estado = s.nextLine();

                    System.out.println("Digite a Cidade do destino:");
                    cidade = s.nextLine();
                     
                    try {
                            System.out.println("Digite o preço para viajar para esse destino (use ponto para decimais):");
                            preco = s.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Certifique-se de usar um número decimal, por exemplo, 500.00");
                            s.nextLine(); // Limpa a entrada inválida
                            continue; // Volta ao menu
                        }
                  
                    Destinos destino1 = new Destinos(nome, pais, estado, cidade, preco);
                    destinoDAO.create(destino1);
                    break;

                case 2:
                    destinoDAO.read();

                    for (Destinos d : destinoDAO.read()) {
                        System.out.println(d.toString());
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome do Destino, EX: DISNEY Orlando:");
                    nome = s.nextLine();

                    System.out.println("Digite o País do Destino:");
                    pais = s.nextLine();

                    System.out.println("Digite o Estado do Destino:");
                    estado = s.nextLine();

                    System.out.println("Digite a Cidade do Destino:");
                    cidade = s.nextLine();

                    try {
                        System.out.println("Digite o preço da viagem para esse Destino (use ponto para decimais):");
                        preco = s.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Certifique-se de usar um número decimal, por exemplo, 500.00");
                        s.nextLine(); // Limpa a entrada inválida
                        continue; // Volta ao menu
                    }

                    System.out.println("Digite o ID do Destino");
                    int ID = s.nextInt();
                    s.nextLine();

                    Destinos destino2 = new Destinos(ID, nome, pais, estado, cidade, preco);
                    destinoDAO.update(destino2);
                    break;

                case 4:
                    System.out.println("Digite um ID:");
                    ID = s.nextInt();
                    s.nextLine();

                    destinoDAO.delete(ID);
                    break;

                case 5:
                    System.out.println("Digite um ID:");
                    ID = s.nextInt();
                    s.nextLine();

                    Destinos destino3 = destinoDAO.readByID(ID);
                    System.out.println(destino3.toString());
                    break;

                default:
                    break;
            }
        } while (opcao != 0);

        System.out.print("Até logo!");
    }
}
