
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

import java.util.*;

public class DessertsFrame extends JFrame{

  JLabel background;
  JLabel headerLabel;
  JLabel items;
  JLabel Quantity;
  JLabel total_price;
  JLabel item_selected_name;
  JLabel item_selected_price;
  JTextField txtInput;
    JButton Order;
    JButton goBackButton;
    JButton Exit;
    JButton Add_to_Plate;
    JScrollBar S;

    public static ArrayList <String> DItems = new ArrayList <String> ();
    public static ArrayList <Integer> DPrice = new ArrayList <Integer> ();
    public static ArrayList <Integer> DNet = new ArrayList <Integer> ();
    public static ArrayList <Integer> DQty = new ArrayList <Integer> ();
     DessertsFrame(){
        this.setTitle("Desserts Bar");
       this.setVisible(true); //make frame visible
       this.setSize(562,1000);// Dimensions of the frame
       this.setResizable(false);//Doesnt allow the screen to maximize
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       this.background = new JLabel(new ImageIcon("dessertsbg.jpg"));
       this.init();

       add(background);
       background.setVisible(true);  
       this.pack();
       this.setSize(562,1000);
       this.setLocationRelativeTo(null);
     }

     public void init(){
      headerLabel = new JLabel("Desserts");
      this.headerLabel.setBounds(100,70,250,100);
      this.headerLabel.setFont(new Font("Cooper Black", Font.BOLD, 50));
      headerLabel.setForeground(Color.black);
      add(headerLabel);
      items = new JLabel("Items                                Price");
      this.items.setBounds(90,120,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD,20));
      items.setForeground(Color.black);
      add(items);

      S=new JScrollBar();  
      S.setBounds(532,0, 20,1000);   
      this.S.setVisible(true); 
      add(S);

      items = new JLabel("1. Chocolate Brownie        5");
      this.items.setBounds(70,180,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD,20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,245,100,20);
      add(Order);
      Order.addActionListener(this::ChocolateBrownieActionPerformed);

      items = new JLabel("2. Red Velvet Cake              8");
      this.items.setBounds(70,220,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,285,100,20);
      add(Order);
      Order.addActionListener(this::RedVelvetCakeActionPerformed);

      items = new JLabel("3. Plum cake                           8");
      this.items.setBounds(70,260,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,325,100,20);
      add(Order);
      Order.addActionListener(this::PlumCakeActionPerformed);

      items = new JLabel("4. Vanilla Cupcake              5");
      this.items.setBounds(70,300,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,365,100,20);
      add(Order);
      Order.addActionListener(this::VanillaCupcakeActionPerformed);

      items = new JLabel("5. Chocolate Croissant      10");
      this.items.setBounds(70,340,300,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD, 20));
      items.setForeground(Color.black);
      add(items);

      this.Order=new JButton("Order");
      this.Order.setFont(new Font("Cooper Black", Font.PLAIN, 15));
      this.Order.setBounds(410,405,100,20);
      add(Order);
      Order.addActionListener(this::ChocolateCroissantActionPerformed);

      
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

      total_price = new JLabel("total price:");
      this.total_price.setBounds(100,520,500,150);
      this.total_price.setFont(new Font("Geomanist", Font.BOLD,20));
      total_price.setForeground(Color.black);
      add(total_price);


      this.Add_to_Plate=new JButton("Add to plate");
      this.Add_to_Plate.setFont(new Font("Cooper Black", Font.PLAIN, 20));
      this.Add_to_Plate.setBounds(180,630,180,35);
      this.Add_to_Plate.setVisible(false);
      add(Add_to_Plate);
      Add_to_Plate.addActionListener(this::addItems);

      this.goBackButton=new JButton("Go Back to the main menu");
      this.goBackButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
      this.goBackButton.setBounds(80,700,380,35);
      add(goBackButton);
      goBackButton.addActionListener(this::goBack);
    
    }
    public void ChocolateBrownieActionPerformed(java.awt.event.ActionEvent evt){

      item_selected_name.setText("Item name: Chocolate Brownie");
      item_selected_price.setText("Item cost: 5 AED");
      this.Add_to_Plate.setVisible(true);

    }

    public void RedVelvetCakeActionPerformed(java.awt.event.ActionEvent evt)
    {
      item_selected_name.setText("Item name: Red Velvet Cakes");
      item_selected_price.setText("Item cost: 8 AED");
      this.Add_to_Plate.setVisible(true);
      
    }

    public void PlumCakeActionPerformed(java.awt.event.ActionEvent evt)
    {
      item_selected_name.setText("Item name: Plum Cake");
      item_selected_price.setText("Item cost: 8 AED");
      this.Add_to_Plate.setVisible(true);
      
    }
    
    public void VanillaCupcakeActionPerformed(java.awt.event.ActionEvent evt)
    {
      item_selected_name.setText("Item name: Vanilla Cupcake");
      item_selected_price.setText("Item cost: 5 AED");
      this.Add_to_Plate.setVisible(true);
      
    }
    
    public void ChocolateCroissantActionPerformed(java.awt.event.ActionEvent evt)
    {
      item_selected_name.setText("Item name: Chocolate Croissant");
      item_selected_price.setText("Item cost: 10 AED");
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

      if(DItems.contains(name))
{
  int i = DItems.indexOf(name);
  DItems.remove(i);
  DPrice.remove(i);
  DQty.remove(i);
  DNet.remove(i);
}


      DItems.add(name);
      DPrice.add(price);
      DNet.add(qty*price);
      DQty.add(qty);
}

public void goBack(java.awt.event.ActionEvent evt)
{
  setVisible(false);
  new menuFrame(true);
}

    
}