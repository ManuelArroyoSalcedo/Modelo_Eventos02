/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacomp05_modeloeventos;

import compo1.EO_Provincias;
import compo1.IF_Provincias;

/**
 *
 * @author Manuel
 */
public class LI_Provincias01 implements IF_Provincias {

    @Override
    public void Ejecuta(EO_Provincias eveObj) {
        System.out.println(eveObj.getNomProvincia());
        System.out.println(eveObj.getCpProvincia());
        System.out.println(eveObj.getMinisProvincia());
        System.out.println(eveObj.getPosEnMatriz());
    }
    
}
