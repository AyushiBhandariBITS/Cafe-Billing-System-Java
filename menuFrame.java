
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menuFrame extends JFrame{
  JLabel background;
  JLabel headerLabel;
  JLabel Asking;
    JButton Snacks;
    JButton Desserts;
    JButton Beverages;
    JButton GenerateBill;
   
    public menuFrame(boolean vision) {
        this.setVisible(vision); //make frame visible
        this.setSize( 600,1000);// Dimensions of the frame
        this.setResizable(false);//Doesnt allow the screen to maximize
        this.setTitle("Menu Card"); // setting the title for the frame
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.background = new JLabel(new ImageIcon("background.jpg"));
       this.init();

       add(background);
       background.setVisible(true);  
       this.pack();
       this.setSize(800,800);
       this.setLocationRelativeTo(null);

    }

    public void init(){
    headerLabel = new JLabel();
    this.headerLabel.setText("Welcome to Best Brew");
    this.headerLabel.setBounds(270,110,300,150);
    this.headerLabel.setFont(new Font("Cooper Black", Font.BOLD, 25));
    headerLabel.setForeground(Color.black);
    add(headerLabel);
    

    Asking = new JLabel();
    this.Asking.setText("What would you like to have today");
    this.Asking.setBounds(160,180,500,100);
    this.Asking.setFont(new Font("Cooper Black", Font.PLAIN, 25));
    Asking.setForeground(Color.black);
    add(Asking);

        this.Snacks=new JButton("Snacks");
        this.Snacks.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        this.Snacks.setBounds(270,280,250,100);
        add(Snacks);
        Snacks.addActionListener(this::SnacksActionPerformed);
    
        this.Desserts=new JButton("Desserts");
        this.Desserts.setBounds(270,400,250,100);
        this.Desserts.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        add(Desserts);
        Desserts.addActionListener(this::DessertsActionPerformed);
    
        this.Beverages=new JButton("Beverages");
        this.Beverages.setBounds(270,520,250,100);
        this.Beverages.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        add(Beverages);
        Beverages.addActionListener(this::BeveragesActionPerformed);

        this.GenerateBill=new JButton("Generate Bill");
        this.GenerateBill.setBounds(270,640,250,100);
        this.GenerateBill.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        add(GenerateBill);
        GenerateBill.addActionListener(this::GenerateBillActionPerformed);
    
    }
    public void SnacksActionPerformed(java.awt.event.ActionEvent evt){
         new SnacksFrame();
        setVisible(false);
        }
    public void DessertsActionPerformed(java.awt.event.ActionEvent evt){
        new DessertsFrame();
        setVisible(false);
        }
    public void BeveragesActionPerformed(java.awt.event.ActionEvent evt){
         new BeveragesFrame();
         setVisible(false);
        }

    public void GenerateBillActionPerformed(java.awt.event.ActionEvent evt)
    { new GenerateBillFrame();
        setVisible(false);}
     }







