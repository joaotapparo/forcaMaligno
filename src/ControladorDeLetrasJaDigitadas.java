public class ControladorDeLetrasJaDigitadas implements Cloneable {
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas() {
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada(char letra) {
        return letrasJaDigitadas.indexOf(letra) != -1;
    }

    public void registre(char letra) throws Exception {
        if (isJaDigitada(letra)) {
            throw new Exception("A letra '" + letra + "' já foi digitada!");
        }
        letrasJaDigitadas += letra; // Concatena a letra
    }

    public String toString() {
        if (letrasJaDigitadas.isEmpty()) {
            return "Nenhuma letra digitada.";
        }
        return letrasJaDigitadas.replace("", ",").substring(1); // Formata a string com vírgulas
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ControladorDeLetrasJaDigitadas)) return false;
        ControladorDeLetrasJaDigitadas other = (ControladorDeLetrasJaDigitadas) obj;
        return this.letrasJaDigitadas.equals(other.letrasJaDigitadas);
    }

    public int hashCode() {
        return letrasJaDigitadas.hashCode();
    }

    public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas) throws Exception {
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone() {
        try {
            return new ControladorDeLetrasJaDigitadas(this);
        } catch (Exception e) {
            return null; // Não deve acontecer
        }
    }
}
