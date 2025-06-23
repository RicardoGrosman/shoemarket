import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private static Estoque instancia;
    private final Map<String, Integer> produtos = new HashMap<>();

    private Estoque() {}

    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public void adicionar(String produto, int qtd) {
        produtos.put(produto, produtos.getOrDefault(produto, 0) + qtd);
    }

    public int verificar(String produto) {
        return produtos.getOrDefault(produto, 0);
    }
}
