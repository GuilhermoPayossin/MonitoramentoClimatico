import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Sensor> listaSensor = new ArrayList<>();
        List<List<Double>> listaLeitura = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            listaSensor.add(new Sensor(i+""));
            listaLeitura.add(gerar(i));
        }

        SistemaMoitoramento sistemaMoitoramento = new SistemaMoitoramento();
        sistemaMoitoramento.processarSensores(listaSensor, listaLeitura);
        sistemaMoitoramento.exibirRelatorio();
    }

    private static List<Double> gerar(int i) {
        Random rd = new Random();
        List<Double> lista = new ArrayList<>();
        int total = 100;
        int limite = 60;
        switch(i) {
            case 2 -> total /= 2;
            case 3 -> limite *= 3;
        }
        for (int j = 0; j < total; j++) {
            lista.add(rd.nextDouble(-limite, limite));
        }
        return lista;
    }
}
