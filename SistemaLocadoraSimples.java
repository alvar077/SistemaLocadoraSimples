import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaLocadoraSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Veiculo> veiculos = new ArrayList<>(); // Lista de veículos disponíveis
        List<Cliente> clientes = new ArrayList<>(); // Lista de clientes cadastrados

        // Cadastro de veículos
        System.out.print("Quantos veículos deseja cadastrar? ");
        int numVeiculos = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do scanner

        for (int i = 0; i < numVeiculos; i++) {
            System.out.print("Categoria do veículo (Econômico, Luxo, SUV): ");
            String categoria = scanner.nextLine();
            System.out.print("É exclusivo para VIP? ([SIM]true/[Não]false): ");
            boolean exclusivoVIP = scanner.nextBoolean();
            scanner.nextLine();
            veiculos.add(new Veiculo(categoria, exclusivoVIP)); // Criação do veículo
        }

        // Cadastro de clientes
        System.out.print("Quantos clientes deseja cadastrar? ");
        int numClientes = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do scanner

        for (int i = 0; i < numClientes; i++) {
            System.out.print("Nome do cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Tipo de cliente (Regular ou VIP): ");
            String tipo = scanner.nextLine();
            clientes.add(new Cliente(nome, tipo)); // Criação do cliente
        }

        // Criação de reservas
        Relatorio relatorio = new Relatorio(); // Relatório de reservas
        System.out.print("Quantas reservas deseja fazer? ");
        int numReservas = scanner.nextInt();

        for (int i = 0; i < numReservas; i++) {
            System.out.println("\nReserva " + (i + 1) + ":");
            System.out.print("Número do cliente (0 a " + (clientes.size() - 1) + "): ");
            int clienteIndex = scanner.nextInt();
            System.out.print("Número do veículo (0 a " + (veiculos.size() - 1) + "): ");
            int veiculoIndex = scanner.nextInt();
            System.out.print("Quantidade de dias: ");
            int dias = scanner.nextInt();

            Cliente cliente = clientes.get(clienteIndex);
            Veiculo veiculo = veiculos.get(veiculoIndex);

            // Validação: verifica se o veículo está disponível para o tipo de cliente
            if (veiculo.emManutencao) {
                System.out.println("Este veículo está em manutenção e não pode ser alugado.");
                continue;
            } else if (veiculo.exclusivoVIP && !cliente.tipo.equals("VIP")) {
                System.out.println("Este veículo é exclusivo para clientes VIP.");
                continue;
            }

            // Criação da reserva e registro de atraso, se houver
            Reserva reserva = new Reserva(cliente, veiculo, dias);
            System.out.print("Dias de atraso na devolução (se houver): ");
            int diasAtraso = scanner.nextInt();
            reserva.registrarAtraso(diasAtraso);
            relatorio.adicionarReserva(reserva);  // Adiciona a reserva ao relatório

            // Acumula pontos de fidelidade
            cliente.acumularPontos(dias);
        }

        // Exibe o relatório final
        relatorio.mostrarRelatorio();
        scanner.close();
    }
}