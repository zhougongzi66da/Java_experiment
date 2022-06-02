package Experiment_6;

import java.io.File;
import java.io.IOException;

public interface IPProcess {
    void process(File in, File out) throws IOException;
}
