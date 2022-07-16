/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interface.ArticuloInterface;
import Model.Articulo;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author edins
 */
public  class ArticuloDAO implements ArticuloInterface{

  
    
     Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     Articulo p;
    
    //Articulo  p=new Articulo();
    
    @Override
    public List listar() {
         ArrayList<Articulo>list=new ArrayList<>();
        String sql="select * from articulo where Estado='0'";
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
                art.setEstado(rs.getString("Estado"));
                art.setImagen(rs.getString("imagen"));
                list.add(art);
                
            }
            
        }catch(Exception e){
        }
        return list;
    }

    @Override
    public Articulo list(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        String sql="select * from articulo where Id_articulo='"+id+"'";
        
        try{
            con =cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();    
            
            while (rs.next()) {
                
                p = new Articulo();
                p.setIdArticulo(rs.getInt("Id_articulo"));
                p.setNombreArticulo(rs.getString("NomArticulo"));
                p.setEstadoArticulo(rs.getString("EstadoArticulo"));
                p.setTituloArticulo(rs.getString("TituloArticulo"));
                p.setIdCategoria(rs.getString("IdCategoria"));
                p.setDescripcionArticulo(rs.getString("DistritoArticulo"));
                p.setPreferenciaArticulo(rs.getString("PreferenciaArticulo"));
                p.setDistritoArticulo(rs.getString("DistritoArticulo"));
                p.setIdUsuario(rs.getShort("IdUsuario"));
                
                System.out.println("Accion :"+ ps );
                System.out.println("Accion :"+ p );
            }
            
        }catch(Exception e){ 
            
            System.out.println("Accion :"+ ps );
            logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return p;
        
        
    }

    @Override
    public boolean add(Articulo art) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
        try {
            /*nombre de artilo concatenado con id del usaurio*/
            //imagen=
            String sql=" INSERT INTO  articulo ( NomArticulo, IdCategoria, FechaCreacionArt, DistritoArticulo,"
                    + " PreferenciaArticulo, TituloArticulo, EstadoArticulo, DescripcionArticulo, Imagen, IdUsuario)"
                    + " VALUES (?,?,sysdate(),?,?,?,?,?,?,?);";
            
            con= cn.getConnection();
            ps = con.prepareStatement(sql);    
            ps.setString(1, art.getNombreArticulo());
            ps.setString(2, art.getIdCategoria());
            ps.setString(3, art.getDistritoArticulo());
            ps.setString(4, art.getPreferenciaArticulo());
            ps.setString(5, art.getTituloArticulo());
            ps.setString(6, art.getEstadoArticulo());
            ps.setString(7, art.getDescripcionArticulo());
            ps.setString(8, art.getImagen());
            ps.setInt(9, art.getIdUsuario());
            System.out.println("Accion :"+ ps );
            ps.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Accion :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return false;
    }

    @Override
    public boolean edit(Articulo art) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            String sql="update "
                    + "  articulo set "
                    + " NomArticulo=?" +
                    " ,IdCategoria=? "+
                    " ,DistritoArticulo=?" +
                    " ,PreferenciaArticulo=?" +
                    " ,TituloArticulo=?" +
                    " ,EstadoArticulo=?"+
                    " ,DescripcionArticulo=?" +
                    " ,Imagen=?"
                    + " where Id_articulo =?;";
            
            con= cn.getConnection();
            ps = con.prepareStatement(sql);    
            ps.setString(1, art.getNombreArticulo());
            ps.setString(2, art.getIdCategoria());
            ps.setString(3, art.getDistritoArticulo());
            ps.setString(4, art.getPreferenciaArticulo());
            ps.setString(5, art.getTituloArticulo());
            ps.setString(6, art.getEstadoArticulo());
            ps.setString(7, art.getDescripcionArticulo());
            ps.setString(8, art.getImagen());
            ps.setInt(9, art.getIdArticulo());
            
            System.out.println("Accion :"+ ps );
            ps.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Accion :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return false;
    }

  

    @Override
    public List ListaArtUsuarui(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Articulo>list=new ArrayList<>();
        String sql="select * from articulo where IdUsuario='"+id+"'";
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
                art.setEstado(rs.getString("Estado"));
                art.setImagen(rs.getString("imagen"));
                list.add(art);
                
            }
            
        }catch(Exception e){
        }
        return list;
        
    }

    @Override
    public boolean delete(int Idart) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            String sql="DELETE FROM articulo WHERE Id_articulo=?";
            con= cn.getConnection();
            ps = con.prepareStatement(sql);    
            ps.setInt(1, Idart);
            System.out.println("Accion :"+ ps );
            ps.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Accion :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return false;
    }

    @Override
    public boolean updateEstado(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            String sql="update "
                    + "  articulo set "
                    + " Estado=1"
                    + " where Id_articulo =?;";
            
            con= cn.getConnection();
            ps = con.prepareStatement(sql);    
            ps.setInt(1,id);
            System.out.println("Accion :"+ ps );
            ps.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Accion :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return false;
        
    }

    
    
}
