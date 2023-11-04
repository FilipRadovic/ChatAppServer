/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import domen.Administrator;
import domen.Korisnik;
import domen.Poruka;
import forme.ServerskaForma;
import java.util.ArrayList;

/**
 *
 * @author frado
 */
public class Kontroler {
    
    private static Kontroler instance;
    private DBBroker dbb;
    private ServerskaForma sf;
    
    private ArrayList<Korisnik> ulogovaniKorisnici = new ArrayList<>();

    public Kontroler() {
        dbb = new DBBroker();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Administrator loginAdmin(String email, String password) {
        return dbb.loginAdmin(email, password);
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }

    public ServerskaForma getSf() {
        return sf;
    }

    public Object daLiJeUlogovan(Korisnik k) {
        for (Korisnik korisnik : ulogovaniKorisnici) {
            if (korisnik.equals(k)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Korisnik> getUlogovaniKorisnici() {
        return ulogovaniKorisnici;
    }
    
    public ArrayList<Korisnik> vratiSveKorisnike(){
        return dbb.vratiSveKorisnike();
    }

    public boolean dodajKorisnika(Korisnik k) {
        return dbb.dodajKorisnika(k);
    }

    public Korisnik login(String username, String password) {
        Korisnik k = dbb.login(username, password);
        
        if (k != null) {
            if (!ulogovaniKorisnici.contains(k)) {
                ulogovaniKorisnici.add(k);
                sf.refreshujTabelu();
                return k;
            }
            else{
                k.setKorisnikID(-1);
                return k;
            }
        }
        
        return null;
    }

    public ArrayList<Poruka> vratiPorukeZaKorisnika(Korisnik korisnik) {
        return dbb.vratiPorukeZaKorisnika(korisnik);
    }

    public boolean sacuvajPoruku(Poruka p) {
        return dbb.sacuvajPoruku(p);
    }
    
    
}
