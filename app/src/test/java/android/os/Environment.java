package android.os;

import java.io.File;

/**
 * @author Yang Shihao
 */

public class Environment {

    public static File getExternalStorageDirectory() {
        return new File("/Users/hao/App/Demo/app/src/test/java/android/os/SDCard");
    }
}