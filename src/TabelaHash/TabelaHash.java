package TabelaHash;

import java.util.Random;

public class TabelaHash {
    
	private int colisao;
    private NodeTable table[];
    private Random random;

    public TabelaHash(int tamanho){
    	
        colisao = 0;
        table = new NodeTable[tamanho];
        preencherTabela();
    }

    private void preencherTabela(){
    	
        for (int i = 0; i < table.length; i++){
            table[i] = new NodeTable();
        }
    }

    public void insert(int chave){
    	
        int hash = (chave % table.length);
        if (table[hash].getInfo() == -1){
            table[hash].setInfo(chave);
        }
        
        else {
            if (table[hash].getList() == null)
                table[hash].setList(new ListaEncadeada());
            colisao += 1;
            table[hash].getList().insereOrdenado(chave);
        }
    }

    public void print(){
    	
        System.out.println("----Tabela Hash----");
        
        for (int i = 0; i < table.length; i++){
                System.out.print(i + " : ");
                System.out.print(table[i].getInfo() + " ");
                if (table[i].getList() != null){
                    table[i].getList().imprime();
                }
                System.out.println("");
        }
        
        System.out.println("Numero de colisoes: " + colisao);
    
    }

    private int gerarAleatorio(){
    	
        random = new Random();
        return random.nextInt((9999999 - 0));

    }

    public void popularTabela(){
    	
        for (int i = 0; i < table.length * 0.9; i++){
            insert(gerarAleatorio());
        }
    }

    public boolean procura(int chave){
    	
        int hash = (chave % table.length);
        
        if (chave == table[hash].getInfo()){
            return true;
        } 
        else if (table[hash].getList() != null){
             
        	if (table[hash].getList().getNode(chave) != null){
                return true;
            
        	}
        }
        return false;
    }
}