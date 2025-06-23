public class PedidoProcessando implements PedidoState {
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoEmTransporte());
    }

    public String getStatus() {
        return "Processando";
    }
}