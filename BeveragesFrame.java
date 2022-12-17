import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.util.*;

public class BeveragesFrame extends JFrame{

  //components to be added in the BeverageFrame class

  JLabel background;
  JLabel headerLabel;
  JLabel items;
  JLabel Quantity;
  JLabel total_price;
  JTextField txtInput;
  JLabel item_selected_name;
  JLabel item_selected_price;
    JButton Order;
    JButton goBackButton;
    JButton Exit;
    JButton Add_to_Plate;
    JScrollBar S;
    public static ArrayList <String> BItems = new ArrayList <String> ();
    public static ArrayList <Integer> BPrice = new ArrayList <Integer> ();
    public static ArrayList <Integer> BNet = new ArrayList <Integer> ();
    public static ArrayList <Integer> BQty = new ArrayList <Integer> ();

    //constructor 

     BeveragesFrame(){
        this.setTitle("Beverages Bar");
       this.setVisible(true); //make frame visible
       this.setSize(562,1000);// Dimensions of the frame
       this.setResizable(false);//Doesnt allow the screen to maximize
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       this.background = new JLabel(new ImageIcon("beveragesbg.jpg"));// Component which helps to access the background image
       this.init();   //this function is used for adding the components that must `be visible on the screen

       add(background);// to add the image in the frame background
       background.setVisible(true);  // to make the image visible in the frame background
       this.pack();// Causes the Frame window to be sized to fit the preferred size and layouts of its subcomponents. 
       this.setSize(562,1000);// Resizes the frame so that it has width width and height height
       this.setLocationRelativeTo(null);//Sets the location of the window relative to the specified component. Here its null since they are absolute positioned
     }

     public void init(){

      //Initializing the components that must show up on the screen

      //Heading
      headerLabel = new JLabel("Beverages");
      this.headerLabel.setBounds(150,70,280,100);
      this.headerLabel.setFont(new Font("Cooper Black", Font.BOLD, 50));
      headerLabel.setForeground(Color.black);
      add(headerLabel);

      //Scroll Bar
      S=new JScrollBar();  
      S.setBounds(532,0, 20,1000);   
      this.S.setVisible(true); 
      add(S);

      //Sub- heading
      items = new JLabel("Items                              Price");
      this.items.setBounds(90,120,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD,20));
      items.setForeground(Color.black);
      add(items);

      //Coffee
      items = new JLabel("1. Coffee                                  7");
      this.items.setBounds(70,180,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD,20));
      items.setForeground(Color.black);
      add(items);

      //Coffee's Order Button
      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,245,100,20);
      add(Order);
      Order.addActionListener(this::CoffeeActionPerformed);// The action to be performed when the coffee order button is pressed.

      //Milkshakes
      items = new JLabel("2. Milkshakes                     10");
      this.items.setBounds(70,220,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      //Milkshakes Order Button
      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,285,100,20);
      add(Order);
      Order.addActionListener(this::MilkshakesActionPerformed);// The action to be performed when the milkshake order button is pressed.


      //Mojito 
      items = new JLabel("3. Mojito                                  5");
      this.items.setBounds(70,260,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      //Mojito's order button
      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,325,100,20);
      add(Order);
      Order.addActionListener(this::MojitoActionPerformed);// The action to be performed when the Mojito order button is pressed.

      //Tea
      items = new JLabel("4. Tea                                        8");
      this.items.setBounds(70,300,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      //Tea's order button
      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,365,100,20);
      add(Order);
      Order.addActionListener(this::TeaActionPerformed);// The action to be performed when the Tea order button is pressed.

      //Fresh Fruit Juice
      items = new JLabel("5. Fresh Fruit Juice       10");
      this.items.setBounds(70,340,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      //Fresh Fruit juice's order button
      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,405,100,20);
      add(Order);
      Order.addActionListener(this::FreshFruitJuiceActionPerformed);// The action to be performed when the Fresh fruit juice order button is pressed.


      //The selected item's descriptions.
    
      this.item_selected_name = new JLabel("Item name:");
      this.item_selected_name.setBounds(100,400,1000,150);
      this.item_selected_name.setFont(new Font("Geomanist", Font.BOLD,20));
      items.setForeground(Color.black);
      add(item_selected_name);
      
      item_selected_price = new JLabel("Item cost:");
      this.item_selected_price.setBounds(100,440,500,150);
      this.item_selected_price.setFont(new Font("Geomanist", Font.BOLD,20));
      item_selected_price.setForeground(Color.black);
      add(item_selected_price);

      Quantity = new JLabel("Quantity:");
      this.Quantity.setBounds(100,480,500,150);
      this.Quantity.setFont(new Font("Geomanist", Font.BOLD,20));
      Quantity.setForeground(Color.black);
      add(Quantity);

      //Place for user to input the Quantity demanded
      txtInput= new JTextField();
      txtInput.setBounds(200,545,75,25);
      add(txtInput);

      total_price = new JLabel("Total price:");
      this.total_price.setBounds(100,520,500,150);
      this.total_price.setFont(new Font("Geomanist", Font.BOLD,20));
      total_price.setForeground(Color.black);
      add(total_price);


//Button to add the selected dish for billing

      this.Add_to_Plate=new JButton("Add to plate");
      this.Add_to_Plate.setFont(new Font("Cooper Black", Font.PLAIN, 20));
      this.Add_to_Plate.setBounds(180,630,180,35);
      this.Add_to_Plate.setVisible(false);
      add(Add_to_Plate);
      Add_to_Plate.addActionListener(this::addItems);

      //Button to return back to the main Frame
    
      this.goBackButton=new JButton("Go Back to the main menu");
      this.goBackButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
      this.goBackButton.setBounds(80,700,380,35);
      add(goBackButton);
      goBackButton.addActionListener(this::goBack);
    }
   
    public void CoffeeActionPerformed(java.awt.event.ActionEvent evt) //Functions performed when their respective buttons are pressed and Action event is generated.
{
      item_selected_name.setText("Item name: Coffee");
      item_selected_price.setText("Item cost: 7 AED");
      this.Add_to_Plate.setVisible(true);

    }

    public void MilkshakesActionPerformed(java.awt.event.ActionEvent evt) //Functions performed when their respective buttons are pressed and Action event is generated.
    {
      item_selected_name.setText("Item name: Milkshakes");
      item_selected_price.setText("Item cost: 10 AED");
      this.Add_to_Plate.setVisible(true);
    }

    public void MojitoActionPerformed(java.awt.event.ActionEvent evt) //Functions performed when their respective buttons are pressed and Action event is generated.
    {
      item_selected_name.setText("Item name: Mojito");
      item_selected_price.setText("Item cost: 5 AED");
      this.Add_to_Plate.setVisible(true);
      
    }
    
    public void TeaActionPerformed(java.awt.event.ActionEvent evt) //Functions performed when their respective buttons are pressed and Action event is generated.
    {
      item_selected_name.setText("Item name: Tea");
      item_selected_price.setText("Item cost: 8 AED");
      this.Add_to_Plate.setVisible(true);
      
    }
    
    public void FreshFruitJuiceActionPerformed(java.awt.event.ActionEvent evt) //Functions performed when their respective buttons are pressed and Action event is generated.
    {
      item_selected_name.setText("Item name: Fresh Fruit Juice");
      item_selected_price.setText("Item cost: 10 AED");
      this.Add_to_Plate.setVisible(true);
      
    }
    
    public void addItems(java.awt.event.ActionEvent evt) //Functions performed when their respective buttons are pressed and Action event is generated.
      {String input = txtInput.getText(); //get the inputed number
      int qty = Integer.parseInt(input);// Converting the recieved text to integer
      String name = this.item_selected_name.getText().substring(11); //extracting the required substring data
      int last = this.item_selected_price.getText().indexOf("AED");//extracting the required substring data
      String cost = this.item_selected_price.getText().substring(11,last).trim();//formatting the string
      int price = Integer.parseInt(cost);
      this.total_price.setText("Total price: "+ qty*price);

      if(BItems.contains(name)) //Removing any copies if the person orders the same good twice.
      {
        int i = BItems.indexOf(name);
        BItems.remove(i);
        BPrice.remove(i);
        BQty.remove(i);
        BNet.remove(i);
      }
//Adding the order to the subarraylist 
      BItems.add(name);
      BPrice.add(price);
      BNet.add(qty*price);
      BQty.add(qty);
}

public void goBack(java.awt.event.ActionEvent evt) //Functions performed when their respective buttons are pressed and Action event is generated.
{
  setVisible(false);
  new menuFrame(true);// calling the menu frame again and closing the Snacks Frame
}

}