public class Conversion {
    private String fromCode;
    private String toCode;
    private double amount;
    private double resultado;
    private String fechaHora;

    public Conversion(String fromCode, String toCode, double amount, double resultado, String fechaHora) {
        this.fromCode = fromCode;
        this.toCode = toCode;
        this.amount = amount;
        this.resultado = resultado;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "fromCode='" + fromCode + '\'' +
                ", toCode='" + toCode + '\'' +
                ", amount=" + amount +
                ", resultado=" + resultado +
                ", fechaHora='" + fechaHora + '\'' +
                '}';
    }
}