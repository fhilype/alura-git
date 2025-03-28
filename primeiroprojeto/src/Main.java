public class Main {
    public static void main(String[] args) {
        System.out.println("Inicializando Screen Match...");

        int anoDeLancamento = 2022;
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;

        // Média de três notas
        double media = (9.8 + 6.3 + 8.0) / 3;
        System.out.println(media);

        String sinopse = """
                Filme: Top Gun: Maverick
                Sinopse: Filme de aventura com galã dos anos 80.
                Muito bom!
                Ano de Lançamento: 
                """ + anoDeLancamento;

        System.out.println(sinopse);

        int classificacao;
        classificacao = (int) (media / 2);
        System.out.println(classificacao);

    }
}