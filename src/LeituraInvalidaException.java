public class LeituraInvalidaException extends Exception {
    public LeituraInvalidaException(int index, double temperatura) {
        super("Leitura inválida na posição: " + index + " temperatura: " + temperatura);
    }
}
