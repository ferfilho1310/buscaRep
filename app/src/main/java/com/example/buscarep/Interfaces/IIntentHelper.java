package com.example.buscarep.Interfaces;

import android.app.Activity;

public interface IIntentHelper {

    void simpleIntent(Activity activity, Class clazz);

    void intentWithFinish(Activity activity, Class clazz);

    void intentWithFinishAndFlags(Activity activity, Class clazz);

    void intentWithPutExtra(Activity activity, Class clazz, boolean showButtonAnunciar, String idPutExtra);
}
