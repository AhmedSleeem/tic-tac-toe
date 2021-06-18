package dbproject;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public  class DataBaseUI extends BorderPane {

    protected final FlowPane flowPane;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final TitledPane titledPane;
    protected final AnchorPane anchorPane;
    protected final FlowPane flowPane0;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final TextField textField;
    protected final TextField textField0;
    protected final TextField textField1;

    public DataBaseUI() {

        flowPane = new FlowPane();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        titledPane = new TitledPane();
        anchorPane = new AnchorPane();
        flowPane0 = new FlowPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        textField = new TextField();
        textField0 = new TextField();
        textField1 = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setColumnHalignment(javafx.geometry.HPos.CENTER);
        flowPane.setHgap(10.0);
        flowPane.setPrefHeight(45.0);
        flowPane.setPrefWidth(600.0);
        flowPane.setVgap(10.0);

        button.setMnemonicParsing(false);
        button.setText("New..");

        button0.setMnemonicParsing(false);
        button0.setText("Update");

        button1.setMnemonicParsing(false);
        button1.setText("Delete");

        button2.setMnemonicParsing(false);
        button2.setText("First");

        button3.setMnemonicParsing(false);
        button3.setText("Previous");

        button4.setMnemonicParsing(false);
        button4.setText("Next");

        button5.setMnemonicParsing(false);
        button5.setText("Last");
        setBottom(flowPane);

        BorderPane.setAlignment(titledPane, javafx.geometry.Pos.CENTER);
        titledPane.setAnimated(false);
        titledPane.setPrefHeight(337.0);
        titledPane.setPrefWidth(573.0);
        titledPane.setText("Person Details");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(296.0);
        anchorPane.setPrefWidth(571.0);

        flowPane0.setHgap(20.0);
        flowPane0.setLayoutX(7.0);
        flowPane0.setLayoutY(56.0);
        flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWidth(154.0);
        flowPane0.setVgap(35.0);

        label.setGraphicTextGap(20.0);
        label.setText("ID");

        label0.setText("Name");

        label1.setText("Salary");

        textField.setLayoutX(129.0);
        textField.setLayoutY(56.0);

        textField0.setLayoutX(129.0);
        textField0.setLayoutY(106.0);

        textField1.setLayoutX(129.0);
        textField1.setLayoutY(156.0);
        titledPane.setContent(anchorPane);
        setLeft(titledPane);

        flowPane.getChildren().add(button);
        flowPane.getChildren().add(button0);
        flowPane.getChildren().add(button1);
        flowPane.getChildren().add(button2);
        flowPane.getChildren().add(button3);
        flowPane.getChildren().add(button4);
        flowPane.getChildren().add(button5);
        flowPane0.getChildren().add(label);
        flowPane0.getChildren().add(label0);
        flowPane0.getChildren().add(label1);
        anchorPane.getChildren().add(flowPane0);
        anchorPane.getChildren().add(textField);
        anchorPane.getChildren().add(textField0);
        anchorPane.getChildren().add(textField1);

    }
}