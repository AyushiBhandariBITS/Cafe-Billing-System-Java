
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;


public class GenerateBillFrame extends JFrame {

   JLabel background;
  JLabel headerLabel;
  JLabel items;
  JLabel msg;
    JButton Cash;
    JButton Card;
   JButton Enter;
   JButton Exit;
   JTextField tf;
   JScrollBar S;

   int total=0;
   int x = 30;
   int y= 140;

   public static ArrayList <String> FItems ;
   public static ArrayList <Integer> FPrice;
   public static ArrayList <Integer> FQty;
   public static ArrayList <Integer> FNet;

   static{
      FItems = SnacksFrame.SItems;
      FItems.addAll(DessertsFrame.DItems);
      FItems.addAll(BeveragesFrame.BItems);

      FPrice = SnacksFrame.SPrice;
      FPrice.addAll(DessertsFrame.DPrice);
      FPrice.addAll(BeveragesFrame.BPrice);

      FQty = SnacksFrame.SQty;
      FQty.addAll(DessertsFrame.DQty);
      FQty.addAll(BeveragesFrame.BQty);

      FNet = SnacksFrame.SNet;
      FNet.addAll(DessertsFrame.DNet);
      FNet.addAll(BeveragesFrame.BNet);

      if(FQty.contains(0))
      {
        int i= FQty.indexOf(0);
        FItems.remove(i);
        FNet.remove(i);
        FQty.remove(i);
        FPrice.remove(i);
      }

   
   }

     GenerateBillFrame(){
        this.setTitle("Receipt");
        this.setVisible(true); //make frame visible
        this.setSize(562,1000);// Dimensions of the frame
        this.setResizable(false);//Doesnt allow the screen to maximize
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.background = new JLabel(new ImageIcon("bg.jpg"));
        this.init();
        
        
        add(background);
        background.setVisible(true);  
        this.pack();
        this.setSize(562,1000);
        this.setLocationRelativeTo(null);
     }
    

   public void init()
     {
      headerLabel = new JLabel("Receipt");
      this.headerLabel.setBounds(160,30,280,100);
      this.headerLabel.setFont(new Font("Cooper Black", Font.BOLD, 50));
      headerLabel.setForeground(Color.black);
      add(headerLabel);

      S=new JScrollBar();  
      S.setBounds(532,0, 20,1000);   
      this.S.setVisible(true); 
      add(S);


      items = new JLabel("Items                             Unit Price      Qty.      Price");
      this.items.setBounds(50,100,500,150);
      this.items.setFont(new Font("Cooper Black", Font.BOLD,20));
      items.setForeground(Color.black);
      add(items);
      for(int i=0; i<FItems.size() ; i++)
      {
         items = new JLabel((i+1)+ "   "+FItems.get(i));
      this.items.setBounds(x,y,300,150);
      this.items.setFont(new Font("Geomanist", Font.BOLD,17));
      items.setForeground(Color.black);
      add(items);

         items = new JLabel( "   "+FPrice.get(i));
      this.items.setBounds(x+250,y,300,150);
      this.items.setFont(new Font("Geomanist", Font.BOLD,17));
      items.setForeground(Color.black);
      add(items);
   

         items = new JLabel( "   "+FQty.get(i));
      this.items.setBounds(x+350,y,300,150);
      this.items.setFont(new Font("Geomanist", Font.BOLD,17));
      items.setForeground(Color.black);
      add(items);
   
         items = new JLabel( "   "+FNet.get(i));
      this.items.setBounds(x+420,y,300,150);
      this.items.setFont(new Font("Geomanist", Font.BOLD,17));
      items.setForeground(Color.black);
      add(items);
      total+=FNet.get(i);
      y+=30;}

      items = new JLabel( "Total Payment: "+ total+" AED");
      this.items.setBounds(150,y+40,300,150);
      this.items.setFont(new Font("Geomanist", Font.BOLD,25));
      items.setForeground(Color.black);
      add(items);

      items = new JLabel( "How do you want to pay ? ");
      this.items.setBounds(100,y+90,400,150);
      this.items.setFont(new Font("Geomanist", Font.BOLD,25));
      items.setForeground(Color.black);
      add(items);

      Card = new JButton("Card");
      this.Card.setFont(new Font("Cooper Black", Font.PLAIN, 20));
      this.Card.setBounds(50,y+200,150,35);
      this.Card.setVisible(true);
      add(Card);
      Card.addActionListener(this::CardPayment);

      msg = new JLabel( "");
      this.msg.setBounds(100,y+230,400,150);
      this.msg.setFont(new Font("Geomanist", Font.BOLD,25));
      msg.setForeground(Color.black);
      msg.setVisible(false);
      add(msg);

      tf= new JTextField();
      tf.setBounds(200,y+350,75,35);
      add(tf);
     tf.setVisible(false);

      Cash = new JButton("Cash");
      this.Cash.setFont(new Font("Cooper Black", Font.PLAIN, 20));
      this.Cash.setBounds(300,y+200,150,35);
      this.Cash.setVisible(true);
      add(Cash);
      Cash.addActionListener(this::CashPayment);

    Enter = new JButton("Enter");
    this.Enter.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    this.Enter.setBounds(180,y+400,150,35);
    this.Enter.setVisible(false);
    add(Enter);
    Enter.addActionListener(this::EnteredPressed);

    Exit = new JButton("Exit");
    this.Exit.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    this.Exit.setBounds(180,y+440,150,35);
    this.Exit.setVisible(false);
    add(Exit);
    Exit.addActionListener(this::ExitedPressed);

  }

  public void CashPayment (java.awt.event.ActionEvent event) {
   msg.setVisible(true);
   msg.setText("How much are you paying."); 
   this.msg.setBounds(100,y+230,400,150);
   msg.setFont(new Font("Geomanist", Font.BOLD,25));
   tf.setVisible(true);
   Enter.setVisible(true);}

   public void EnteredPressed(java.awt.event.ActionEvent event)
   {
      String input = tf.getText();
      int qty = Integer.parseInt(input);
        if (qty>total) {
          double change = qty-total;
          msg.setText("Your change is "+change+" AED. Please come again :)");
          this.msg.setBounds(70,y+230,500,150);
          this.msg.setFont(new Font("Geomanist", Font.PLAIN,20));
         Exit.setVisible(true);} 

          else if(qty<total){
            double change = total-qty;
            msg.setText("Please pay "+change+" AED more to this initial amount.");
            this.msg.setBounds(70,y+230,500,150);
            this.msg.setFont(new Font("Geomanist", Font.BOLD,20));
          }
      else
       {msg.setText("Thank you for eating at our cafe. Please come again :)");
       this.msg.setBounds(10,y+230,500,150);
       this.msg.setFont(new Font("Geomanist", Font.PLAIN,20));
       Exit.setVisible(true);}
   }


   public void CardPayment(java.awt.event.ActionEvent event)
   {    msg.setVisible(true);
      tf.setVisible(false);
      msg.setText("Please scan your card at the counter. We await to serve you again :)"); 
      this.msg.setBounds(10,y+230,550,150);
      this.msg.setFont(new Font("Geomanist", Font.PLAIN,17));
      this.Enter.setVisible(false);
      Exit.setVisible(true);
   }

   public void ExitedPressed(java.awt.event.ActionEvent event)
   {System.exit(0);}


}

