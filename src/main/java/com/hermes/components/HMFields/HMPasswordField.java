/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hermes.components.HMFields;

import com.hermes.components.documents.MaxLenghtDocument;
import com.hermes.components.utils.ImageFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;
import net.java.balloontip.utils.TimingUtils;

/**
 *
 * @author iury
 */
public class HMPasswordField extends JPasswordField {

    private int emptyCount = 0;
    private int specialCount = 0;
    private boolean valid;

    public HMPasswordField() {
        initComponents();
        initComponent();
    }

    public void initComponent() {
        Dimension dm = new Dimension(150, 26);
        this.setPreferredSize(dm);
        this.setText("");
        this.setLayout(new BorderLayout());
        lb_img.setIcon(new ImageFactory().getIcon("lock.png", 18, 18));
        this.add(lb_img, new BorderLayout().EAST);
        this.valid = false;
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    public void setCharacterLimit(int limit){
        setDocument(new MaxLenghtDocument(limit));
    }

    public void onFocusGained() {
        if (isValid()) {
            setText(getText());
            setCaretPosition(getText().length());
        }
    }

    public void onKeyTyped() {
        if (this.getText().contains(" ")) {
            RoundedBalloonStyle balao = new RoundedBalloonStyle(2, 2, new Color(224, 237, 255), new Color(224, 237, 255));
            this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            this.valid = false;
            if (specialCount < 2) {
                TimingUtils.showTimedBalloon(new BalloonTip(this, "O campo contém caracteres especiais", balao, false), 1000);
            }
            specialCount++;
        } else if (!this.getText().isEmpty()) {
            this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN));
            this.valid = true;
        } else {
            this.valid = false;
        }
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            RoundedBalloonStyle balao = new RoundedBalloonStyle(2, 2, new Color(224, 237, 255), new Color(224, 237, 255));
            TimingUtils.showTimedBalloon(new BalloonTip(this, "A tecla Caps Lock está ligada", balao, false), 1000);
        }
    }

    public void onFocusLost() {
        if (this.getText().isEmpty()) {
            RoundedBalloonStyle balao = new RoundedBalloonStyle(2, 2, new Color(224, 237, 255), new Color(224, 237, 255));
            this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            this.valid = false;
            if (emptyCount < 2) {
                TimingUtils.showTimedBalloon(new BalloonTip(this, "O campo está em branco!", balao, false), 1000);
            }
            emptyCount++;
        } else {
            this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GREEN));
            this.valid = true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_img = new javax.swing.JLabel();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        onFocusLost();
    }//GEN-LAST:event_formFocusLost

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        onKeyTyped();
    }//GEN-LAST:event_formKeyReleased

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        onFocusGained();
    }//GEN-LAST:event_formFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_img;
    // End of variables declaration//GEN-END:variables
}
