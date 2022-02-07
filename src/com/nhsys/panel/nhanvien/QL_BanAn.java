/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.panel.nhanvien;

import com.nhsys.dao.BanAnDAO;
import com.nhsys.entity.BanAn;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author VU
 */
public class QL_BanAn extends javax.swing.JPanel {

    List<BanAn> arrBan = new ArrayList<>();
    BanAnDAO BaDao = new BanAnDAO();
    List<BanAn> ban = new ArrayList<>();

    /**
     * Creates new form SoDoPanel
     */
    public QL_BanAn() {
        initComponents();
        FillBan();
    }

    public void FillBan() {
        arrBan = new BanAnDAO().selectAll();
        if (arrBan != null) {
            jpBan.removeAll();
            JButton[] btn = new JButton[arrBan.size()];
            for (int i = 0; i < arrBan.size(); i++) {
                btn[i] = new JButton();
                btn[i].setName(String.valueOf(arrBan.get(i).getMaBan()));
               
                btn[i].setText(String.valueOf(arrBan.get(i).getMaBan()));
//                btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/ico-Table.png")));
                Border thickBorder = new LineBorder(Color.WHITE, 8);
                btn[i].setBorder(thickBorder);
                btn[i].setBackground(Color.decode("#8080ff"));
                btn[i].setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
                btn[i].setForeground(new java.awt.Color(51, 51, 51));
                if (arrBan.get(i).getTrangThai().equals("Đang phục vụ")) {
                    btn[i].setBackground(Color.decode("#66ff66"));
                }
                if (arrBan.get(i).getTrangThai().equals("Đã đặt trước")) {
                    btn[i].setBackground(Color.decode("#ff6699"));
                }
                btn[i].setPreferredSize(new Dimension(90, 70));

                btn[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        NV_FillMonAn monan;
                        ban = BaDao.GetBan(Integer.parseInt(e.getComponent().getName()));

//                            JpGoiMon goimon;
//                              ban = BaDao.selectAll();
//                              ban.get(0).getMaBan();
//                            ban = cn.GetBan(Integer.parseInt(e.getComponent().getName()));
                        if (ban != null) {
                            monan = new NV_FillMonAn(ban.get(0).getMaBan());
//                            QL_MonAn.model.setRowCount(0);
                            jpBan.removeAll();
                            jpBan.add(monan);
                            jpBan.updateUI();
                        }
                    }
                });
                jpBan.add(btn[i]);
                jpBan.updateUI();
            }
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

        jPanel1 = new javax.swing.JPanel();
        jpBan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jpBan.setLayout(new java.awt.GridLayout(4, 0));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addGap(134, 134, 134)
                .addComponent(jLabel2)
                .addGap(256, 256, 256)
                .addComponent(jLabel3)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpBan, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 244, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpBan;
    // End of variables declaration//GEN-END:variables
}
