package com.viacheslavtitov.commoncode.file;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Viacheslav Titov on 21.09.2017.
 */

public class FileUtils {

    public static final String DIR_EXTERNAL_CACHE_NAME = "/commonCacheDir";

    public static boolean existFile(File file) {
        if (file == null || !file.exists()) return false;
        return true;
    }

    public static String getFileData(File file) {
        if (!existFile(file)) return null;
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return text.toString();
    }

    private static File getFile(String fileName) {
        return new File(getExternalFileCacheDir(), fileName);
    }

    public static String readFileFromAssets(Context context, String fileName) {
        if (context == null) return null;
        StringBuilder buf = new StringBuilder();
        InputStream json = null;
        BufferedReader in = null;
        try {
            json = context.getAssets().open(fileName);
            in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return buf.toString();
    }

    public static String readFile(String fileName) {
        return readFile(getFile(fileName));
    }

    public static String readFile(File file) {
        StringBuilder text = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                //text.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return text.toString();
    }

    private static File getExternalFileCacheDir() {
        File root = android.os.Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + DIR_EXTERNAL_CACHE_NAME);
        if (!dir.exists()) {
            dir.mkdir();
        } else if (dir.isFile()) {
            dir.delete();
            dir.mkdir();
        }
        return dir;
    }

    public static void writeToFile(String data, String fileName) {
        writeToFile(data, getFile(fileName));
    }

    public static void writeToFile(String data, File file) {
        FileOutputStream f = null;
        PrintWriter pw = null;
        try {
            f = new FileOutputStream(file);
            pw = new PrintWriter(f);
            pw.write(data);
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) pw.close();
            if (f != null) try {
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
