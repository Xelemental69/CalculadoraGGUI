/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paneles;

/**
 *
 * @author fcoj
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;    
    private double aux1 = 0;
    private double aux2 = 0;
    private double res = 0;

    // Constructor
    public MainPanel() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        boolean fallo = false;
        // Si es un botón

        if (((JButton) o).getText().equals("C")) {

            areaTexto.setText("");
            aux1 = 0;
            aux2 = 0;

        } else if (((JButton) o).getText().equals("+")) {

            if (tipoOperacion == 0) {

                aux1 = aux1 + aux2;

            }
            
            tipoOperacion = 0;

        } else if (((JButton) o).getText().equals("-")) {

            if (tipoOperacion == 1) {

                aux1 = aux1 - aux2;

            }
            
            tipoOperacion = 1;

        } else if (((JButton) o).getText().equals("*")) {

            if (tipoOperacion == 2) {

                aux1 = aux1 * aux2;

            }
            
            tipoOperacion = 2;

        } else if (((JButton) o).getText().equals("/")) {

            if (tipoOperacion == 3 && aux1 != 0 && aux2 != 0) {

                aux1 = aux1 / aux2;

            }
            
            tipoOperacion = 3;

        } else if (((JButton) o).getText().equals("=")) {

            switch (tipoOperacion) {

                case 0:

                    res = aux1 + aux2;

                    break;

                case 1:

                    res = aux1 - aux2;

                    break;

                case 2:

                    res = aux1 * aux2;

                    break;

                case 3:

                    if (aux1 != 0 && aux2 != 0) {

                        res = aux1 / aux2;

                    } else {

                        areaTexto.setText("ERROR (División por 0)");

                    }

                    break;

            }

            if (!fallo) {

                areaTexto.setText("" + res);
                System.out.println("Res = " + res);

            }else if(tipoOperacion == -1){
                
                areaTexto.setText("" + res);
                System.out.println("Res = " + res);
                
            }
            
            tipoOperacion = -1;
            aux1 = 0;
            aux2 = 0;

        } else if (o instanceof JButton) {            
            areaTexto.setText(((JButton) o).getText());

            if (tipoOperacion == -1) {

                aux1 = Double.parseDouble(((JButton) o).getText());

            } else {

                aux2 = Double.parseDouble(((JButton) o).getText());

            }

        }
        
        System.out.println(((JButton) o).getText());
        System.out.println("tipoOperacion: " + tipoOperacion);
        System.out.println("aux1 = " + aux1);
        System.out.println("aux2 = " + aux2);

        // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
    }

}
