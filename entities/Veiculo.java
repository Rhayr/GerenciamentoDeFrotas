package entities;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;

    public Veiculo(){
        this("","",1900,"");
    }

    public Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }
    
    // Métodos Getters and Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public abstract String getTipo();

    public abstract String getDetalhesEspecificos();

    @Override
    public String toString() {
        return "Tipo: " + getTipo() + " - " + modelo + ", " + marca + " e " + ano + " - Placa: " + placa + " - " + getDetalhesEspecificos();
    }

    void ligar() {
        System.out.println("Veículo Ligado!");
    }
}
