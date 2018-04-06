/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package php_lexicalanalyzer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author usuario
 */
public class Frame extends javax.swing.JFrame
{
   
   Analyzer lexicalAnalyzer = new Analyzer();
   String inputName ="";
   /**
    * Creates new form Frame
    */
   public Frame()
   {
      initComponents();
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      jPanel1 = new javax.swing.JPanel();
      jScrollPane2 = new javax.swing.JScrollPane();
      txtCorrections = new javax.swing.JTextArea();
      jScrollPane3 = new javax.swing.JScrollPane();
      txtStatements = new javax.swing.JTextArea();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      lblClear = new javax.swing.JLabel();
      btnImport = new javax.swing.JButton();
      btnExport = new javax.swing.JButton();
      jScrollPane5 = new javax.swing.JScrollPane();
      txtResults = new javax.swing.JTextArea();
      jLabel4 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jPanel1.setBackground(new java.awt.Color(60, 180, 203));

      txtCorrections.setBackground(new java.awt.Color(244, 185, 184));
      txtCorrections.setColumns(20);
      txtCorrections.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
      txtCorrections.setForeground(new java.awt.Color(0, 0, 153));
      txtCorrections.setRows(5);
      jScrollPane2.setViewportView(txtCorrections);

      txtStatements.setBackground(new java.awt.Color(244, 185, 184));
      txtStatements.setColumns(20);
      txtStatements.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
      txtStatements.setForeground(new java.awt.Color(0, 0, 153));
      txtStatements.setRows(5);
      jScrollPane3.setViewportView(txtStatements);

      jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(255, 255, 255));
      jLabel1.setText("PHP Statements");

      jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(255, 255, 255));
      jLabel2.setText("PHP result");

      jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(255, 255, 255));
      jLabel3.setText("Lexical analyzer corrections");

      lblClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/php_lexicalanalyzer/clear.png"))); // NOI18N
      lblClear.addMouseListener(new java.awt.event.MouseAdapter()
      {
         public void mouseClicked(java.awt.event.MouseEvent evt)
         {
            lblClearMouseClicked(evt);
         }
      });

      btnImport.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
      btnImport.setText("Import");
      btnImport.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            btnImportActionPerformed(evt);
         }
      });

      btnExport.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
      btnExport.setText("Export .out");
      btnExport.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            btnExportActionPerformed(evt);
         }
      });

      txtResults.setBackground(new java.awt.Color(244, 185, 184));
      txtResults.setColumns(20);
      txtResults.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
      txtResults.setForeground(new java.awt.Color(0, 0, 153));
      txtResults.setRows(5);
      jScrollPane5.setViewportView(txtResults);

      jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 1, 48)); // NOI18N
      jLabel4.setForeground(new java.awt.Color(51, 51, 51));
      jLabel4.setText("Lexical Analyzer");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(29, 29, 29)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1625, Short.MAX_VALUE)
                        .addComponent(btnExport))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblClear)))
                  .addGap(23, 23, 23))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImport)))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(467, 467, 467)))
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel3)
                     .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18))))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(lblClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(jLabel2)
               .addComponent(jLabel1)
               .addComponent(btnImport)
               .addComponent(btnExport))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
               .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane3))
            .addGap(58, 58, 58))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnImportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnImportActionPerformed
   {//GEN-HEADEREND:event_btnImportActionPerformed
      // TODO add your handling code here:
      lexicalAnalyzer.reviewLexerDotJava();
       try{
          //front-end
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt","*.php","php"));
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setCurrentDirectory(new File("."));
            chooser.showOpenDialog(chooser);
            
            String[] split = chooser.getSelectedFile().getAbsolutePath().replace("\\", "!").split("!");
            inputName = split[split.length-1];
            txtStatements.setText( EnumTheAreas(lexicalAnalyzer.ReadFileContent(chooser.getSelectedFile().getAbsolutePath())));
            txtResults.setText(lexicalAnalyzer.ProcessingInput());
            txtCorrections.setText(EnumTheAreasResult(lexicalAnalyzer.contentFixed));
        }catch(Exception e){
           
        }
   }//GEN-LAST:event_btnImportActionPerformed

   private void lblClearMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblClearMouseClicked
   {//GEN-HEADEREND:event_lblClearMouseClicked
      // TODO add your handling code here:
      txtCorrections.setText("");
      txtResults.setText("");
      txtStatements.setText("");
      
      try{
         //delete the content of lexer.java file
         PrintWriter writer = new PrintWriter("src\\php_lexicalanalyzer\\Lexer.java");
         writer.print("");
         writer.close();
         JOptionPane.showMessageDialog(null,"Se ha borrado Lexer.java con éxito"); 
      }catch(Exception e){}
   }//GEN-LAST:event_lblClearMouseClicked

   private void btnExportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExportActionPerformed
   {//GEN-HEADEREND:event_btnExportActionPerformed
      // TODO add your handling code here:
      if(!txtCorrections.getText().isEmpty()){
         JFileChooser chooser = new JFileChooser(); 
         chooser.setCurrentDirectory(new java.io.File("."));
         chooser.setDialogTitle("Choose a location for save");
         chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         chooser.setAcceptAllFileFilterUsed(false);
         inputName = "\\"+inputName.replace(".", "!").split("!")[0]+".out";
         //    
         try{
               if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                  PrintWriter writer = new PrintWriter(new File(chooser.getSelectedFile().getAbsolutePath()+inputName), "UTF-8");
                  String content = "##############################CODE ANALIZED##############################\n"+txtCorrections.getText()+ "\n##############################TOKENS##############################\n"+txtResults.getText();
                  String[] lines = content.split("\n");
                  for (int i = 0; i < lines.length; i++)
                  {
                     writer.println(lines[i]);
                  }
                  writer.close();
             JOptionPane.showMessageDialog(null,"¡Export success!");     
         }
         }catch(Exception e){
         }
      }
   }//GEN-LAST:event_btnExportActionPerformed

    private String EnumTheAreas(String areaText){
         String[] lines = areaText.split("\n");
         String resultText = "";
         for (int i = 0; i < lines.length; i++)
         {
            resultText+=(i+1)+") "+lines[i]+"\n";
         }
         resultText = resultText.replace("é", "\\n");
         return resultText;
      }
    
    private String EnumTheAreasResult(String areaText){
       areaText = areaText.replace("\\n", "###");
      String[] lines = areaText.split("###");
         String resultText = "";
         for (int i = 0; i < lines.length; i++)
         {
            resultText+=(i+1)+") "+lines[i]+"\n";
         }
         return resultText;
    }
   /**
    * 
    * @param args the command line arguments
    */
   public static void main(String args[])
   {
      /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try
      {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
         {
            if ("Nimbus".equals(info.getName()))
            {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      }
      catch (ClassNotFoundException ex)
      {
         java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
        //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new Frame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnExport;
   private javax.swing.JButton btnImport;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JScrollPane jScrollPane5;
   private javax.swing.JLabel lblClear;
   private javax.swing.JTextArea txtCorrections;
   private javax.swing.JTextArea txtResults;
   private javax.swing.JTextArea txtStatements;
   // End of variables declaration//GEN-END:variables
}
