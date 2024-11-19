import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    List<Reserva> reservas = new ArrayList<>(); // Lista de reservas realizadas
    double totalReceita = 0; // Total arrecadado com as reservas
    double custoManutencao = 0; // Total gasto com manutenção dos veículos

    // Método para adicionar uma reserva ao relatório
    void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        totalReceita += reserva.calcularTotal();
    }

    // Método para adicionar o custo de manutenção ao relatório
    void adicionarCustoManutencao(double custo) {
        custoManutencao += custo;
    }

    // Método para exibir o relatório final com o total de reservas, custos e lucros
    void mostrarRelatorio() {
        System.out.println("Relatório de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.cliente.nome + ", Total: R$" + reserva.calcularTotal());
        }
        System.out.println("Receita total: R$" + totalReceita);
        System.out.println("Custo de manutenção: R$" + custoManutencao);
        System.out.println("Lucro líquido: R$" + (totalReceita - custoManutencao));
    }
}
