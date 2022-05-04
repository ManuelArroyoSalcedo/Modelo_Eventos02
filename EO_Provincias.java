
package compo1;

import java.util.EventObject;

/**
 *
 * @author Manuel Arroyo Salcedo
 */
public class EO_Provincias extends EventObject{
    private String nomProvincia;
    private String cpProvincia;
    private String minisProvincia;
    private int posEnMatriz;

    public EO_Provincias(Object source) {
        super(source);
    }

  
    public String getNomProvincia() {
        return nomProvincia;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }

    public String getCpProvincia() {
        return cpProvincia;
    }

    public void setCpProvincia(String cpProvincia) {
        this.cpProvincia = cpProvincia;
    }

    public String getMinisProvincia() {
        return minisProvincia;
    }

    public void setMinisProvincia(String minisProvincia) {
        this.minisProvincia = minisProvincia;
    }

    public int getPosEnMatriz() {
        return posEnMatriz;
    }

    public void setPosEnMatriz(int posEnMatriz) {
        this.posEnMatriz = posEnMatriz;
    }
    
    
    
    
}
