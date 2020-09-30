package com.example.buscarep.Util;

import android.app.Activity;
import android.content.Intent;

import com.example.buscarep.Interfaces.IIntentHelper;

public class IntentHelper implements IIntentHelper {

    private static IntentHelper intentHelper;

    public static synchronized IntentHelper getInstance(){
        if(intentHelper == null){
            intentHelper = new IntentHelper();
        }
        return intentHelper;
    }

    @Override
    public void SimpleIntent(Activity activity, Class clazz){
        Intent intent = new Intent(activity,clazz);
        activity.startActivity(intent);
    }

    @Override
    public void IntentWithFinish(Activity activity, Class clazz){
        Intent intent = new Intent(activity,clazz);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    public void IntentWithFinishAndFlags(Activity activity, Class clazz) {
        Intent intent = new Intent(activity, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }

}
