package com.zick;

import com.test.util.FtpUtil2;
import org.junit.Test;

public class FtpDownloadTestScript {

    @Test
    public void run() {

        String ftpHost = "172.16.0.118";
        String ftpUserName = "zick";
        String ftpPassword = "zick";
        int ftpPort = 21;
        String ftpPath = "D:\\ftpfile/";
        String localPath = "C:\\Users\\Administrator\\Downloads";
        String fileName = "FTPServer.rar";
        FtpUtil2.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName);
    }
}
