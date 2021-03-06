/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author cech
 */
public class ListaSimple {

    NodoLista primerNodo;
    NodoLista ultimoNodo;
    String nombre;

    public ListaSimple() {
        this("lista");
    }

    public ListaSimple(String n) {
        nombre = n;
        primerNodo = ultimoNodo = null;
    }

    public void insertarAlFrente(Object ei) {
        if (estaVacia()) {
            primerNodo = ultimoNodo = new NodoLista(ei);
        } else {
            primerNodo = new NodoLista(ei, primerNodo);
        }
    }

    public void insertarAlFinal(Object ei) {
        if (estaVacia()) {
            primerNodo = ultimoNodo = new NodoLista(ei);
        } else {
            ultimoNodo = ultimoNodo.siguienteNodo = new NodoLista(ei);
        }
    }

    public Object eliminarDelFrente() {
        if (estaVacia()) {
            return "Lista Vacia";
        } else {
            Object ee = primerNodo.datos;
            if (primerNodo == ultimoNodo) {
                primerNodo = ultimoNodo = null;
            } else {
                primerNodo = primerNodo.siguienteNodo;
            }
            return ee;
        }
    }

    public boolean estaVacia() {

        return primerNodo == null;
    }

    public String nodoPosicion(int posicion) {
        String palabra = null;
        if (!estaVacia()) {
            NodoLista temp = primerNodo;
            int c = -1;
            //System.out.println(" ");
            do {
                palabra = temp.datos.toString();
                temp = temp.siguienteNodo;
                c++;
            } while (posicion != c);

        }
        return palabra;
    }
    
    public Object nodoPosicionO(int posicion) {
        Object palabra = null;
        if (!estaVacia()) {
            NodoLista temp = primerNodo;
            int c = -1;
            //System.out.println(" ");
            do {
                palabra = temp.datos;
                temp = temp.siguienteNodo;
                c++;
            } while (posicion != c);

        }
        return palabra;
    }
    
    public Boolean insertar(String word){
        for (int i = 0; i < getsize(); i++) {
            if (nodoPosicionO(i).toString().equalsIgnoreCase(word)) {
                return false;
            }
        }
    return true;
    }
    
    public Boolean dic(String word){
        for (int i = 0; i < getsize(); i++) {
            if (nodoPosicionO(i).toString().equalsIgnoreCase(word)) {
                nodoPosicionKill(i);
                return true;
            }
        }
        //insertarAlFinal(word);
    return false;
    }
    public String nodoPosicionKill(int posicion) {
        String palabra = null;
        if (!estaVacia()) {
            if (posicion == 0) {
                palabra = eliminarDelFrente().toString();
            }
            else if(posicion==getsize() || posicion==(getsize()-1)){
                System.out.println("vas a borrar ultimo nodo");
                NodoLista tempnodo = primerNodo;
                for (int i = 0; i < (getsize()-2); i++) {
                    tempnodo = tempnodo.siguienteNodo;
                }
                palabra=ultimoNodo.datos.toString();
                System.out.println("get: "+palabra);
                ultimoNodo= tempnodo.siguienteNodo;
                tempnodo.siguienteNodo = ultimoNodo;
            }
            else {
                NodoLista temp = primerNodo;
                int c = -1;
                //System.out.println(" ");
                do {
                    palabra = temp.datos.toString();
                    temp = temp.siguienteNodo;
                    c++;
                } while (posicion != c);
                NodoLista cambio2 = temp;
                NodoLista temp2 = primerNodo;
                c = 0;
                //System.out.println(" ");
                while ((posicion - 1) != c) {
                    //palabra = temp.datos.toString();
                    temp2 = temp2.siguienteNodo;
                    c++;
                }
                temp2.siguienteNodo = cambio2;
            }

        }
        return palabra;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.printf("%s vacia\n", nombre);
            return;
        }
        System.out.printf("La %s es: ", nombre);
        NodoLista actual = primerNodo;

        System.out.println(" ");
        while (actual != null) {
            System.out.printf("%s", actual.datos);
            actual = actual.siguienteNodo;
            System.out.println("");
        }

    }

    public Jugadores[] imprimir2() {
        Jugadores[] arraydata = new Jugadores[getsize()];
        if (estaVacia()) {
            System.out.printf("%s vacia\n", nombre);
            return arraydata;
        }
        //System.out.printf("La %s es: ", nombre);
        NodoLista actual = primerNodo;
        int c = 0;
        System.out.println(" ");
        while (actual != null) {
            arraydata[c] = (Jugadores) actual.datos;
            //System.out.printf("%s", actual.datos);
            actual = actual.siguienteNodo;
            //System.out.println("");
            c++;
        }
        return arraydata;
    }

    public int getsize() {

        NodoLista actual = primerNodo;
        int c = 0;
        //System.out.println(" ");
        if (primerNodo != null) {
            do {
                //7System.out.println("Lista: "+ c);
                //System.out.println(actual.lista.nombre);
                //actual.lista.imprimir();
                actual = actual.siguienteNodo;
                c++;
            } while (actual != null);
        }
        return c;
    }
}
