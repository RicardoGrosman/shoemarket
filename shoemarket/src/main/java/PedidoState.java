public interface PedidoState {
    void proximo(Pedido pedido);
    String getStatus();
}