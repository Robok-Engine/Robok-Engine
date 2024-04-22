package com.gamengine;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import com.gamengine.classes.methods.GamEngineMethodCaller;
import com.gamengine.classes.methods.MyClass;



public class MainActivity extends AppCompatActivity {
	
	GamEngineMethodCaller methodCaller;
	
	private LinearLayout background;
	private LinearLayout bottomAppBar;
	private CardView card;
	private LinearLayout linearOne;
	private EditText code;
	private LinearLayout dropDown;
	private Button runCode;
	private TextView fileName;
	private ImageView imgDropDown;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		methodCaller = new GamEngineMethodCaller(this, MainActivity.this);
		background = findViewById(R.id.background);
		bottomAppBar = findViewById(R.id.bottomAppBar);
		card = findViewById(R.id.card);
		linearOne = findViewById(R.id.linearOne);
		code = findViewById(R.id.code);
		dropDown = findViewById(R.id.dropDown);
		runCode = findViewById(R.id.runCode);
		fileName = findViewById(R.id.fileName);
		imgDropDown = findViewById(R.id.imgDropDown);
		
		runCode.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_compileCode();
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	public void _compileCode() {
		        String codeText = code.getText().toString();
		        String[] parts = codeText.split(" ");
		        
		        if (parts[0].contains("createButton")) {
				            methodCaller.callMethod(parts[0], parts[1], parts[2]);
				        } else if(parts[0].contains("createText")) {
				            methodCaller.callMethod(parts[0], parts[1], parts[2]);
				        } else if(parts[0].contains("showToast")){
				            methodCaller.callMethod(parts[0], parts[1]);
				        } else if(parts[0].contains("showTerminal")){
				            methodCaller.callMethod(parts[0]);
				        } else {
				            methodCaller.callMethod("showToast", "Nenhum Metodo");
				        }
	}
	
	
	public void _now() {
	}
	
}
