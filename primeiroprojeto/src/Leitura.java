import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu filme favorito:");
        String filme = scanner.nextLine();
        System.out.println(filme);

        System.out.println("Qual o ano de lançamento?");
        int anoDeLancamento = scanner.nextInt();
        System.out.println(anoDeLancamento);

        System.out.println("Diga sua avaliação para o filme");
        double avaliacao = scanner.nextDouble();
        System.out.println(avaliacao);
    }
}
