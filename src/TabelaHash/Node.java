package TabelaHash;

public class Node {
    private Integer info;
    private Node prox;

    public Node(){
        info = null;
        prox = null;
    }

    public Node(int info){
        this.info = info;
        prox = null;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Node getProx() {
        return prox;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }
}