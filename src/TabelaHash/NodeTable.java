package TabelaHash;

public class NodeTable {
   
	int info;
    ListaEncadeada list;

    public NodeTable(){
        info = -1;
        list = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public ListaEncadeada getList() {
        return list;
    }

    public void setList(ListaEncadeada list) {
        this.list = list;
    }
}