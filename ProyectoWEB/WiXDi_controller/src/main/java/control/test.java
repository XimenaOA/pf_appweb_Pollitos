/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author haloa
 */
public class test {
       public static void main(String[] args) {
        IFachada f;
        f = new Fachada();
        
        System.out.println(f.consultarUsuarioPorCorreo("cris@gmail.com"));
        
        
    }
}
