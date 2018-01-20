package atkins.food.carbs.calculator;

import java.util.List;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;

/**
 *
 * @author Mark
 */
public class AtkinsFoodCarbsCalculator extends Application {
    //create the vbox for glabal manipulation
    VBox vbox = new VBox();
	//create the array list for all food carb totals to be added to
    List<Double> foodArray = new ArrayList();
    // Create the first ChoiceBox for food element
    ChoiceBox<String> symptoms = new ChoiceBox<>();
    //Set up the serving size
	double servingSize = 0.0;
	//set up the filed for the net carbs per 1 serving
    double servingNC = 0.0;
	//set up the buttons
    Button btn = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    //set up the total and sub total text boxes
	Text Total = new Text(); 
    Text subTotal = new Text();
    TextArea record = new TextArea();
    
    HBox hbox = new HBox();
    
    @Override
    public void start(Stage primaryStage) {  
        record.setEditable(false);
        record.setWrapText(true);
        //set up the buttons with their event handlers
        btn4.setText("Sub Total");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            //shows the sub total
            @Override
            public void handle(ActionEvent event) {
                double sc1 = servingNC*servingSize;
                subTotal.setText("Food Total: " + String.valueOf(sc1));
            }
        });
        btn.setText("Save Carbs");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            //stores the sub total in the array
            @Override
            public void handle(ActionEvent event) {
                double sc = servingNC*servingSize;
                String doublesc = Double.toString(sc);
                record.appendText(symptoms.getValue() + ": " + doublesc + ",");
                storeInt(sc);
                subTotal.setText(" ");
            }
        });
        btn2.setText("Total Carbs");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            //shows the total of the main array
            @Override
            public void handle(ActionEvent event) {
                Total.setText(String.valueOf(listTotal()));
            }
        });
        
        btn3.setText("Reset");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            //clears the array to start another meal
            @Override
            public void handle(ActionEvent event) {
                intStore().clear();
                record.clear();
                Total.setText(" ");
            }
        });
        //create the scene
        Scene scene = new Scene(hbox, 600, 300);
		//position the vbox
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        //define the stage
        primaryStage.setTitle("Net Carb Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //create the text box and the label for the food element of the program
        Text selectionLbl = new Text("Your selection: None");
        // Create the Label for the food element
        Label symptomLbl = new Label("Food");
        
        
        // Add the items to the ChoiceBox
        symptoms.getItems().addAll("None", "Sour Cream", "Parsley", "Chives", "Ginger", "Rosemary", "Sage", "Black Pepper", "Garlic", "Caesar", "Ranch", "Lemon Juice", "Bleu Cheese", "Lime Juice", "Balsamic Vinegar", "Italian Creamy", "Tomato", "Portobello Mushroom", "Yellow Squash", "Cabbage", "Green Beans", "Red Pepper", "Leeks", "Shallots", "Sprouts", "Spaghetti Squash", "Cherry Tomato", "Kohlrabi", "Pumpkin", "Garlic Minced", "Snow Peas", "Tomato Cooked", "Hard Boiled Egg", "Mushrooms", "Parmesan", "Blue Cheese", "Cheddar", "Mozzarella", "Cream Cheese", "Watercress", "Radishes", "Spinach", "Lettuce", "Button Mushrooms", "Celery", "Avocado", "Onion", "Courgette", "Cucumber", "Cauliflower", "Broccoli", "Rhubarb", "Asparagus", "Green Pepper", "Aubergine", "Kale", "Spring Onion", "Turnip", "Sweetner");
        // Select the first item from the list
        symptoms.getSelectionModel().selectFirst();

        // Add a ChangeListener to the ChoiceBox
        symptoms.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov, final String oldValue, String newValue)
            {//creat the switch that the choice box is based on.
                switch(symptoms.getValue()) {
    case "Sour Cream":
      newValue = "Sour Cream 2tbsp";
      servingNC = 1.2;
      break;
      
    case "Parsley":
      newValue = "Parsley 1tbsp";
      servingNC = 0.1;
      break;
      
    case "Chives":
      newValue = "Chives 1tbsp";
      servingNC = 0.1;
      break;
      
    case "Ginger":
      newValue = "Ginger (fresh) 1tbsp";
      servingNC = 0.8;
      break;
      
    case "Rosemary":
      newValue = "Rosemary (dried) 1tbsp";
      servingNC = 0.8;
      break;

    case "Sage":
      newValue = "Sage 1tsp";
      servingNC = 0.8;
      break;
      
    case "Black Pepper":
      newValue = "Black Pepper 1tsp";
      servingNC = 0.9;
      break;
      
    case "Garlic":
      newValue = "Garlic 1 Clove";
      servingNC = 0.9;
      break;

    case "Caesar":
      newValue = "Caesar 2tbsp";
      servingNC = 1.0;
      break;
      
    case "Ranch":
      newValue = "Ranch 2tbsp";
      servingNC = 1.4;
      break;
      
    case "Lemon Juice":
      newValue = "Lemon Juice 2tbsp";
      servingNC = 2.0;
      break;

    case "Bleu Cheese":
      newValue = "Bleu Cheese 2tbsp";
      servingNC = 2.3;
      break;
      
    case "Lime Juice":
      newValue = "Lime Juice 2tbsp";
      servingNC = 2.4;
      break;
      
    case "Balsamic Vinegar":
      newValue = "Balsamic Vinegar 1tbsp";
      servingNC = 2.7;
      break;

    case "Italian Creamy":
      newValue = "Italian, Creamy 2tbsp";
      servingNC = 3.0;
      break;
      
    case "Tomato":
      newValue = "Tomato, Small (Raw) 1 Each";
      servingNC = 2.5;
      break;
      
    case "Portobello Mushroom":
      newValue = "Portobello Mushroom 1 Each";
      servingNC = 2.6;
      break;

    case "Yellow Squash":
      newValue = "Yellow Squash Half Cup";
      servingNC = 2.6;
      break;
      
    case "Cabbage":
      newValue = "Cabbage Half Cup";
      servingNC = 2.7;
      break;
      
    case "Green Beans":
      newValue = "Green Beans Half Cup";
      servingNC = 2.9;
      break;
    
    case "Red Pepper":
      newValue = "Red Pepper Half Cup";
      servingNC = 3.0;
      break;
    
      case "Leeks":
      newValue = "Leeks 2 tbsp";
      servingNC = 3.4;
      break;
      
      case "Shallots":
      newValue = "Shallots 2 Tbsp";
      servingNC = 3.4;
      break;
      
      case "Sprouts":
      newValue = "Sprouts (Cooked) Half Cup";
      servingNC = 3.5;
      break;
      
      case "Spaghetti Squash":
      newValue = "Spaghetti Squash Half Cup";
      servingNC = 4.0;
      break;
      
      case "Cherry Tomato":
      newValue = "Cheery Tomato 10 Each";
      servingNC = 4.6;
      break;
      
      case "Kohlrabi":
      newValue = "Kohlrabi Half Cup";
      servingNC = 4.6;
      break;
      
      case "Pumpkin":
      newValue = "Pumpkin Half Cup";
      servingNC = 4.7;
      break;
      
      case "Garlic Minced":
      newValue = "Garlic Minced 2 tbsp";
      servingNC = 5.3;
      break;
      
      case "Snow Peas":
      newValue = "Snow Peas Half Cup";
      servingNC = 5.4;
      break;
      
      case "Tomato Cooked":
      newValue = "Tomato Cooked Half Cup";
      servingNC = 8.6;
      break;
      
      case "Hard Boiled Egg":
      newValue = "Hard Boiled Egg 1 Egg";
      servingNC = 0.5;
      break;
      
      case "Mushrooms":
      newValue = "Mushrooms Half Cup";
      servingNC = 1.0;
      break;
      
      case "Parmesan":
      newValue = "Parmesan 1 tbsp";
      servingNC = 0.2;
      break;
      
      case "Blue Cheese":
      newValue = "Blue Cheese 2 tbsp";
      servingNC = 0.4;
      break;
      
      case "Cheddar":
      newValue = "Cheddar 1oz";
      servingNC = 0.4;
      break;
      
      case "Mozzarella":
      newValue = "Mozzarella 1oz";
      servingNC = 0.6;
      break;
      
      case "Cream Cheese":
      newValue = "Cream Cheese 2 tbsp";
      servingNC = 0.8;
      break;
      
      case "Watercress":
      newValue = "Watercress Half Cup";
      servingNC = 0.1;
      break;
      
      case "Radishes":
      newValue = "Radishes 1 each";
      servingNC = 0.1;
      break;
      
      case "Spinach":
      newValue = "Spinach Half Cup";
      servingNC = 0.2;
      break;
      
      case "Lettuce":
      newValue = "Lettuce Half Cup";
      servingNC = 0.5;
      break;
      
      case "Button Mushrooms":
      newValue = "Button Mushrooms Half Cup";
      servingNC = 0.8;
      break;
      
      case "Celery":
      newValue = "Celery 1 Stalk";
      servingNC = 1.0;
      break;
      
      case "Avocado":
      newValue = "Avocado Half";
      servingNC = 1.3;
      break;
      
      case "Onion":
      newValue = "Onion 2 tbsp";
      servingNC = 1.5;
      break;
      
      case "Courgette":
      newValue = "Courgette Half Cup";
      servingNC = 1.5;
      break;
      
      case "Cucumber":
      newValue = "Cucumber Half Cup";
      servingNC = 1.5;
      break;
      
      case "Cauliflower":
      newValue = "Cauliflower(Cooked) Half Cup";
      servingNC = 1.7;
      break;
      
      case "Broccoli":
      newValue = "Broccoli Half Cup";
      servingNC = 1.8;
      break;
      
      case "Rhubarb":
      newValue = "Rhubarb Half Cup";
      servingNC = 1.8;
      break;
      
      case "Asparagus":
      newValue = "Asparagus 6 Stalks";
      servingNC = 1.9;
      break;
      
      case "Green Pepper":
      newValue = "Green Pepper Half Cup";
      servingNC = 2.2;
      break;
      
      case "Aubergine":
      newValue = "Aubergine Half Cup";
      servingNC = 2.3;
      break;
      
      case "Kale":
      newValue = "Kale (Cooked) Half Cup";
      servingNC = 2.4;
      break;
      
      case "Spring Onion":
      newValue = "Spring Onion Half Cup";
      servingNC = 2.4;
      break;
      
      case "Turnip":
      newValue = "Red Pepper Half Cup";
      servingNC = 2.4;
      break;
      
      case "Sweetner":
      newValue = "Sweetner 1 Packet";
      servingNC = 1.0;
      break;
      
    default:
      newValue = "None";
  }
                //assign the value of the choosen case to the lbl.
                selectionLbl.setText("Your selection: " + newValue);
                selectionLbl.wrappingWidthProperty().bind(vbox.widthProperty());
            }
        });
        
        //create the text box and the label for the portion element
        Text selectionLbl2 = new Text("Your selection: None");
        // Create the Label for the amount
        Label symptomLbl2 = new Label("Amount:");
        
        // Create a ChoiceBox for portion amount
        ChoiceBox<String> symptom = new ChoiceBox<>();
        // Add the items to the ChoiceBox
        symptom.getItems().addAll("0.25", "0.3", "0.5", "0.6", "0.75", "1", "1.25", "1.3", "1.5", "1.6", "1.75", "2", "2.25", "2.3", "2.5", "2.6", "2.75", "3", "3.25", "3.3", "3.5", "3.6", "3.75", "4", "4.25", "4.3", "4.5", "4.6", "4.75", "5", "5.25", "5.3", "5.5", "5.6", "5.75", "6");
        // Select the first case from the list and switch
        symptom.getSelectionModel().selectFirst();

        // Add a ChangeListener to the ChoiceBox
        symptom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov, final String oldValue, String newValue)
            {//creat the switch that the choice box is based on.
                switch(symptom.getValue()) {
    case "0.25":
      newValue = "0.25";
      servingSize = 0.25;
      break;
      
    case "0.3":
      newValue = "0.3";
      servingSize = 0.3;
      break;
      
    case "0.5":
      newValue = "0.5";
      servingSize = 0.5;
      break;
      
    case "0.6":
      newValue = "0.6";
      servingSize = 0.6;
      break;
      
    case "0.75":
      newValue = "0.75";
      servingSize = 0.75;
      break;

    case "1":
      newValue = "1";
      servingSize = 1;
      break;
      
    case "1.25":
      newValue = "1.25";
      servingSize = 1.25;
      break;
      
    case "1.3":
      newValue = "1.3";
      servingSize = 1.3;
      break;

    case "1.5":
      newValue = "1.5";
      servingSize = 1.5;
      break;
      
    case "1.6":
      newValue = "1.6";
      servingSize = 1.6;
      break;
      
    case "1.75":
      newValue = "1.75";
      servingSize = 1.75;
      break;

    case "2":
      newValue = "2";
      servingSize = 2;
      break;
      
    case "2.25":
      newValue = "2.25";
      servingSize = 2.25;
      break;
      
    case "2.3":
      newValue = "2.3";
      servingSize = 2.3;
      break;

    case "2.5":
      newValue = "2.5";
      servingSize = 2.5;
      break;
      
    case "2.6":
      newValue = "2.6";
      servingSize = 2.6;
      break;
      
    case "2.75":
      newValue = "2.75";
      servingSize = 2.75;
      break;

    case "3":
      newValue = "3";
      servingSize = 3;
      break;
      
    case "3.25":
      newValue = "3.25";
      servingSize = 3.25;
      break;
      
    case "3.3":
      newValue = "3.3";
      servingSize = 3.3;
      break;
    
    case "3.5":
      newValue = "3.5";
      servingSize = 3.5;
      break;
    
      case "3.6":
      newValue = "3.6";
      servingSize = 3.6;
      break;
      
      case "3.75":
      newValue = "3.75";
      servingSize = 3.75;
      break;
      
      case "4":
      newValue = "4";
      servingSize = 4;
      break;
      
      case "4.25":
      newValue = "4.25";
      servingSize = 4.25;
      break;
      
      case "4.3":
      newValue = "4.3";
      servingSize = 4.3;
      break;
      
      case "4.5":
      newValue = "4.5";
      servingSize = 4.5;
      break;
      
      case "4.6":
      newValue = "4.6";
      servingSize = 4.6;
      break;
      
      case "4.75":
      newValue = "4.75";
      servingSize = 4.75;
      break;
      
      case "5":
      newValue = "5";
      servingSize = 5;
      break;
      
      case "5.25":
      newValue = "5.25";
      servingSize = 5.25;
      break;
      
      case "5.3":
      newValue = "5.3";
      servingSize = 5.3;
      break;
      
      case "5.5":
      newValue = "5.5";
      servingSize = 5.5;
      break;
      
      case "5.6":
      newValue = "5.6";
      servingSize = 5.6;
      break;
      
      case "5.75":
      newValue = "5.75";
      servingSize = 5.75;
      break;
      
      case "6":
      newValue = "6";
      servingSize = 6;
      break;
      
    default:
      newValue = "None";
  }
                //assign the value of the choosen case to the lbl.
                selectionLbl2.setText("Your selection: " + newValue);
                selectionLbl2.wrappingWidthProperty().bind(vbox.widthProperty());
            }
        });
        //add all of the children to the vbox in the required order
        vbox.getChildren().addAll(symptoms, symptomLbl, selectionLbl, symptom, symptomLbl2, selectionLbl2, btn4, subTotal, btn, btn2, Total, btn3);
        hbox.getChildren().addAll(vbox, record);
    }
    //empty constructor for any future upgrades
    public void AtkinsFoodCarbsCalculator() {
    
    
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
	//Adds the current carbs to the storage array
    public void storeInt(Double i){
        foodArray.add(i);
    }
	//Returns the array using a method for cleaner manipulation and future expansion
    public List<Double> intStore() {
        return foodArray;
    }
	//Totals up the array
    public double listTotal() {
      //Gets the size of the array
	  int t = intStore().size();
      //Starts the counter for the while loop at 0
	  int o = 0;
      //sets up the total field
	  double total = 0;
      //while loop to go through and add up the array
      while (o!=t) {
        total += intStore().get(o);
        o++;
      }
	  //Returns the double total of carbs
      return total;
    }
    
}
