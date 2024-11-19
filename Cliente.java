public class Cliente {
    String nome; // Nome do cliente
    String tipo; // Tipo de cliente: Regular ou VIP
    int pontos = 0; // Pontos acumulados pelo cliente (para descontos futuros)

    // Construtor que inicializa o nome e o tipo de cliente
    Cliente(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    // Método que retorna o desconto com base no tipo de cliente ou pontos acumulados
    double obterDesconto() {
        // Se for VIP, tem 15% de desconto. Se não for VIP e tiver 10 ou mais pontos, tem 10% de desconto.
        return tipo.equals("VIP") ? 0.85 : (pontos >= 10 ? 0.90 : 1.0);
    }

    // Método para acumular pontos com base no número de dias de locação
    void acumularPontos(int valor) {
        pontos += valor;
    }
}
