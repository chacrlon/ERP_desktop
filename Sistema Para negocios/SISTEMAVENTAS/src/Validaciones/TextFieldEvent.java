/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author AARON ROMAN
 */
public class TextFieldEvent {
    
    public void textKeyPress(KeyEvent evt){ 
        //Declaramos una variable y le asignamos un evento
      char car=evt.getKeyChar();  
        //Condicion que nos permite ingresar datos de tipo texto
        if((car < 'a' || car > 'z')&&(car < 'A' || car > 'Z')
                &&(car !=(char) KeyEvent.VK_BACK_SPACE)&&(car!=(char) KeyEvent.VK_SPACE))
            evt.consume();
    }
    
    
    public void numberKeyPress(KeyEvent evt){ 
        //Declaramos una variable y le asignamos un evento
      char car=evt.getKeyChar();  
        //Condicion que nos permite ingresar datos de tipo texto
        if((car < '0' || car > '9')&&(car !=(char) KeyEvent.VK_BACK_SPACE)){ 
            evt.consume();
        }
                
    }
    
    
    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField){ 
        //Declaramos una variable y le asignamos un evento
      char car=evt.getKeyChar();  
        //Condicion que nos permite ingresar datos de tipo texto
        if((car < '0' || car > '9')&&textField.getText().contains(".")
                &&(car !=(char) KeyEvent.VK_BACK_SPACE)){ 
            evt.consume();
        }else if((car < '0' || car > '9')&&(car!='.')
                &&(car !=(char) KeyEvent.VK_BACK_SPACE)){ 
            evt.consume();
        }
                
    }
    
}
