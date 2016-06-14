package beans;

class Knapsack {
    public static void main(String[] args) throws Exception {
        int valores[] = {10, 40, 30, 50, 10, 20};//vetor de valorores
        int pesos[] = {1, 4, 6, 3, 1, 5};//vetor de pesos
        int pesoMax = 10;//capacidade da mochila
        System.out.println(knapsack(valores, pesos, pesoMax)); //imprime valoror total que compõe a mochila
    }

    public static int knapsack(int valores[], int pesos[], int pesoMax) {

        //N representa o numero total de itens dispostos
        int N = pesos.length; 

        //criar matriz
        int[][] V = new int[N + 1][pesoMax + 1]; 

        //Se a capacidade da mochila é 0, defina todas as colunas da linha 0 para o valoror 
        for (int coluna = 0; coluna <= pesoMax; coluna++) {
            V[0][coluna] = 0;
        }
        //Se não há itens na casa - What if there are no items at home. (supoe q um ladrão vai roubar uma casa, porém não há itens para serem roubados)  
        //Preencha a primeira linha com 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item=1;item<=N;item++){
            //Vamos preencher os valorores linha a linha
            for (int peso=1;peso<=pesoMax;peso++){
                //Se o pesos do item atual é menor ou igual ao pesos da mochila atual 
                if (pesos[item-1]<=peso)
//Dado um pesos, checa se o valoror do item atual somado com o valoror do item que poderíamos dispor com o pesos restante é maior que o valoror sem o item atual  
                    V[item][peso]=Math.max (valores[item-1]+V[item-1][peso-pesos[item-1]], V[item-1][peso]);
                else
//Se o pesos do item atual é maior que o pesos em execução, apenas carregue o valoror sem o item atual.
                    V[item][peso]=V[item-1][peso];
            }
        }
        //imprimir a matriz 
        for (int[] linha : V) {
            for (int coluna : linha) {
                System.out.format("%5d", coluna);
            }
            System.out.println();
        }
        return V[N][pesoMax];
    }
}