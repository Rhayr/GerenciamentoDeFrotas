package entities;

public final class Moto extends Veiculo {
    private boolean partidaEletrica;

    public Moto(String marca, String modelo, int ano, String placa, boolean partidaEletrica) {
        super(marca, modelo, ano, placa);
        this.partidaEletrica = partidaEletrica;
    }

    public boolean getPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    @Override
    public String getTipo() {
        return "Moto";
    }

    @Override
    public String getDetalhesEspecificos() {
        return partidaEletrica ? "Partida Elétrica: Sim" : "Partida Elétrica: Não";
    }

    @Override
    public String toString() {
        return "Tipo: " + getTipo() + " - " + getMarca() + " " + getModelo() + " " + getAno() + " - Placa: " + getPlaca() + " - " + getDetalhesEspecificos();
    }
}


