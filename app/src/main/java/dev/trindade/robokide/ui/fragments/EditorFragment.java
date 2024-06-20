package dev.trindade.robokide.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.trindade.robokide.R;
import dev.trindade.robokide.MainActivity;

import robok.trindade.interpreter.*;

import com.google.android.material.transition.MaterialSharedAxis;

public class EditorFragment extends Fragment {
	
	BaseCompiller baseCompiler;
	
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
		mCtx = getContext(); 
		
		baseCompiler = new BaseCompiller(mCtx);
		
		codeEditText = view.findViewById(R.id.code);
		runCode = view.findViewById(R.id.runCode);
		
		try{
			runCode.setOnClickListener(v -> {
				baseCompiler.compile(codeEditText.getText().toString());
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