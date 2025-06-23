import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    public void testEstadoEObserver() {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente("Lucas");

        pedido.adicionarObservador(cliente);
        assertEquals("Processando", cliente.getStatusAtual());

        pedido.avancarEstado();
        assertEquals("Em transporte", cliente.getStatusAtual());

        pedido.avancarEstado();
        assertEquals("Entregue", cliente.getStatusAtual());
    }

    @Test
    public void testEstoqueSingleton() {
        Estoque estoque1 = Estoque.getInstancia();
        Estoque estoque2 = Estoque.getInstancia();

        estoque1.adicionar("Bota", 10);
        assertEquals(10, estoque2.verificar("Bota"));
        assertSame(estoque1, estoque2);
    }

    @Test
    public void testCalcadoFactoryEPersonalizacao() {
        CalcadoFactory factoryTenis = new TenisFactory();
        Calcado tenis = factoryTenis.criarCalcado();
        assertEquals("Tenis basico + cadarco colorido", tenis.descricao());
        assertEquals(165.0, tenis.preco(), 0.01);

        CalcadoFactory factoryBota = new BotaFactory();
        Calcado bota = factoryBota.criarCalcado();
        assertEquals("Bota basica + sola extra", bota.descricao());
        assertEquals(230.0, bota.preco(), 0.01);
    }

    @Test
    public void testEntregaFactoryBridge() {
        EntregaFactory factory = new EntregaMotoboyFactory();
        Entrega entrega = factory.criarEntrega();

        assertEquals("Entrega expressa via Motoboy Rapido", entrega.realizarEntrega());
    }

    @Test
    public void testChainOfResponsibilityPedidoValido() {
        PedidoValidador validadorEndereco = new ValidadorEndereco();
        PedidoValidador validadorCPF = new ValidadorCPF();
        PedidoValidador validadorPagamento = new ValidadorPagamento();

        validadorEndereco.setProximo(validadorCPF);
        validadorCPF.setProximo(validadorPagamento);

        PedidoDados dados = new PedidoDados("Rua A", "12345678901", "Cartao");
        assertTrue(validadorEndereco.validar(dados));
    }

    @Test
    public void testChainOfResponsibilityPedidoInvalido() {
        PedidoValidador validadorEndereco = new ValidadorEndereco();
        PedidoValidador validadorCPF = new ValidadorCPF();
        PedidoValidador validadorPagamento = new ValidadorPagamento();

        validadorEndereco.setProximo(validadorCPF);
        validadorCPF.setProximo(validadorPagamento);

        PedidoDados dados = new PedidoDados("Rua A", "", "Cartao");
        assertFalse(validadorEndereco.validar(dados));
    }
}
