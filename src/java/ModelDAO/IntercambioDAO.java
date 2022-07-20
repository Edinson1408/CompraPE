/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;
import Config.Conexion;
import Interface.IntercambioInterface;
import Model.Articulo;
import Model.Intercambio;
/**
 *
 * @author edins
 */

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
public class IntercambioDAO implements IntercambioInterface{
Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     Intercambio i;
    @Override
    public List listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         ArrayList<Articulo>list=new ArrayList<>();
        String sql="SELECT a.Id_interArticulo,a.Mensaje,a.Estado,a.FechaCreacioIntArt,a.Id_articulo,a.IdUsuario,b.UserName,"
                + "a.EstadoArticulo,b.Distrito FROM intercambioarticulo a inner join users b on b.id=a.IdUsuario WHERE A.Id_articulo='50';";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Articulo art=new Articulo();
                art.setIdArticulo(rs.getInt("Id_articulo"));
                art.setNombreArticulo(rs.getString("NomArticulo"));
                art.setEstadoArticulo(rs.getString("EstadoArticulo"));
                art.setTituloArticulo(rs.getString("TituloArticulo"));
                art.setIdCategoria(rs.getString("IdCategoria"));
                list.add(art);
                
            }
            
        }catch(Exception e){
        }
        return list;

    }

    @Override
    public Intercambio list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Intercambio inter) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        /*
            int Id_interArticulo ;
            String Mensaje; - 
            String Estado;
            String Id_articulo; -
            String EstadoArticulo; -
            int IdUsuario; -
        */
        
         try {
            /*nombre de artilo concatenado con id del usaurio*/
           
            String sql=" INSERT INTO  intercambioarticulo ( Mensaje, Id_articulo, EstadoArticulo, IdUsuario,img)"
                    + " VALUES (?,?,?,?,?);";
            
            con= cn.getConnection();
            ps = con.prepareStatement(sql);    
            ps.setString(1, inter.getMensaje());
            ps.setString(2, inter.getId_articulo());
            ps.setString(3, inter.getEstadoArticulo());
            ps.setInt(4, inter.getIdUsuario());
            ps.setString(5, inter.getImg());
           
            System.out.println("Accion :"+ ps );
            ps.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Accion :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return false;
    }

    @Override
    public boolean edit(Intercambio inter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Intercambio> ListarMensajes(int idArticulo) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Intercambio>list=new ArrayList<>();
        String sql="SELECT a.Id_interArticulo,a.Mensaje,a.Estado,a.FechaCreacioIntArt,a.Id_articulo,a.IdUsuario,b.UserName,"
                + " a.EstadoArticulo,b.Distrito,a.img FROM intercambioarticulo a inner join users b on b.id=a.IdUsuario WHERE A.Id_articulo='"+idArticulo+"'"
                + " order by a.estado DESC ,a.FechaCreacioIntArt DESC;";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Intercambio inter=new Intercambio();
                inter.setId_interArticulo(rs.getInt("Id_interArticulo"));
                inter.setMensaje(rs.getString("Mensaje"));
                inter.setEstado(rs.getString("Estado"));
                inter.setFecha(rs.getString("FechaCreacioIntArt"));
                inter.setId_articulo(rs.getString("Id_articulo"));
                inter.setIdUsuario(rs.getInt("IdUsuario"));
                inter.setUsername(rs.getString("UserName"));
                inter.setEstadoArticulo(rs.getString("EstadoArticulo"));
                inter.setDistrito(rs.getString("Distrito"));
                inter.setImg(rs.getString("img"));
                
                list.add(inter);
                System.out.println("Accion :"+ ps );
                System.out.println("Accion :"+ list );
            }
            
        }catch(Exception e){
        }
        return list;
    }

    @Override
    public boolean updateEstado(int id) {
        try {
            String sql="update "
                    + "  intercambioarticulo set "
                    + " Estado=1"
                    + " where Id_interArticulo =?;";
            
            con= cn.getConnection();
            ps = con.prepareStatement(sql);    
            ps.setInt(1,id);
            System.out.println("Accion :"+ ps );
            ps.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Accion :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return true;
    }

    
    
}
