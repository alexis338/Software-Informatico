
package softwareinformaticomvc;
/**
 *
 * @author Eliel Novelo
 */
public class CsSecante {
    int interacion;
    double xi1,xi,fxi1,fxi,n,d,xi1r,error;
    public int getInteracion() {
        return interacion;
    }
    public double getXi1() {
        return xi1;
    }
    public double getXi() {
        return xi;
    }
    public double getFxi1() {
        return fxi1;
    }
    public double getFxi() {
        return fxi;
    }
    public double getN() {
        return n;
    }
    public double getD() {
        return d;
    }
    public double getXi1r() {
        return xi1r;
    }
    public double getError() {
        return error;
    }
    public void setInteracion(int interacion) {
        this.interacion = interacion;
    }
    public void setXi1(double xi1) {
        this.xi1 = xi1;
    }
    public void setXi(double xi) {
        this.xi = xi;
    }
    public void setFxi1(double fxi1) {
        this.fxi1 = fxi1;
    }
    public void setFxi(double fxi) {
        this.fxi = fxi;
    }
    public void setN(double n) {
        this.n = n;
    }
    public void setD(double d) {
        this.d = d;
    }
    public void setXi1r(double xi1r) {
        this.xi1r = xi1r;
    }        
    public void setError(double error) {
        this.error = error;
    }
    @Override
    public String toString() {
        return "CsSecante{" + "interacion=" + interacion + ", xi1=" + xi1 + ", xi=" + xi + ", fxi1=" + fxi1 + ", fxi=" + fxi + ", n=" + n + ", d=" + d + ", error=" + error + '}';
    }   
}
