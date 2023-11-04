/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Administrator;
import domen.Korisnik;
import domen.Poruka;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frado
 */
public class DBBroker {
    
    public ArrayList<Object> vrati(){
        
        ArrayList<Object> lista = new ArrayList<>();
        String upit = "";
        
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            while (rs.next()) {                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
    public boolean cuvajIzmeniBrisi(){
        String upit = "";
        
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.executeUpdate();
            
            Konekcija.getInstance().getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Administrator loginAdmin(String email, String password) {
        
        String upit = "SELECT * FROM ADMINISTRATOR";
        
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            while (rs.next()) {                
                Administrator a = new Administrator(rs.getLong(1), rs.getString(2),
                                        rs.getString(3), rs.getString(4), rs.getString(5));
                
                if (a.getEmail().equals(email) && a.getLozinka().equals(password)) {
                    return a;
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Korisnik> vratiSveKorisnike() {
        ArrayList<Korisnik> lista = new ArrayList<>();
        String upit = "SELECT * FROM KORISNIK";
        
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            while (rs.next()) {                
                Korisnik k = new Korisnik(rs.getLong(1), rs.getString(2), rs.getString(3));
                lista.add(k);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean dodajKorisnika(Korisnik k) {
        String upit = "INSERT INTO KORISNIK (USERNAME, PASSWORD) VALUES (?,?)";
        
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.setString(1, k.getUsername());
            ps.setString(2, k.getPassword());
            
            ps.executeUpdate();
            
            Konekcija.getInstance().getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Korisnik login(String username, String password) {
        String upit = "SELECT * FROM KORISNIK";
        
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            while (rs.next()) {                
                Korisnik k = new Korisnik(rs.getLong(1), rs.getString(2), rs.getString(3));
                if (k.getUsername().equals(username) && k.getPassword().equals(password)) {
                    return k;
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Poruka> vratiPorukeZaKorisnika(Korisnik korisnik) {
        ArrayList<Poruka> lista = new ArrayList<>();
        String upit = "SELECT * FROM PORUKA WHERE PRIMALAC = '" + 
                korisnik.getUsername() + "' OR PRIMALAC = 'Svi'";
        
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            while (rs.next()) {
                Poruka poruka = new Poruka(rs.getLong(1), rs.getString(2), rs.getString(3),
                                rs.getTimestamp(4), rs.getString(5));
                lista.add(poruka);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean sacuvajPoruku(Poruka p) {
        String upit = "INSERT INTO PORUKA (POSILJALAC, PRIMALAC, DATUMVREME, PORUKA) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.setString(1, p.getPosiljalac());
            ps.setString(2, p.getPrimalac());
            ps.setTimestamp(3, new Timestamp(p.getDatumVreme().getTime()));
            ps.setString(4, p.getPoruka());
            
            ps.executeUpdate();
            
            Konekcija.getInstance().getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    
}
