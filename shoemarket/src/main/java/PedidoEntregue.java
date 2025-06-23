public class PedidoEntregue implements PedidoState {
    public void proximo(Pedido pedido) {
        // estado final
    }

    public String getStatus() {
        return "Entregue";
    }
}