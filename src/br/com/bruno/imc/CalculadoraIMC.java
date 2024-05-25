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
                onCancel();
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
