/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEG;

import DTS.Consultas;
import OBJS.ObjVar;
import java.util.ArrayList;

/**
 *
 * @author Guerrero
 */
public class Var {
    Consultas VV = new Consultas();
    public ArrayList<ObjVar> loadVar(){
        ArrayList<ObjVar> VarList = VV.Var();
        return VarList;       
    }
}
