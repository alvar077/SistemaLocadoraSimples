public class Veiculo {
    String categoria; // Categoria do veículo (Econômico, Luxo, SUV)
    boolean emManutencao = false; // Flag para indicar se o veículo está em manutenção
    boolean exclusivoVIP = false; // Define se o veículo é exclusivo para clientes VIP

    // Construtor que inicializa a categoria e se o veículo é exclusivo para VIP
    Veiculo(String categoria, boolean exclusivoVIP) {
        this.categoria = categoria;
        this.exclusivoVIP = exclusivoVIP;
    }

    // Método para bloquear o veículo para manutenção
    void bloquearParaManutencao() {
        emManutencao = true;
    }

    // Método para liberar o veículo de manutenção
    void liberarDeManutencao() {
        emManutencao = false;
    }
}

