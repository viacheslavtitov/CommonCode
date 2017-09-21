package com.viacheslavtitov.commoncode.data.objects;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Viacheslav Titov on 21.09.2017.
 */

public class ObjectsUtils {

    public static void storeObject(Context context, Serializable object, String fileName) {
        FileOutputStream fos;
        try {
            fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readObject(Context context, String fileName) {
        T result = null;
        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //noinspection unchecked
            result = (T) objectInputStream.readObject();
        } catch (Exception e) {
            storeObject(context, null, fileName);
            e.printStackTrace();
        }
        return result;
    }

}
