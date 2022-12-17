import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.util.*;

public class SnacksFrame extends JFrame{

   JLabel background;
  JLabel headerLabel;
  JLabel items;
  JLabel Quantity;
  JLabel total_price;
  JLabel item_selected_name;
  JLabel item_selected_price;
    JButton Order;
    JButton goBackButton;
    JButton Add_to_Plate;
    JTextField txtInput ;
    JScrollBar S;
  public static ArrayList <String> SItems = new ArrayList <String> ();
  public static ArrayList <Integer> SPrice = new ArrayList <Integer> ();
  public static ArrayList <Integer> SQty = new ArrayList <Integer> ();
  public static ArrayList <Integer> SNet = new ArrayList <Integer> ();

     SnacksFrame(){
        this.setTitle("Snacks Bar");
       this.setVisible(true); //make frame visible
       this.setSize(562,1000);// Dimensions of the frame
       this.setResizable(false);//Doesnt allow the screen to maximize
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       this.background = new JLabel(new ImageIcon("snacksbg.jpg"));
       this.init();

       add(background);
       background.setVisible(true);  
       this.pack();
       this.setSize(562,1000);
       this.setLocationRelativeTo(null);
     }

     public void init(){
      headerLabel = new JLabel("Snacks");
      this.headerLabel.setBounds(120,60,200,100);
      this.headerLabel.setFont(new Font("Cooper Black", Font.BOLD, 50));
      headerLabel.setForeground(Color.black);
      add(headerLabel);

      S=new JScrollBar();  
      S.setBounds(532,0, 20,1000);   
      this.S.setVisible(true); 
      add(S);

      items = new JLabel("Items                              Price");
      this.items.setBounds(110,120,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD,20));
      items.setForeground(Color.black);
      add(items);

      items = new JLabel("1. Club Sandwich         8");
      this.items.setBounds(110,180,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD,20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,245,100,20);
      add(Order);
      Order.addActionListener(this::ClubSandwichActionPerformed);

      items = new JLabel("2. Veg Burger                 8");
      this.items.setBounds(110,220,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,285,100,20);
      add(Order);
      Order.addActionListener(this::VegBurgerActionPerformed);

      items = new JLabel("3. Chicken Burger      10");
      this.items.setBounds(110,260,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,325,100,20);
      add(Order);
      Order.addActionListener(this::ChickenBurgerActionPerformed);

      items = new JLabel("4. Cheese Pizza               9");
      this.items.setBounds(110,300,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,365,100,20);
      add(Order);
      Order.addActionListener(this::CheezePizzaActionPerformed);

      items = new JLabel("5. Samosa                         7");
      this.items.setBounds(110,340,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,405,100,20);
      add(Order);
      Order.addActionListener(this::SamosaActionPerformed);

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

      txtInput= new JTextField();
      txtInput.setBounds(200,545,75,25);
      add(txtInput);

      total_price = new JLabel("Total price:");
      this.total_price.setBounds(100,520,500,150);
      this.total_price.setFont(new Font("Geomanist", Font.BOLD,20));
      total_price.setForeground(Color.black);
      add(total_price);  
      
      this.Add_to_Plate=new JButton("Add to plate");
      this.Add_to_Plate.setFont(new Font("Cooper Black", Font.PLAIN, 20));
      this.Add_to_Plate.setBounds(180,630,180,35);
      add(Add_to_Plate);
      this.Add_to_Plate.setVisible(false);
      Add_to_Plate.addActionListener(this::addItems);

      this.goBackButton=new JButton("Go Back to the main menu");
      this.goBackButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
      this.goBackButton.setBounds(80,700,380,35);
      add(goBackButton);
      goBackButton.addActionListener(this::goBack);

    }

    public void ClubSandwichActionPerformed(java.awt.event.ActionEvent evt){

      item_selected_name.setText("Item name: Club Sandwich");
      item_selected_price.setText("Item cost: 8 AED");
      this.Add_to_Plate.setVisible(true);

    }

    public void VegBurgerActionPerformed(java.awt.event.ActionEvent evt)
    {
      item_selected_name.setText("Item name: Veg Burger");
      item_selected_price.setText("Item cost: 8 AED");
      this.Add_to_Plate.setVisible(true);
    }

    public void CheezePizzaActionPerformed(java.awt.event.ActionEvent evt)
    {
      item_selected_name.setText("Item name: Cheese Pizza");
      item_selected_price.setText("Item cost: 9 AED");
      this.Add_to_Plate.setVisible(true);
      
    }
    
    public void ChickenBurgerActionPerformed(java.awt.event.ActionEvent evt)
    {
      item_selected_name.setText("Item name: Chicken Burger");
      item_selected_price.setText("Item cost: 10 AED");
      this.Add_to_Plate.setVisible(true);

    }
    
    public void SamosaActionPerformed(java.awt.event.ActionEvent evt)
    {
      item_selected_name.setText("Item name: Samosa");
      item_selected_price.setText("Item cost: 7 AED");
      this.Add_to_Plate.setVisible(true);

    }

    public void addItems(java.awt.event.ActionEvent evt){
      String input = txtInput.getText();
      int qty = Integer.parseInt(input);
      String name = this.item_selected_name.getText().substring(11);
      int last = this.item_selected_price.getText().indexOf("AED");
      String cost = this.item_selected_price.getText().substring(11,last).trim();
      int price = Integer.parseInt(cost);
      this.total_price.setText("Total price: "+ qty*price);

if(SItems.contains(name))
{
  int i = SItems.indexOf(name);
  SItems.remove(i);
  SPrice.remove(i);
  SQty.remove(i);
  SNet.remove(i);
}
      SItems.add(name);
      SPrice.add(price);
      SQty.add(qty);
      SNet.add(qty*price);

    }

    public void goBack(java.awt.event.ActionEvent evt)
    {
     setVisible(false);
     new menuFrame(true);
   
    }

}
    
   
