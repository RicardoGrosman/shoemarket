public class ValidadorCPF extends PedidoValidador {
    public boolean validar(PedidoDados dados) {
        return dados.getCpf() != null && dados.getCpf().length() == 11 &&
                (proximo == null || proximo.validar(dados));
    }
}