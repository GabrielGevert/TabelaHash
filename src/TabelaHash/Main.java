package TabelaHash;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o tamanho desejado da tabela: ");
        TabelaHash th = new TabelaHash(sc.nextInt());

        th.popularTabela();

        /*
        
        th.insert(08);
        th.insert(09);
        th.insert(10);
        th.insert(11);
        th.insert(12);
        th.insert(13);
        th.insert(300);
        th.insert(303);
        th.insert(305);
        
        */

        th.print();


        System.out.print("Deseja procurar um numero? (1 ou -1) ");
        
        while (sc.nextInt() != -1){
        	
            System.out.print("Digite o valor a ser procurado: ");
            
            if (th.search(sc.nextInt())){
            	
                System.out.println("Valor encontrado!");
            }
            else {
                System.out.println("Valor nao encontrado!");
            }
            System.out.print("Deseja procurar outro numero? (1 ou -1) ");
        }
    }
}