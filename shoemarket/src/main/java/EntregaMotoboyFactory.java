public class EntregaMotoboyFactory extends EntregaFactory {
    public Entrega criarEntrega() {
        return new EntregaExpressa(new Motoboy());
    }
}