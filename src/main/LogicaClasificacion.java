package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    
    public String invertirCadena(String texto) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<String>();
        for ( int i = 0 ; i < texto.length() ; i++){
                st.push(texto.charAt(i) + "");
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb +"";
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> st = new Stack<Character>();
        Map < Character , Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put(']', '[');
        mp.put('}', '{');
        for ( char c : expresion.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            }else{
              if (st.isEmpty() || st.pop() != mp.get(c)) {
                    return false;
                }  
            }
            
        }

        return st.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
   public List<Integer> ordenarPila(Stack<Integer> pila) {
    Stack<Integer> st = new Stack<>();

    while (!pila.isEmpty()) {
        int tp = pila.pop();

        while (!st.isEmpty() && st.peek() < tp) {
            pila.push(st.pop());
        }

        st.push(tp);
    }

    List<Integer> resultado = new ArrayList<>();
    while (!st.isEmpty()) {
        resultado.add(st.pop());
    }

    return resultado; 
}


    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) { 
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for (Integer n : original){
            if(n %2 == 0){
                pares.add(n);
            }else{
                impares.add(n);
            }
        }

        LinkedList<Integer> f = new LinkedList<>();
        f.addAll(pares);
        f.addAll(impares);

        return f ;
    }
}
