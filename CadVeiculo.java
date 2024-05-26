import java.util.Scanner;

import entities.Carro;
import entities.Moto;
import entities.Veiculo;
import services.VeiculoService;

public class CadVeiculo {
    private static Scanner scan;
    private static VeiculoService veiculoService;

    public static void main(String[] args) throws Exception {
        scan = new Scanner(System.in);
        veiculoService = new VeiculoService();
        int opcao;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Sistema de Gerenciamento de Frotas");
            System.out.println("MENU DE OPÇÕES:");
            System.out.println("1 - Cadastrar Novo Veículo");
            System.out.println("2 - Listar todos os Veículos");
            System.out.println("3 - Pesquisar Veículo por Placa");
            System.out.println("4 - Remover Veículo");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            
            while (true) {
                if (scan.hasNextInt()) {
                    opcao = scan.nextInt();
                    if (opcao >= 0 && opcao <= 4)
                        break;
                }
                scan.nextLine();
                System.out.print("Digite um número dentro das opções acima: ");
            }
            scan.nextLine();
            
            switch (opcao) {
                case 1:
                    save();
                    break;
                case 2:
                    VeiculoService.imprimirVeiculos();
                    System.out.println("Pressione Enter para retornar ao Menu Inicial");
                    scan.nextLine();
                    break;
                case 3:
                    pesquisarVeiculoPorPlaca();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 0:
                    System.out.println("Volte logo!");
                    break;
            }
        } while (opcao != 0);
    }

    public static void save() {
        Veiculo veiculoAdd;

        System.out.println("CADASTRO DE VEÍCULO");
        System.out.println("Qual o tipo de veículo");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.print("Digite a opção desejada: ");
        
        int tipoVeiculo;
        while (true) {
            if (scan.hasNextInt()) {
                tipoVeiculo = scan.nextInt();
                if (tipoVeiculo >= 1 && tipoVeiculo <= 2)
                    break;
            }
            scan.nextLine();
            System.out.print("Digite um número dentro das opções acima: ");
        }
        scan.nextLine();

        String descricao = tipoVeiculo == 1 ? "do carro: " : "da moto: ";

        System.out.print("Digite a marca " + descricao);
        String marca = scan.nextLine();
        System.out.print("Digite o modelo " + descricao);
        String modelo = scan.nextLine();
        System.out.print("Digite o ano " + descricao);
        int ano;
        while (true) {
            if (scan.hasNextInt()) {
                ano = scan.nextInt();
                if (ano >= 1900 && ano <= 2024)
                    break;
            }
            scan.nextLine();
            System.out.print("Digite um ano válido: ");
        }
        scan.nextLine();
        System.out.print("Digite a placa " + descricao);
        String placa = scan.nextLine();
        while (VeiculoService.verificarPlaca(placa)) {
            System.out.print("Esta placa já existe! Registre outra: ");
            placa = scan.nextLine();
        }

        if (tipoVeiculo == 1) {
            System.out.print("Digite o número de portas: ");
            int numeroPortas;
            while (true) {
                if (scan.hasNextInt()) {
                    numeroPortas = scan.nextInt();
                    if (numeroPortas == 2 || numeroPortas == 4)
                        break;
                }
                scan.nextLine();
                System.out.print("Digite um número de portas válido: ");
            }
            scan.nextLine();
            veiculoAdd = new Carro(marca, modelo, ano, placa, numeroPortas);
        } else {
            System.out.println("A moto possui partida elétrica: 1-Sim, 2-Não");
            int partidaEletrica;
            while (true) {
                if (scan.hasNextInt()) {
                    partidaEletrica = scan.nextInt();
                    if (partidaEletrica == 1 || partidaEletrica == 2)
                        break;
                }
                scan.nextLine();
                System.out.print("Digite um número dentro das opções acima: ");
            }
            scan.nextLine();
            boolean partida = partidaEletrica == 1;
            veiculoAdd = new Moto(marca, modelo, ano, placa, partida);
        }

        try {
            veiculoService.save(veiculoAdd);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("\nNÃO FOI POSSÍVEL CADASTRAR O VEÍCULO");
            System.out.println(e.getMessage());
        }
        System.out.println("Pressione Enter para voltar ao Menu Inicial");
        scan.nextLine();
    }

    private static void pesquisarVeiculoPorPlaca() { 
        System.out.println("PESQUISA DE VEÍCULOS POR PLACA");
        System.out.print("Informe a placa que deseja pesquisar: ");
        String placa = scan.nextLine();
        Veiculo veiculo = veiculoService.pesquisarPorPlaca(placa);
        if (veiculo != null) {
            System.out.println("Veículo " + veiculo);
        } else {
            System.out.println("Veículo não encontrado com a placa informada");
        }
        System.out.println("Pressione Enter para voltar ao Menu Inicial");
        scan.nextLine();
    }

    private static void removerVeiculo() throws Exception {
        System.out.println("REMOÇÃO DE VEÍCULOS");
        VeiculoService.imprimirVeiculos();
        System.out.print("Digite a placa do veículo que deseja REMOVER: ");
        String placa = scan.nextLine();
        veiculoService.removerPorPlaca(placa);
        System.out.println("Pressione Enter para voltar ao Menu Inicial");
        scan.nextLine();
    }
}
