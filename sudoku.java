import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;


class sudoku {
    public static void main(String args[]){
       JFrame frame = new JFrame("Sudoku solver");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500,500);
             
       JPanel panel = new JPanel(new BorderLayout());
       Container contentPane = frame.getContentPane();
       contentPane.setLayout(new FlowLayout());
       
       JButton button = new JButton("Press");
       frame.getContentPane().add(button); // Adds Button to content pane of frame

       JColorChooser colorChooser = new JColorChooser();
       frame.getContentPane().add(colorChooser); // Adds Button to content pane of frame


       frame.setVisible(true);
    }
}