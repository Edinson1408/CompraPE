/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Model.Intercambio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edins
 */
public interface IntercambioInterface {
    public List listar();
    public Intercambio list(int id);
    public boolean add(Intercambio inter);
    public boolean edit(Intercambio inter);
    public boolean delete(int id);
    //public List ListaArtUsuarui(int id);
    public ArrayList<Intercambio> ListarMensajes(int idArticulo);
    public boolean updateEstado(int id);
    
}
