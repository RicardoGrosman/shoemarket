public class ValidadorPagamento extends PedidoValidador {
    public boolean validar(PedidoDados dados) {
        return dados.getMetodoPagamento() != null &&
                (proximo == null || proximo.validar(dados));
    }
}