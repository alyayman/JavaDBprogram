/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedemo;
import org.apache.derby.jdbc.ClientDriver;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import databasedemo.otd;
/**
 *
 * @author 20101
 */
public class DataAcessLayer {
    Connection conn;

    public DataAcessLayer(String URL,String User,String Password) {
        try {
            DriverManager.registerDriver(new ClientDriver() );
            
             conn=DriverManager.getConnection(URL,User,Password);
             conn.setAutoCommit( true );
                    } catch (SQLException ex) {
            Logger.getLogger(DataAcessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static final Logger LOG = Logger.getLogger(DataAcessLayer.class.getName());
    
    
    public otd create(ResultSet st){
        otd data=null;
        
        try {
            data =  new otd(st.getInt(1),st.getString(2),st.getString(3),st.getString(4),st.getString(5),st.getInt(6));
            
            return data;
                    } catch (SQLException ex) {
            Logger.getLogger(DataAcessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
   public ResultSet select(){
       ResultSet rs=null;
        try {
            Statement stmt = conn.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from TABLE1");
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAcessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       return rs;
   
   }
   
    /**
     *
     * @param data
     * @param rs
     */
    public void insert(otd data,ResultSet rs){
      
        try {
            rs.moveToInsertRow();
            rs.updateInt(1, data.getId());
            rs.updateString(2, data.getFname());
            rs.updateString(3,data.getMname());
            rs.updateString(4, data.getLname());
            rs.updateString(5, data.getMail());
            rs.updateInt(6, data.getPhone());
            rs.insertRow();                                
            rs.moveToCurrentRow();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
   
   }
    public void update(otd data,ResultSet rs){
      
        try {
            rs.moveToCurrentRow();
            rs.updateInt(1, data.getId());
            rs.updateString(2, data.getFname());
            rs.updateString(3,data.getMname());
            rs.updateString(4, data.getLname());
            rs.updateString(5, data.getMail());
            rs.updateInt(6, data.getPhone());
            rs.updateRow();                                
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAcessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
   
   }
    public void delete (ResultSet rs){
        try {
            rs.deleteRow();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
