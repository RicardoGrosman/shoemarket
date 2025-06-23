public class TenisFactory implements CalcadoFactory {
    public Calcado criarCalcado() {
        return new CadarcoColorido(new TenisBase());
    }
}
