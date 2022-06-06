package GUIMain;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXcenter extends Application {
    Stage SignStage = new Stage();
    GridPane SignPane = new GridPane();// ��¼�����
    Scene SignScene = new Scene(SignPane, 600, 400);
    GridPane CenterPane = new GridPane();// �������
    Scene CenterScene = new Scene(CenterPane, 350, 820);
    GridPane RegisterPane = new GridPane();// ע������
    Scene RegisterScene = new Scene(RegisterPane, 500, 600);

    public void start(Stage primaryStage) {// UI����
        Sign();
        Center();
        Register();
        SignStage.setScene(SignScene);
        SignStage.initStyle(StageStyle.UNDECORATED);
        SignStage.show();
    }

    void Sign() {// ***��¼UI
        Label SignTitle = new Label("    ��¼");
        SignTitle.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 40));
        Label SignAccountLabel = new Label("�˺�:");
        SignAccountLabel.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 20));
        Label SignPasswordLabel = new Label("����:");
        SignPasswordLabel.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 20));
        Label SignUnableLabel = new Label("�޷���¼->");
        SignUnableLabel.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 15));
        Label SignForgetLabel = new Label("�˺Ż����������");
        SignForgetLabel.setTextFill(Color.RED);
        SignForgetLabel.setFont(Font.font("T", FontPosture.ITALIC, 20));
        SignForgetLabel.setVisible(false);

        TextField SignAccountTextField = new TextField();
        TextField SignPasswordTextField = new TextField();

        Button SignOkButton = new Button("��¼");
        Button SignRegisterButton = new Button("ע��");
        Button SignForgetButton = new Button("��������");
        SignOkButton.setTranslateX(250);
        SignOkButton.setTranslateY(250);
        SignForgetButton.setTranslateX(420);
        SignForgetButton.setTranslateY(285);
        SignRegisterButton.setTranslateX(420);
        SignRegisterButton.setTranslateY(320);

        SignPane.setHgap(20);
        SignPane.setVgap(20);

        SignPane.setPadding(new Insets(0, 10, 10, 10));

        SignPane.add(SignTitle, 4, 2);
        SignPane.add(SignAccountLabel, 3, 3);
        SignPane.add(SignAccountTextField, 4, 3);
        SignPane.add(SignPasswordLabel, 3, 4);
        SignPane.add(SignPasswordTextField, 4, 4);
        SignPane.add(SignUnableLabel, 5, 6);
        SignPane.add(SignForgetLabel, 4, 7);
        SignPane.getChildren().addAll(SignOkButton, SignRegisterButton, SignForgetButton);
        SignPane.setStyle("-fx-background-image: url(" + "file:GUI/Sign.jpg" + "); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;"
                + "-fx-background-color:  transparent;" + "-fx-background-size: 750px;");

        SignOkButton.setOnAction(e -> { // ת�����������
            try {
                if (accountNumber.testing(SignAccountTextField.getText(), SignPasswordTextField.getText()) == 1)
                    SignStage.setScene(CenterScene);
                else {
                    SignForgetLabel.setVisible(true);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        SignRegisterButton.setOnAction(e -> {// ת��ע�����
            SignStage.setScene(RegisterScene);
        });

    }

    void Register() {// ***ע��UI
        Label RegisterTitle = new Label("   ע��");
        RegisterTitle.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 40));
        Label RegisterAccountLabel = new Label("�˺�:");
        RegisterAccountLabel.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 20));
        Label RegisterPasswordLabel = new Label("����:");
        RegisterPasswordLabel.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 20));
        Label RegisterIDLabel = new Label("�û���:");
        RegisterIDLabel.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 20));
        Label RegisterRepeatLabel = new Label("���˺��Ѵ���");
        RegisterRepeatLabel.setTextFill(Color.RED);
        RegisterRepeatLabel.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 20));
        RegisterRepeatLabel.setVisible(false);
        Label RegisterSuccessLabel = new Label("ע��ɹ���");
        RegisterSuccessLabel.setTextFill(Color.RED);
        RegisterSuccessLabel.setFont(Font.font("T", FontWeight.LIGHT, FontPosture.ITALIC, 40));
        RegisterSuccessLabel.setVisible(false);

        Button RegisterOkButton = new Button("ע��");
        RegisterOkButton.setTranslateX(220);
        RegisterOkButton.setTranslateY(400);
        Button RegisterReButton = new Button("����");
        RegisterReButton.setTranslateX(420);
        RegisterReButton.setTranslateY(550);

        TextField RegisterAccountTextField = new TextField();
        TextField RegisterPasswordTextField = new TextField();
        TextField RegisterIDTextField = new TextField();

        RegisterPane.setHgap(20);
        RegisterPane.setVgap(20);
        RegisterPane.setStyle("-fx-background-image: url(" + "file:GUI/Register.jpg"
                + "); " + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;"
                + "-fx-background-color:  transparent;" + "-fx-background-size: 500px;");

        RegisterPane.setPadding(new Insets(0, 10, 10, 10));
        RegisterPane.add(RegisterTitle, 3, 2);
        RegisterPane.add(RegisterAccountLabel, 2, 5);
        RegisterPane.add(RegisterPasswordLabel, 2, 7);
        RegisterPane.add(RegisterIDLabel, 2, 9);
        RegisterPane.add(RegisterAccountTextField, 3, 5);
        RegisterPane.add(RegisterPasswordTextField, 3, 7);
        RegisterPane.add(RegisterIDTextField, 3, 9);
        RegisterPane.add(RegisterRepeatLabel, 3, 6);
        RegisterPane.add(RegisterSuccessLabel, 3, 13);

        RegisterPane.getChildren().addAll(RegisterOkButton, RegisterReButton);

        RegisterReButton.setOnAction(e -> SignStage.setScene(SignScene));

        RegisterOkButton.setOnAction(e -> {
            try {
                if (accountNumber.testing(RegisterAccountTextField.getText()) == 1) {
                    accountNumber.register(RegisterAccountTextField.getText(), RegisterPasswordTextField.getText(),
                            RegisterIDTextField.getText());
                    RegisterSuccessLabel.setVisible(true);
                } else
                    RegisterRepeatLabel.setVisible(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    void Center() {// ***����UI

        CenterPane.setHgap(20);
        CenterPane.setVgap(20);
        CenterPane.add(new Label("����������"), 0, 0);
        CenterPane.setPadding(new Insets(0, 10, 10, 10));
    }

    public static void main(String[] args) {// ***����
        launch(args);
    }

}