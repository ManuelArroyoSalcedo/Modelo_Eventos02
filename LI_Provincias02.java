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
 * @author Manuel Arroyo
 */
public class LI_Provincias02 implements IF_Provincias{

    @Override
    public void Ejecuta(EO_Provincias eveObj) {
        System.out.println("La provincia elegida es: " + eveObj.getNomProvincia());
    }
    
}
