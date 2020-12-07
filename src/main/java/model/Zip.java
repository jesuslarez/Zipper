package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.zip.*;
import java.util.List;
import javax.swing.JProgressBar;

public class Zip {

    private static double contFiles;
    private static double totalFiles;
    private static JProgressBar JProgressBar;

    public static void compress(List<String> files, String filePath, String parentPath, String parentName, JProgressBar JProgressBar) {
        String separator = System.getProperty("file.separator");
        double porcentaje = 0;
        try {
            // Objeto para referenciar a los archivos que queremos comprimir
            BufferedInputStream origin = null;
            // Objeto para referenciar el archivo zip de salida
            FileOutputStream dest = null;

            if (filePath.equals(parentPath)) {
                dest = new FileOutputStream(filePath + separator + parentName + ".zip");
                System.out.println(filePath + separator + parentName + ".zip");
            } else {
                dest = new FileOutputStream(filePath + ".zip");
                System.out.println(filePath + ".zip");
            }

            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            // Buffer de transferencia para almacenar datos a comprimir
            byte[] data = new byte[4096];
            Iterator i = files.iterator();
            totalFiles = files.size();
            contFiles = 0;
            JProgressBar.setValue(0);
            while (i.hasNext()) {
                String filename = (String) i.next();
                FileInputStream fi = new FileInputStream(parentPath + separator + filename);
                origin = new BufferedInputStream(fi, 4096);
                ZipEntry entry = new ZipEntry(filename);
                out.putNextEntry(entry);
                // Leemos datos desde el archivo origen y se envían al archivo destino
                int count;
                while ((count = origin.read(data, 0, 4096)) != -1) {
                    out.write(data, 0, count);
                }
                contFiles++;
                Thread.sleep(1000);
                porcentaje = (contFiles / totalFiles) * 100;
                JProgressBar.setValue((int) porcentaje);
                // Cerramos el archivo origen, ya enviado a comprimir
                origin.close();
            }
            // Cerramos el archivo zip
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
