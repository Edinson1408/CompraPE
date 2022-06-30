/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.Conexion;
import Interface.UsuarioInterface;
import Model.Usuario;
import com.sun.istack.internal.logging.Logger;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author edins
 */
public class UsuarioDAO implements UsuarioInterface{

    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u;
    
    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario list(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String Sql="select * from users where Id='"+id+"'";
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(Sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                u=new Usuario();
                u.setId(rs.getInt("Id"));
                u.setNombres(rs.getString("Nombres"));
                u.setApellidos(rs.getString("Apellidos"));
                u.setUserName(rs.getString("UserName"));
                u.setEmail(rs.getString("Email"));
                u.setPasswordHash(rs.getString("PasswordHash"));
                u.setCelular(rs.getString("Celular"));
                u.setDistrito(rs.getString("Distrito"));
                u.setFechaNacimiento(rs.getString("FechaNacimiento"));
                u.setSexo(rs.getString("Sexo"));
                
            }
            
        }
        catch(Exception e){
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
        return u;
                
    }

    @Override
    public boolean add(Usuario u) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        
        try {
            String sql="INSERT INTO users(Nombres, Apellidos, UserName, Email,PasswordHash, Celular, Distrito, FechaNacimiento, Sexo) VALUES (?,?,?,?,?,?,?,?,?);";
            con= cn.getConnection();
            ps = con.prepareStatement(sql);    
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getUserName());
            ps.setString(4, u.getEmail());
            ps.setString(5, this.getMD5(u.getPasswordHash()));
            ps.setString(6, u.getCelular());
            ps.setString(7, u.getDistrito());
            ps.setString(8, u.getFechaNacimiento());
            ps.setString(9, u.getSexo());
            System.out.println("Accion :"+ ps );
            ps.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Accion :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return false;
    }

    @Override
    public boolean edit(Usuario u) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          try {
            String sql="update "
                    + " users set "
                    + " Nombres=?" +
                    " ,Apellidos=? "+
                    " ,Email=?" +
                    " ,PasswordHash=?" +
                    " ,Celular=?" +
                    " ,Distrito=?"+
                    " ,FechaNacimiento=?" +
                    " ,Sexo=?"
                    + " where Id=?;";
            
            con= cn.getConnection();
            ps = con.prepareStatement(sql);    
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getEmail());
            ps.setString(4, this.getMD5(u.getPasswordHash()));
            ps.setString(5, u.getCelular());
            ps.setString(6, u.getDistrito());
            ps.setString(7, u.getFechaNacimiento());
            ps.setString(8, u.getSexo());
            ps.setInt(9, u.getId());
            System.out.println("Accion :"+ ps );
            ps.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Accion :"+ ps );
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
        return false;
    }

    @Override
    public boolean delete(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static String getMD5(String input) {
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
        }
        return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario login(String userName, String passWord) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        passWord=this.getMD5(passWord);
         String Sql="select * from users where UserName='"+userName+"' and PasswordHash='"+passWord+"';";
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(Sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                u=new Usuario();
                u.setId(rs.getInt("Id"));
                u.setNombres(rs.getString("Nombres"));
                u.setApellidos(rs.getString("Apellidos"));
                u.setUserName(rs.getString("UserName"));
                u.setEmail(rs.getString("Email"));
                u.setPasswordHash(rs.getString("PasswordHash"));
                u.setCelular(rs.getString("Celular"));
                u.setDistrito(rs.getString("Distrito"));
                u.setFechaNacimiento(rs.getString("FechaNacimiento"));
                u.setSexo(rs.getString("Sexo"));
                
            }
            
        }
        catch(Exception e){
            logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
        return u;
    }
    
    
}
