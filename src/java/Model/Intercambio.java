/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author edins
 */
public class Intercambio {
    int Id_interArticulo ;
    String Mensaje;
    String Estado;
    String Id_articulo;
    String EstadoArticulo;
    int IdUsuario;
    String Distrito;
    String fecha;
    String username;
    String img;
    
    public Intercambio() {}

    public Intercambio(int Id_interArticulo, String Mensaje, String Estado, String Id_articulo, String EstadoArticulo, int IdUsuario,String img) {
        this.Id_interArticulo = Id_interArticulo;
        this.Mensaje = Mensaje;
        this.Estado = Estado;
        this.Id_articulo = Id_articulo;
        this.EstadoArticulo = EstadoArticulo;
        this.IdUsuario = IdUsuario;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_interArticulo() {
        return Id_interArticulo;
    }

    public void setId_interArticulo(int Id_interArticulo) {
        this.Id_interArticulo = Id_interArticulo;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getId_articulo() {
        return Id_articulo;
    }

    public void setId_articulo(String Id_articulo) {
        this.Id_articulo = Id_articulo;
    }

    public String getEstadoArticulo() {
        return EstadoArticulo;
    }

    public void setEstadoArticulo(String EstadoArticulo) {
        this.EstadoArticulo = EstadoArticulo;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    

    
    
}
