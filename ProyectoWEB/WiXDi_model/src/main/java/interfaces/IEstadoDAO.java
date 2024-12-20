/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Estado;
import dominio.Municipio;

/**
 *
 * @author pollitos
 */
public interface IEstadoDAO {
    public void agregarEstado (Estado estado);
    public void agregarMunicipio(Estado estado, Municipio municipio);
    public void actualizarEstado(Estado estado);
    public Estado consultarEstado(int id);
}
