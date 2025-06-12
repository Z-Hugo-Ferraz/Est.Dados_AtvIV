public class Sensor {
    private int id;
    private String data;
    private double valor;

    public Sensor(int id, String data, double valor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }
    public String getData() {
        return data;
    }
    public double getValor() {
        return valor;
    }
}
