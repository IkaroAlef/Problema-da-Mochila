package beans;

class Knapsack {
    public static void main(String[] args) throws Exception {
        int valores[] = {40, 60, 15, 30, 20};//vetor de valoror
        int pesos[] = {3, 7, 2, 4, 5};//vetor de pesos
        int pesoMax = 8;//capacidade da mochila
        System.out.println(knapsack(valores, pesos, pesoMax)); //imprime valor total que comp�e a mochila
    }

    public static int knapsack(int valores[], int pesos[], int pesoMax) {

        //N representa o numero total de itens dispostos
        int N = pesos.length; 

        //criar matriz
        int[][] V = new int[N + 1][pesoMax + 1]; 

        //Se a capacidade da mochila � 0, defina todas as colunas da linha 0 para o valor 
        for (int coluna = 0; coluna <= pesoMax; coluna++) {
            V[0][coluna] = 0;
        }
        //Se n�o h� itens na casa(supoe q um ladr�o vai roubar uma casa, por�m n�o h� itens para serem roubados)  
        //Preencha a primeira linha com 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item=1;item<=N;item++){
            //Vamos preencher os valorores linha a linha
            for (int peso=1;peso<=pesoMax;peso++){
                //Se o pesos do item atual � menor ou igual ao pesos da mochila atual 
                if (pesos[item-1]<=peso)
//Dado um pesos, checa se o valor do item atual somado com o valor do item que poder�amos dispor com o pesos restante � maior que o valor sem o item atual  
                    V[item][peso]=Math.max (valores[item-1]+V[item-1][peso-pesos[item-1]], V[item-1][peso]);
                else
//Se o peso do item atual � maior que o peso em execu��o, apenas carregue o valor sem o item atual.
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