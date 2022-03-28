/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJS;
    
import java.util.ArrayList;

/**
 *
 * @author Guerrero
 */
public class ObjVar {
    private String AERName;
    private int PASCant;
    private String AEName;
    public static ArrayList Var = new ArrayList<>();

    public ObjVar(String AERName, int PASCant, String AEName) {
        this.AERName = AERName;
        this.PASCant = PASCant;
        this.AEName = AEName;
    }

    public String getAERName() {
        return AERName;
    }

    public void setAERName(String AERName) {
        this.AERName = AERName;
    }

    public int getPASCant() {
        return PASCant;
    }

    public void setPASCant(int PASCant) {
        this.PASCant = PASCant;
    }

    public String getAEName() {
        return AEName;
    }

    public void setAEName(String AEName) {
        this.AEName = AEName;
    }

    public static ArrayList getVar() {
        return Var;
    }

    public static void setVar(ArrayList Var) {
        ObjVar.Var = Var;
    }
    
}
