import java.util.List;

public class Sensor {
    private List<Double> leituras;
    private String id;

    public Sensor(String id, List<Double> leituras) {
        this.id = id;
        this.leituras = leituras;
    }

    public void registrarLeituras(List<Double> lista) throws LeituraInvalidaException{
        if (leituras.size() != 100) {
            throw new IllegalArgumentException("O total de leituras deve ser 100");
        }
        for (int i = 0; i < leituras.size(); i++) {
            double temp = leituras.get(i);
            if (temp < -60 || temp > 60) {
                throw new LeituraInvalidaException(i, temp);
            }
        }
        this.leituras = leituras;
    }

    public List<Double> getLeituras() {
        return leituras;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "temperaturas=" + leituras +
                ", id='" + id;
    }
}
