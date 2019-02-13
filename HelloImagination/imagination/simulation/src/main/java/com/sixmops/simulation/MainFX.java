package com.sixmops.simulation;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.HBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.sixmops.component.App;
import com.sixmops.simulation.BitcoinRate;
import com.sixmops.simulation.EverythingDate;
import com.sixmops.simulation.EverythingTimer;

public class MainFX extends Application {
	App zap;
	StringProperty dollars;
	BitcoinRate bitcoinRate;
	EverythingDate everythingDate;
	EverythingTimer everythingTimer;
	public MainFX() {
		
		bitcoinRate = new BitcoinRate();
		everythingDate = new EverythingDate();
		everythingTimer = new EverythingTimer( everythingDate );
		zap = new App();
		bitcoinRate.setRate( zap.getUsd() );
		
		BitAppController control = new BitAppController( zap, bitcoinRate );
		

		bitcoinRate.getProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	        	System.out.println("changed value Hello World!   NEW:"+ newValue);
	        	
	        	//dollars = new SimpleStringProperty( zap.getUsd() );
	        	if (!newValue.matches("\\d*")) {
	            	System.out.println("new value Hello World!");
	            }
	
	            if (newValue.isEmpty())
	                System.out.println(" empty valueHello World!");
	            
	    	  
			}
	   });  
	}
	
	@Override
	public void start(Stage primaryStage) {

		//primaryStage.initStyle(StageStyle.TRANSPARENT);
		
		BorderPane border = new BorderPane();
		HBox hbox = addHBox();
		border.setTop(hbox);
		
		border.setLeft(addVBox());
		
		addStackPane(hbox);
		border.setRight(addFlowPane());
		//border.setCenter(addAnchorPane(addGridPane()));
		border.setCenter( addGridPane() );
		
		border.setBottom( addAnchorPane( new GridPane() ));

		primaryStage.setTitle("Hello JavaFX Application +12 with JDK 11");
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
				new App();
			}
		});

		Scene scene = new Scene(border);
		scene.setFill(Color.TRANSPARENT);
		primaryStage.setScene(scene);

		zap = new App();
		zap.getBitcoinTicker();
		bitcoinRate.setRate( zap.getUsd() );
		primaryStage.show();
		

	}

	private VBox addVBox() {

		VBox vbox = new VBox(50);
		vbox.setMaxWidth(Region.USE_PREF_SIZE);
		vbox.setMaxHeight(Region.USE_PREF_SIZE);
		vbox.setBackground(Background.EMPTY);
		String style = "-fx-background-color: rgba(255, 255, 255, 0.5);";
		vbox.setStyle(style);
		
		
		vbox.setPadding(new Insets(50)); // Set all sides to 10
		vbox.setSpacing(8); // Gap between nodes

		Text title = new Text("WHACTAMACCALIT");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox.getChildren().add(title);

//		Hyperlink options[] = new Hyperlink[] { new Hyperlink("Sales"), new Hyperlink("Marketing"),
//				new Hyperlink("Distribution"), new Hyperlink("Costs") };
//
//		for (int i = 0; i < 4; i++) {
//			// Add offset to left side to indent from title
//			VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
//			vbox.getChildren().add(options[i]);
//		}

		return vbox;
	}

	private HBox addHBox() {

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(35, 32, 25, 32));
		hbox.setSpacing(10); // Gap between nodes
		hbox.setStyle("-fx-background-color: #336699;");

//		Button buttonCurrent = new Button("Current");
//		buttonCurrent.setPrefSize(100, 20);
//
//		Button buttonProjected = new Button("Projected");
//		buttonProjected.setPrefSize(100, 20);
		
		Text dateText = new Text( everythingDate.getCurrentDateTime() );
		dateText.textProperty().bind( everythingDate.getProperty() );
		dateText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		

		//hbox.getChildren().addAll(buttonCurrent, buttonProjected, dateText);
		hbox.getChildren().addAll( dateText );

		return hbox;
	}

	private void addStackPane(HBox hb) {

		StackPane stack = new StackPane();
		
		
		Rectangle helpIcon = new Rectangle(30.0, 25.0);
		helpIcon.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
				new Stop[] { new Stop(0, Color.web("#4977A3")), new Stop(0.5, Color.web("#B0C6DA")),
						new Stop(1, Color.web("#9CB6CF")), }));
		helpIcon.setStroke(Color.web("#D0E6FA"));
		helpIcon.setArcHeight(3.5);
		helpIcon.setArcWidth(3.5);

		Text helpText = new Text("?");
		helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		helpText.setFill(Color.WHITE);
		helpText.setStroke(Color.web("#7080A0"));

		stack.getChildren().addAll(helpIcon, helpText);
		stack.setAlignment(Pos.CENTER_RIGHT);
		// Add offset to right for question mark to compensate for RIGHT
		// alignment of all nodes
		StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));

		hb.getChildren().add(stack);
		HBox.setHgrow(stack, Priority.ALWAYS);

	}

	private GridPane addGridPane() {

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(50, 10, 50, 10));

		// Category in column 2, row 1
		Text category = new Text("Currency Value:");
		category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		grid.add(category, 1, 0);

		// Title in column 3, row 1
		//Text chartTitle = new Text( zap.getUsd());
		Text chartTitle = new Text( bitcoinRate.getRate() );
		chartTitle.textProperty().bind( bitcoinRate.getProperty() );
		chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		grid.add(chartTitle, 2, 0);

		// Subtitle in columns 2-3, row 2
//		Text chartSubtitle = new Text("Goods and Services");
//		grid.add(chartSubtitle, 1, 1, 2, 1);

		// House icon in column 1, rows 1-2
		//ImageView imageHouse = new ImageView(new Image(LayoutSample.class.getResourceAsStream("graphics/house.png")));
		//grid.add(imageHouse, 0, 0, 1, 2);

		// Left label in column 1 (bottom), row 3
//		Text goodsPercent = new Text("Goods\n80%");
//		GridPane.setValignment(goodsPercent, VPos.BOTTOM);
//		grid.add(goodsPercent, 0, 2);

		// Chart in columns 2-3, row 3
//		ImageView imageChart = new ImageView(
//				new Image(LayoutSample.class.getResourceAsStream("graphics/piechart.png")));
//		grid.add(imageChart, 1, 2, 2, 1);

		// Right label in column 4 (top), row 3
//		Text servicesPercent = new Text("Services\n20%");
//		GridPane.setValignment(servicesPercent, VPos.TOP);
//		grid.add(servicesPercent, 3, 2);

//	        grid.setGridLinesVisible(true);
		return grid;
	}

	private FlowPane addFlowPane() {

		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(35, 0, 35, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(170); // preferred width allows for two columns
		flow.setStyle("-fx-background-color: #81F781;");
//
//		ImageView pages[] = new ImageView[8];
//		for (int i = 0; i < 8; i++) {
//			pages[i] = new ImageView(
//					new Image(MainFX.class.getResourceAsStream("graphics/chart_" + (i + 1) + ".png")));
//			flow.getChildren().add(pages[i]);
//		}

		return flow;
	}

	private AnchorPane addAnchorPane(GridPane grid) {

		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setStyle("-fx-background-color: #81F781;");
		
		Button buttonSave = new Button("Save");
		buttonSave.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
				App zng = new App();
				System.out.println("Hello THE DOLLARS are :"+ zng.getUsd() );
			}
		});
		Button buttonCancel = new Button("Cancel");
		buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("exit out");
				System.exit(1);
			}
		});

		HBox hb = new HBox();
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setSpacing(10);
		
		hb.getChildren().addAll(buttonSave, buttonCancel);

		anchorpane.getChildren().addAll(grid, hb);
		// Anchor buttons to bottom right, anchor grid to top
		anchorpane.setBottomAnchor(hb, 20.0);
		anchorpane.setRightAnchor(hb, 50.0);
		anchorpane.setLeftAnchor(hb, 300.0);
		
		AnchorPane.setTopAnchor(grid, 10.0);

		return anchorpane;
	}

	public static void main(String[] args) {
		System.out.println("App invoking main");
		Application.launch(args);

	}
}
