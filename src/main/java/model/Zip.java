package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.zip.*;
import java.util.List;

public class Zip {


    public static void compress(List<String> files, String filePath, String parentPath, String parentName) {
        try {
            // Objeto para referenciar a los archivos que queremos comprimir
            BufferedInputStream origin = null;
            // Objeto para referenciar el archivo zip de salida
            FileOutputStream dest = null;
            
            if (filePath.equals(parentPath)) {
                dest = new FileOutputStream(filePath + "\\" +parentName + ".zip");
                System.out.println(filePath + "\\" +parentName + ".zip");
            }else{
                dest = new FileOutputStream(filePath + ".zip");
                System.out.println(filePath + ".zip");
            }
            
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            // Buffer de transferencia para almacenar datos a comprimir
            byte[] data = new byte[4096];
            Iterator i = files.iterator();
            while (i.hasNext()) {
                String filename = (String) i.next();
                FileInputStream fi = new FileInputStream(parentPath + "\\" + filename);
                origin = new BufferedInputStream(fi, 4096);
                ZipEntry entry = new ZipEntry(filename);
                out.putNextEntry(entry);
                System.out.println(filename);
                // Leemos datos desde el archivo origen y se envían al archivo destino
                int count;
                while ((count = origin.read(data, 0, 4096)) != -1) {
                    out.write(data, 0, count);
                }
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
