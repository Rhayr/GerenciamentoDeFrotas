package entities;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String marca, String modelo, int ano, String placa, int numeroPortas) {
        super(marca, modelo, ano, placa);
        this.numeroPortas = numeroPortas;
    } 

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    @Override
    public String getTipo() {
        return "Carro";
    }

    @Override
    public String getDetalhesEspecificos() {
        return "N. Portas: " + numeroPortas;
    }

    @Override
    public String toString() {
        return "Tipo: " + getTipo() + " - " + getMarca() + " " + getModelo() + " " + getAno() + " - Placa: " + getPlaca() + " - " + getDetalhesEspecificos();
    }
}
