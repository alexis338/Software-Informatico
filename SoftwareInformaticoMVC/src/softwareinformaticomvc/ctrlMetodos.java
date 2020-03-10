/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareinformaticomvc;

import java.util.ArrayList;

/**
 *
 * @author Eliel ja ja
 */
public class ctrlMetodos {

    
    
    public tblBiseccion Biseccion(double li, double ls,double errorDeseado, int it)
      {//rrayList<csBiseccion> lista = new ArrayList<csBiseccion>();
      
        ArrayList <csBiseccion> lista = null;
        tblBiseccion tabla=null;
        double fxi;
        double fxs;
        double errorCalculado = 1;
        int interacion = 0;
        double xAnterior;
        double xActual;
        fxi = this.getfx(li);
        fxs = this.getfx(ls);
        if((fxi*fxs)<0)
        {
            lista = new ArrayList<csBiseccion>();
            while(errorCalculado>errorDeseado && it>0)
            {
               csBiseccion fila = new csBiseccion();
               fila.setInteracion(interacion+1);
               fila.setXi(li);
               fila.setXs(ls);
               fila.setXr((fila.getXi()+fila.getXs())/2);
               fila.setFxi(this.getfx(fila.getXi()));
               fila.setFxr(this.getfx(fila.getXr()));
               fila.setProducto(fila.getFxi()*fila.getFxr());
               if(fila.getProducto()>0)
               {
                   errorCalculado = this.errorRelativo(li, ls);
                   xAnterior = li;
                   li = fila.getXr();
               }
               else{
                   errorCalculado = this.errorRelativo(li, ls);
                   xAnterior = ls;
                   ls = fila.getXr();
               }
               //errorCalculado = this.errorRelativo(fila.getXr(), xAnterior);
               fila.setError(errorCalculado);
               System.out.println(fila.toString());
               lista.add(fila);
               interacion++;
            }
            tabla = new tblBiseccion(lista);
            return tabla;
            
        }
        else return null;
        
      } 
    
    private double getfx(double x)
    {
        return ((9.8*68.1)/x)*(1-Math.exp(-(x/68.1)*10))-40;
    }
    
    private double errorRelativo(double xActual, double xAnterior)
    {
        return Math.abs((xActual-xAnterior)/xActual);
    }
   
    
    //Ejercicio Punto Fijo
    public ArrayList<csFijo> PuntoFijo(double xo, double errorDeseado, int iteraciones){ 
        double x = this.funcion(xo);
        double errorCalculado=1;
        
        ArrayList<csFijo> lista;

        int i = 1; 
        
        lista = new ArrayList<csFijo>();
        
        while (i <= iteraciones && errorCalculado > errorDeseado) {
           
            csFijo fila = new csFijo();
            fila.setIteracion(i);
            fila.setXi(xo); 
            fila.setGx(this.funcion(fila.getXi()));
            
            xo = fila.getGx();         
            if (i > 1) {
                     
                errorCalculado = Math.abs((this.funcion(fila.getXi()) - fila.getXi()) / this.funcion(fila.getXi()));
                fila.setError(errorCalculado);
            } else {
                fila.setError(errorCalculado);
            }
            lista.add(fila);
            i++;
        }
        
        return lista;   
    }
   
    private double funcion(double x){
     
        return Math.pow(2.7182818284590452353602874713527,-x);
    }
    
     //Metodos de Newton
     public tblNewton Newton(double li,double errorDeseado, int it){
         
         ArrayList <csNewton> lista = null;
         tblNewton tabla= null;
         double errorCalculado = 1;
         double xAnterior=0;
        int i = 1;
        lista = new ArrayList<csNewton>();
        while (errorCalculado > errorDeseado && it>0) {
            csNewton fila = new csNewton();
            fila.setIteracion(i); 
            fila.setXi(li); 
            double fxo = this.Funcion(fila.getXi());
            double fxdo = this.DerivadaFuncion(fila.getXi());
            fila.setFxi(fxo); 
            fila.setFdxi(fxdo); 
            fila.setResta(fila.getXi() - (fxo / fxdo));
            xAnterior = fila.getXi(); 
            li = fila.getResta();          
            if (i > 1) {
                      
                errorCalculado = Math.abs((fila.getResta() - fila.getXi()) / fila.getResta());
                fila.setError(errorCalculado);

            } else {
                fila.setError(errorCalculado);
            }
            lista.add(fila);
            i++;
        }
        if (errorCalculado < errorDeseado) {
            tabla = new tblNewton(lista);
            return tabla;
        } else {
            return null;
        }
         
         
     }
     
     public tblSecante Secante(double xi1, double xi, double  error, int iteraciones){
       ArrayList<CsSecante> lista = null;
       tblSecante tabla;
       double fxi1;
       double errorc =1;
       double fxi;
       int iteracion =0;
       fxi1 = getFxi(xi1);
       fxi = getFxi(xi);
            lista = new ArrayList<CsSecante>();
            while(errorc > error && iteraciones > 0){
             CsSecante fila = new CsSecante();
             fila.setInteracion(iteracion +1);
             fila.setXi1(xi1);
             fila.setXi(xi);
             fila.setFxi1(this.getFxi(fila.getXi1()));
             fila.setFxi(this.getFxi(fila.getXi()));
             fila.setN(fila.getFxi()*(fila.xi1-fila.xi));
             fila.setD(fila.getFxi1()-fila.getFxi());
             fila.setXi1r(fila.getXi()-(fila.getN()/fila.getD()));            
             if (fila.getError()< 0) {
                    errorc= this.errorRelativo(fila.getXi1r(), fila.getXi());
                    
                    xi1 = fila.getXi();
                    xi = fila.getXi1r();
                }else{
                    errorc= this.errorRelativo(fila.getXi1r(), fila.getXi());
                    xi1 = fila.getXi();
                    xi = fila.getXi1r(); 
                } //empiza baeza
                fila.setError(errorc);             
                lista.add(fila);
                iteracion++;
            }
         tabla = new tblSecante(lista);
         return tabla;     
    } 
     //metodo secante
    private double getFxi(double x){
        return (Math.exp(-(x)))-x;
    }
     
    //Funciones de Newton
     public double Funcion(double x) {
        return Math.pow(2.7182818284590452353602874713527, -x) - x;
    }

    public double DerivadaFuncion(double x) {
        return -Math.pow(2.7182818284590452353602874713527, -x) - 1;
    }
}

