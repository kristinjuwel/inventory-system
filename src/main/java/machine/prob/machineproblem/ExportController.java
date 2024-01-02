package machine.prob.machineproblem;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.*;

public class ExportController {
    public TextField filenameText;

    public void exportToFile(ActionEvent actionEvent) {
        /**
         * The exportToFile method is responsible for the button aspect for the
         * actual exporting of the data into a csv file.
         */
        //String userInputName = "export-stocks.csv";
        String exportFileName = filenameText.getText();
        File exportFile = new File(exportFileName);
        String line, content = "";
        File dbFile = new File("stocks.csv");
        try {
            BufferedReader freader = new BufferedReader(new FileReader(dbFile));
            for(line = freader.readLine(); line!=null; line=freader.readLine())
            {
                content = content + line + "\n";
            }
            freader.close();
            FileWriter fw = new FileWriter(exportFile);
            fw.write(content);
            fw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
