package javafxtest.test12;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

import java.awt.Desktop;
import java.net.URI;

public class Merci extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Message principal
        String message = "Merci Felix TANZI \n"
                + "La je faisais un test d'une maniere pour remercier ses proches.\n"
                + "Apres je suis ouvert aux suggestions.";

        Label messageLabel = new Label(message);
        messageLabel.setFont(Font.font("Arial", 22));
        messageLabel.setTextFill(Color.CYAN);
        messageLabel.setEffect(new DropShadow(4, Color.BLACK));
        messageLabel.setWrapText(true);
        messageLabel.setAlignment(Pos.CENTER);
        messageLabel.setStyle("-fx-text-alignment: center;");

        // Signature
        Label signature = new Label("Avec tout mon amour, Félix ");
        signature.setFont(Font.font("Georgia", 18));
        signature.setTextFill(Color.LIGHTBLUE);
        signature.setOpacity(0);

        // Image - la c'est une redirection vers mon image
        String imageUrl = "https://gi-enspy.com/NzikoTalla.jpeg";
        ImageView imageView;
        try {
            Image image = new Image(imageUrl, 200, 200, true, true);
            imageView = new ImageView(image);
            imageView.setEffect(new DropShadow(10, Color.DARKGRAY));
        } catch (Exception e) {
            imageView = new ImageView();
            System.out.println("Erreur lors du chargement de l'image.");
        }


        HBox socialBox = new HBox(20);
        socialBox.setAlignment(Pos.CENTER);
        socialBox.setPadding(new Insets(15, 0, 0, 0));

        // Redirection sur mes differentes pages
        socialBox.getChildren().addAll(
                createSocialIcon("https://cdn-icons-png.flaticon.com/512/2111/2111463.png", "https://www.instagram.com/felix.tanzi/"),
                createSocialIcon("https://cdn-icons-png.flaticon.com/512/174/174857.png", "https://www.linkedin.com/in/𝐅é𝐥𝐢𝐱-𝐓𝐀𝐍𝐙𝐈-7809b025a"),
                createSocialIcon("https://cdn-icons-png.flaticon.com/512/733/733553.png", "https://github.com/Felix-TANZI")
        );


        FadeTransition fadeMessage = new FadeTransition(Duration.seconds(3), messageLabel);
        fadeMessage.setFromValue(0);
        fadeMessage.setToValue(1);
        fadeMessage.setCycleCount(1);
        fadeMessage.play();

        FadeTransition fadeSignature = new FadeTransition(Duration.seconds(2), signature);
        fadeSignature.setFromValue(0);
        fadeSignature.setToValue(1);
        fadeSignature.setCycleCount(1);
        fadeSignature.setDelay(Duration.seconds(3));
        fadeSignature.play();

        VBox root = new VBox(20, imageView, messageLabel, signature, socialBox);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #000000; -fx-padding: 30;");

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Mess-T");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode utilitaire pour créer un logo avec lien
    private HBox createSocialIcon(String iconUrl, String linkUrl) {
        ImageView icon = new ImageView(new Image(iconUrl, 40, 40, true, true));
        icon.setCursor(javafx.scene.Cursor.HAND);
        icon.setOnMouseClicked(e -> {
            try {
                Desktop.getDesktop().browse(new URI(linkUrl));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        HBox box = new HBox(icon);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}