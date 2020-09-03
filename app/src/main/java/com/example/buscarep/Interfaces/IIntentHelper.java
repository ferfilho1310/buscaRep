package com.example.buscarep.Interfaces;

import android.app.Activity;

public interface IIntentHelper {

    void SimpleIntent(Activity activity, Class clazz);

    void IntentWithFinish(Activity activity, Class clazz);

    void IntentWithFinishAndFlags(Activity activity, Class clazz);
}
