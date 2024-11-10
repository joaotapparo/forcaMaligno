public class ControladorDeErros implements Cloneable {
    private int qtdMax, qtdErr = 0;

    public ControladorDeErros(int qtdMax) throws Exception {
        //verifica se qtdMax fornecida não é positiva, lançando uma exceção.
        //armazena qtdMax fornecida em this.qtdMax.
        if (qtdMax < 1) throw new Exception("Quantidade inválida");

        this.qtdMax = qtdMax;
    }

    public void registreUmErro() throws Exception {
        //verifica se this.qtdErr já é igual a this.qtdMax,
        //lançando exceção em caso positivo ou
        //incrementando this.qtdErr em caso negativo.
        if (this.qtdErr == this.qtdMax) throw new Exception("Errou além do máximo");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros() {
        //retorna true se this.qtdErr for igual a this.qtdMax,
        //ou então false, caso contrário.
        return this.qtdErr == this.qtdMax;
    }

    public String toString() {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals(Object obj) {
        //verifica se this e obj possuem o mesmo conteúdo, retornando
        //true no caso afirmativo ou false no caso negativo.
        if (this == obj) return true;
        if (!(obj instanceof ControladorDeErros)) return false;
        ControladorDeErros other = (ControladorDeErros) obj;
        return this.qtdMax == other.qtdMax && this.qtdErr == other.qtdErr;
    }

    public int hashCode() {
        //calcula e retorna o hashcode de this.
        return Integer.hashCode(qtdMax) * 31 + Integer.hashCode(qtdErr);
    }

    public ControladorDeErros(ControladorDeErros c) throws Exception { //construtor de cópia
        //copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr.
        this(c.qtdMax); //chama o construtor para definir qtdMax
        this.qtdErr = c.qtdErr; //copia a quantidade de erros
    }

    public Object clone() {
        //retornar uma cópia de this.
        try {
            return new ControladorDeErros(this);
        } catch (Exception e) {
            return null;
        }
    }
}
