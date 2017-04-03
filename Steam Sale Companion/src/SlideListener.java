import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SlideListener implements ChangeListener {    
    //creates JTextField and JSlider objects
    public JTextField text;
    public JSlider slider;
    
    /**
     * initializes the text and slide objects 
     * @param txt
     * @param slide 
     */
    public SlideListener(JTextField txt, JSlider slide){
        text = txt; 
        slider = slide; 
    }
    
    /**
     * sets the text of the stored textField to 
     * the value represented by the slide
     * @param e 
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        text.setText(String.valueOf(slider.getValue()));
        
        slider.setEnabled(true);
    }
}