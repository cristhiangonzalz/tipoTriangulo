package tipos_de_triangulos;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Principal1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtLado1;
	private JTextField txtLado2;
	private JTextField txtLado3;
	private double lado1, lado2, lado3; 
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal1 frame = new Principal1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/icono/icono_triangulos.png"));
		setResizable(false);
		setTitle("Clasificación de Triángulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 548);
		
		/*pantalla completa
		this.setExtendedState(MAXIMIZED_BOTH); */
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 488, 521);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblQueTipoEs = new JLabel("¿Qué tipo de triángulo es?");
		lblQueTipoEs.setForeground(SystemColor.window);
		lblQueTipoEs.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblQueTipoEs.setBounds(120, 18, 297, 27);
		panel.add(lblQueTipoEs);

		JLabel lblIngreseLados = new JLabel("Ingrese los lados");
		lblIngreseLados.setForeground(SystemColor.window);
		lblIngreseLados.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblIngreseLados.setBounds(165, 36, 297, 27);
		panel.add(lblIngreseLados);
		
		JLabel lblLado1 = new JLabel("Lado 1");
		lblLado1.setForeground(Color.WHITE);
		lblLado1.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblLado1.setBounds(114, 90, 66, 27);
		panel.add(lblLado1);
		
		JLabel lblLado2 = new JLabel("Lado 2");
		lblLado2.setForeground(Color.WHITE);
		lblLado2.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblLado2.setBounds(114, 157, 66, 25);
		panel.add(lblLado2);
		
		JLabel lblLado3 = new JLabel("Lado 3");
		lblLado3.setForeground(Color.WHITE);
		lblLado3.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblLado3.setBounds(114, 230, 66, 27);
		panel.add(lblLado3);
		
		txtLado1 = new JTextField();
	
		//LIMITAR LA CANTIDAD DE CARACTERES QUE SE INGRESA EN EL CAMPO
			
		txtLado1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtLado1.getText().length() > 10) {
					e.consume();
				}
			}
		});
		txtLado1.setBounds(244, 91, 77, 25);
		panel.add(txtLado1);
		txtLado1.setColumns(10);
		
		txtLado2 = new JTextField();
		txtLado2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtLado2.getText().length() > 10) {
					e.consume();
				}
			}
		});
		txtLado2.setColumns(10);
		txtLado2.setBounds(244, 157, 77, 26);
		panel.add(txtLado2);
			
		txtLado3 = new JTextField();
		txtLado3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtLado3.getText().length() > 10) {
					e.consume();
				}
			}
		});
		
		//CONFIRMAR CON ENTER
		
	txtLado3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						lado1 = Double.parseDouble(txtLado1.getText());
						lado2 = Double.parseDouble(txtLado2.getText());
						lado3 = Double.parseDouble(txtLado3.getText());
						
						contieneGuionException(txtLado1, txtLado2, txtLado3);
						diferenteDeCeroException(lado1, lado2, lado3);
						tipoTriangulo(lado1, lado2, lado3);
						
					
					} catch (DiferenteDeCeroException e2) {
						JOptionPane.showMessageDialog(null, "Debe ingresar valores mayores a cero");
					
					} catch (ContieneGuionExcpetion e3) {
						JOptionPane.showMessageDialog(null, "Debe ingresar números positivos");
						
					} catch (java.lang.NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "Debe ingresar valores numéricos");		
						
					}
				}
				
			}
		});  
	
		txtLado3.setColumns(10);
		txtLado3.setBounds(244, 231, 77, 26);
		panel.add(txtLado3);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(102, 204, 204));
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Lucida Console", Font.BOLD, 16));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		try {
				lado1 = Double.parseDouble(txtLado1.getText());
				lado2 = Double.parseDouble(txtLado2.getText());
				lado3 = Double.parseDouble(txtLado3.getText());
				
				contieneGuionException(txtLado1, txtLado2, txtLado3);
				diferenteDeCeroException(lado1, lado2, lado3);
				tipoTriangulo(lado1, lado2, lado3);
				
			
			} catch (DiferenteDeCeroException e2) {
				JOptionPane.showMessageDialog(null, "Debe ingresar valores mayores a cero");
			
			} catch (ContieneGuionExcpetion e3) {
				JOptionPane.showMessageDialog(null, "Debe ingresar números positivos");
				
			} catch (java.lang.NumberFormatException e1){
				JOptionPane.showMessageDialog(null, "Debe ingresar valores numéricos");		
				
			}
	
		}
			
	});
		btnConfirmar.setBounds(163, 291, 148, 48);
		panel.add(btnConfirmar);
		
		JLabel lblVersion = new JLabel("v 1.2");
		lblVersion.setForeground(Color.WHITE);
		lblVersion.setFont(new Font("Lucida Console", Font.PLAIN, 8));
		lblVersion.setBounds(222, 416, 59, 16);
		panel.add(lblVersion);
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.setFont(new Font("Lucida Console", Font.PLAIN, 10));
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setearCampos(txtLado1, txtLado2, txtLado3);
			}
		});
		btnLimpiarCampos.setBounds(163, 356, 148, 27);
		panel.add(btnLimpiarCampos);
	}

	public static void tipoTriangulo(double lado1, double lado2, double lado3) {
		if ((lado1 == lado2 && lado2 == lado3) && (lado1 != 0 && lado2 != 0 && lado3 != 0)) {
			JOptionPane.showMessageDialog(null, "Triángulo Equilatero \n"
					+ "Este tipo de triángulos se caracteriza por \ntener todos sus lados iguales");	
		}
		if ((lado1 == lado2 && lado2 != lado3) || (lado1 == lado3 && lado3 != lado2) || (lado2 == lado3 && lado3 != lado1) && (lado1 != 0 || lado2 != 0 || lado3 != 0)){
			//	((lado1 == lado2 && lado2 != lado3 && lado1 != 0 && lado3 != 0) || (lado1 == lado3 && lado3 != lado2 && lado1 != 0 && lado2 != 0) || (lado2 == lado3 && lado3 != lado1 && lado2 != 0 && lado1 != 0)) {
			JOptionPane.showMessageDialog(null, "Triángulo Isósceles \n"
					+ "Este tipo de triángulos se caracteriza \npor tener dos de sus lados iguales");
		}
		if ((lado1 != lado2 && lado2 != lado3 && lado3 != lado1) && (lado1 != 0 && lado2 != 0 && lado3 != 0)) {
			JOptionPane.showMessageDialog(null, "Triángulo Escaleno \n"
					 + "Este tipo de triángulos se caracteriza \npor tener todos sus lados diferentes");
		}  
	}
	public static void setearCampos(JTextField txtLado1, JTextField txtLado2, JTextField txtLado3) {
		txtLado1.setText("");
		txtLado2.setText("");
		txtLado3.setText(""); 
	}
	
	public static void diferenteDeCeroException(double lado1, double lado2, double lado3) throws DiferenteDeCeroException {
		if (lado1 == 0 || lado2 == 0 || lado3 == 0)
			throw new DiferenteDeCeroException("Debe ingresar valores mayores a cero");
	}
	public static void contieneGuionException (JTextField txtLado1, JTextField txtLado2, JTextField txtLado3) throws ContieneGuionExcpetion {
		if (txtLado1.getText().contains("-"))
			throw new ContieneGuionExcpetion("Debe ingresar números positivos");
		if (txtLado2.getText().contains("-"))
			throw new ContieneGuionExcpetion("Debe ingresar números positivos");
		if (txtLado3.getText().contains("-"))
			throw new ContieneGuionExcpetion("Debe ingresar números positivos");
			 
	}
}
