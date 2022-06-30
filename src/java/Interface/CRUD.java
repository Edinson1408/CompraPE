/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Articulo;
import java.util.List;
/**
 *
 * @author edins
 */
public interface CRUD {
    
    public List listar();
    public Articulo list(int id);
    public boolean add(Articulo art);
    public boolean edit(Articulo art);
    public boolean delete(int Idart);
    public List ListaArtUsuarui(int id);
    
}
