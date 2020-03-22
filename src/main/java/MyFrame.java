import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.*;


public class MyFrame extends JFrame {
    public MyFrame() {
        super(("Not Hello world"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 1000);
        setLocation(50, 50);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(new JButton("pobierz"));
        add(new JLabel());

        JButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    JLabel.setIcon(ReasizeImage());
                }
                else if(result==JFileChooser.CANCEL_OPTION){
                    System.out.println("No FIle Select");
                }
            }
        });

        setVisible(true);
    }

    public ImageIcon ReasizeImage(String ImagePath){
      ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(JLabel.getWitdh(), JLabel.getHight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    };


}


