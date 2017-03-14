import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SlideListener implements ChangeListener {    
    public JTextField text;
    public JSlider slider;
    
    SlideListener(JTextField txt, JSlider slide){
        text = txt; 
        slider = slide; 
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        text.setText(String.valueOf(slider.getValue()));
        
        slider.setEnabled(true);
   
        int testValTF = Integer.parseInt(text.getText());
        
    }
}