public class PedidoEmTransporte implements PedidoState {
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }

    public String getStatus() {
        return "Em transporte";
    }
}