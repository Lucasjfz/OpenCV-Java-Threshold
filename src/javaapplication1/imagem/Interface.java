package javaapplication1.imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Interface extends javax.swing.JFrame {
                        
    private javax.swing.JButton jButtonTSG;
    private javax.swing.JButton jButtonTSL;
    private javax.swing.JButton jButtonCR;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JScrollPane jScrollPaneConteudo;
    private JLabel picLabel;
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface().setVisible(true);
                
        
            }
            
        });
        
        
    }
    
    public Interface() {
       
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Image files", "png",
                "jpg", "bmp"));
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return;
        }
                try{
                    
                    String thre = JOptionPane.showInputDialog("Valor de Threshold:"); //Fornece a opcao do usuario definir o valor de threshold
                    int t = Integer.valueOf(thre);
                        // Carrega a imagem do disco
                      File img = chooser.getSelectedFile();
                    BufferedImage image = ImageIO.read(img);
                    
                    picLabel = new JLabel(new ImageIcon(image));
   
                } catch (IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }

        jScrollPaneConteudo = new javax.swing.JScrollPane();
        jButtonTSG = new javax.swing.JButton();
        jButtonTSL = new javax.swing.JButton();
        jButtonCR = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        picLabel =new javax.swing.JLabel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        
        
        
        jButtonTSG.setText("Thresholding Global");
        jButtonTSG.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTSGActionPerformed(evt);
            }
        });

        jButtonTSL.setText("Thresholding Local");
        jButtonTSL.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTSLActionPerformed(evt);
            }
        });

        jButtonCR.setText("Crescimento por Regiões");
        jButtonCR.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCRActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonTSG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTSL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSair)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonTSG)
                        .addComponent(jButtonCR)
                        .addComponent(jButtonTSL)
                        .addComponent(jButtonSair)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(picLabel, 500, 500, 600)
                .addGap(20, 20, 20))
            
        );
        

        pack();
    }// </editor-fold>              
    
    

    private void jButtonTSGActionPerformed(java.awt.event.ActionEvent evt) {                                             
       
    }
                                                                                     
    private void jButtonTSLActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
        
    }                                                                                          

    private void jButtonCRActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        
    }                                            

        
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        if (JOptionPane.showConfirmDialog(this, "Sair?") == JOptionPane.OK_OPTION) {
             System.exit(0);
        } else {
            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    } 
    
    
    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (JOptionPane.showConfirmDialog(this, "Sair?") == JOptionPane.OK_OPTION) {
             System.exit(0);
        } else {
            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }                                                             
}