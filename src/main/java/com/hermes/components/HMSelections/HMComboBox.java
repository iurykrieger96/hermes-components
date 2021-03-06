package com.hermes.components.HMSelections;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author iury
 */
public class HMComboBox<T> extends JComboBox {

    private List<T> list;
    
    public HMComboBox() {
        initComponents();
        Dimension dm = new Dimension(150, 26);
        this.setPreferredSize(dm);
    }
    
    public HMComboBox(List<T> list){
        this.list = list;
        insertValues();
    }
    
    public void setValues(List<T> list){
        this.list = list;
        insertValues();
    }
    
    public void setValues(T[] list){
        this.list = new ArrayList();
        for (T t : list) {
            this.list.add(t);
        }
        insertValues();
    }
    
    public List<T> getValues(){
        return this.list;
    }
    
    public void insertValues(){
        for (T ob : list) {
            addItem(ob);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
