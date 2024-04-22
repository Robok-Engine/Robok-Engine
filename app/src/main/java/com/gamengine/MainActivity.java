package com.gamengine;

//Android
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//AndroidX

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

//GamIDE
import com.gamengine.classes.methods.MethodCaller;

public class MainActivity extends AppCompatActivity {

  MethodCaller methodCaller;

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
    methodCaller = new MethodCaller(this, MainActivity.this);
    background = findViewById(R.id.background);
    bottomAppBar = findViewById(R.id.bottomAppBar);
    card = findViewById(R.id.card);
    linearOne = findViewById(R.id.linearOne);
    code = findViewById(R.id.code);
    dropDown = findViewById(R.id.dropDown);
    runCode = findViewById(R.id.runCode);
    fileName = findViewById(R.id.fileName);
    imgDropDown = findViewById(R.id.imgDropDown);

    runCode.setOnClickListener(v ->{
			compileCode();
	});
  }

  public void compileCode() {
    String codeText = code.getText().toString();
    String[] parts = codeText.split(" ");
    if (parts[0].contains("createButton")) {
      methodCaller.callMethod(parts[0], parts[1], parts[2]);
    } else if (parts[0].contains("createText")) {
      methodCaller.callMethod(parts[0], parts[1], parts[2]);
    } else if (parts[0].contains("showToast")) {
      methodCaller.callMethod(parts[0], parts[1]);
    } else if (parts[0].contains("openTerminal")) {
      methodCaller.callMethod(parts[0]);
	} else if (parts[0].contains("clear"))  {
	  methodCaller.callMethod(parts[0]);
	} else if (parts[0].contains("showDialog")) {
		methodCaller.callMethod(parts[0], parts[1], parts[2]);
    } else {
      methodCaller.callMethod("showToast", "Nenhum Metodo");
    }
  }
}
