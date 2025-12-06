import javax.swing.JOptionPane;
public class NameDialog{
    public static void main(String args[]){
        String name=JOptionPane.showInputDialog("what is your name?");
        String message=String.format("welcome,%s to java programming!",name );
        JOptionPane.showMessageDialog(null,message);
    }
}
