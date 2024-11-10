public class Palavra implements Comparable<Palavra> {
    private String texto;

    public Palavra(String texto) throws Exception {
        if (texto == null || texto.isEmpty()) {
            throw new Exception("Texto inválido!");
        }
        this.texto = texto;
    }

    public int getQuantidade(char letra) {
        int count = 0;
        for (char c : this.texto.toCharArray()) {
            if (c == letra) {
                count++;
            }
        }
        return count;
    }

    public int getPosicaoDaIezimaOcorrencia(int i, char letra) throws Exception {
        int count = 0;
        for (int index = 0; index < this.texto.length(); index++) {
            if (this.texto.charAt(index) == letra) {
                if (count == i) {
                    return index;
                }
                count++;
            }
        }
        throw new Exception("A letra '" + letra + "' não tem a " + i + "ª ocorrência.");
    }

    public int getTamanho() {
        return this.texto.length();
    }

    public String toString() {
        return this.texto;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Palavra)) return false;
        Palavra other = (Palavra) obj;
        return this.texto.equals(other.texto);
    }

    public int hashCode() {
        return this.texto.hashCode();
    }

    public int compareTo(Palavra palavra) {
        return this.texto.compareTo(palavra.texto);
    }
}
