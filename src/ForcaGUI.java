import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForcaGUI extends JFrame {
    private JLabel palavraLabel;
    private JTextField letraField;
    private JButton enviarButton;
    private JButton reiniciarButton;
    private JLabel mensagemLabel;

    //rotulos para exibir letras digitadas e erros
    private JLabel letrasDigitadasLabel;
    private JLabel errosLabel;

    private ControladorDeErros controladorDeErros;
    private ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas;
    private Tracinhos tracinhos;
    private Palavra palavra;

    public ForcaGUI() {
        setTitle("Jogo da Forca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        palavraLabel = new JLabel("Palavra: ");
        letraField = new JTextField(1);
        enviarButton = new JButton("Enviar");
        reiniciarButton = new JButton("Reiniciar");
        mensagemLabel = new JLabel("");

        //rotulos para letras digitadas e erros
        letrasDigitadasLabel = new JLabel("Letras digitadas: ");
        errosLabel = new JLabel("Erros: 0");

        add(palavraLabel);
        add(letraField);
        add(enviarButton);
        add(reiniciarButton);
        add(mensagemLabel);
        
        //adiciona os novos rótulos à interface
        add(letrasDigitadasLabel);
        add(errosLabel);

        //adiciona ações aos botoes
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processarLetra();
            }
        });

        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo();
            }
        });

        reiniciarJogo(); //inicia o jogo ao abrir a janela
    }

    private void processarLetra() {
        String letra = letraField.getText().toUpperCase();
        letraField.setText(""); //limpa o campo de entrada

        if (letra.length() == 1) {
            try {
                if (controladorDeLetrasJaDigitadas.isJaDigitada(letra.charAt(0))) {
                    mensagemLabel.setText("Essa letra já foi digitada!");
                } else {
                    controladorDeLetrasJaDigitadas.registre(letra.charAt(0));
                    letrasDigitadasLabel.setText("Letras digitadas: " + controladorDeLetrasJaDigitadas);

                    int qtd = palavra.getQuantidade(letra.charAt(0));

                    if (qtd == 0) {
                        controladorDeErros.registreUmErro();
                        errosLabel.setText("Erros: " + controladorDeErros);
                        mensagemLabel.setText("A palavra não tem essa letra!");
                    } else {
                        for (int i = 0; i < qtd; i++) {
                            int posicao = palavra.getPosicaoDaIezimaOcorrencia(i, letra.charAt(0));
                            tracinhos.revele(posicao, letra.charAt(0));
                        }
                        mensagemLabel.setText("Boa tentativa!");
                    }

                    atualizarPalavra();
                }

                if (controladorDeErros.isAtingidoMaximoDeErros()) {
                    mensagemLabel.setText("Você perdeu! A palavra era: " + palavra);
                } else if (!tracinhos.isAindaComTracinhos()) {
                    mensagemLabel.setText("Parabéns! Você ganhou!");
                }
            } catch (Exception ex) {
                mensagemLabel.setText(ex.getMessage());
            }
        } else {
            mensagemLabel.setText("Por favor, digite apenas uma letra.");
        }
    }

    private void atualizarPalavra() {
        palavraLabel.setText("Palavra: " + tracinhos);
    }

    private void reiniciarJogo() {
        try {
            palavra = BancoDePalavras.getPalavraSorteada();
            tracinhos = new Tracinhos(palavra.getTamanho());
            controladorDeErros = new ControladorDeErros((int)(palavra.getTamanho() * 0.6));
            controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();

            atualizarPalavra();
            mensagemLabel.setText("");
            letraField.setText("");
            
            //reinicia os rótulos de letras digitadas e erros
            letrasDigitadasLabel.setText("Letras digitadas: ");
            errosLabel.setText("Erros: 0");
            
        } catch (Exception e) {
            mensagemLabel.setText(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ForcaGUI gui = new ForcaGUI();
            gui.setVisible(true);
        });
    }
}
