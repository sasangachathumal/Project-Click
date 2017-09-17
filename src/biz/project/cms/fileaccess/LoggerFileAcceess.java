/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.fileaccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vihanga
 */
public class LoggerFileAcceess {

    private static final File file = new File("./LOG"+getDate() + ".txt");
    private static final ReentrantReadWriteLock RRWL = new ReentrantReadWriteLock();

    public static boolean exceptionLogger(String stackTrace) {
        try {
            RRWL.writeLock().lock();
            BufferedWriter bufferWriter = null;
            FileWriter fileWriter = null;
            try {
              //  new File("./").mkdirs();
                if (!file.exists()) {
                    file.createNewFile();
                }
                String s = "* * " + getTime() + " * *\n";

                stackTrace += "\n\n\n"
                        + "==============================================================================================================================="
                        + "\n\n\n";

                s += stackTrace;
                fileWriter = new FileWriter(file, true);
                bufferWriter = new BufferedWriter(fileWriter);
                bufferWriter.write(s);
                bufferWriter.flush();
            } catch (IOException ex) {
                Logger.getLogger(LoggerFileAcceess.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (bufferWriter != null) {
                    try {
                        bufferWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LoggerFileAcceess.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LoggerFileAcceess.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return true;
        } finally {
            RRWL.writeLock().unlock();
        }
    }

    private static String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }

    private static String getTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(date);
    }
}
