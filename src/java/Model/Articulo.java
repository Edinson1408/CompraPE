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
public class Articulo {
    int IdArticulo;
    String NombreArticulo;
    //String fk_categoria;
    String FechaCreacionArt;
    String DistritoArticulo;
    String PreferenciaArticulo;
    String TituloArticulo;
    String EstadoArticulo;
    String DescripcionArticulo;
    String Imagen;
    String IdCategoria;
    int idUsuario;
    String Estado;
    String CantidadMensajes;
    
    public Articulo() {
    }

    /*public Articulo(String NombreArticulo, String FechaCreacionArt, String DistritoArticulo, String PreferenciaArticulo, String TituloArticulo, String EstadoArticulo, String DescripcionArticulo, String Imagen) {
        this.NombreArticulo = NombreArticulo;
        this.FechaCreacionArt = FechaCreacionArt;
        this.DistritoArticulo = DistritoArticulo;
        this.PreferenciaArticulo = PreferenciaArticulo;
        this.TituloArticulo = TituloArticulo;
        this.EstadoArticulo = EstadoArticulo;
        this.DescripcionArticulo = DescripcionArticulo;
        this.Imagen = Imagen;
        this.IdCategoria = IdCategoria;
        
    }*/

    public Articulo(int IdArticulo, String NombreArticulo, String FechaCreacionArt, String DistritoArticulo, String PreferenciaArticulo, String TituloArticulo, String EstadoArticulo, String DescripcionArticulo, String Imagen, String IdCategoria, int idUsuario,String CantidadMensajes) {
        this.IdArticulo = IdArticulo;
        this.NombreArticulo = NombreArticulo;
        this.FechaCreacionArt = FechaCreacionArt;
        this.DistritoArticulo = DistritoArticulo;
        this.PreferenciaArticulo = PreferenciaArticulo;
        this.TituloArticulo = TituloArticulo;
        this.EstadoArticulo = EstadoArticulo;
        this.DescripcionArticulo = DescripcionArticulo;
        this.Imagen = Imagen;
        this.IdCategoria = IdCategoria;
        this.idUsuario = idUsuario;
        this.CantidadMensajes=CantidadMensajes;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    public String getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(String IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public int getIdArticulo() {
        return IdArticulo;
    }

    public void setIdArticulo(int IdArticulo) {
        this.IdArticulo = IdArticulo;
    }

    public String getNombreArticulo() {
        return NombreArticulo;
    }

    public void setNombreArticulo(String NombreArticulo) {
        this.NombreArticulo = NombreArticulo;
    }

    public String getFechaCreacionArt() {
        return FechaCreacionArt;
    }

    public void setFechaCreacionArt(String FechaCreacionArt) {
        this.FechaCreacionArt = FechaCreacionArt;
    }

    public String getDistritoArticulo() {
        return DistritoArticulo;
    }

    public void setDistritoArticulo(String DistritoArticulo) {
        this.DistritoArticulo = DistritoArticulo;
    }

    public String getPreferenciaArticulo() {
        return PreferenciaArticulo;
    }

    public void setPreferenciaArticulo(String PreferenciaArticulo) {
        this.PreferenciaArticulo = PreferenciaArticulo;
    }

    public String getTituloArticulo() {
        return TituloArticulo;
    }

    public void setTituloArticulo(String TituloArticulo) {
        this.TituloArticulo = TituloArticulo;
    }

    public String getEstadoArticulo() {
        return EstadoArticulo;
    }

    public void setEstadoArticulo(String EstadoArticulo) {
        this.EstadoArticulo = EstadoArticulo;
    }

    public String getDescripcionArticulo() {
        return DescripcionArticulo;
    }

    public void setDescripcionArticulo(String DescripcionArticulo) {
        this.DescripcionArticulo = DescripcionArticulo;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getCantidadMensajes() {
        return CantidadMensajes;
    }

    public void setCantidadMensajes(String CantidadMensajes) {
        this.CantidadMensajes = CantidadMensajes;
    }
    
}
