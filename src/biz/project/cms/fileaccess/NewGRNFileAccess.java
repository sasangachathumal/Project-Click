/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.fileaccess;

import biz.project.cms.model.TempOrder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Vihanga
 */
public class NewGRNFileAccess {

    private final File file = new File("./tempgrnbackup.txt");
    private static final ReentrantReadWriteLock RRWL = new ReentrantReadWriteLock();

    public boolean addorderdetail(TempOrder detail) throws RemoteException,
            IOException, ClassNotFoundException {
        try {
          //  new File("./").mkdirs();
            RRWL.writeLock().lock();
            BufferedWriter bufferWriter = null;
            FileWriter fileWriter = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String data = detail.getNo() + "#" + detail.getCode()
                        + "#" + detail.getDesc()
                        + "#" + detail.getWarranty()
                        + "#" + detail.getQty()
                        + "#" + detail.getCost()
                        + "#" + detail.getSellingPrice()
                        + "#" + detail.getPrice()
                        + "#" + detail.getAmount() + "\n";
                fileWriter = new FileWriter(file, true);
                bufferWriter = new BufferedWriter(fileWriter);
                bufferWriter.write(data);
                bufferWriter.flush();
            } finally {
                if (bufferWriter != null) {
                    bufferWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }
            return true;
        } finally {
            RRWL.writeLock().unlock();
        }
    }

    public boolean updateOrder(String qty, String bid) throws
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
                        String[] data = line.split("#");
                        if (bid.equals(data[1])) {
                            data[4] = qty;
                        }
                        document += data[0] + "#" + data[1] + "#" + data[2]
                                + "#" + data[3] + "#" + data[4] + "#"
                                + data[5] + "#" + data[6] + "#" 
                                + data[7] + "#" + data[8] +  "\n";
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

    /**
     * @return all details
     */
    public ArrayList<TempOrder> getAllDetail() throws RemoteException,
            IOException, ClassNotFoundException {
        try {
            RRWL.readLock().lock();
            BufferedReader bufferedReader = null;
            FileReader fileReader = null;
            ArrayList<TempOrder> details = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);
                    details = new ArrayList<>();
                    String line;
                    TempOrder detail;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] data = line.split("#");
                        detail = new TempOrder(data[1], data[2], data[3],
                                data[4], data[7], data[8], data[5],data[6], data[0]);
                        details.add(detail);
                    }
                }
                return details;
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

    public boolean deleteEntry(String code) throws FileNotFoundException,
            IOException {
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
                        String[] data = line.split("#");
                        if (code.equals(data[1])) {
                            continue;
                        }
                        document += line + "\n";
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

    /**
     * @return delete all
     */
    public boolean deleteAll() throws FileNotFoundException, IOException {
        try {
            RRWL.writeLock().lock();
            BufferedWriter bufferWriter = null;
            FileWriter fileWriter = null;
            try {
                if (file.exists()) {
                    fileWriter = new FileWriter(file, false);
                    bufferWriter = new BufferedWriter(fileWriter);
                    bufferWriter.write("");
                    bufferWriter.flush();
                }
                return bufferWriter != null;
            } finally {
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
