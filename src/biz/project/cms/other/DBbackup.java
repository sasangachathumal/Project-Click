/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.other;

import java.io.IOException;

/**
 *
 * @author Vihanga
 */
public class DBbackup {

    public static int restoreBackup(String path) throws IOException, InterruptedException {
        String[] executeCmd = new String[]{"mysql", "click", "--user=root", "--password=mysql", "-e", " source " + path};
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int res = runtimeProcess.waitFor();
        return res;
    }

    public static int writeBackup(String path) throws IOException, InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        Process runtimeProcess = runTime.exec("mysqldump click -h localhost -u root -pmysql --routines=true -r" + path);
        int res = runtimeProcess.waitFor();
        return res;
    }
}
//mysqldump click -h localhost -u root -pmysql -r  --routines