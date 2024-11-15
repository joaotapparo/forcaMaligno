public class Tracinhos implements Cloneable {
    private char texto[];

    public Tracinhos(int qtd) throws Exception {
        if (qtd <= 0) {
            throw new Exception("Quantidade de tracinhos deve ser positiva!");
        }
        this.texto = new char[qtd];
        for (int i = 0; i < qtd; i++) {
            this.texto[i] = '_'; //preenche com underlines
        }
    }

    public void revele(int posicao, char letra) throws Exception {
        if (posicao < 0 || posicao >= this.texto.length) {
            throw new Exception("Posição inválida!");
        }
        //armazena a letra na posição fornecida apenas se for um underline.
        if (this.texto[posicao] == '_') {
            this.texto[posicao] = letra; //armazena a letra na posição fornecida
        }
    }    

    public boolean isAindaComTracinhos() {
        for (char c : this.texto) {
            if (c == '_') {
                return true; //se ainda houver um underline, retorna true
            }
        }
        return false; //todos os tracinhos foram revelados
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char c : this.texto) {
            sb.append(c).append(' '); //adiciona um espaço entre os caracteres
        }
        return sb.toString().trim(); //retorna a string formatada
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tracinhos)) return false;
        Tracinhos other = (Tracinhos) obj;
        return java.util.Arrays.equals(this.texto, other.texto);
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(this.texto);
    }

    public Tracinhos(Tracinhos t) throws Exception { //construtor de cópia
        this.texto = new char[t.texto.length];
        System.arraycopy(t.texto, 0, this.texto, 0, t.texto.length);
    }

    public Object clone() {
        try {
            return new Tracinhos(this);
        } catch (Exception e) {
            return null; //nao deve acontecer
        }
    }
}
