package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Consulta {
    private JTextField PlacaCons;
    private JTextField MarcaCons;
    private JTextField CilindrajeCons;
    private JTextField CombustibleCons;
    private JTextField ColorCons;
    private JTextField PropietarioCons;
    private JButton buscarButton;
    private JButton limpiarButton;
    private JButton regresarButton;
    public JPanel PanelConsulta;

    public Consulta() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/VEHICULOS";
                String user = "root";
                String password = "Lap20112023$";

                String id=PlacaCons.getText();

                CLASE_VEHICULO ve2=new CLASE_VEHICULO();

                String sql="SELECT * FROM DATOS WHERE PLACA="+'"'+id+'"';

                try(Connection conec2= DriverManager.getConnection(url,user,password);){
                    System.out.println("Conexión Exitosa");
                    Statement stat = conec2.createStatement();
                    ResultSet resul= stat.executeQuery(sql);
                    while(resul.next()){
                        ve2.setPlaca(resul.getString("PLACA"));
                        ve2.setMarca(resul.getString("MARCA"));
                        ve2.setCilindraje(resul.getDouble("CILINDRAJE"));
                        ve2.setCombustible(resul.getString("TIPO_COMBUSTIBLE"));
                        ve2.setColor(resul.getString("COLOR"));
                        ve2.setPropietario(resul.getString("PROPIETARIO"));

                        PlacaCons.setText(ve2.getPlaca());
                        MarcaCons.setText(ve2.getMarca());
                        String cilindraje= String.valueOf(ve2.getCilindraje());
                        CilindrajeCons.setText(cilindraje);
                        CombustibleCons.setText(ve2.getCombustible());
                        ColorCons.setText(ve2.getColor());
                        PropietarioCons.setText(ve2.getPropietario());
                    }


                }catch(SQLException v){
                    v.printStackTrace();
                }

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlacaCons.setText("");
                MarcaCons.setText("");
                CilindrajeCons.setText("");
                CombustibleCons.setText("");
                ColorCons.setText("");
                PropietarioCons.setText("");
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame principal = new JFrame();
                principal.setContentPane(new Principal().PanelPrincipal);
                principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                principal.setTitle("Registro y Consulta");
                principal.setSize(500,300);
                principal.setLocationRelativeTo(null);
                principal.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
    }
}
