package org.antennapod.audio;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinmiaoouyang on 17/10/9.
 */

public class Utils {

    /**
     * Returns a user agent string based on the given application name and the library version.
     *
     * @param context         A valid context of the calling application.
     * @param applicationName String that will be prefix'ed to the generated user agent.
     * @return A user agent string generated using the applicationName and the library version.
     */
    private static String getUserAgent(Context context, String applicationName) {
        String versionName;
        try {
            String packageName = context.getPackageName();
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            versionName = "?";
        }
        return applicationName + "/" + versionName + " (Linux;Android " + Build.VERSION.RELEASE
                + ") ";
    }

    public static Map<String, String> getUserAgentHeaders(Context context) {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("User-Agent", Utils.getUserAgent(context, "CastBox"));
        return headerMap;
    }
}
