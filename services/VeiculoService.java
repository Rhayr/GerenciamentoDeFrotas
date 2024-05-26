package services;

import java.util.ArrayList;
import java.util.List;

import entities.Veiculo;

public class VeiculoService {
    private static List<Veiculo> veiculosDB;

    public VeiculoService() {
        VeiculoService.veiculosDB = new ArrayList<>();
    }

    public static List<Veiculo> getVeiculosDB() {
        return veiculosDB;
    }

    public Veiculo save(Veiculo veiculo) throws Exception {
        if (veiculo == null)
            throw new Exception("Objeto nulo");
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty())
            throw new Exception("Campo Marca não pode ser em branco");
        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty())
            throw new Exception("Campo Modelo não pode ser em branco");
        if (veiculo.getAno() <= 0)
            throw new Exception("Campo Ano deve ser um valor positivo");
        if (veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty())
            throw new Exception("Campo Placa não pode ser em branco");
        
        veiculosDB.add(veiculo);
        return veiculo;
    }

    public Veiculo pesquisarPorPlaca(String placa) {
        for (Veiculo veiculo : veiculosDB) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void removerPorPlaca(String placa) throws Exception {
        Veiculo veiculo = pesquisarPorPlaca(placa);

        try {
            if (veiculo == null ) {
                System.out.println("Veículo não encontrado com a placa informada.");
            } else {
            veiculosDB.remove(veiculo);
            System.out.println("Veículo removido com sucesso!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean verificarPlaca(String placa) {
        List<Veiculo> veiculos = VeiculoService.getVeiculosDB();
        for (Veiculo veiculo : veiculos) {
            if (placa.equals(veiculo.getPlaca())) {
                return true;
            }
        }
        return false;
    }
    
    public static void imprimirVeiculos() {
        System.out.println("LISTA DE VEÍCULOS CADASTRADOS");
        List<Veiculo> veiculos = VeiculoService.getVeiculosDB();
        int contador = 1;
        for (Veiculo veiculo : veiculos) {
            System.out.println("Veículo " + contador + " - " + veiculo);
            contador++;
        }
    }
}

