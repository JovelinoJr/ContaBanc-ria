import java.util.Scanner;

public class ContaTerminal {
    private final ContaBancaria conta;

    public ContaTerminal(ContaBancaria conta) {
        this.conta = conta;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirSaldo();
                    break;
                case 2:
                    depositar(scanner);
                    break;
                case 3:
                    sacar(scanner);
                    break;
                case 4:
                    transferir(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Sair");
    }

    private void exibirSaldo() {
        System.out.println("Seu saldo atual é: " + conta.getSaldo());
    }

    private void depositar(Scanner scanner) {
        System.out.print("Digite o valor que deseja depositar: ");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso.");
    }

    private void sacar(Scanner scanner) {
        System.out.print("Digite o valor que deseja sacar: ");
        double valor = scanner.nextDouble();
        if (conta.sacar(valor)) {
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    private void transferir(Scanner scanner) {
        System.out.print("Digite o valor que deseja transferir: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite o número da conta de destino: ");
        String numeroContaDestino = scanner.next();
        if (conta.transferir(valor, numeroContaDestino)) {
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Transferência não concluída. Verifique os dados e tente novamente.");
        }
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(); // Supondo que ContaBancaria seja a classe que você implementou
        ContaTerminal terminal = new ContaTerminal(conta);
        terminal.iniciar();
    }
}
