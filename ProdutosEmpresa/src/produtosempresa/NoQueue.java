/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtosempresa;

/**
 *
 * @author Pichau
 * @param <T>
 */
public class NoQueue<T>  {

    private T info;
    private NoQueue<T> prox;
    
    NoQueue (T valor) {
        info = valor;
    }
    void setInfo(T valor) {
        info = valor;
    }
    void setProx (NoQueue<T> novoProx) {
        prox = novoProx;
    }
    T getInfo() {
        return info;
    }
    NoQueue<T> getProx() {
        return prox;
    }    
}

