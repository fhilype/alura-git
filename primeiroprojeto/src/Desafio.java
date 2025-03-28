import java.text.NumberFormat;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        int opcao = 0;
        String nome = "Fhilype Medeiros Melo";
        String tipoConta = "Correte";
        double saldo = 2500;
        System.out.println("***************************");
        System.out.println("Dados iniciais do cliente:");
        System.out.println("Nome:             " + nome);
        System.out.println("Tipo conta:       " + tipoConta);
        System.out.println("Saldo inicial:    " + formatter.format(saldo));
        System.out.println("***************************");
        double valor;

        while (true) {
            System.out.println("Operações:");
            System.out.println("1 - Consultar saldos;");
            System.out.println("2 - Receber valor;");
            System.out.println("3 - Transferir valor;");
            System.out.println("4 - Sair;");
            System.out.println("Digite a opção desejada:");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual é: " + formatter.format(saldo));
                    break;
                case 2:
                    System.out.println("Quanto vai receber?");
                    valor = scanner.nextDouble();
                    saldo += valor < 0 ? valor * -1 : valor;
                    break;
                case 3:
                    System.out.println("3 - Transferir valor;");
                    System.out.println("Quanto vai transferir?");
                    valor = scanner.nextDouble();
                    saldo -= valor < 0 ? valor * -1 : valor;
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            if (opcao == 4) {
                break;
            }
        }
    }
}
