import java.time.LocalDateTime;

/**
 * Ficha1 - Exercicios II
 */
public class Ficha1 {

    public class Exe2 {
        /** Exercicio 1
        *
        * Converte temperatura de celsius para farenheit
        *
        * @param graus temperatura em celsius
        * @return temperatura em farenheit
        */
        public double celsiusParaFarenheit(double graus) {
            return graus * 1.8 + 32;
        }

        /** Exercicio 2
        *
        * Retorna o maior de dois numeros
        *
        * @param a primeiro numero
        * @param b segundo numero
        * @return maior numero
        */
        public int maximoNumeros(int a, int b) {
            int max = a > b ? a : b;
            System.out.println(max);
            return max;
        }

        /** Exercicio 3
        *
        * Cria descricao de conta
        *
        * @param nome nome do titular da conta
        * @param saldo saldo da conta
        * @return descricao da conta
        */
        public String criaDescricaoConta(String nome, double saldo) {
            String msg = "Nome: " + nome + ", saldo: " + saldo;
            System.out.println(msg);
            return msg;
        }

        /** Exercicio 4
        *
        * Converte euros para libras
        *
        * @param valor valor em euros
        * @param taxaConversao taxa de conversao
        * @return valor em libras
        */
        public double eurosParaLibras(double valor, double taxaConversao) {
            return valor * taxaConversao;
        }

        // Exercicio 5 -Made in TestePrograma

        /** Exercicio 6
        *
        * Calcula o factorial de um numero
        *
        * @param num numero
        * @return factorial do numero
        */
        public long factorial(int num) {
            long r = 1;
            while (num > 1) {
                r *= num;
                num--;
            }
            return r;
        }

        /** Exercicio 7
        *
        * Calcula o tempo gasto a calcular o factorial de 5000
        *
        * @return tempo gasto
        */
        public long tempoGasto() {
            LocalDateTime startDateTime = LocalDateTime.now();

            // factorial of 5000
            factorial(5000);

            LocalDateTime endDateTime = LocalDateTime.now();

            // get difference in milliseconds between start and end
            long diff = java.time.Duration.between(startDateTime, endDateTime).toMillis();
            return diff;
        }
    }
}
