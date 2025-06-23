public class EntregaExpressa extends Entrega {
    public EntregaExpressa(Transporte transporte) {
        super(transporte);
    }

    public String realizarEntrega() {
        return "Entrega expressa via " + transporte.tipo();
    }
}