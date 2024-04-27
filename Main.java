package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	Button admin, customer, cfile, ofile, btn, btn5, back, prev;
	DoubleLinkedlist list = new DoubleLinkedlist();
	ArrayList<String> array = new ArrayList();
	ArrayList<String> marray = new ArrayList();
	ArrayList<String> carray = new ArrayList();
	ArrayList<Double> parray = new ArrayList();
	ArrayList<Integer> yarray = new ArrayList();
	StringBuilder stringBuilder = new StringBuilder();
	TextArea Area = new TextArea();
	Stage stage2, stage4, stage1;
	Stack stack = new Stack();
	Queue queue = new Queue();
	TableView<Cars> tableView;
	Notifcations note = new Notifcations();
	VBox vbox4;
	Label lbl3 = new Label();
	ComboBox<String> brandbox, cbox, cbox2, cmb, carbox;
	ComboBox<Integer> Ibox;
	ComboBox<Double> pbox;
	TextArea ta;
	private TableView<Cars> table;
	ArrayList<Cars> carlist = new ArrayList<>();
	Brand brand = new Brand();
	Queue Tempqueue = new Queue();
	Orders order;
	Stack temp = new Stack();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label title = new Label("Welcome To The Car Agency System ");
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		Image m = new Image("C:\\Users\\user\\Desktop\\Afnan\\Phase2\\src\\351589546_795152075272745_3967941938827033218_n.jpg");
		ImageView img = new ImageView(m);
		admin = new Button("Admin");
		admin.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		customer = new Button("Customer");
		customer.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		cfile = new Button("Cars File");
		cfile.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		cfile.setOnAction(e -> {
			FileChooser chooser = new FileChooser();
			chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.txt", "*.*"));
			File selectedFile = chooser.showOpenDialog(primaryStage);
			try {
				Scanner scan = new Scanner(selectedFile);
				String line;
				if (selectedFile != null) {
					while (scan.hasNext()) {
						line = scan.nextLine();
						String[] token = line.split(",");
						String brand = token[0];
						String model = token[1];
						String year1 = token[2].replaceAll("[^\\d.]", "");
						int year = Integer.parseInt(year1);
						String color = token[3];
						String numberString = token[4];
						double price = convertToDouble1(numberString);
						Brand brand2 = new Brand(brand);
						Node node = list.search(brand2);
						Cars car = new Cars(brand, model, year, color, price);
						if (node == null) {// this condition to check if the location is exist or not
							array.add(brand);
							list.insertAndSort(brand2);
							list.search(brand2).getList().addAndSort(car);
							carlist.add(new Cars(brand, model, year, color, price));
							marray.add(model);
							addWithoutDuplicates(carray, color);
							parray.add(price);
							yarray.add(year);
							System.out.println(model);
						} else {
							list.search(brand2).getList().addAndSort(car);
							carlist.add(new Cars(brand, model, year, color, price));
							marray.add(model);
							carray.add(color);
							parray.add(price);
							yarray.add(year);
						}

					}
				}
			} catch (FileNotFoundException e1) {
				System.out.println(" the file is not found");
			} catch (NumberFormatException e2) {
				System.out.println("there's no age found for someone");
			}
		});
		ofile = new Button("Orders File");
		ofile.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		ofile.setOnAction(e -> {
			FileChooser file = new FileChooser();
			file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.txt", "*.*"));
			File selected = file.showOpenDialog(primaryStage);
			try {

				Scanner scan = new Scanner(selected);
				String line;
				if (selected != null) {
					while (scan.hasNext()) {
						line = scan.nextLine();
						String[] token = line.split(",");
						String name = token[0];
						int mobile = Integer.parseInt(token[1].trim());
						String brand = token[2];
						String model = token[3];
						int year = Integer.parseInt(token[4].trim());
						String color = token[5];
						System.out.println(name);
						String number = token[6];
						double price = convertToDouble1(number);
						String date = token[7];
						String status = token[8];
						System.out.println(name);
						if (status.trim().equalsIgnoreCase("Finished")) {
							stack.push(new Orders(name, mobile, brand, model, year, color, price, date, status));

						} else
							queue.enqueue(new Orders(name, mobile, brand, model, year, color, price, date, status));

					}
				}
			} catch (FileNotFoundException e1) {
				System.out.println(" the file is not found");
			}

		});

		VBox vbox2 = new VBox(30);
		HBox hbox1 = new HBox(20);
		hbox1.getChildren().addAll(admin, customer, cfile, ofile);
		admin.setOnAction(e -> {
			showAdmin();
			// print();
		});
		customer.setOnAction(e -> {
			tableView();

		});
		hbox1.setAlignment(Pos.CENTER);
		vbox2.getChildren().addAll(title, img, hbox1);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setStyle("-fx-background:#89cff0");
		img.setFitHeight(400);
		img.setFitWidth(400);
		Scene scene = new Scene(vbox2, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showAdmin() {
		stage2 = new Stage();
		Label lbl = new Label("Welcome in Admin Page");
		lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		Label lbl2 = new Label("password");
		lbl2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		TextField txt = new TextField();
		HBox hbox2 = new HBox(20);
		hbox2.getChildren().addAll(lbl2, txt);
		hbox2.setAlignment(Pos.CENTER);
		Image m2 = new Image(
				"C:\\Users\\user\\Desktop\\Afnan\\Phase2\\src\\png-transparent-car-door-motor-vehicle-automotive-design-bumper-car-blue-hand-car.png");
		ImageView img = new ImageView(m2);
		img.setFitHeight(400);
		img.setFitWidth(400);
		btn = new Button("Next");
		btn.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
		// btn.setDisable(true);
		back = new Button("Back");
		back.setOnAction(e -> {
			stage2.close();
		});
		try {
			btn.setOnAction(e -> {
				if (txt.getText().equals("1210673")) {
					btn.setDisable(false);
					nextStage();
				} else if (txt.getText() != "1210673") {
					note.no();
					txt.clear();
				}
			});
		} catch (Exception e1) {
			note.no2();
		}

		vbox4 = new VBox(30);
		vbox4.getChildren().addAll(lbl, hbox2, img, btn, back);
		vbox4.setAlignment(Pos.CENTER);
		vbox4.setStyle("-fx-background:#a4dcab");
		Scene s2 = new Scene(vbox4, 800, 800);
		stage2.setScene(s2);
		stage2.showAndWait();

	}

	public void nextStage() {
		stage1 = new Stage();
		TabPane tabs = new TabPane();
		Tab tab1 = new Tab("Brands");
		Tab tab2 = new Tab("cars");
		Tab tab3 = new Tab("Orders");
		Tab tab4 = new Tab("Save and reports");
		Tab tab5 = new Tab("Saving");
		tabs.getTabs().addAll(tab1, tab2, tab3, tab4, tab5);
		tab1.setContent(tapOne());
		tab2.setContent(tabTwo());
		tab3.setContent(Tab3());
		tab4.setContent(Tab4());
		tab5.setContent(tab5());
		Button back2 = new Button("Back");
		VBox vBox2 = new VBox(tabs);
		VBox vPane = new VBox(vBox2, back2);
		back2.setOnAction(e -> {
			stage1.close();
		});
		Scene s2 = new Scene(vPane, 800, 800);
		stage1.setScene(s2);
		tabs.setStyle("-fx-background:LIGHTGREY");
		stage1.show();
	}

	public GridPane tapOne() {
		GridPane gpane = new GridPane();
		RadioButton rbtn1 = new RadioButton("insert");
		RadioButton rbtn2 = new RadioButton("update");
		RadioButton rbtn3 = new RadioButton("Delete");
		RadioButton rbtn4 = new RadioButton("Search");
		gpane.addColumn(1, rbtn1, rbtn2, rbtn3, rbtn4);
		lbl3 = new Label("Brand");
		lbl3.setVisible(false);
		TextField txt3 = new TextField();
		txt3.setVisible(false);
		Button btn2 = new Button("insert");
		btn2.setVisible(false);
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(lbl3, txt3);
		gpane.addRow(0, hbox, btn2);
		rbtn1.setOnAction(e -> {
			if (rbtn1.isSelected())
				lbl3.setVisible(true);
			txt3.setVisible(true);
			btn2.setVisible(true);
		});

		btn2.setOnAction(e -> {
			if (txt3.getText() == null) {
				note.no2();
			} else if (txt3.getText() != null) {
				if ((list.search(new Brand(txt3.getText())) == null)) {
					list.insertAndSort(new Brand(txt3.getText()));
					note.massege(" ", "Dear user:Add This Brand to List Done Successsful");
					array.add(txt3.getText());
					txt3.clear();

				} else

					note.display("Worning ", "This Brand already Exist");

			}
		});

		TextField txtu1 = new TextField();
		TextField txtu2 = new TextField();
		Button btn3 = new Button("update");
		txtu1.setVisible(false);
		txtu2.setVisible(false);
		btn3.setVisible(false);
		gpane.addRow(1, txtu1, txtu2, btn3);
		rbtn2.setOnAction(e -> {
			if (rbtn2.isSelected())
				txt3.setVisible(false);
			btn2.setVisible(false);
			txtu1.setVisible(true);
			txtu2.setVisible(true);
			btn3.setVisible(true);
		});
		btn3.setOnAction(e -> {
			if (list.search(new Brand(txtu1.getText())) == null) {
				note.error(" ", "Dear User This Brand unvalid in your list");
			} else
				list.update(txtu1.getText(), txtu2.getText());
			note.massegeu("  ", "Dear user:update at This Brand to List Done Successs");
			array.remove(txt3.getText());
			array.add(txtu2.getText());
			txtu1.clear();
			txtu2.clear();

		});

		TextField txtd = new TextField();
		Button btn4 = new Button("Delete");
		txtd.setVisible(false);
		btn4.setVisible(false);
		gpane.addRow(2, txtd, btn4);
		rbtn3.setOnAction(e -> {
			if (rbtn2.isSelected())
				txtd.setVisible(true);
			btn4.setVisible(true);
		});
		btn4.setOnAction(e -> {
			if (list.search(new Brand(txtd.getText())) == null)
				note.error(" ", "Dear User This Brand unvalid in your list");
			else

				list.removeobj(new Brand(txtd.getText()));
			if (list.search(new Brand(txtd.getText())).getList() != null) {
				note.buynote2();
			} else {
				list.removeobj(new Brand(txtd.getText()));
				note.delete("  ", "Dear User This Brand unvalid in your list");
				array.remove(txtd.getText());
			}
			txtd.clear();
		});
		cbox = new ComboBox<String>();
		cbox.setVisible(false);
		ta = new TextArea();
		ta.setVisible(false);
		gpane.addRow(3, cbox, ta);
		ta.setText("");
		cbox = new ComboBox<>();
		cbox.setVisible(false);
		ta = new TextArea();
		ta.setVisible(false);
		gpane.addRow(3, cbox, ta);
		rbtn4.setOnAction(e -> {
			if (rbtn4.isSelected())
				cbox.setVisible(true);
			cbox.getItems().addAll(array);
			ObservableList<String> options = FXCollections.observableArrayList(array);
			cbox.setItems(options);
			ta.setVisible(true);
		});
		StringBuilder sd = new StringBuilder();
		cbox.setOnAction(e -> {
			String selected = cbox.getSelectionModel().getSelectedItem();
			if (list.search(new Brand(selected)) == null) {
				sd.append("this Brand don't contian any Cars");
				ta.setText(sd.toString());
			} else
				ta.setText(list.search(new Brand(selected)).getList().getLinkedListAsString());

		});

		gpane.setAlignment(Pos.CENTER);
		gpane.setHgap(10);
		gpane.setVgap(80);
		return gpane;
	}

	public BorderPane tabTwo() {
		BorderPane pane = new BorderPane();
		GridPane gpane = new GridPane();
		RadioButton rbtn1 = new RadioButton("insert");
		RadioButton rbtn2 = new RadioButton("update");
		RadioButton rbtn3 = new RadioButton("Delete");
		RadioButton rbtn4 = new RadioButton("Search");
		gpane.addRow(0, rbtn1, rbtn2, rbtn3, rbtn4);
		ToggleGroup group = new ToggleGroup();
		Label lbl1 = new Label("Brand Name");
		Label lbl2 = new Label("Model");
		Label lbl4 = new Label("Year");
		Label lbl5 = new Label("Color");
		Label lbl6 = new Label("Price");
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		rbtn1.setToggleGroup(group);
		rbtn2.setToggleGroup(group);
		rbtn3.setToggleGroup(group);
		rbtn4.setToggleGroup(group);
		ComboBox<String> carbox = new ComboBox();
		ObservableList<String> options = FXCollections.observableArrayList(array);
		carbox.setItems(options);
		carbox.getSelectionModel().select(0);
		TextField txt2 = new TextField();
		TextField txt3 = new TextField();
		TextField txt5 = new TextField();
		TextField txt6 = new TextField();
		carbox.setVisible(false);
		txt2.setVisible(false);
		txt3.setVisible(false);
		txt5.setVisible(false);
		txt6.setVisible(false);
		Button btn2 = new Button("insert");
		btn2.setVisible(false);
		gpane.addRow(1, lbl1, carbox);
		gpane.addRow(2, lbl2, txt2);
		gpane.addRow(3, lbl4, txt3);
		gpane.addRow(4, lbl5, txt5);
		gpane.addRow(5, lbl6, txt6);
		gpane.addRow(6, btn2);
		gpane.setHgap(20);
		gpane.setVgap(20);
		gpane.setAlignment(Pos.CENTER);
		rbtn1.setOnAction(e -> {
			if (rbtn1.isSelected())
				lbl1.setVisible(true);
			lbl2.setVisible(true);
			lbl4.setVisible(true);
			lbl5.setVisible(true);
			lbl6.setVisible(true);
			carbox.setVisible(true);
			txt2.setVisible(true);
			txt3.setVisible(true);
			txt5.setVisible(true);
			txt6.setVisible(true);
			btn2.setVisible(true);
		});
		pane.setCenter(gpane);
		btn2.setOnAction(e -> {
			try {
				if (list.search(new Brand(carbox.getValue())) != null) {
					list.search(new Brand(carbox.getValue())).getList()
							.addAndSort(new Cars(carbox.getValue(), txt2.getText(), Integer.parseInt(txt3.getText()),
									txt5.getText(), Double.parseDouble(txt6.getText())));
					carlist.add(new Cars(carbox.getValue(), txt2.getText(), Integer.parseInt(txt3.getText()),
							txt5.getText(), Double.parseDouble(txt6.getText())));
					array.add(carbox.getValue());
					marray.add(txt2.getText());
					carray.add(txt5.getText());
					parray.add(Double.parseDouble(txt6.getText()));
					yarray.add(Integer.parseInt(txt3.getText()));
					note.massege(" ", "Dear user:Add This  to List Done Successsful");
				}
			} catch (NumberFormatException e1) {
				note.display2();
				e1.printStackTrace();
			} catch (Exception e1) {
				note.display2();
			}
		});
		TextField txtu55 = new TextField();
		txtu55.setVisible(false);
		TextField txtu66 = new TextField();
		txtu66.setVisible(false);
		TextField txtu77 = new TextField();
		txtu77.setVisible(false);
		TextField txtu88 = new TextField();
		txtu88.setVisible(false);
		Button btn3 = new Button("update");
		btn3.setVisible(false);
		gpane.addColumn(3, txtu55, txtu66, txtu77, txtu88);
		gpane.add(btn3, 3, 6);
		rbtn2.setOnAction(e -> {
			carbox.setVisible(true);
			btn2.setVisible(false);
			txt2.setVisible(true);
			txt3.setVisible(true);
			txt5.setVisible(true);
			txt6.setVisible(true);
			txtu55.setVisible(true);
			txtu66.setVisible(true);
			txtu77.setVisible(true);
			txtu88.setVisible(true);
			btn3.setVisible(true);
		});
		btn3.setOnAction(e -> {
			Linkedlist list1 = new Linkedlist();
			list1 = list.search(new Brand(carbox.getValue())).getList();
			try {
				if (list1.searchList(new Cars(carbox.getValue(), txt2.getText(), Integer.parseInt(txt3.getText()),
						txt5.getText(), Double.parseDouble(txt6.getText()))) != null) {
					list1.delete(new Cars(carbox.getValue(), txt2.getText(), Integer.parseInt(txt3.getText()),
							txt5.getText(), Double.parseDouble(txt6.getText())));
					array.remove(carbox.getValue());
					marray.remove(txt2.getText());
					carray.remove(txt5.getText());
					parray.remove(Double.parseDouble(txt6.getText()));
					yarray.remove(Integer.parseInt(txt3.getText()));
					list1.addAndSort(new Cars(carbox.getValue(), txtu55.getText(), Integer.parseInt(txtu66.getText()),
							txtu77.getText(), Double.parseDouble(txtu88.getText())));
					array.add(carbox.getValue());
					marray.add(txtu55.getText());
					carray.add(txtu77.getText());
					parray.add(Double.parseDouble(txtu88.getText()));
					yarray.add(Integer.parseInt(txtu66.getText()));

					note.massegeu(" ", "update done successfully");
					txt2.clear();
					txt3.clear();
					txt5.clear();
					txt6.clear();
					txtu55.clear();
					txtu66.clear();
					txtu77.clear();
					txtu88.clear();
				} else {
					note.dCars(" ", "Dear User This Cars not vaild in your list");
					txt2.clear();
					txt3.clear();
					txt5.clear();
					txt6.clear();
					txtu55.clear();
					txtu66.clear();
					txtu77.clear();
					txtu88.clear();
				}
			} catch (NumberFormatException e1) {
				note.display2();
				e1.printStackTrace();
			} catch (Exception e1) {
				note.display2();
			}

		});
		txt2.setVisible(false);
		Button btn4 = new Button("Delete");
		btn4.setVisible(false);

		rbtn3.setOnAction(e -> {
			btn2.setVisible(false);
			btn3.setVisible(false);
			carbox.setVisible(true);
			txt2.setVisible(true);
			btn4.setVisible(true);
			txtu55.setVisible(false);
			txtu66.setVisible(false);
			txtu77.setVisible(false);
			txtu88.setVisible(false);
			txt3.setVisible(true);
			txt5.setVisible(true);
			txt6.setVisible(true);
			btn4.setVisible(true);
		});

		btn4.setOnAction(e -> {
			if (list.search(new Brand(cbox.getValue())).getList()
					.searchList(new Cars(cbox.getValue(), txt2.getText())) != null) {
				list.search(new Brand(cbox.getValue())).getList().remove(new Cars(cbox.getValue(), txt2.getText()));
				array.remove(carbox.getValue());
				marray.remove(txt2.getText());

				note.delete(" ", "Dear User Delete done successful in your list");
			} else {
				note.dCars(" ", "Dear User This Cars not vaild in your list");

			}
		});
		btn5 = new Button("Search");
		btn5.setVisible(false);
		TextArea ta2 = new TextArea();
		ta2.setVisible(false);
		rbtn4.setOnAction(e -> {
			if (rbtn4.isSelected()) {
				if (rbtn1.isSelected())
					lbl1.setVisible(true);
				lbl2.setVisible(true);
				lbl4.setVisible(true);
				lbl5.setVisible(true);
				lbl6.setVisible(true);
				carbox.setVisible(true);
				txt2.setVisible(true);
				txt3.setVisible(true);
				txt5.setVisible(true);
				txt6.setVisible(true);
				ta2.setVisible(true);
				btn5.setVisible(true);

			}
		});
		try {
			btn5.setOnAction(e -> {
				StringBuilder build = new StringBuilder();
				if (list.search(new Brand(carbox.getSelectionModel().getSelectedItem())).list.search(carbox.getValue(),
						txt2.getText(), Integer.parseInt(txt3.getText()), txt5.getText(),
						Double.parseDouble(txt6.getText())) == null) {
					ta2.setText("Sorry can't find this brand");
				} else {
					build.append(list.search(new Brand(carbox.getValue())).getList().search(carbox.getValue(),
							txt2.getText(), Integer.parseInt(txt3.getText()), txt5.getText(),
							Double.parseDouble(txt6.getText())));
					ta2.setText(build.toString());

				}

			});

			gpane.addRow(2, btn4, btn5, ta2);
			gpane.setAlignment(Pos.CENTER);
			gpane.setHgap(10);
			gpane.setVgap(30);
			pane.setCenter(gpane);
		} catch (Exception e1) {
			note.display2();
		}

		return pane;
	}

	public Pane tab5() {
		Stage stage = new Stage();
		Button box1 = new Button("Write in order File");

		Button box2 = new Button("Write car File");

		Label label = new Label("The following option can be used to print report :");
		HBox hBox = new HBox(20);
		GridPane pane = new GridPane();

		pane.setPadding(new Insets(5, 5, 5, 5));

		label.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(box1, box2);

		// add all control to the pane
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.add(label, 0, 0);
		pane.add(hBox, 0, 3);

		box1.setOnAction(e -> {

			writeOrderFile(stage);

		});

		box2.setOnAction(e -> {
			writeCarFile(stage);
		});
		return pane;
	}

	public Pane Tab3() { // This method to Read and Show the Queue by admin.
		GridPane pane = new GridPane();
		Label label2 = new Label();
		Button button = new Button("Read Order");
		Button ShowOrder = new Button("Show Order");
		label2.setText("Read the Costamer order from Queue:"); // add text to the label
		button.setPrefWidth(300);
		ShowOrder.setPrefWidth(300);
		pane.setHgap(15);
		pane.setVgap(15);
		pane.add(label2, 0, 0);
		pane.add(button, 0, 5);
		pane.add(ShowOrder, 0, 8);
		pane.setAlignment(Pos.CENTER);

		button.setOnAction(e -> {
			readOrders();
		});
		ShowOrder.setOnAction(e -> {
			printQueue();
		});

		return pane;

	}

	public void readOrders() {
		while (!queue.isEmpty()) {
			order = queue.dequeue();
			System.out.println("uiy7urftydry");
			String m1 = order.getModel();
			String m2 = order.getColor();
			String m3 = order.getBrand();
			int m4 = order.getYear();
			double m5 = order.getPrice();

			Cars cars = new Cars(m3, m1, m4, m2, m5);
			System.out.println(cars);
			brand = new Brand(m3);
			if (list.search(brand).getList().search(m3, m1, m4, m2, m5) != null) {
				stack.push(order);
				list.search(brand).getList().delete(cars);
				System.out.println(order);

			}

			else
				Tempqueue.enqueue(order);
		}

		while (!Tempqueue.isEmpty()) {
			queue.enqueue(Tempqueue.dequeue());
		}
	}

	public void printQueue() {
		Stage stage = new Stage();
		GridPane pane = new GridPane();
		Button back = new Button("Back");
		StringBuilder stringBuilder = new StringBuilder();
		TextArea Area = new TextArea();

		Area.setPrefWidth(600);
		Area.setPrefHeight(500);
		pane.setAlignment(Pos.CENTER);
		pane.add(Area, 0, 0);
		pane.add(back, 3, 7);

		while (!queue.isEmpty()) {
			Orders element = queue.dequeue();
			element.setOrderStatut("InProcess");
			stringBuilder.append(element.toString() + "\n");
			Tempqueue.enqueue(element);
		}

		Area.setText(stringBuilder.toString());

		while (!Tempqueue.isEmpty()) {
			queue.enqueue((Tempqueue.dequeue()));
		}
		back.setOnAction(e -> {
			stage.close();
		});
		Scene scene = new Scene(pane, 850, 800);
		stage.setScene(scene);
		stage.setTitle("Report:");
		stage.show();
	}

	public VBox Tab4() {
		Label lbl = new Label("Cars sold Informations");
		Button info = new Button("Sold Cars");
		TextArea txtarea = new TextArea();
		txtarea.setVisible(false);
		Stack temp = new Stack();
		info.setOnAction(e -> {
			txtarea.setVisible(true);
			// StringBuilder stringBuilder = new StringBuilder();
			int num = 0;
			while (!stack.isEmpty() && num < 10) {
				Orders element = stack.pop();
				element.setOrderStatut("Finished");
				temp.push(stack.pop());
				stringBuilder.append(element.toString()).append("\n");

				num++;
			}
			txtarea.setText(stringBuilder.toString());

		});

		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		VBox pane = new VBox(20);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(lbl, info, txtarea);
		return pane;
	}

	public void tableView() {
		brandbox = new ComboBox<String>();
		ObservableList<String> info = FXCollections.observableArrayList(array);
		brandbox.setItems(info);
		cbox2 = new ComboBox<String>();
		cmb = new ComboBox<String>();
		ObservableList<String> options = FXCollections.observableArrayList(marray);
		cbox2.setItems(options);
		Ibox = new ComboBox<Integer>();
		ObservableList<Integer> years = FXCollections.observableArrayList(yarray);
		Ibox.setItems(years);
		ObservableList<String> datas = FXCollections.observableArrayList(carray);
		cmb.setItems(datas);
		pbox = new ComboBox<Double>();
		ObservableList<Double> money = FXCollections.observableArrayList(parray);
		pbox.setItems(money);
		tableView = new TableView<>();
		ObservableList<Cars> data = FXCollections.observableArrayList(carlist);
		tableView.setItems(data);
		TableColumn nameC = new TableColumn("Brand Name");
		nameC.setMinWidth(100);
		nameC.setCellValueFactory(new PropertyValueFactory<Cars, String>("brand"));
		TableColumn modelc = new TableColumn("Model");
		modelc.setMinWidth(100);
		modelc.setCellValueFactory(new PropertyValueFactory<Cars, String>("model"));
		TableColumn time = new TableColumn("Year");
		time.setMinWidth(100);
		time.setCellValueFactory(new PropertyValueFactory<Cars, String>("year"));
		TableColumn colorc = new TableColumn("Color");
		modelc.setMinWidth(100);
		colorc.setCellValueFactory(new PropertyValueFactory<Cars, String>("color"));
		TableColumn price = new TableColumn("Price");
		price.setMinWidth(100);
		price.setCellValueFactory(new PropertyValueFactory<Cars, String>("price"));
		tableView.getColumns().addAll(nameC, modelc, time, colorc, price);
		GridPane Gpane = new GridPane();
		Button filter = new Button("Filtring Data");
		HBox hBox = new HBox(10);
		HBox hBox2 = new HBox(10);
		Button next = new Button("next:");
		Button back = new Button("return");
		hBox2.getChildren().addAll(brandbox, cbox2, Ibox, cmb, pbox, filter, next, back);
		next.setOnAction(e -> {
			cleantinfo();
		});
		Gpane.add(hBox, 0, 0);
		Gpane.add(hBox2, 1, 0);
		BorderPane pane = new BorderPane();
		filter.setOnAction(e -> {
			String selectedBrand = brandbox.getSelectionModel().getSelectedItem();
			String selectedModel = cbox2.getSelectionModel().getSelectedItem();
			int selectedYear = Ibox.getSelectionModel().getSelectedItem();
			String selectedColor = cmb.getSelectionModel().getSelectedItem();
			double selectedPrice = pbox.getSelectionModel().getSelectedItem();
			ArrayList<Cars> carmy = new ArrayList<>();
			for (Node front = list.getFirst(); front != null; front = front.next) {
				for (Nodes current = front.getList().getFirst(); current != null; current = current.next) {
					Cars car = current.getElement();
					if (car.getBrand() != null && brandbox.getSelectionModel().getSelectedIndex() != 0
							&& car.getBrand().trim().equalsIgnoreCase(selectedBrand.trim()) && car.getModel() != null
							&& car.getModel().equals(selectedModel) && car.getYear() == selectedYear
							&& car.getColor().trim() != null
							&& car.getColor().trim().equalsIgnoreCase(selectedColor.trim())
							&& car.getPrice() == selectedPrice) {
						carmy.add(car);

					}
				}
			}

			ObservableList<Cars> data2 = FXCollections.observableArrayList(carmy);
			tableView.setItems(data2);

		});

		pane.setTop(Gpane);
		pane.setCenter(tableView);
		stage4 = new Stage();
		back.setOnAction(e -> {
			stage4.close();
		});
		Scene scene2 = new Scene(pane, 600, 600);
		stage4.setScene(scene2);
		stage4.show();
	}

	public void print() {
		Node current = new Node();
		Nodes front = new Nodes();
		for (current = list.getFirst(); current != null; current = current.next) {
			for (front = current.getList().getFirst(); front != null; front = front.next)
				System.out.println(front.element.toString());
		}
	}

	public void cleantinfo() {
		String s = new String("In proces");
		Stage myStage = new Stage();
		Label welcome = new Label("Please Enter your information Dear User");
		welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		Label name = new Label("Customer Name:");
		TextField nlbl = new TextField();
		Label mobile = new Label("Mobile Number:");
		TextField mlbl = new TextField();
		Label order = new Label("Order Date:");
		TextField olbl = new TextField();
		Button buy = new Button("buy a car ");
		buy.setOnAction(e -> {
			String selectBrand = tableView.getSelectionModel().getSelectedItem().getBrand();
			String selectModel = tableView.getSelectionModel().getSelectedItem().getModel();
			int selectYear = tableView.getSelectionModel().getSelectedItem().getYear();
			String selectcolor = tableView.getSelectionModel().getSelectedItem().getColor();
			double price = tableView.getSelectionModel().getSelectedItem().getPrice();
			queue.enqueue(new Orders(nlbl.getText(), Integer.parseInt(mlbl.getText()), selectBrand, selectModel,
					selectYear, selectcolor, price, olbl.getText(), s));
			note.buynote();

		});
		prev = new Button("preivous Page");
		GridPane grid = new GridPane();
		grid.addRow(0, welcome);
		grid.addColumn(2, nlbl, mlbl, olbl, buy);
		grid.addColumn(1, name, mobile, order, prev);
		prev.setOnAction(e -> {
			myStage.close();
		});
		grid.setHgap(15);
		grid.setVgap(30);
		grid.setAlignment(Pos.CENTER);
		Scene scene = new Scene(grid, 800, 800);
		myStage.setScene(scene);
		myStage.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static double convertToDouble1(String numberString) {
		double number = Double.parseDouble(numberString.substring(0, numberString.length() - 1));

		char magnitudeSuffix = numberString.charAt(numberString.length() - 1);

		if (magnitudeSuffix == 'K') {
			number *= 1000.0;
		}
		return number;
	}

	public void writeOrderFile(Stage primaryStage) { // this method to print all information from stack and queue in
														// file
		// Choose the file to write the new sorted data inside it
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save File");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
		File file = fileChooser.showSaveDialog(primaryStage);

		if (file != null) { // Check if a file was selected
			try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
				Orders writeOrder;

				// Write data from the stack
				while (stack != null && !stack.isEmpty()) {
					writeOrder = stack.pop();
					if (writeOrder != null) {
						writer.println(writeOrder.getCustomerName() + "," + writeOrder.getCustomerNumber() + ","
								+ writeOrder.getBrand() + "," + writeOrder.getModel() + "," + writeOrder.getYear() + ","
								+ writeOrder.getColor() + "," + writeOrder.getPrice() + ","
								+ writeOrder.getOrderStatut());
						temp.push(writeOrder);
					}
				}

				// Restore the original stack
				while (!temp.isEmpty()) {
					stack.push(temp.pop());
				}

				// Write data from the queue
				while (queue != null && !queue.isEmpty()) {
					writeOrder = queue.dequeue();
					if (writeOrder != null) {
						writer.println(writeOrder.getCustomerName() + "," + writeOrder.getCustomerNumber() + ","
								+ writeOrder.getBrand() + "," + writeOrder.getModel() + "," + writeOrder.getYear() + ","
								+ writeOrder.getColor() + " ," + writeOrder.getPrice() + ","
								+ writeOrder.getOrderStatut());
						Tempqueue.enqueue(writeOrder);
					}
				}

				// Restore the original queue
				while (!Tempqueue.isEmpty()) {
					queue.enqueue(Tempqueue.dequeue());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void writeCarFile(Stage primaryStage) { // this method to print all information from stack and queue in file
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save File");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
		File file = fileChooser.showSaveDialog(primaryStage);

		if (file != null) { // Check if a file was selected
			try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
				Node curr1;
				Nodes curr2;
				for (curr1 = list.getFirst(); curr1 != null; curr1 = curr1.next) {
					for (curr2 = curr1.getList().getFirst(); curr2 != null; curr2 = curr2.next) {
						writer.println(curr2.element.toString());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void addWithoutDuplicates(ArrayList<String> carray, String element) {
		for (int i = 0; i < carray.size(); i++) {
			if (!carray.contains(element)) {
				carray.add(element);
			}

		}
	}
}