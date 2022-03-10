import javax.swing.*;
import java.awt.Font; 
import java.awt.FlowLayout; 
import java.io.*;

// IMAGE ENCRYPTIONS AND DECRYPTIONS

public class ImageOperation {

    public static void operate(int key){
           JFileChooser filechooser = new JFileChooser();
           filechooser.showOpenDialog(null);
           File file = filechooser.getSelectedFile(); 

        //    file input stream reader
        try {
            FileInputStream fis = new FileInputStream(file);
            byte [] data = new byte[fis.available()];
            fis.read(data); 
            int i =0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            // File Output Stream 
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "DONE");
        } catch (Exception e) {
            //TODO: handle exception
        }
            
    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Image Encryption");  
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        Font font = new Font("Roboto",Font.BOLD,25);

        // Progress Bar
        // JProgressBar pb = new JProgressBar();
        // f.add(pb);
        // pb.setLocation(4000,5000);


        // Creating Buttons 
        JButton button = new JButton();
        button.setText("Open Image");
        button.setFont(font); 

    

        // Creating TextField
        JTextField textfield = new JTextField(10);
        textfield.setFont(font);
        f.setLayout(new FlowLayout()); 
        f.add(button);
        f.add(textfield);

        button.addActionListener(e->{
            System.out.println("Button Clicked");
            String text = textfield.getText(); 
            int temp=Integer.parseInt(text);
            operate(temp);
        });

        f.setVisible(true); 

        // CREATED BY DIBENDU
    }
}  