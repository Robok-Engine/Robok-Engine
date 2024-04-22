package com.gamengine.classes.methods;

//Android
import android.content.Context;
import android.widget.Toast;
//GamIDE
import com.gamengine.MainActivity;
import com.gamengine.classes.methods.Methods;

//Java
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MethodCaller {

    private Map<String, Method> methodMap;
    private Context mCtx;
    private WeakReference<MainActivity> weak;
    private Methods myClassInstance;

    public MethodCaller(Context ctx, MainActivity main) {
        methodMap = new HashMap<>();
        mCtx = ctx;
        weak = new WeakReference<>(main);
        myClassInstance = new Methods(ctx, main);
        try {
            methodMap.put("showToast", Methods.class.getDeclaredMethod("showToast", String.class));
            methodMap.put("createButton", Methods.class.getDeclaredMethod("createButton", String.class, String.class));
            methodMap.put("createText", Methods.class.getDeclaredMethod("createText", String.class, String.class));
            methodMap.put("openTerminal", Methods.class.getDeclaredMethod("openTerminal"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void callMethod(String methodName, Object... args) {
        Method method = methodMap.get(methodName);
        if (method != null) {
            try {
                method.invoke(myClassInstance, args);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(mCtx, "Erro ao chamar método '" + methodName + "'.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(mCtx, "Método '" + methodName + "' não encontrado.", Toast.LENGTH_SHORT).show();
        }
    }
}