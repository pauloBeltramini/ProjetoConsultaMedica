
package extras;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class TratarFormularios {
    
    public static void limparCampos(JFrame form) throws Exception {
        limparCampos(form.getComponents());
    }
    
    public static void limparCampos(JInternalFrame form) throws Exception {
        limparCampos(form.getContentPane().getComponents());
    }
    
    private static void limparCampos(Component[] form) throws Exception {
        for (Component c: form) {
            if (c instanceof JTextField) {
                JTextField t = (JTextField) c;
                t.setText("");
            }
            
            if (c instanceof JComboBox) {
                JComboBox t = (JComboBox) c;
                t.setSelectedIndex(0);
            }
            if (c instanceof JPanel) {
                JPanel jp = (JPanel) c;
                limparCampos(jp.getComponents());
            }
            if (c instanceof JTabbedPane) {
                JTabbedPane jtp = (JTabbedPane) c;
                limparCampos(jtp.getComponents());
            }
        }
    }    
    
    public static void habilitarCampos(JInternalFrame form) throws Exception {
        habilitarCampos(form.getContentPane().getComponents());
    }
    
    private static void habilitarCampos(Component[] form) throws Exception {
        for (Component c: form) {
            c.setEnabled(true);
            if (c instanceof JPanel) {
                JPanel jp = (JPanel) c;
                habilitarCampos(jp.getComponents());
            }
            if (c instanceof JTabbedPane) {
                JTabbedPane jtp = (JTabbedPane) c;
                habilitarCampos(jtp.getComponents());
            }
        }   
    } 
    
}
