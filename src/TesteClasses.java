public class TesteClasses {
  public static void main(String[] args) {
      //testando a classe Palavra
      testPalavra();

      //testando a classe ControladorDeErros
      testControladorDeErros();

      //testando a classe ControladorDeLetrasJaDigitadas
      testControladorDeLetrasJaDigitadas();

      //testando a classe Tracinhos
      testTracinhos();
  }

  private static void testPalavra() {
      System.out.println("Testando a classe Palavra:");
      try {
          Palavra palavra = new Palavra("JAVA");
          System.out.println("Palavra criada: " + palavra);
          System.out.println("Tamanho da palavra: " + palavra.getTamanho());
          System.out.println("Quantidade de letras 'A': " + palavra.getQuantidade('A'));
          System.out.println("Posição da primeira ocorrência de 'A': " + palavra.getPosicaoDaIezimaOcorrencia(0, 'A'));
          System.out.println("Posição da segunda ocorrência de 'A' (deve lançar exceção): " + palavra.getPosicaoDaIezimaOcorrencia(1, 'A'));
      } catch (Exception e) {
          System.err.println(e.getMessage());
      }
      System.out.println();
  }

  private static void testControladorDeErros() {
      System.out.println("Testando a classe ControladorDeErros:");
      try {
          ControladorDeErros controlador = new ControladorDeErros(3);
          controlador.registreUmErro();
          controlador.registreUmErro();
          System.out.println("Erros registrados: " + controlador);
          controlador.registreUmErro();
          System.out.println("Máximo de erros atingido: " + controlador.isAtingidoMaximoDeErros());
          try {
              controlador.registreUmErro(); //deve lançar exceção
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
      }
      System.out.println();
  }

  private static void testControladorDeLetrasJaDigitadas() {
      System.out.println("Testando a classe ControladorDeLetrasJaDigitadas:");
      try {
          ControladorDeLetrasJaDigitadas controlador = new ControladorDeLetrasJaDigitadas();
          controlador.registre('A');
          controlador.registre('B');
          System.out.println("Letras já digitadas: " + controlador);
          System.out.println("Letra 'A' já digitada? " + controlador.isJaDigitada('A'));
          try {
              controlador.registre('A'); //deve lançar exceção
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      } catch (Exception e) {
          System.err.println(e.getMessage());
      }
      System.out.println();
  }

  private static void testTracinhos() {
    System.out.println("Testando a classe Tracinhos:");
    try {
        Tracinhos tracinhos = new Tracinhos(4);
        System.out.println("Tracinhos iniciais: " + tracinhos);
        
        //revela algumas letras
        tracinhos.revele(2, 'V');
        System.out.println("Tracinhos após revelar 'A' na posição 2: " + tracinhos);
        
        //revela mais letras
        tracinhos.revele(0, 'J');
        System.out.println("Tracinhos após revelar 'J' na posição 0: " + tracinhos);
        
        tracinhos.revele(1, 'A');
        System.out.println("Tracinhos após revelar 'A' na posição 1: " + tracinhos);
        
        //verifica se ainda há tracinhos antes de revelar o último
        if (!tracinhos.isAindaComTracinhos()) {
            System.out.println("Todos os tracinhos foram revelados!");
            return; //sai do método se todos já foram revelados
        }
        
        tracinhos.revele(3, 'A');
        System.out.println("Tracinhos após revelar 'A' na posição 3: " + tracinhos);

        //verifica se todos os tracinhos foram revelados agora
        if (!tracinhos.isAindaComTracinhos()) {
            System.out.println("Todos os tracinhos foram revelados!");
        } else {
            System.out.println("Ainda há tracinhos a serem revelados.");
        }
        
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
}

}
