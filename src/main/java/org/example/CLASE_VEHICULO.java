package org.example;

public class CLASE_VEHICULO {
    String placa, marca, propietario,combustible, color;
    double cilindraje;
    public CLASE_VEHICULO() {}
    public CLASE_VEHICULO(String placa, String marca, String propietario, String combustible, String color, double cilindraje){
        this.placa = placa;
        this.marca = marca;
        this.propietario = propietario;
        this.combustible = combustible;
        this.color = color;
        this.cilindraje = cilindraje;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getColor() {
        return color;
    }

    public double getCilindraje() {
        return cilindraje;
    }
}
