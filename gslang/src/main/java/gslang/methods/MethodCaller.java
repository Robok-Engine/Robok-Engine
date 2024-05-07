package gslang.methods;

import android.content.Context;
import android.widget.Toast;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import gslang.methods.Methods;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MethodCaller {

    private Map<String, Method> methodMap;
    private Context mCtx;
    private Methods myClassInstance;

    public MethodCaller(Context ctx) {
        methodMap = new HashMap<>();
        mCtx = ctx;
        myClassInstance = new Methods(ctx);
        try {
            methodMap.put("showToast", Methods.class.getDeclaredMethod("showToast", String.class, int.class));
            methodMap.put("createButton", Methods.class.getDeclaredMethod("createButton", String.class, int.class));
            methodMap.put("createText", Methods.class.getDeclaredMethod("createText", String.class, int.class));
            methodMap.put("openTerminal", Methods.class.getDeclaredMethod("openTerminal"));
			methodMap.put("showDialog", Methods.class.getDeclaredMethod("showDialog", String.class, String.class));
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
