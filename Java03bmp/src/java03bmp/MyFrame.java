package java03bmp;

import javax.swing.JFileChooser;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

public class MyFrame extends javax.swing.JFrame {

    JFileChooser jfc;  // Abrir ficheros
    String filename;  // Nombre fichero
    byte[] unidim;  // Array 1d de pixeles
    Punto[][] bidim;  // Array 2d de puntos con tres colores
    FileOutputStream fos;
    FileInputStream fis;
    int nread;
    Punto paux;
    int altura, anchura, size;  // Altura y anchura de imagen
    int offset;  // Ppsición de primer punto leido
            
    public MyFrame() {
        initComponents();
        jfc = new JFileChooser();
        unidim = new byte[500];
        bidim = new Punto[100][100];
    }

    // Método para convertir 4 bytes de cabecera del BMP a un entero
    private int bentero(byte a, byte b, byte c, byte d){
        // Conversión implícita de byte a entero
        int aint = a, bint=b, cint=c, dint=d;
        // Desplazar bits (añadir ceros al final)
        int aux;
        aux = dint << 24;
        dint = aux;
        aux = cint << 16;
        cint = aux;
        aux = bint << 8;
        bint = aux;
        // Devolver la suma entera
        return aint + bint + cint + dint;
    }
    
    private void load () {
        // Leer parámetros de imagen
        offset = bentero(unidim[10], unidim[11], unidim[12], unidim[13]);
        anchura = bentero(unidim[18], unidim[19], unidim[20], unidim[21]);
        altura = bentero(unidim[22], unidim[23], unidim[24], unidim[25]);
        size = bentero(unidim[2], unidim[3], unidim[4], unidim[5]);
        System.out.println("Offset, anchura, altura: " + 
                offset + ", " + anchura + ", " +altura);
        
        // Bucle para pasar de array 1D a imagen 2D con tres colores
        int n = 0, l = 0;
        for (int i = offset; i<size; i += 3){
            n = (i / 3) % altura; // Fila
            l = (i / 3) / anchura; // Columna
            // Leer cada punto
            paux = new Punto();
            paux.red = unidim[i];
            paux.green = unidim[i + 1];
            paux.blue = unidim[i + 2];
            // Añadirlo a la matriz 2D
            bidim[n][l] = paux;

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btGuardar = new javax.swing.JButton();
        tfCoordX = new javax.swing.JTextField();
        tfRojo = new javax.swing.JTextField();
        tfVerde = new javax.swing.JTextField();
        tfAzul = new javax.swing.JTextField();
        tfCoordY = new javax.swing.JTextField();
        btElegir = new javax.swing.JButton();
        btMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Valor Azul");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Coordenada X");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Coordenada Y");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Valor Rojo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Valor Verde");

        btGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.setName("btnGuardar"); // NOI18N
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        tfCoordX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfCoordX.setName("txtCoordX"); // NOI18N

        tfRojo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfRojo.setName("txtRojo"); // NOI18N

        tfVerde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfVerde.setName("txtVerde"); // NOI18N

        tfAzul.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfAzul.setName("txtAzul"); // NOI18N
        tfAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAzulActionPerformed(evt);
            }
        });

        tfCoordY.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfCoordY.setName("txtCoordY"); // NOI18N

        btElegir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btElegir.setText("Elegir");
        btElegir.setName("btnElegir"); // NOI18N
        btElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btElegirActionPerformed(evt);
            }
        });

        btMostrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btMostrar.setText("Mostrar");
        btMostrar.setName("btnMostrar"); // NOI18N
        btMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(btMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGap(111, 111, 111))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(562, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(567, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(tfCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(178, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // Guardar
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btElegirActionPerformed
        // Elegir imagen, comprobando antes que no hay error
        if(jfc.showOpenDialog(this) == 0){
            filename = jfc.getSelectedFile().getAbsolutePath();//.toString();
            System.out.println(filename + " seleccionado correctamente");   
        }
        
        try {
            fis = new FileInputStream(filename);
            // Pasa, desde posicion off, len bytes a buffer unidim. Devuelve 
            // el nº de bytes leidos (int), -1 si hay error
            nread = fis.read(unidim, 0, 54);

            System.out.println("Nº bytes leidos: " + nread);
        } 
        catch (Exception e) {
            e.printStackTrace();
            tfCoordX.setText(e.toString());
        }
        // Si no hay error cargar imagen
        if(nread!=-1) load();
        
    }//GEN-LAST:event_btElegirActionPerformed

    private void btMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarActionPerformed
        // Mostrar
    }//GEN-LAST:event_btMostrarActionPerformed

    private void tfAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAzulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAzulActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btElegir;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfAzul;
    private javax.swing.JTextField tfCoordX;
    private javax.swing.JTextField tfCoordY;
    private javax.swing.JTextField tfRojo;
    private javax.swing.JTextField tfVerde;
    // End of variables declaration//GEN-END:variables
}