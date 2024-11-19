public class Reserva {
    Cliente cliente; // Cliente que fez a reserva
    Veiculo veiculo; // Veículo reservado
    int dias; // Número de dias da locação
    int diasAtraso = 0; // Quantidade de dias de atraso na devolução
    double taxaDiaria = 100.0; // Taxa diária de locação
    double taxaAtraso = 20.0; // Taxa adicional por dia de atraso

    // Construtor que inicializa os dados da reserva
    Reserva(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;
    }

    // Método que calcula o valor total da reserva, aplicando o desconto e as taxas de atraso
    double calcularTotal() {
        double total = dias * taxaDiaria * cliente.obterDesconto();
        if (diasAtraso > 0) {
            total += diasAtraso * taxaAtraso;  // Aplica a taxa de atraso, se houver
        }
        return total;
    }

    // Método para registrar os dias de atraso na devolução
    void registrarAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }
}
