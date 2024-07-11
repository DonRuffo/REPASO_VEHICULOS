package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registro {
    private JTextField PlacaDato;
    private JTextField MarcaDato;
    private JTextField CilindrajeDato;
    private JTextField CombustibleDato;
    private JTextField ColorDato;
    private JTextField PropietarioDato;
    private JButton regresarButton;
    private JButton registrarButton;
    private JButton limpiarButton;
    public JPanel PanelRegistro;

    public Registro() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/VEHICULOS";
                String user = "root";
                String password = "Lap20112023$";

                CLASE_VEHICULO ve1=new CLASE_VEHICULO();

                String sql="INSERT INTO DATOS(PLACA, MARCA, CILINDRAJE, TIPO_COMBUSTIBLE, COLOR, PROPIETARIO) VALUES (?,?,?,?,?,?)";

                try(Connection conec= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conexión exitosa");
                    PreparedStatement pst = conec.prepareStatement(sql);
                    double cilin=Double.parseDouble(CilindrajeDato.getText());
                    //seteo al objeto
                    ve1.setPlaca(PlacaDato.getText());
                    ve1.setMarca(MarcaDato.getText());
                    ve1.setCilindraje(cilin);
                    ve1.setCombustible(CombustibleDato.getText());
                    ve1.setColor(ColorDato.getText());
                    ve1.setPropietario(PropietarioDato.getText());
                    //subida de los valore seteados
                    pst.setString(1, ve1.getPlaca());
                    pst.setString(2, ve1.getMarca());
                    pst.setDouble(3, ve1.getCilindraje());
                    pst.setString(4, ve1.getCombustible());
                    pst.setString(5, ve1.getColor());
                    pst.setString(6, ve1.getPropietario());

                    int pruebas=pst.executeUpdate();
                    if(pruebas>0){
                        JOptionPane.showMessageDialog(null,"Registro exitoso");
                    }
                }catch(SQLException v){
                    v.printStackTrace();
                }
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
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlacaDato.setText("");
                MarcaDato.setText("");
                CilindrajeDato.setText("");
                ColorDato.setText("");
                PropietarioDato.setText("");
                CombustibleDato.setText("");
            }
        });
    }
}
