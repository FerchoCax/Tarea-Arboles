package otroarbol;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * ferch
 */
public class Escena extends JPanel
{
    private ArbolGeneral<Character> arbolGeneral;
    private PanelArbol<Character> vista;
    
    
    public Escena()
    {
        int aux =0;
        int p = -1;
        int arbolAnterior = 0;
        ArrayList<Character> nodos = new ArrayList <Character>();
        ArrayList<Character> nodosAux = new ArrayList <Character>();
        String arbol = "A(B(E(K,L),F),C(G),D(H(M),I,J)))";
         char c ;
        //Nodo dato = null;
        
        while(true){
            c = Hijos(arbol);
        if(Hijos(arbol)=='?'){
            break;
        }
        if(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')||((c =='(') || (c == ')') || (c == ','))){
            nodos.add(c);
        }
           arbol = arbol.substring(Hijos2(arbol)+1);
        }
        this.arbolGeneral=new ArbolGeneral<Character>();
       Elemento<Character> elemento=arbolGeneral.insertarRaiz(nodos.get(0));
       int Hijo=0;
       char ultimoPadre = ' ';
       int conteo=0;
       System.out.println(nodos.get(28));
        for (int i = 1; i < nodos.size(); i++) {
            
            if((EsLetra(nodos.get(i))==1) && (Hijo==0) && (nodos.get(i-1)==',') && (nodos.get(i-2)==')')&&(nodos.get(i+1)=='(') && Hijo == 0){
                elemento=arbolGeneral.insertarHijo(arbolGeneral.getRaiz(),nodos.get(i));
                ultimoPadre= nodos.get(i);
                System.out.println(nodos.get(i));
                System.out.println("Fase 1");
                System.out.println(Hijo);
            }else if(((EsLetra(nodos.get(i))==1) && (((nodos.get(i-1)=='(' && nodos.get(i+1)==')') || (nodos.get(i-1)=='(' && nodos.get(i+1)==',') || (nodos.get(i-1)==',' && nodos.get(i+1)==','))) && (Hijo==0))){
                arbolGeneral.insertarHijo(elemento,nodos.get(i));
                System.out.println(nodos.get(i));
                System.out.println("Fase 2");
                System.out.println(Hijo);
            }else if((((EsLetra(nodos.get(i))==1)) && ((nodos.get(i+1)=='('))&& (EsLetra(nodos.get(i+2))==1))&& Hijo==0){
                Hijo +=1;
                elemento=arbolGeneral.insertarHijo(elemento,nodos.get(i));
                System.out.println(nodos.get(i));
                //ultimoPadre= nodos.get(i);
                System.out.println("Fase 3");
                System.out.println(Hijo);
                
                
            }else if(((EsLetra(nodos.get(i))==1) && (((nodos.get(i-1)==',')&& nodos.get(i+1)==')')
                    || ((nodos.get(i-1)=='(') && nodos.get(i+1)==')'))) && (Hijo==1) ){
                Hijo -=1;
                arbolGeneral.insertarHijo(arbolGeneral.obtenerElemento(ultimoPadre),nodos.get(i)); 
                System.out.println(nodos.get(i));
                System.out.println("Fase 4");
                System.out.println(Hijo);
            }else  if((((EsLetra(nodos.get(i))==1)) && ((nodos.get(i+1)=='('))&& (EsLetra(nodos.get(i+2))==1))&& Hijo==1){
                Hijo +=1;
                elemento=arbolGeneral.insertarHijo(elemento,nodos.get(i));
                System.out.println(nodos.get(i));
                System.out.println("Fase 10");
                System.out.println(Hijo);
                ultimoPadre= nodos.get(i);
            }
            
            if(((EsLetra(nodos.get(i))==1) && (((nodos.get(i-1)=='(' && nodos.get(i+1)==')') || (nodos.get(i-1)=='(' && nodos.get(i+1)==',') || (nodos.get(i-1)==',' && nodos.get(i+1)==','))) && (Hijo==1))){
                //arbolGeneral.insertarHijo(elemento,nodos.get(i));
                arbolGeneral.insertarHijo(arbolGeneral.obtenerElemento(ultimoPadre),nodos.get(i));
                System.out.println(nodos.get(i));
                System.out.println("Fase 5");
                
                
            }
            if((((EsLetra(c)==1)) && ((nodos.get(i-1)=='(')) && (EsLetra(nodos.get(i+2))==1))&& Hijo==1){ 
                Hijo +=1;
                System.out.println(nodos.get(i));
                System.out.println("Fase 6");
                elemento=arbolGeneral.insertarHijo(elemento,nodos.get(i));              
            }else if(((EsLetra(nodos.get(i))==1) && ((nodos.get(i-1)==',')&& nodos.get(i+1)==')') || ((nodos.get(i-1)=='(') && nodos.get(i+1)==')')) && (Hijo==2) ){
                Hijo -=1;
                arbolGeneral.insertarHijo(elemento,nodos.get(i)); 
                System.out.println(nodos.get(i));
                System.out.println("Fase 7");
                System.out.println(Hijo);
            }else
            
            if((nodos.get(i)==')') && Hijo==2){
                Hijo-=1;
                System.out.println("Fase 8");
                //arbolGeneral.insertarHijo(arbolGeneral.obtenerElemento('I'),'W');
            }
            else if(((EsLetra(nodos.get(i))==1) && (((nodos.get(i-1)=='(' && nodos.get(i+1)==')') || (nodos.get(i-1)=='(' && nodos.get(i+1)==',') || (nodos.get(i-1)==',' && nodos.get(i+1)==','))) && (Hijo==2))){
                arbolGeneral.insertarHijo(elemento,nodos.get(i));
                System.out.println(nodos.get(i));
                System.out.println("Fase 9");
                System.out.println(Hijo);
            }
            
            else if(((EsLetra(nodos.get(i))==1) && (((nodos.get(i-1)==',' && nodos.get(i+1)==')') || (nodos.get(i-1)=='(' && nodos.get(i+1)==',') || (nodos.get(i-1)==',' && nodos.get(i+1)==','))) && (Hijo==1))){
                arbolGeneral.insertarHijo(arbolGeneral.obtenerElemento(ultimoPadre),nodos.get(i));
                System.out.println(nodos.get(i));
                System.out.println("Fase 11");
                System.out.println(Hijo);
                System.out.println(arbolGeneral.obtenerElemento(ultimoPadre));
            }
            /*
            ---------------------------------------------------------------------------------------------------------------
            if((((EsLetra(nodos.get(i))==1)) && ((nodos.get(i+1)=='(')) && (EsLetra(nodos.get(i+2))==1))&& Hijo==1){
                System.out.println(Hijo);
                Hijo +=1;
                System.out.println(Hijo);
                elemento=arbolGeneral.insertarHijo(elemento,nodos.get(i));
                elemento=arbolGeneral.insertarHijo(elemento,'D');
                
            }
            
            if(((EsLetra(nodos.get(i))==1) && (((nodos.get(i-1)=='(' && nodos.get(i+1)==')') || (nodos.get(i-1)=='(' && nodos.get(i+1)==',') || (nodos.get(i-1)==',' && nodos.get(i+1)==','))) && (Hijo==1))){
                arbolGeneral.insertarHijo(elemento,nodos.get(i));
            }
            
            else if(((EsLetra(nodos.get(i))==1) && ((nodos.get(i-1)==',')&& nodos.get(i+1)==')')|| ((nodos.get(i-1)=='(') && nodos.get(i+1)==')')) && (Hijo==2) ){
                Hijo -=1;
                arbolGeneral.insertarHijo(elemento,nodos.get(i));
                
            }
            
            
//((nodos.get(i-1)=='(' && nodos.get(i+1)==')') || (nodos.get(i-1)==',' && nodos.get(i+1)==')') || (nodos.get(i-1)=='(' && nodos.get(i+1)==',') || (nodos.get(i-1)==',' && nodos.get(i+1)==','))
            
            if(nodos.get(i)==')'){
                Hijo=0;
            }
            
            
         */  
            conteo++;
        }
        /*Elemento<Character> elemento=arbolGeneral.insertarRaiz('B');
        arbolGeneral.insertarHijo(elemento,'A');
        elemento=arbolGeneral.insertarHijo(elemento,'D');
        arbolGeneral.insertarHijo(elemento,'C');
        arbolGeneral.insertarHijo(elemento,'E');
        arbolGeneral.insertarHijo(elemento,'J');
        elemento=arbolGeneral.insertarHijo(elemento,'G');
        arbolGeneral.insertarHijo(elemento,'F');
        elemento=arbolGeneral.insertarHijo(arbolGeneral.getRaiz(),'I');
        arbolGeneral.insertarHijo(elemento,'H');
        elemento=arbolGeneral.insertarHijo(elemento,'P');
        arbolGeneral.insertarHijo(elemento,'L');
        
        arbolGeneral.insertarHijo(arbolGeneral.obtenerElemento('I'),'W');
        elemento=arbolGeneral.insertarHijo(arbolGeneral.getRaiz(),'O');
        arbolGeneral.insertarHijo(elemento,'M');*/
        //System.out.println(conteo);
        this.vista=new PanelArbol<Character>(arbolGeneral);
        this.setLayout(new BorderLayout());
        add(vista,BorderLayout.CENTER);


    
    }
    
    public static int EsLetra(char c){
        if(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))){
            return 1;
        }else{
            return 0;
        }
    }
    
    public static char Hijos(String Arbol){
        if (Arbol.length()!=0){
        char c = Arbol.charAt(0);
        // Si no está entre a y z, ni entre A y Z, ni es un espacio
         if(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')){
            //int startIndex = Arbol.indexOf(c);
            return c;
        }else if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')){
             //int startIndex = Arbol.indexOf(c);
             return c;
        }
        }
    return '?';
    }
    public static int Hijos2(String Arbol){
        char c = Arbol.charAt(0);
        // Si no está entre a y z, ni entre A y Z, ni es un espacio
         if(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')){
            int startIndex = Arbol.indexOf(c);
            return startIndex;
        }else if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')){
             int startIndex = Arbol.indexOf(c);
             return startIndex;
        }
    return -1;
    }
}
