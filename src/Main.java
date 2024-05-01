import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ContaTerminal> contas = new ArrayList<>();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Excluir cliente");
            System.out.println("3 - Consultar clientes");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta:");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a agência:");
                    String agencia = scanner.nextLine();

                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o saldo:");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();
                    if (saldo < 0) {
                        throw new RuntimeException("Saldo inválido");
                    }
                    ContaTerminal conta = new ContaTerminal(numero, agencia, new Cliente(nome), saldo);
                    contas.add(conta);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o número da conta a ser excluída:");
                    int numeroExcluir = scanner.nextInt();
                    scanner.nextLine();

                    boolean encontrado = false;
                    for (ContaTerminal contaTerminal : contas) {
                        if (contaTerminal.getNumero() == numeroExcluir) {
                            contas.remove(contaTerminal);
                            encontrado = true;
                            System.out.println("Conta excluída com sucesso!");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Lista de clientes cadastrados:");
                    for (ContaTerminal contaTerminal : contas) {
                        contaTerminal.exibirInfoConta();
                        System.out.println("-------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
