public class ValidadorEndereco extends PedidoValidador {
    public boolean validar(PedidoDados dados) {
        return dados.getEndereco() != null && !dados.getEndereco().isEmpty() &&
                (proximo == null || proximo.validar(dados));
    }
}