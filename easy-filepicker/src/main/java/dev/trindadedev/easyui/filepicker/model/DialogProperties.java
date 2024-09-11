package dev.trindadedev.easyui.filepicker.model;

import java.io.File;

public class DialogProperties {

    public int selection_mode;

    public int selection_type;

    public File root;

    public File error_dir;
    
    public File offset;

    public String[] extensions;

    public DialogProperties() {
        selection_mode = DialogConfigs.SINGLE_MODE;
        selection_type = DialogConfigs.FILE_SELECT;
        root = new File(DialogConfigs.DEFAULT_DIR);
        error_dir = new File(DialogConfigs.DEFAULT_DIR);
        offset = new File(DialogConfigs.DEFAULT_DIR);
        extensions = null;
    }
}