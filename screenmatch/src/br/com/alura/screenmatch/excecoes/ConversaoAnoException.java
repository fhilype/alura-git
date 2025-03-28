package br.com.alura.screenmatch.excecoes;

public class ConversaoAnoException extends RuntimeException {
    private final String mensagem;

    public ConversaoAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
