public class Cliente {
    private final String nome;
    private String statusAtual;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void atualizar(String status) {
        this.statusAtual = status;
    }

    public String getStatusAtual() {
        return statusAtual;
    }
}
