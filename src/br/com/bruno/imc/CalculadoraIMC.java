package br.com.bruno.imc;

import javax.swing.*;
import java.awt.event.*;

public class CalculadoraIMC extends JDialog {
    private JPanel contentPane;
    private JButton buttonCalcular;
    private JButton buttonLimpar;
    private JTextField textFieldAltura;
    private JTextField textFieldPeso;
    private JFormattedTextField formattedTextFieldResultado;
    private JLabel labelPeso;
    private JLabel labelAltura;
    private JLabel labelResultado;
    private JLabel imagemIMC;
    private JEditorPane editorPaneTabelaIMC;

    public CalculadoraIMC() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCalcular);

        // inserindo acao no botao calcular
        buttonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCalcular();
            }
        });

        // inserindo acao no botao limpar
        buttonLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLimpar();

            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCalcular() {
        // acao ao clicar no botao calcular
        try {
            // recebendo o valor de altura
            double altura = Double.parseDouble(textFieldAltura.getText());
            double peso = Double.parseDouble(textFieldPeso.getText());
            double imc = peso / (altura * altura);
            formattedTextFieldResultado.setText(String.format("%.2f", imc));

            //adicionando retorno de acordo com a tabela:
            String categoriaIMC;
            if (imc < 18.5) {
                categoriaIMC = "Abaixo do peso\n" +
                        "Pode indicar desnutrição ou um problema de saúde subjacente.\n" +
                        "Importante procurar orientação médica e nutricional.";
            } else if (imc >= 18.5 && imc < 25.0) {
                categoriaIMC = "Peso normal\n" +
                        "Indica que o peso está adequado em relação à altura.\n" +
                        "Recomenda-se manter hábitos saudáveis de alimentação e atividade física.";
            } else if (imc >= 25.0 && imc < 30.0) {
                categoriaIMC = "Sobrepeso\n" +
                        "Pode ser um sinal de risco aumentado para problemas de saúde como doenças cardíacas, diabetes tipo 2 e pressão alta.\n" +
                        "Aconselha-se adotar um estilo de vida saudável para evitar o ganho adicional de peso.";
                ;
            } else if (imc >= 30.0 && imc < 35.0) {
                categoriaIMC = "Obesidade Grau I\n" +
                        "Aumenta significativamente o risco de desenvolver problemas de saúde associados ao peso.\n" +
                        "Importante buscar orientação profissional para manejo do peso.";
            } else if (imc >= 35.0 && imc < 40.0) {
                categoriaIMC = "Obesidade Grau II\n" +
                        "Indica um risco elevado de problemas de saúde graves.\n" +
                        "Necessário intervenção médica e mudanças no estilo de vida para redução do peso.";
            } else {
                categoriaIMC = "Obesidade Grau III\n" +
                        "Também conhecida como obesidade mórbida, representa um risco muito alto de complicações de saúde.\n" +
                        "Requer tratamento médico especializado e, muitas vezes, pode incluir intervenção cirúrgica.";
            }

            // Exibindo a categoria de IMC no editor de texto formatado
            editorPaneTabelaIMC.setText("Categoria de IMC: " + categoriaIMC);


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos para altura e peso.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void onLimpar() {
        // acao ao clicar no botao limpar
        textFieldAltura.setText("");
        textFieldPeso.setText("");
        formattedTextFieldResultado.setText("");

    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        CalculadoraIMC dialog = new CalculadoraIMC();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
