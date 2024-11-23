/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Municipio;

/**
 *
 * @author pollitos
 */
public interface IMunicipioDAO {
    
    public void agregarMunicipio(Municipio municipio);
    public void actualizarMunicipio(Municipio municipio);
    public Municipio consultarMunicipio(int id);
}
