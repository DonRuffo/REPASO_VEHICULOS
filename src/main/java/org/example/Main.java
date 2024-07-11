package org.example;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame principal = new JFrame();
        principal.setContentPane(new Principal().PanelPrincipal);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setTitle("Registro y Consulta");
        principal.setSize(500,300);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
    //DENNIS DIAZ
}