public class PedidoDados {
    private final String endereco;
    private final String cpf;
    private final String metodoPagamento;

    public PedidoDados(String endereco, String cpf, String metodoPagamento) {
        this.endereco = endereco;
        this.cpf = cpf;
        this.metodoPagamento = metodoPagamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }
}
