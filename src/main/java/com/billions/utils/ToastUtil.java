package com.billions.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * 优化Toast，功能防止用户短时间内多次触发Toast而发生的Toast泛滥.
 *
 * @author OneOfBillions
 */
public class ToastUtil {

    /**
     * The toast.
     */
    private static Toast toast = null;

    /**
     * Instantiates a new toast util.
     */
    private ToastUtil() {
    }

    private static Toast getInstance(Context context, int resStr, int during) {

        return getInstance(context, context.getString(resStr), during);

    }

    /**
     * Gets the single instance of ToastUtil.
     *
     * @param context the context
     * @param msg     the msg
     * @param during  the during
     * @return single instance of ToastUtil
     */
    @SuppressLint("ShowToast")
    private static Toast getInstance(Context context, String msg, int during) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, during);
        } else {
            toast.setDuration(during);
            toast.setText(msg);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;
    }

    /**
     * Show message.
     *
     * @param context the context
     * @param msg     the msg
     * @param during  the during
     */
    public static void showMessage(final Context context, final String msg,
                                   int during) {

        getInstance(context, msg, during).show();

    }

    public static void showMessage(final Context context, final int resStr,
                                   int during) {

        getInstance(context, resStr, during)
                .show();

    }

    public static void showMessage(final Context context, final int resStr) {

        getInstance(context, resStr,
                Toast.LENGTH_SHORT).show();

    }

}