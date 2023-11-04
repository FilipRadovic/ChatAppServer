/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Korisnik;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import logika.Kontroler;

/**
 *
 * @author frado
 */
public class ModelTabeleKorisnici extends AbstractTableModel{
    
    ArrayList<Korisnik> lista;
    String[] kolone = {"KorisnikID", "Username", "Ulogovan"};

    public ModelTabeleKorisnici() {
        
        ArrayList<Korisnik> listaUlogovanih = Kontroler.getInstance().getUlogovaniKorisnici();
        ArrayList<Korisnik> listaSvih = Kontroler.getInstance().vratiSveKorisnike();
        
        ArrayList<Korisnik> sortiranaLista = new ArrayList<>();
        
        for (Korisnik korisnik : listaSvih) {
            if (listaUlogovanih.contains(korisnik)) {
                sortiranaLista.add(korisnik);
            }
        }
        
        for (Korisnik korisnik : listaSvih) {
            if (!listaUlogovanih.contains(korisnik)) {
                sortiranaLista.add(korisnik);
            }
        }
        
        lista = sortiranaLista;
    }
    
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik k = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return k.getKorisnikID();
            case 1:
                return k.getUsername();
            case 2:
                return Kontroler.getInstance().daLiJeUlogovan(k);
                
            default:
                return "return!";
        }
    }
    
}
