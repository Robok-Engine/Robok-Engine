package robok.dev.compiler.logic;

public interface LogicCompilerListener {
	public void onCompiled(String logs);
	public void onOutput(String output);
}