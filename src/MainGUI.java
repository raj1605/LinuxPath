import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainGUI implements ActionListener {
    JButton convertBtn;
    JFrame frame;
    JTextArea ta;
    public MainGUI(){
        frame = new JFrame("Linux Path GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);

        JMenuBar mb = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Save");
        mb.add(menu1);
        mb.add(menu2);
        JMenuItem menuItem1 = new JMenuItem("New");
        JMenuItem menuItem2 = new JMenuItem("Open");
        menu1.add(menuItem1);
        menu1.add(menuItem2);

        JPanel jp = new JPanel();
        convertBtn = new JButton("Convert and Copy to clipboard");
        convertBtn.addActionListener(this);
        ta = new JTextArea();
        jp.add(ta);
        jp.add(convertBtn);

        frame.add(BorderLayout.SOUTH,jp);
        frame.add(BorderLayout.CENTER,ta);
        frame.setVisible(true);
    }
    public static void main(String[] args){

        new MainGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convertBtn){
            String s = ta.getText();

            char[] carr = s.toCharArray();
            for(int i = 0;i<carr.length;i++){
                if(carr[i] == '\\') {
                    carr[i] = '/';
                }
            }
            String fin = "";
            for(char c: carr){
                fin += c;
            }
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(fin), null);

        }



    }
}
