package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


	public class Notifcations {
		//  this class to a massege should show to user 
		public static void display(String Title, String massage) {
			Stage window = new Stage();
			window.setTitle(" Warning");
			Label lbl = new Label("This Brand already Exist");
			Button btOk = new Button("Ok");
			btOk.setOnAction(e -> window.close());
			VBox vbox = new VBox(5);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(lbl, btOk);
			Scene scene = new Scene(vbox, 300, 200);
			window.setScene(scene);
			window.showAndWait();

		}
		public static void display2() {
			Stage window = new Stage();
			window.setTitle(" Warning");
			Label lbl = new Label("check what you are write in Text filed please Dear User");
			Button btOk = new Button("Ok");
			btOk.setOnAction(e -> window.close());
			VBox vbox = new VBox(5);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(lbl, btOk);
			Scene scene = new Scene(vbox, 300, 200);
			window.setScene(scene);
			window.showAndWait();

		}
		public static void massege(String Title, String massage) {
			Stage window = new Stage();
			window.setTitle("");
			Label lbl = new Label("Dear user:Add This  to List Done Successsful");
			Button btOk = new Button("Ok");
			btOk.setOnAction(e -> window.close());
			VBox vbox = new VBox(5);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(lbl, btOk);
			Scene scene = new Scene(vbox, 300, 200);
			window.setScene(scene);
			window.showAndWait();

	}
		public static void massegeu(String Title, String massage) {
			Stage window = new Stage();
			window.setTitle("");
			Label lbl = new Label("Dear user:update at This Brand to List Done Successsful");
			Button btOk = new Button("Ok");
			btOk.setOnAction(e -> window.close());
			VBox vbox = new VBox(5);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(lbl, btOk);
			Scene scene = new Scene(vbox, 300, 200);
			window.setScene(scene);
			window.showAndWait();

	}
		public static void error(String Title, String massage) {
			Stage window = new Stage();
			window.setTitle("");
			Label lbl = new Label("Dear User This Brand unvalid in your list");
			Button btOk = new Button("Ok");
			btOk.setOnAction(e -> window.close());
			VBox vbox = new VBox(5);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(lbl, btOk);
			Scene scene = new Scene(vbox, 300, 200);
			window.setScene(scene);
			window.showAndWait();}
		
			public static void delete(String Title, String massage) {
				Stage window = new Stage();
				window.setTitle("");
				Label lbl = new Label("Dear User Delete done successful in your list");
				Button btOk = new Button("Ok");
				btOk.setOnAction(e -> window.close());
				VBox vbox = new VBox(5);
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(lbl, btOk);
				Scene scene = new Scene(vbox, 300, 200);
				window.setScene(scene);
				window.showAndWait();

	}
			public static void no() {
				Stage window = new Stage();
				window.setTitle(" !!");
				Label lbl = new Label("please add your Password again");
				Button btOk = new Button("Ok");
				btOk.setOnAction(e -> window.close());
				VBox vbox = new VBox(5);
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(lbl, btOk);
				Scene scene = new Scene(vbox, 300, 200);
				window.setScene(scene);
				window.showAndWait();

			}
			public static void no2() {
				Stage window = new Stage();
				window.setTitle(" ");
				Label lbl = new Label("Try again and add a number only");
				Button btOk = new Button("Ok");
				btOk.setOnAction(e -> window.close());
				VBox vbox = new VBox(5);
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(lbl, btOk);
				Scene scene = new Scene(vbox, 300, 200);
				window.setScene(scene);
				window.showAndWait();}
			public static void dCars(String Title, String massage) {
				Stage window = new Stage();
				window.setTitle("");
				Label lbl = new Label("Dear User This Cars not vaild in your list");
				Button btOk = new Button("Ok");
				btOk.setOnAction(e -> window.close());
				VBox vbox = new VBox(5);
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(lbl, btOk);
				Scene scene = new Scene(vbox, 300, 200);
				window.setScene(scene);
				window.showAndWait();

	}
			public void buynote() {
					Stage window = new Stage();
					window.setTitle("");
					Label lbl = new Label("Dear User your order Send to Admin");
					Button btOk = new Button("Ok");
					btOk.setOnAction(e -> window.close());
					VBox vbox = new VBox(5);
					vbox.setAlignment(Pos.CENTER);
					vbox.getChildren().addAll(lbl, btOk);
					Scene scene = new Scene(vbox, 300, 200);
					window.setScene(scene);
					window.showAndWait();

		}
			public void buynote2() {
				Stage window = new Stage();
				window.setTitle("");
				Label lbl = new Label("Dear User this Brand Have a cars if you wont to cancel a cars in it go to next Stage");
				Button btOk = new Button("Ok");
				btOk.setOnAction(e -> window.close());
				VBox vbox = new VBox(5);
				vbox.setAlignment(Pos.CENTER);
				vbox.getChildren().addAll(lbl, btOk);
				Scene scene = new Scene(vbox, 300, 200);
				window.setScene(scene);
				window.showAndWait();

	}
			}
	
