package view;

import java.io.File;
import java.io.FileFilter;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame {

    private final JFileChooser jFileChooserOpen;
    private JFileChooser jFileChooserSave;
    private String path;

    public MainFrame() {
        setLookAndFeel();
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        jFileChooserOpen = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilterOpen = new FileNameExtensionFilter("Directory", new String[]{"directory"});
        jFileChooserOpen.setAcceptAllFileFilterUsed(false);
        jFileChooserOpen.addChoosableFileFilter(fileNameExtensionFilterOpen);
        jFileChooserOpen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.setTitle("Zipper - By Ignacio Marín & Jesús Lárez");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        filesJList = new javax.swing.JList<>();
        compressJButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        openDirectoryJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(filesJList);

        compressJButton.setText("Compress");
        compressJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressJButtonActionPerformed(evt);
            }
        });

        fileJMenu.setMnemonic('f');
        fileJMenu.setText("File");

        openDirectoryJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openDirectoryJMenuItem.setText("Open directory");
        openDirectoryJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDirectoryJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(openDirectoryJMenuItem);

        exitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitJMenuItem.setText("Exit");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        jMenuBar1.add(fileJMenu);

        helpJMenu.setMnemonic('h');
        helpJMenu.setText("Help");

        aboutJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        jMenuBar1.add(helpJMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(compressJButton)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(compressJButton)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private class FilterZip implements FileFilter{
        @Override
        public boolean accept(File file) {
            boolean isFile = file.isFile();
            return isFile;
        }
    }
    
    private void openDirectoryJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDirectoryJMenuItemActionPerformed
        int res = jFileChooserOpen.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            path = jFileChooserOpen.getSelectedFile().getAbsolutePath();
            if (new File(path).listFiles(new FilterZip()) == null){
                JOptionPane.showMessageDialog(rootPane, "That directory does not exist");
            } else{
                loadFiles(new File(path).listFiles(new FilterZip()));
            }
        }
    }

    private void setLookAndFeel() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openDirectoryJMenuItemActionPerformed

    private void compressJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compressJButtonActionPerformed
        jFileChooserSave = new JFileChooser(new File(path));
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Zip", new String[]{"Zip"});
        jFileChooserSave.addChoosableFileFilter(fileNameExtensionFilter);
        jFileChooserSave.setAcceptAllFileFilterUsed(false);
        if (filesJList.getSelectedValuesList().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "You must select at least one item from the list");
        } else {
            if (jFileChooserSave.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                ProgressFrame progressFrame = new ProgressFrame(
                        filesJList.getSelectedValuesList(), 
                        jFileChooserSave.getSelectedFile().getAbsolutePath(),
                        new File(path).getAbsolutePath(),new File(path).getName());
                progressFrame.setVisible(true);
                loadFiles(new File(path).listFiles(new FilterZip()));
            }
        }
    }//GEN-LAST:event_compressJButtonActionPerformed

    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJMenuItemActionPerformed
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you wanna exit?", "Exit", JOptionPane.YES_OPTION);
        if (res == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Zipper is based on Swing from the Java Library."
                + "\nThis program compresses files. "
                + "\nVersion 1.0 - GitHub information: https://github.com/jesuslarez/Zipper");
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    
    public void loadFiles(File[] files) {
        DefaultListModel model = new DefaultListModel();
        for (File file : files) {
            model.addElement(file.getName());
        }
        filesJList.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JButton compressJButton;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JList<String> filesJList;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem openDirectoryJMenuItem;
    // End of variables declaration//GEN-END:variables

}
