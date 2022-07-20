/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Interface.MyIntercambioInterface;
import Model.MyIntercambio;
import java.util.ArrayList;
import Config.Conexion;
import Model.Intercambio;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;import java.util.logging.Level;
/**
 *
 * @author edins
 */
public class MyIntercambioDAO implements  MyIntercambioInterface{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     
    @Override
    public ArrayList<MyIntercambio> ListaMisIntervambios(int IdUsuario) {
        
        System.out.println("Accion :"+"INTERCAMBIO" );
            ArrayList<MyIntercambio>list=new ArrayList<>();
        /*String sql="SELECT a.Id_interArticulo,a.Mensaje,a.Estado,a.FechaCreacioIntArt,a.Id_articulo,a.IdUsuario,b.UserName,"
                + " a.EstadoArticulo,b.Distrito FROM intercambioarticulo a inner join users b on b.id=a.IdUsuario WHERE A.Id_articulo='50'"
                + " order by a.estado DESC ,a.FechaCreacioIntArt DESC;";*/

        String sql="SELECT b.Id_articulo,b.NomArticulo,b.IdCategoria,b.FechaCreacionArt,b.DistritoArticulo,b.PreferenciaArticulo,b.TituloArticulo,b.EstadoArticulo,"
                + " b.DescripcionArticulo,b.Imagen,b.IdUsuario,b.Estado,a.Id_interArticulo,a.Estado AS EstadoIntercambio "
                + " FROM intercambioarticulo a inner join articulo b on b.Id_articulo=a.Id_articulo AND b.Estado!='0' WHERE a.Estado!='0' AND a.IdUsuario='"+IdUsuario+"'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                MyIntercambio inter=new MyIntercambio();
                inter.setId_interArticulo(rs.getInt("Id_interArticulo"));
                inter.setNombreArticulo(rs.getString("NomArticulo"));
                inter.setIdCategoria(rs.getString("IdCategoria"));
                
                inter.setFechaCreacionArt(rs.getString("FechaCreacionArt"));
                inter.setDistritoArticulo(rs.getString("DistritoArticulo"));
                inter.setPreferenciaArticulo(rs.getString("PreferenciaArticulo"));
                inter.setTituloArticulo(rs.getString("TituloArticulo"));
                inter.setEstadoArticulo(rs.getString("EstadoArticulo"));
                
                inter.setDescripcionArticulo(rs.getString("DescripcionArticulo"));
                inter.setImagen(rs.getString("Imagen"));
                inter.setIdUsuario(rs.getInt("IdUsuario"));
                inter.setEstado(rs.getString("Estado"));
                inter.setIdArticulo(rs.getInt("Id_articulo"));
               
                inter.setEstadoIntercambio(rs.getString("EstadoIntercambio"));
                
                list.add(inter);
                System.out.println("Accion1 :"+ ps );
                System.out.println("Accion2 :"+ list );
            }
            
        }catch(Exception e){
        }
        return list;
        /*
           ArrayList<MyIntercambio>list=new ArrayList<>();
        /*String sql="SELECT b.Id_articulo,b.NomArticulo,b.IdCategoria,b.FechaCreacionArt,b.DistritoArticulo,b.PreferenciaArticulo,b.TituloArticulo,"
                + "b.EstadoArticulo,b.DescripcionArticulo,b.Imagen,b.IdUsuario,b.Estado,a.Id_interArticulo,a.Estado as EstadoIntercambio "
                + "FROM intercambioarticulo a inner join articulo b on b.Id_articulo=a.Id_articulo AND b.Estado='1' WHERE a.Estado<>'0' AND a.IdUsuario='10';";
        String sql="SELECT * FROM articulo";
        System.out.println("query  :"+ sql );
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                MyIntercambio inter=new MyIntercambio();
                inter.setIdArticulo(rs.getInt("IdArticulo"));
                inter.setNombreArticulo(rs.getString("NomArticulo"));
                //inter.setIdCategoria(rs.getString("IdCategoria"));
                //inter.setFechaCreacionArt(rs.getString("FechaCreacionArt"));
                //inter.setDistritoArticulo(rs.getString("DistritoArticulo"));
                //inter.setPreferenciaArticulo(rs.getString("PreferenciaArticulo"));
                //inter.setTituloArticulo(rs.getString("TituloArticulo"));
                //inter.setEstadoArticulo(rs.getString("EstadoArticulo"));
                //inter.setDescripcionArticulo(rs.getString("DescripcionArticulo"));
                //inter.setImagen(rs.getString("Imagen"));
                //inter.setIdUsuario(rs.getInt("IdUsuario"));
                //inter.setEstado(rs.getString("Estado"));
                //inter.setId_interArticulo(rs.getInt("Id_interArticulo"));
                //inter.setEstadoIntercambio(rs.getString("EstadoIntercambio"));
                
                list.add(inter);
                System.out.println("Accion :"+ ps );
                System.out.println("Accion2 :"+ list );
            }
            
        }catch(Exception e){
            System.out.println("error :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return list; */
        
    }
    
}
