public abstract class Entrega {
    protected Transporte transporte;

    public Entrega(Transporte transporte) {
        this.transporte = transporte;
    }

    public abstract String realizarEntrega();
}