package com.trindade.gamide.ui.fragments;

// Android
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// AndroidX
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// GamIDE
import com.trindade.gamide.R;
import com.trindade.gamide.classes.interpreter.BaseCompiller;

// Google
import com.google.android.material.transition.MaterialSharedAxis;

public class EditorFragment extends Fragment {
	
	// GamIDE Classes
	BaseCompiller base;
	
	private Context mCtx;
	private EditText codeEditText;
	private Button runCode;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setEnterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
		setExitTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));
	}
	
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_editor, container, false);
		mCtx = getContext(); // Inicialize o contexto aqui
		
		// GamIDE
		base = new BaseCompiller(mCtx);
		
		codeEditText = view.findViewById(R.id.code);
		runCode = view.findViewById(R.id.runCode);
		
		try{
			runCode.setOnClickListener(v -> {
				base.compile(codeEditText.getText().toString());
			});
		} catch (Exception e) {
			Toast.makeText(mCtx, e.toString(), 4000).show();
		}
		
		return view;
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}
}