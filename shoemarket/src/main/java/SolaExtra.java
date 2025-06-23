public class SolaExtra implements Calcado {
    private final Calcado base;
    public SolaExtra(Calcado base) { this.base = base; }

    public String descricao() { return base.descricao() + " + sola extra"; }
    public double preco() { return base.preco() + 30.0; }
}