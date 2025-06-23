import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private PedidoState estado = new PedidoProcessando();
    private final List<Cliente> clientes = new ArrayList<>();

    public void avancarEstado() {
        estado.proximo(this);
    }

    public void setEstado(PedidoState novoEstado) {
        this.estado = novoEstado;
        notificar();
    }

    public void adicionarObservador(Cliente cliente) {
        clientes.add(cliente);
        cliente.atualizar(estado.getStatus());
    }

    private void notificar() {
        for (Cliente c : clientes) {
            c.atualizar(estado.getStatus());
        }
    }

    public String getStatus() {
        return estado.getStatus();
    }
}
