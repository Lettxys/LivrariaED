package Livraria.SV;

    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    
    public class RelatorioVendas {
        private static final String ARQUIVO_RELATORIO = "vendas.csv";
    
        // Método para registrar uma venda no arquivo CSV
        public static void gerarRelatorio(String produto, int quantidade, double valorTotal) {
            LocalDateTime horario = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String horarioFormatado = horario.format(formatter);
    
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_RELATORIO, true))) {
                String linha = String.format("%s;%s;%d;%.2f\n", 
                    horarioFormatado, produto, quantidade, valorTotal);
                
                writer.write(linha);
                System.out.println("Venda registrada com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao salvar relatório: " + e.getMessage());
            }
        }
    }

