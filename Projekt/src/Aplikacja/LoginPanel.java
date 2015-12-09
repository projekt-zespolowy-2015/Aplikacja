package Aplikacja;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
 



import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class LoginPanel extends JPanel {
    private JTextField PoleNazwa; //pole na nazwê
    private JPasswordField PoleHaslo; //pole na has³o
    private JButton PrzyciskZaloguj; //przycisk logowania
    private LoginListener listener; //s³uchacz przycisku
 
    /**
     * @return wprowadzona nazwa u¿ytkownika
     */
    public String getName() {
        return PoleNazwa.getText();
    }
    /**
     * @return wprowadzone przez u¿ytkownika has³o
     */
    public String getPassword() {
        String haslo = "";
        char[] pass = PoleHaslo.getPassword();
        for(int i=0; i<pass.length; i++) {
            haslo += pass[i];
        }
        return haslo;
    }
 
    public LoginPanel(LoginListener listener) {
        super();
        // ustawiamy layout
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        // tworzymy komponenty logowania
        this.listener = listener;
        this.listener.setPanel(this);
        createComponents();
    }
 
    /**
     * Metoda, która tworzy etykiety i pola do wprowadzania danych.
     */
    private void createComponents() {
    	JLabel opis= new JLabel("<html>Proszê siê zalogowaæ, aby przejœæ dalej! </html>");
        JLabel login = new JLabel("<html>Login:</html>");
        JLabel haslo = new JLabel("Has³o: ");
        PoleNazwa = new JTextField();
        PoleHaslo = new JPasswordField();
 
        //pomocniczy panel do wprowadzania danych
        JPanel inputPanel = new JPanel();
        inputPanel.add(opis);
        inputPanel.setLayout(new GridLayout(8,8));
        inputPanel.add(login);
        inputPanel.add(PoleNazwa);
        inputPanel.add(haslo);
        inputPanel.add(PoleHaslo);
        //tworzymy przycisk logowania
        PrzyciskZaloguj = new JButton("Zaloguj");
        PrzyciskZaloguj.addActionListener(listener);
 
        //pomocniczy panel do wyœrodkowania elementów
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);
        parentPanel.add(PrzyciskZaloguj, BorderLayout.SOUTH);
 
        // dodajemy do g³ównego panelu
        this.add(parentPanel);
    }
}