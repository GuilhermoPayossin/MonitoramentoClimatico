public class Teste {
    public static void main(String[] args) {
        int index = 10;
        double temperatura = -90;

        try {
            validar(index, temperatura);
        } catch (LeituraInvalidaException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Teste");
        }
    }

    private static void validar(int index, double temperatura) throws LeituraInvalidaException{
        if (temperatura < -60 || temperatura > 60) {
            throw new LeituraInvalidaException(index, temperatura);
        }
    }
}
