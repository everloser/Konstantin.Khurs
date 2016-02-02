package homework1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BonusEx
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new FormulaFrame();
               frame.setTitle("FormulaX");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

class FormulaFrame extends JFrame
{
   

   public FormulaFrame()
   {
      JTextField xField = new JTextField();
      xField.setFont(new Font("Serif", Font.BOLD, 20));
      JTextField tField = new JTextField();
      tField.setFont(new Font("Serif", Font.BOLD, 20));
      JTextField sField = new JTextField();
      sField.setFont(new Font("Serif", Font.BOLD, 20));
      JPanel northPanel = new JPanel();
      northPanel.setLayout(new GridLayout(3, 2));
      JLabel label1 = new JLabel("Input x value: ", SwingConstants.RIGHT);
      label1.setFont(new Font("Serif", Font.BOLD, 20));
      JLabel label2 = new JLabel("Input t value: ", SwingConstants.RIGHT);
      label2.setFont(new Font("Serif", Font.BOLD, 20));
      JLabel label3 = new JLabel("Input s value: ", SwingConstants.RIGHT);
      label3.setFont(new Font("Serif", Font.BOLD, 20));
      northPanel.add(label1);
      northPanel.add(xField);
      northPanel.add(label2);
      northPanel.add(tField);
      northPanel.add(label3);
      northPanel.add(sField);
           add(northPanel, BorderLayout.NORTH);

      JLabel formula = new JLabel();
      ImageIcon icon = new ImageIcon("formula.gif");
      formula.setIcon(icon);
           add(formula, BorderLayout.CENTER);
       

      JPanel southPanel = new JPanel();
      southPanel.setLayout(new GridLayout(1, 3));
      JButton resultButton = new JButton("Get Y");
      southPanel.add(resultButton);
      JTextField Yres = new JTextField();
      Yres.setFont(new Font("Serif", Font.BOLD, 20));
      southPanel.add(Yres);
      JButton clearTXT = new JButton("Clear all");      
      southPanel.add(clearTXT);
      resultButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               double x = Double.valueOf(xField.getText());
               double t = Double.valueOf(tField.getText());
               double s = Double.valueOf(sField.getText());
               double y =((Math.sin(Math.pow(x,t)))*(Math.sin(Math.pow(x,t))))/(Math.sqrt(1+Math.pow(x,s)));
               String yy = String.format("%.5f", y);
               Yres.setText(yy);
            }
         });
      
      clearTXT.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
            Yres.setText("");
            xField.setText("");
            tField.setText("");
            sField.setText("");
            
         }
      });

      add(southPanel, BorderLayout.SOUTH);
      pack();
   }
}
