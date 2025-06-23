public abstract class PedidoValidador {
    protected PedidoValidador proximo;

    public void setProximo(PedidoValidador proximo) {
        this.proximo = proximo;
    }

    public abstract boolean validar(PedidoDados dados);
}
