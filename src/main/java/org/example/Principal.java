package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    private JButton registroButton;
    private JButton consultaButton;
    public JPanel PanelPrincipal;

    public Principal() {
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Registro = new JFrame();
                Registro.setTitle("Registro");
                Registro.setContentPane(new Registro().PanelRegistro);
                Registro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Registro.setSize(400,300);
                Registro.setLocationRelativeTo(null);
                Registro.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(registroButton)).dispose();
            }
        });
        consultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Consulta = new JFrame();
                Consulta.setTitle("Consulta");
                Consulta.setContentPane(new Consulta().PanelConsulta);
                Consulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Consulta.setSize(400,300);
                Consulta.setLocationRelativeTo(null);
                Consulta.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(consultaButton)).dispose();
            }
        });
    }
}
