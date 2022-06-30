/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import  Model.Usuario;
import java.util.List;

/**
 *
 * @author edins
 */
public interface UsuarioInterface {
    public List listar();
    public Usuario list(int id);
    public boolean add(Usuario u);
    public boolean edit(Usuario u);
    public boolean delete(Usuario u);
    public Usuario login(String userName ,String passWord);
}
