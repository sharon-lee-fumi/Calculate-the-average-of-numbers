/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalone;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Xiaowen Li
 */
public class FinalOne extends Application
{

    private Label countField;
    private TextField number;
    private int count;

    @Override
    public void start(Stage primaryStage)
    {
        VBox root = new VBox();

        this.countField = new Label("Count:0");
        root.getChildren().add(countField);

        this.number = new TextField();
        root.getChildren().add(number);

        HBox buttons = new HBox();

        Button clear = new Button("Clear");
        clear.setOnAction(new ClearForm());
        buttons.getChildren().add(clear);

        Button addNumber = new Button("Add number");
        buttons.getChildren().add(addNumber);

        addNumber.setOnAction(new AddNumber());
        root.getChildren().add(buttons);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    private class AddNumber implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event)
        {
            for (int i = 0; i< number.getText().length(); i++)
            {
                if (Character.isLetter(number.getText().charAt(i)))
                {
                    return;
                }
            }
            int c = Integer.parseInt(number.getText());

            if (c % 2 == 0)
            {
                count++;
            }
            updateOutput();
        }

        private void updateOutput()
        {
            countField.setText("Count:" + Integer.toString(count));
        }
    }

    private class ClearForm implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent t)
        {
            clearForm();
        }

        private void clearForm()
        {
            number.clear();
        }
    }
}
