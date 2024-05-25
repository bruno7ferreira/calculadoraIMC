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

        buttonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CalculadoraIMC dialog = new CalculadoraIMC();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
