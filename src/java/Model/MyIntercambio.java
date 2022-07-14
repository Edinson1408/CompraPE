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
public class MyIntercambio {
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
    String Estado;
    int idUsuario;
    int Id_interArticulo;
    String EstadoIntercambio ;

    public MyIntercambio(){
    }

    public MyIntercambio(int IdArticulo, String NombreArticulo, String FechaCreacionArt, String DistritoArticulo, String PreferenciaArticulo, String TituloArticulo, String EstadoArticulo, String DescripcionArticulo, String Imagen, String IdCategoria, String Estado, int idUsuario, int Id_interArticulo, String EstadoIntercambio) {
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
        this.Estado = Estado;
        this.idUsuario = idUsuario;
        this.Id_interArticulo = Id_interArticulo;
        this.EstadoIntercambio = EstadoIntercambio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
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

    public String getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(String IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getId_interArticulo() {
        return Id_interArticulo;
    }

    public void setId_interArticulo(int Id_interArticulo) {
        this.Id_interArticulo = Id_interArticulo;
    }

    public String getEstadoIntercambio() {
        return EstadoIntercambio;
    }

    public void setEstadoIntercambio(String EstadoIntercambio) {
        this.EstadoIntercambio = EstadoIntercambio;
    }
    
    
    
}
