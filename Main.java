package application;
	
import javafx.application.Application;
import javafx.scene.control.Slider;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.lang.Math;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;




public class Main extends Application {

	public void isAfterEq(TextField textField) {
		if(afterEq) {
			textField.setText("");
			afterEq = false;
			
		}
	}
	public boolean isAllDigits(String text) {
		int i = 0;
		while(i < text.length()) {
			if(!Character.isDigit(text.charAt(i))) {
				if(text.charAt(i) != '.') 
					return false;
			}
			i++;
		}
		return true;
	}
	public boolean hasDecimal(String text) {
		int i = 0;
		if(hasOperand) {
			String first = text.substring(0,text.indexOf(operand));
			String last = text.substring(text.indexOf(operand)+1, text.length());
			
			if(first.contains(".")) {
				firstDecimal = true;
			}
			if(last.contains(".")) {
				lastDecimal = true;
			}
		}
		else {
			while(i < text.length()) {
				if(text.charAt(i) == '.') {
					firstDecimal = true;
				}
				i++;
			}
		}
		
		
		return true;
		
	}
	private boolean hasOperand;
	private boolean afterEq = false;
	private boolean firstDecimal = false;
	private boolean lastDecimal = false;
	private char operand;
	
	@Override
	public void start(Stage primaryStage) {
		//AnchorPane root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
		AnchorPane root = new AnchorPane();
		
		//Create all buttons 0 -9
		Button button0 = new Button();
		button0.setText("0");
		button0.setTranslateX(100);
		button0.setTranslateY(275);

		Button button1 = new Button();
		button1.setText("1");
		button1.setTranslateX(25);
		button1.setTranslateY(200);

		Button button2 = new Button();
		button2.setText("2");
		button2.setTranslateX(100);
		button2.setTranslateY(200);

		Button button3 = new Button();
		button3.setText("3");
		button3.setTranslateX(175);
		button3.setTranslateY(200);

		Button button4 = new Button();
		button4.setText("4");
		button4.setTranslateX(25);
		button4.setTranslateY(125);

		Button button5 = new Button();
		button5.setText("5");
		button5.setTranslateX(100);
		button5.setTranslateY(125);

		Button button6 = new Button();
		button6.setText("6");
		button6.setTranslateX(175);
		button6.setTranslateY(125);

		Button button7 = new Button();
		button7.setText("7");
		button7.setTranslateX(25);
		button7.setTranslateY(50);

		Button button8 = new Button();
		button8.setText("8");
		button8.setTranslateX(100);
		button8.setTranslateY(50);

		Button button9 = new Button();
		button9.setText("9");
		button9.setTranslateX(175);
		button9.setTranslateY(50);

		Slider slider = new Slider(0, 10, 1);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(1f);
		slider.setTranslateX(50);
		slider.setTranslateY(350);

		Button buttonA = new Button();
		buttonA.setText("+");
		buttonA.setTranslateX(250);
		buttonA.setTranslateY(275);

		Button buttonE = new Button();
		buttonE.setText("=");
		buttonE.setTranslateX(175);
		buttonE.setTranslateY(275);

		Button buttonD = new Button();
		buttonD.setText("/");
		buttonD.setTranslateX(250);
		buttonD.setTranslateY(50);

		Button buttonM = new Button();
		buttonM.setText("*");
		buttonM.setTranslateX(250);
		buttonM.setTranslateY(125);

		Button buttonS = new Button();
		buttonS.setText("-");
		buttonS.setTranslateX(250);
		buttonS.setTranslateY(200);

		Button CE = new Button();
		CE.setText("CE");
		CE.setTranslateX(325);
		CE.setTranslateY(50);

		Button C = new Button();
		C.setText("C");
		C.setTranslateX(400);
		C.setTranslateY(50);

		Button negation = new Button();
		negation.setText("negate");
		negation.setTranslateX(325);
		negation.setTranslateY(200);

		Button power = new Button();
		power.setText("^");
		power.setTranslateX(325);
		power.setTranslateY(275);

		Button sqrt = new Button();
		sqrt.setText("sqrt");
		sqrt.setTranslateX(325);
		sqrt.setTranslateY(125);

		Button square = new Button();
		square.setText("^2");
		square.setTranslateX(400);
		square.setTranslateY(125);

		Button decimal = new Button();
		decimal.setText(".");
		decimal.setTranslateX(25);
		decimal.setTranslateY(275);

		//Text field for display and answer
		//Text field also allows for a user to click the text box then type in their query
		
		TextField textField = new TextField();
		textField.setMinHeight(45);
		textField.setMinWidth(475);
		
		Thread t = new Thread( new Runnable() {
			@Override
    		public void run() {
    			try { 
    				String currentText = textField.getText();
    				textField.setText("Syntax Error");
    				Thread.sleep(1000);
    				textField.setText(currentText);
    				
    			} catch ( InterruptedException ie ) {
    				System.err.println( "Sleeping Interrupted.");
    			}
    		}
		});


		root.getChildren().add(textField);
		root.getChildren().add(button0);
		root.getChildren().add(button1);
		root.getChildren().add(button2);
		root.getChildren().add(button3);
		root.getChildren().add(button4);
		root.getChildren().add(button5);
		root.getChildren().add(button6);
		root.getChildren().add(button7);
		root.getChildren().add(button8);
		root.getChildren().add(button9);
		root.getChildren().add(buttonA);
		root.getChildren().add(buttonE);
		root.getChildren().add(buttonM);
		root.getChildren().add(buttonD);
		root.getChildren().add(buttonS);
		root.getChildren().add(C);
		root.getChildren().add(CE);
		root.getChildren().add(negation);
		root.getChildren().add(power);
		root.getChildren().add(sqrt);
		root.getChildren().add(square);
		root.getChildren().add(slider);
		root.getChildren().add(decimal);



		Scene scene = new Scene(root,600,600);

		//add functionality
		button0.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "0");
			}

		});
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "1");
			}

		});
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "2");
			}

		});
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "3");
			}

		});
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "4");
			}

		});
		button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "5");
			}

		});
		button6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "6");
			}

		});
		button7.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "7");
			}

		});
		button8.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "8");
			}

		});
		button9.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);	
				textField.setText(textField.getText() + "9");
			}

		});
		buttonA.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);
				if(textField.getLength() != 0 && !hasOperand) {
					textField.setText(textField.getText() + "+");
					operand = '+';
					hasOperand = true;
				}
			}

		});
		decimal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);
				hasDecimal(textField.getText());
				if(hasOperand && !lastDecimal && textField.getLength() != 0) {
					textField.setText(textField.getText() + ".");
					lastDecimal = true;
				}
				if(!hasOperand && !firstDecimal && textField.getLength() != 0) {
					textField.setText(textField.getText() + ".");
					firstDecimal = true;
				}

			}
		});
		buttonD.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);
				if(textField.getLength() != 0 && !hasOperand) {
					textField.setText(textField.getText() + "/");
					operand = '/';
					hasOperand = true;
				}
			}

		});
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override 
			public void changed(ObservableValue<? extends Number> observableValue,
					Number oldValue, Number newValue) {  
				isAfterEq(textField);
				if(!hasOperand) {
					textField.setText(Float.toString(newValue.floatValue()));
				}
				if(hasOperand) {
					textField.setText( (textField.getText().substring(0,(textField.getText().indexOf(operand)+1) ) )  + Float.toString(newValue.floatValue()));
				}

			}
		});

		buttonM.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);
				if(textField.getLength() != 0 && !hasOperand) {
					textField.setText(textField.getText() + "*");
					operand = '*';
					hasOperand = true;
				}
			}

		});
		buttonS.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);
				if(textField.getLength() != 0 && !hasOperand) {
					textField.setText(textField.getText() + "-");
					operand = '-';
					hasOperand = true;
				}
			}

		});
		power.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				isAfterEq(textField);
				if(textField.getLength() != 0 && !hasOperand) {
					textField.setText(textField.getText() + "^");
					operand = '^';
					hasOperand = true;
				}

			}
		});
		negation.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(!hasOperand && isAllDigits(textField.getText())) {
					float total = Float.parseFloat(textField.getText());
					textField.setText(String.valueOf(-1*total));
					afterEq = true;


				}

			}
		});
		sqrt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(!hasOperand && isAllDigits(textField.getText())) {
					float total = Float.parseFloat(textField.getText());
					textField.setText(String.valueOf(Math.sqrt(total)));
					afterEq = true;

				}
			}
		});
		square.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(!hasOperand && isAllDigits(textField.getText())) {
					float total = Float.parseFloat(textField.getText());
					textField.setText(String.valueOf(total*total));
					afterEq = true;

				}
			}
		});
		C.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				hasOperand = false;
				firstDecimal = false;
				lastDecimal = false;
				operand = ' ';
				textField.setText("");
			}
		});
		CE.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String currentText = textField.getText();
				//has operand and has more digits after
				if(hasOperand && currentText.lastIndexOf(operand)+1 == currentText.length()) {
					hasOperand = false;
					textField.setText(currentText.substring(0,currentText.length()-1));
				}
				else if(hasOperand && currentText.lastIndexOf(operand)+1 != currentText.length()) {
					int i = currentText.length()-1;
					while(currentText.charAt(i) != operand) {
						i--;
					}
					textField.setText(currentText.substring(0, i+1));
					lastDecimal = false;
				}


				else{
					textField.setText("");
					firstDecimal = false;
				}
			}
		});

		buttonE.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String currentText = textField.getText();
				String first = null;
				String last = null;
				float total = 0;
				int i = 0;
				while(i < currentText.length()) {
					if(!Character.isDigit(currentText.charAt(i))) {
						if(currentText.charAt(i) == '.') {
							//do nothing
						}
						else if(currentText.charAt(i) == '+') {
							first = currentText.substring(0,i);
							last = currentText.substring(i+1,currentText.length());
							if(isAllDigits(last)) {
								total = Float.parseFloat(first)+Float.parseFloat(last);
								break;
							}
							else {
								textField.setText("E");
								break;
							}


						}
						else if(currentText.charAt(i) == '/') {
							first = currentText.substring(0,i);
							last = currentText.substring(i+1,currentText.length());
							if(isAllDigits(last)) {
								total = Float.parseFloat(first)/Float.parseFloat(last);
								break;
							}
							else {
								textField.setText("E");
								break;
							}
						}
						else if(currentText.charAt(i) == '-') {
							first = currentText.substring(0,i);
							last = currentText.substring(i+1,currentText.length());
							if(isAllDigits(last)) {
								total = Float.parseFloat(first)-Float.parseFloat(last);
								break;
							}
							else {
								textField.setText("E");
								break;
							}
						}
						else if(currentText.charAt(i) == '*') {
							first = currentText.substring(0,i);
							last = currentText.substring(i+1,currentText.length());
							if(isAllDigits(last)) {
								total = Float.parseFloat(first)*Float.parseFloat(last);
								break;
							}
							else {
								textField.setText("E");
								break;
							}

						}
						else if(currentText.charAt(i) == '^') {
							first = currentText.substring(0,i);
							last = currentText.substring(i+1,currentText.length());
							if(isAllDigits(last)) {
								total = (float) Math.pow(Float.parseFloat(first), (Float.parseFloat(last)));
								break;
							}
							else {
								textField.setText("E");
								break;
							}

						}
						else {
							textField.setText("E");
							break;
						}


					}
					i++;
				}
				if(textField.getText() == "E") {
					t.start();
				}
				else {
					textField.setText(Float.toString(total));
				}
				
				hasOperand = false;
				firstDecimal = false;
				lastDecimal = false;
				first = null;
				last = null;
				i = 0;
				afterEq = true;
				

			}
		});


		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
