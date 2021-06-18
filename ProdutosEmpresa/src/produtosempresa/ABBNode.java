package produtosempresa;


public class ABBNode<T extends Comparable<T>> {

    private T info;
    private ABBNode<T> esq;
    private ABBNode<T> dir;

    ABBNode(T valor) {
        info = valor;
    }

    T getInfo() {
        return info;
    }

    void setInfo(T info) {
        this.info = info;
    }

    ABBNode<T> getEsq() {
        return esq;
    }

    void setEsq(ABBNode<T> esq) {
        this.esq = esq;
    }

    ABBNode<T> getDir() {
        return dir;
    }

    void setDir(ABBNode<T> dir) {
        this.dir = dir;
    }

    void insertNode(T valor) {
        if (valor.compareTo(this.getInfo()) < 0) {
            if (this.esq == null) {
                this.esq = new ABBNode(valor);
            } else {
                this.esq.insertNode(valor);
            }
        } else {
            if (this.dir == null) {
                this.dir = new ABBNode(valor);
            } else {
                this.dir.insertNode(valor);
            }
        }
        

    }
    

}
