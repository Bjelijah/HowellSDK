package com.howellsdk.utils;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2017/3/17.<br/>
 * save file to /data/data/com.example../files
 *
 */
public class FileUtil {

    /**
     * obviously it's not a cach path if you want delete files just uninstall app
     * @param context
     * @return path
     */
    public static String getCachPath(Context context){
        return context.getFilesDir().getAbsolutePath();//put to /data/data/com.example.../files FIXME by CBJ
    }

    /**
     * create /data/data/com.example.../eCamera/ dir
     * @param context
     * @return
     */
    public static String createCertificateDir(Context context){
        File eCameraDir = new File(getCachPath(context) + "/eCamera");
        if (!eCameraDir.exists()) {
            eCameraDir.mkdirs();
        }
        File CertificateDir = new File(getCachPath(context) + "/eCamera/CertificateCache");
        if (!CertificateDir.exists()) {
            CertificateDir.mkdirs();
        }
        return CertificateDir.getAbsolutePath();
    }

    /**
     * save file
     * @param in inputStream of file u wanna save
     * @param filename name
     * @param context context
     * @return file path
     */
    public static String saveCreateCertificate(InputStream in, String filename, Context context){
        if(in==null){
            return null;
        }
        String dir = createCertificateDir(context);
        File file = new File(dir+ File.separator + filename);
        try {

            boolean ret = file.createNewFile();
            if(!ret){
                return file.getAbsolutePath();
            }

            OutputStream outStream = new FileOutputStream(file);

            byte [] bs = new byte[2048];
            while((in.read(bs))!=-1){
                outStream.write(bs);
            }
            outStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    public static RandomAccessFile createVideoFile(String pathDirFileName) throws FileNotFoundException {
        return new RandomAccessFile(new File(pathDirFileName),"rw");
    }

    public static void write2VideoFile(RandomAccessFile file,byte [] data) throws IOException {
        file.write(data);
    }

    public static void closeVideoFile(RandomAccessFile file) throws IOException {
        file.close();
    }

}
