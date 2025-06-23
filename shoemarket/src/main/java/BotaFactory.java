public class BotaFactory implements CalcadoFactory {
    public Calcado criarCalcado() {
        return new SolaExtra(new BotaBase());
    }
}