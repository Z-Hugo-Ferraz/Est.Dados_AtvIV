import java.util.LinkedList;

public class ZonaUrbana extends Zona  implements Emergencia {

    private LinkedList<Sensor> sensores = new LinkedList<>();

    public ZonaUrbana(String nome) {
        super(nome);
    }

    public void addSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public double calcularTotal(){
        double total = 0;
        for (Sensor sensor : sensores) {
            total += sensor.getValor();
        }
        return total;
    }

    public double calcularMedia() {
        if (sensores.isEmpty()) {
            return 0;
        }
        return calcularTotal() / sensores.size();
    }

    @Override
    public String classificarNivelEmergencia() {
        double total = calcularMedia();
        if (total < 51) {
            return "Nível de Emergência: Sem risco";
        } else if (total < 101) {
            return "Nível de Emergência: Monitoramento intensificado";
        } else if (total < 151) {
            return "Nível de Emergência: Alerta para grupos sensíveis";
        } else if (total < 201) {
            return "Nível de Emergência: Alerta Amarelo";
        } else if (total < 301) {
            return "Nível de Emergência: Alerta Laranja";
        } else {
            return "Nível de Emergência: Alerta Vermelho (emergência total) \n"+
                ">>> Ação imediata recomendada: evacuação ou restrição de atividades externas";
        }
    }
    @Override
    public String relatorio() {
        return super.relatorio() + 
            "Total Semanal: " + String.format("%.2f",calcularTotal()) + "\n" +
            "Média Semanal: " + String.format("%.2f",calcularMedia()) + "\n" +
            classificarNivelEmergencia() + "\n" ;
    }
}
