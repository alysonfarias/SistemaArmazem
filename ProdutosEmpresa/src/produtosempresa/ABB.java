package produtosempresa;

public class ABB<T extends Comparable<T>> {

    private ABBNode<T> raiz;

    public boolean isEmpty() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }

    }

    public void insert(T valor) {
        if (this.isEmpty() == true) {
            raiz = new ABBNode(valor);
        } else { // árvore não vazia
            raiz.insertNode(valor);
        }
    }

    public void emOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            percorrerEmOrdem(raiz);
        }
    }

    private void percorrerEmOrdem(ABBNode<T> r) {
        if (r != null) {
            percorrerEmOrdem(r.getEsq());
            System.out.println(r.getInfo());
            percorrerEmOrdem(r.getDir());
        }
    }

    private ABBNode<T> buscaMenorValor(ABBNode<T> r) {
        if (r.getEsq() != null) {
            r = buscaMenorValor(r.getEsq());
        }
        return r;
    }

    private ABBNode<T> buscaMaiorValor(ABBNode<T> r) {
        if (r.getDir() != null) {
            r = buscaMaiorValor(r.getDir());
        }
        return r;
    }

    public void insertSemRecursivo(T valor) { // sem recursividade
        ABBNode<T> aux;
        ABBNode<T> novo = new ABBNode(valor);
        if (this.isEmpty() == true) {
            raiz = novo;
        } else {
            aux = raiz;
            while (true) {
                if (valor.compareTo(aux.getInfo()) == 0) {
                    System.out.println("Valor repetido.");
                    System.out.println("Inserção não efetuada");
                    return;
                } else if (valor.compareTo(aux.getInfo()) < 0) { // esquerda
                    if (aux.getEsq() != null) {
                        aux = aux.getEsq();
                    } else {
                        aux.setEsq(novo);
                        System.out.println("Inserção efetuada");
                        return;
                    }
                } else { // direita
                    if (aux.getDir() != null) {
                        aux = aux.getDir();
                    } else {
                        aux.setDir(novo);
                        System.out.println("Inserção efetuada");
                        return;
                    }
                }
            } // fim do while
        }

    }

    //alterei
    public int contarNos() {
        int cont = 0;
        Queue<ABBNode<T>> fila = new Queue();
        ABBNode<T> aux;
        if (!isEmpty()) {
            fila.enqueue(raiz);
            while (!fila.isEmpty()) {
                aux = fila.dequeue();
                if (aux.getEsq() != null) {
                    fila.enqueue(aux.getEsq());
                }
                if (aux.getDir() != null) {
                    fila.enqueue(aux.getDir());
                }
                cont++;
            }
            return cont;
        } else {
            System.out.println("Empty tree");
            return 0;
        }
    }

    public int contarFolhas() {
        int cont = 0;
        Queue<ABBNode<T>> fila = new Queue();
        ABBNode<T> aux;
        if (!isEmpty()) {
            fila.enqueue(raiz);
            while (!fila.isEmpty()) {
                aux = fila.dequeue();
                if (aux.getEsq() != null) {
                    fila.enqueue(aux.getEsq());
                }
                if (aux.getDir() != null) {
                    fila.enqueue(aux.getDir());
                }
                if (aux.getDir() == null && aux.getEsq() == null) {
                    cont++;
                }
            }
            return cont;
        } else {
            System.out.println("Empty tree");
            return 0;
        }
    }

    public int contarNaoTerminal() {
        int cont = 0;
        Queue<ABBNode<T>> fila = new Queue();
        ABBNode<T> aux;
        if (!isEmpty()) {
            fila.enqueue(raiz);
            while (!fila.isEmpty()) {
                aux = fila.dequeue();
                if (aux.getEsq() != null) {
                    fila.enqueue(aux.getEsq());
                }
                if (aux.getDir() != null) {
                    fila.enqueue(aux.getDir());
                }
                if (aux.getDir() != null && aux.getEsq() != null) {
                    cont++;
                }
            }
            return cont + 1;
        } else {
            System.out.println("Empty tree");
            return 0;
        }
    }

    public T procurarNo(T v) {
        if (!isEmpty()) {
            ABBNode<T> aux = raiz;
            while (aux != null) {
                if (v.compareTo(aux.getInfo()) == 0) {
                    return aux.getInfo();
                } else if (v.compareTo(aux.getInfo()) < 0) {
                    aux = aux.getEsq();
                } else {
                    aux = aux.getDir();
                }
            }
            return null;
        } else {
            return null;
        }

    }

    public int procurarNoPorPassseio(T valor) {
        ABBNode<T> aux = raiz;
        int ocorrencia = 0;

        while (aux != null) {
            T info = aux.getInfo();

            if (valor.compareTo(info) == 0) {
                ocorrencia++;
            }

            if (valor.compareTo(info) >= 0) {
                aux = aux.getDir();
            } else {
                aux = aux.getEsq();
            }
        }

        return ocorrencia;
    }

    public T procurarMenorValor() {
        ABBNode<T> r;
        if (this.isEmpty() == true) {
            System.err.println("Empty tree!");
            return null;
        } else {
            r = buscaMenorValor(raiz);
            return r.getInfo();
        }
    }

    public T procurarMaiorValor() {
        ABBNode<T> r;
        if (this.isEmpty() == true) {
            System.err.println("Empty tree!");
            return null;
        } else {
            r = buscaMaiorValor(raiz);
            return r.getInfo();
        }
    }
    
    public void mostrarNos(){
        percorrerEmOrdem(raiz);
    }

    public void remover(T valor) {
        if (!isEmpty()) {
            raiz = removerNode(raiz, valor);
        } else {
        }

    }
    
    private ABBNode<T> removerNode(ABBNode<T> raiz, T valor) {
        if (raiz != null) {
            if (valor.compareTo(raiz.getInfo()) == 0) {
                ABBNode<T> aux = raiz, aux2;
                if (raiz.getEsq() == null && raiz.getDir() == null) {
                    raiz = null;
                } else if (raiz.getEsq() == null) {
                    raiz = raiz.getDir();
                } else if (raiz.getDir() == null) {
                    raiz = raiz.getEsq();
                } else {
                    aux2 = aux.getEsq();
                    while (aux2.getEsq() != null) {
                        aux = aux2;
                        aux2 = aux2.getDir();
                    }
                    aux.setDir(aux2.getEsq());
                    raiz.setInfo(aux2.getInfo());
                }
            } else if (valor.compareTo(raiz.getInfo()) < 0) {
                raiz.setEsq(removerNode(raiz.getEsq(), valor));
            } else {
                raiz.setDir(removerNode(raiz.getDir(), valor));
            }
        }
        return raiz;
    }

}
