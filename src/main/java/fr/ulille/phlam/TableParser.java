package fr.ulille.phlam;

import fr.ulille.phlam.entities.Datatable;
import fr.ulille.phlam.entities.PredictedTransition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableParser {

    private Datatable datatable;
    private String file;
    private List<PredictedTransition> transitions;

    public TableParser(Datatable datatable, String file){
        this.datatable = datatable;
        this.file = file;
        transitions = new ArrayList<>();
    }

    public void parseTable() throws IOException {
        List<String> input = Files.readAllLines(Paths.get(file));
        PredictionParser parser = new PredictionParser(datatable);
        // for some formats skipIndex may be > 0
        int skipIndex = 0;
        List<String> lines = input.stream().skip(skipIndex).collect(Collectors.toList());
        transitions = lines.stream().map(parser::parseTransition).collect(Collectors.toList());
    }

    public List<PredictedTransition> getTransitions() {
        return transitions;
    }
}
