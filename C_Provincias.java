
package compo1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Este es un componente que conta de una etiqueta y un ComboBox que contiene las provincias de España.
 * Asociado a cada provincia hay un código.
 * Este componente está dotado de eventos para que cuando se seleccione un elemento se proporcione el nombre de la provnicia y su código
 * @author Manuel Arroyo Salcedo
 */
public class C_Provincias extends JPanel{
    private JComboBox<String> provincia;
    private JLabel etiqueta;
    private String mensaje = "Elija una provincia";
    private Boolean hayMensaje = true;
    private int seleccionado;
    
    
    
    
    private String[][] MatrizProv = {{"01","Álava","VI"}, {"02","Albacete","AB"}, {"03","Alicante","A"}, {"04","Almería","AL"}, {"05","Ávila","AV"}, {"06","Badajoz","BA"}, {"07","Baleares","PM / IB"}, {"08","Barcelona","B"}, {"09","Burgos","BU"}, {"10","Cáceres","CC"}, {"11","Cádiz","CA"}, {"12","Castellón","CS"}, {"13","Ciudad Real","CR"}, {"14","Córdoba","CO"}, {"15","La Coruña","C"}, {"16","Cuenca","CU"}, {"17","Gerona/Girona","GE / GI"}, {"18","Granada","GR"}, {"19","Guadalajara","GU"}, {"20","Guipúzcoa","SS"}, {"21","Huelva","H"}, {"22","Huesca","HU"}, {"23","Jaén","J"}, {"24","León","LE"}, {"25","Lérida/Lleida","L"}, {"26","La Rioja","LO"}, {"27","Lugo","LU"}, {"28","Madrid","M"}, {"29","Málaga","MA"}, {"30","Murcia","MU"}, {"31","Navarra","NA"}, {"32","Orense","OR / OU"}, {"33","Asturias","O"}, {"34","Palencia","P"}, {"35","Las Palmas","GC"}, {"36","Pontevedra","PO"}, {"37","Salamanca","SA"}, {"38","Santa Cruz de Tenerife","TF"}, {"39","Cantabria","S"}, {"40","Segovia","SG"}, {"41","Sevilla","SE"}, {"42","Soria","SO"}, {"43","Tarragona","T"}, {"44","Teruel","TE"}, {"45","Toledo","TO"}, {"46","Valencia","V"}, {"47","Valladolid","VA"}, {"48","Vizcaya","BI"}, {"49","Zamora","ZA"}, {"50","Zaragoza","Z"}, {"51","Ceuta","CE"}, {"52","Melilla","ML"}}; 

    //Modelo de eventos
    private ArrayList<IF_Provincias> listaListener = new ArrayList(); //Estructura para guardar los listeners
    
    public C_Provincias() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setPreferredSize(new Dimension(160,25));
        this.seleccionado = 0;
        
        etiqueta = new JLabel("  Provincias  ");
        this.add(etiqueta);
        
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        if(hayMensaje) modelo.addElement(mensaje);
        for(int g = 0; g < MatrizProv.length;g++) modelo.addElement(MatrizProv[g][1]);
         
        provincia = new JComboBox<>(); 
        provincia.setModel(modelo);

        //Modelo de eventos
        ActionListener actList = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hayMensaje)
                   seleccionado = provincia.getSelectedIndex()-1;
                else
                   seleccionado = provincia.getSelectedIndex();
                
                if(((hayMensaje)&&(provincia.getSelectedIndex()!=0))||(!hayMensaje)){
                    //Se la seleccionado una provincia
                    EO_Provincias evObj = new EO_Provincias(this);
                    evObj.setPosEnMatriz(provincia.getSelectedIndex());
                    evObj.setNomProvincia(MatrizProv[seleccionado][1]);
                    evObj.setCpProvincia(MatrizProv[seleccionado][0]);
                    evObj.setMinisProvincia(MatrizProv[seleccionado][2]);
                    fireProvinciasListener(evObj);
                }
            }
        };
        provincia.addActionListener(actList);
        
        this.add(provincia);
        
    }

    
    public String getEtiqueta() {
        return etiqueta.getText();
    }

    public void setEtiqueta(String txt) {
        this.etiqueta.setText(txt);
    }

 
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean getHayMensaje() {
        return hayMensaje;
    }

    public void setHayMensaje(Boolean hayMensaje) {
        this.hayMensaje = hayMensaje;
        
        //Cada vez que se modifica el valor de este atributo, se recarga el modelo de datos del combobox
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        if(hayMensaje) modelo.addElement(mensaje);
        for(int g = 0; g < MatrizProv.length;g++) modelo.addElement(MatrizProv[g][1]);
        provincia.setModel(modelo);
    }
    
    //Modelo de eventos -- MÉTODOS
    public void addProvinciasListener(IF_Provincias listener){//Añade un listener a la estructura
       listaListener.add(listener);
    }
    
    public void removeProvinciasListener(IF_Provincias listener){//Elimina un listener de la estructura
       listaListener.remove(listener);
    }
    
    public void fireProvinciasListener(EO_Provincias eveObj){//Ejecuta los listeners que hay en la estructura
        for (IF_Provincias listener : listaListener) { 
            listener.Ejecuta(eveObj);
        }    
    }
    
    

    public String ProvinciaNom() {
        int pos = seleccionado;
        if(hayMensaje) pos--;        
        return MatrizProv[pos][1];
    }
    
    public void ProvinciaNom(String nombre){
       int pos = buscaMatriz(nombre, 1);
       if(pos!=-1){
           provincia.setSelectedIndex(pos);
           setSeleccionado(pos);
       }
    }
    
    public String ProvinciaCP() {
        int pos = seleccionado;
        if(hayMensaje) pos--;
        return MatrizProv[pos][0];
    } 
    
    public void ProvinciaCP(String nombre){
       int pos = buscaMatriz(nombre, 0);
       if(pos!=-1){
           provincia.setSelectedIndex(pos);
           setSeleccionado(pos);
       }
    }

    public int ProvinciaMI() {
        int pos = seleccionado;
        if(hayMensaje) pos--;        
        return Integer.valueOf(MatrizProv[pos][2]);
    }
    
    public void ProvinciaMI(String nombre){
       int pos = buscaMatriz(nombre, 2);
       if(pos!=-1){
           provincia.setSelectedIndex(pos);
           setSeleccionado(pos);
       }
    }

    public void setSeleccionado(int pos) {
        if(hayMensaje)
          seleccionado = pos+1;  
        else    
          seleccionado = pos;
    }    
    
    private int buscaMatriz(String nombre, int col){
       int pos = 0;
       int nElem = MatrizProv.length;
       Boolean enc = false;
       while((!enc)&&(pos < nElem)){
          if(nombre.equals(MatrizProv[pos][col]))
              pos++;
          else
              enc = true;
       }
       if(!enc) pos = -1;
       return pos;
    }
    
    
}
