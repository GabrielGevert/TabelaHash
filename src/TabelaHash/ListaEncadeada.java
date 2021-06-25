package TabelaHash;

public class ListaEncadeada {
	
    private Node primeiro;

    public ListaEncadeada() {
    	
        primeiro = null;
    }

    public boolean vazia(){
    	
        return primeiro == null;
    }

    public void inserePrimeiro(int info){
    	
        Node aux = new Node();
        aux.setInfo(info);
        aux.setProx(primeiro);
        primeiro = aux;
    }

    public Node getNode(int info){
    	
        Node aux = primeiro;
        
        while (aux != null){
            if (aux.getInfo() == info){
                return aux;
            }
            else {
                aux = aux.getProx();
            }
        }
        return null;
    }

    public void insereDepois(Node node, int info){
    	
        Node aux = primeiro;
        Node n = new Node();
        n.setInfo(info);
        
        if (vazia()) {
            System.out.println("A lista encontra-se vazia!");
        }
        else {
            while (aux != null){
                if (aux == node){
                    n.setProx(aux.getProx());
                    aux.setProx(n);
                    break;
                }
                aux = aux.getProx();
            }
        }
    }

    public void insereUltimo(int info){
    	
        Node node = new Node();
        Node aux = primeiro;
        if (vazia()){
            inserePrimeiro(info);
        }
        else {
            while (aux != null){
                if (aux.getProx() == null){
                    node.setInfo(info);
                    aux.setProx(node);
                    break;
                }
                aux = aux.getProx();
            }
        }
    }

    public void insereOrdenado(int info){
    	
        Node node = new Node();
        node.setInfo(info);
        Node aux = primeiro;
        Node anterior = new Node();
        
        if (vazia()){
        	
            inserePrimeiro(info);
            
        }else {
        	
            while (aux != null){
                anterior = aux;
                if (info <= aux.getInfo()){
                    inserePrimeiro(info);
                    break;
                } 
                else if (aux.getProx() == null){
                    insereUltimo(info);
                    break;
                } 
                else if (info <= aux.getProx().getInfo()){
                    node.setProx(aux.getProx());
                    anterior.setProx(node);
                    break;
                }
                aux = aux.getProx();
            }
        }
    }

    public Node removePrimeiro(){
    	
        if (vazia()){
        	
            System.out.println("A lista ja esta vazia!");
            return null;
        }
        else {
        	
            System.out.println("Node " + primeiro.getInfo() + " removido!");
            primeiro = primeiro.getProx();
            return primeiro;
        }
    }

    public Node removeUltimo(){
    	
        Node aux = primeiro;
        Node removed = new Node();
        
        if (vazia()){
            System.out.println("A lista esta vazia");
        }
        else {
            while (aux != null){
                if (aux.getProx().getProx() == null){
                    removed.setInfo(aux.getProx().getInfo());
                    aux.setProx(null);
                    break;
                }
                aux = aux.getProx();
            }
        }
        return removed;
    }

    public Node remove(Node no){
    	
        Node aux = primeiro;
        Node anterior = new Node();
        Node removed = new Node();
        try{
            if(vazia()){
                System.out.println("Lista esta vazia!");
                return null;
            }
            else {
                while (aux != null){
                    anterior = aux;
                    if (primeiro == no){
                        removed = removePrimeiro();
                    } else if (aux.getProx() == no){
                        System.out.println("Node " + aux.getProx().getInfo() + " removido!");
                        removed = aux.getProx();
                        anterior.setProx(aux.getProx().getProx());
                    }
                    aux = aux.getProx();
                }
            }
        }catch (NullPointerException e){
            System.out.println("Node a ser removido nao encontrado");
        }
        return removed;
    }

    public Node getUltimo(){
        Node aux = primeiro;
        if (vazia()){
            return null;
        } else {
            while (aux != null){
                if (aux.getProx() == null){
                    return aux;
                }
                aux = aux.getProx();
            }
        }
        return aux;
    }

    public void imprime(){
        Node aux = primeiro;
        while (aux != null){
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
    }
}