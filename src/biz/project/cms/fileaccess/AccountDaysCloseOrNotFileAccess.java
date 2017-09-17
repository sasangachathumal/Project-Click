/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.fileaccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * 
 */
public class AccountDaysCloseOrNotFileAccess {
    
    private final File file = new File("./DayCloseOrNot.txt");
    private static final ReentrantReadWriteLock RRWL = new ReentrantReadWriteLock();

    public boolean addCloseAccount(String date, int closeornot) throws RemoteException,
            IOException, ClassNotFoundException {
        try {
           // new File("./").mkdirs();
            RRWL.writeLock().lock();
            BufferedWriter bufferWriter = null;
            FileWriter fileWriter = null;
            boolean ifsucces = false;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String data = "";
                data += date + "@Pdw5FH0.Clse@" +closeornot + "\n";
                
                fileWriter = new FileWriter(file, false);
                bufferWriter = new BufferedWriter(fileWriter);
                bufferWriter.write(data);
                bufferWriter.flush();
                ifsucces = true;
            } finally {
                if (bufferWriter != null) {
                    bufferWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }
            return ifsucces;
        } finally {
            RRWL.writeLock().unlock();
        }
    }
    
    public String[] getAllAccount() throws RemoteException,
            IOException, ClassNotFoundException {
        try {
            RRWL.readLock().lock();
            BufferedReader bufferedReader = null;
            FileReader fileReader = null;
            String[] data = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        data = line.split("@Pdw5FH0.Clse@");
                    }
                }
                return data;
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            }
        } finally {
            RRWL.readLock().unlock();
        }
    }
    
    public boolean updateAccount(String date, int closeornot) throws
            FileNotFoundException, IOException {
        try {
            RRWL.writeLock().lock();
            BufferedReader bufferedReader = null;
            BufferedWriter bufferWriter = null;
            FileWriter fileWriter = null;
            FileReader fileReader = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);
                    String line;
                    String document = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] data = line.split("@Pdw5FH0.Clse@");
                        if (date.equals(data[0])) {
                            data[1] = String.valueOf(closeornot);
                        }
                        document += data[0] + "@Pdw5FH0.Clse@" + data[1];
                    }
                    fileWriter = new FileWriter(file, false);
                    bufferWriter = new BufferedWriter(fileWriter);
                    bufferWriter.write(document);
                    bufferWriter.flush();
                }
                return bufferWriter != null;
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferWriter != null) {
                    bufferWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }
        } finally {
            RRWL.writeLock().unlock();
        }
    }
    
}
