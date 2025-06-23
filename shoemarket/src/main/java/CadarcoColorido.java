
public class CadarcoColorido implements Calcado {
    private final Calcado base;
    public CadarcoColorido(Calcado base) { this.base = base; }

    public String descricao() { return base.descricao() + " + cadarco colorido"; }
    public double preco() { return base.preco() + 15.0; }
}