import java.util.ArrayList;
import java.util.List;

public class SistemaMoitoramento {
    private List<Sensor> sensoresValidos;
    private List<ErroSensor> sensoresComErro;

    public SistemaMoitoramento() {
        this.sensoresComErro = new ArrayList<>();
        this.sensoresValidos = new ArrayList<>();
    }

    public void exibirRelatorio() {
        System.out.println("===== Sensores Válidos =====");
        for (Sensor s : sensoresValidos) {
            System.out.println("Sensor: " + s.getId());
        }

        System.out.println("===== Sensores Inválidos =====");
        for (ErroSensor es : sensoresComErro) {
            System.out.println("Sensor: " + es.getIdSensor() + " --> " + es.getMensagemErro());
        }
    }

    public void processarSensores(List<Sensor> listaSensor, List<List<Double>> listaLeitura) {
        for (int i = 0; i < listaSensor.size(); i++) {
            Sensor sensor = listaSensor.get(i);
            List<Double> leitura = listaLeitura.get(i);
            try {
                sensor.registrarLeituras(leitura);
                sensoresValidos.add(sensor);
            } catch (LeituraInvalidaException | IllegalArgumentException e) {
                sensoresComErro.add(new ErroSensor(sensor.getId(), e.getMessage()));
            }
        }
    }
}
