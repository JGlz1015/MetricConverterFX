import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application  {
    private TextField inputValueField;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        inputValueField = new TextField();
        resultLabel = new Label();

        grid.add(new Label("Enter Value:"), 0, 0);
        grid.add(inputValueField, 1, 0);
        grid.add(new Label("Result:"), 0, 1);
        grid.add(resultLabel, 1, 1);

        inputValueField.setOnAction(e -> convert());

        Scene scene = new Scene(grid, 300, 100);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void convert() {
        try {
            double inputValue = Double.parseDouble(inputValueField.getText());

            double metersToKilometers = inputValue * 0.001;
            double kgToLbs = inputValue * 2.20462;
            double gramsToOunces = inputValue * 0.03527396;

            resultLabel.setText(String.format(
                    "%.2f meters = %.2f kilometers\n" +
                            "%.2f kg = %.2f lbs\n" +
                            "%.2f grams = %.2f ounces",
                    inputValue, metersToKilometers,
                    inputValue, kgToLbs,
                    inputValue, gramsToOunces));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
