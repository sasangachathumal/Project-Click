/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.fileaccess;

import biz.project.cms.model.CustomerSerial;
import biz.project.cms.model.TempSerial;
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
public class OrderSerialFileAccess {

    private final File file = new File("./temporserserialbackup.txt");
    private static final ReentrantReadWriteLock RRWL = new ReentrantReadWriteLock();

    public boolean addSerial(String code, ArrayList<TempSerial> serials) throws RemoteException,
            IOException, ClassNotFoundException {
        try {
      //      new File("./").mkdirs();
            RRWL.writeLock().lock();
            BufferedWriter bufferWriter = null;
            FileWriter fileWriter = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String data = "";
                for (TempSerial serial : serials) {
                    data += code + "#kxtz3#" + serial.getSerial()
                            + "#kxtz3#" + serial.getPeriod() 
                            + "#kxtz3#" + serial.getTag1()
                            + "#kxtz3#" + serial.getTag2() 
                            + "#kxtz3#\n";
                }
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

//    public boolean updateOrder(String serial, String code) throws
//            FileNotFoundException, IOException {
//        try {
//            RRWL.writeLock().lock();
//            BufferedReader bufferedReader = null;
//            BufferedWriter bufferWriter = null;
//            FileWriter fileWriter = null;
//            FileReader fileReader = null;
//            try {
//                if (file.exists()) {
//                    fileReader = new FileReader(file);
//                    bufferedReader = new BufferedReader(fileReader);
//                    String line;
//                    String document = "";
//                    while ((line = bufferedReader.readLine()) != null) {
//                        String[] data = line.split("#kxtz3#");
//                        if (code.equals(data[0])) {
//                            data[4] = qty;
//                        }
//                        document += data[0] + "#kxtz3#" + data[1] + "#kxtz3#" + data[2]
//                                + "#kxtz3#\n";
//                    }
//                    fileWriter = new FileWriter(file, false);
//                    bufferWriter = new BufferedWriter(fileWriter);
//                    bufferWriter.write(document);
//                    bufferWriter.flush();
//                }
//                return bufferWriter != null;
//            } finally {
//                if (bufferedReader != null) {
//                    bufferedReader.close();
//                }
//                if (fileReader != null) {
//                    fileReader.close();
//                }
//                if (bufferWriter != null) {
//                    bufferWriter.close();
//                }
//                if (fileWriter != null) {
//                    fileWriter.close();
//                }
//            }
//        } finally {
//            RRWL.writeLock().unlock();
//        }
//    }
    /**
     * @return all serials
     */
    public ArrayList<String[]> getAllDetail() throws RemoteException,
            IOException, ClassNotFoundException {
        try {
            RRWL.readLock().lock();
            BufferedReader bufferedReader = null;
            FileReader fileReader = null;
            ArrayList<String[]> serials = null;
            try {
                if (file.exists()) {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);
                    serials = new ArrayList<>();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] data = line.split("#kxtz3#");
                        serials.add(data);
                    }
                }
                return serials;
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

    public boolean deleteSerial(String code, String serial) throws FileNotFoundException,
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
                        String[] data = line.split("#kxtz3#");
                        if (code.equals(data[0]) && serial.equals(data[1])) {
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

    public boolean deleteBatch(String code) throws FileNotFoundException,
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
                        String[] data = line.split("#kxtz3#");
                        if (code.equals(data[0])) {
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
