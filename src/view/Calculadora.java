package view;

//Mascara
import java.text.DecimalFormat;
//import java.text.DecimalFormatSymbols;
//import java.util.Random;

//Para usar as classes de Janelas e Menus
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

//import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;

//Para usar a classe de eventos 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Para usar as classes de botoes e texto
//import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;

//Importando o pacote com as funções
import calculos.FuncoesMatematicas;

public class Calculadora extends JFrame {
	
	//Mascara
    //DecimalFormatSymbols ponto = new DecimalFormatSymbols();
    DecimalFormat df = new DecimalFormat("###,###.###");
    DecimalFormat virgula = new DecimalFormat("###,###,##0.00");
	
	//ButtonGroup tipo = new ButtonGroup ();
	
	//Criando o botão menu e seus submenus
	JMenu Exibir = new JMenu("Exibir");
	JRadioButtonMenuItem radipadrao = new JRadioButtonMenuItem("Padão");
	JRadioButtonMenuItem radicienti = new JRadioButtonMenuItem("Cientifica");
	JRadioButtonMenuItem radiprograma = new JRadioButtonMenuItem("Programador");
	JRadioButtonMenuItem radiestatist = new JRadioButtonMenuItem("Estatistica");
	JCheckBoxMenuItem cbAgrupamento = new JCheckBoxMenuItem ("Agrupamento de Digitos");
	
	//Criando os botões de Editar/Ajuda
	JMenu Editar = new JMenu("Editar");
	JMenu Ajuda = new JMenu("Ajuda");
	
	//Criando a barra de menu
	JMenuBar menuBar = new JMenuBar();
	
	//Criando o campo de texto(visor)
	JTextField visor = new JTextField(0);
	
	//Criando os botoões da PRIMEIRA fileira
	JButton btnMC = new JButton("MC");
	JButton btnMR = new JButton("MR");
	JButton btnMS = new JButton("MS");
	JButton btnMais = new JButton("M+");
	JButton btnMenos = new JButton("M-");
	
	//Criando os botoões da SEGUNDA fileira
	JButton backsp = new JButton("<-");
	JButton btnCE = new JButton("CE");
	JButton btnC = new JButton("C");
	JButton btnmom = new JButton("+/-");
	JButton btnraiz = new JButton("Raiz");
	
	//Criando os botoões da TERCEIRA fileira
	JButton btnbarra = new JButton("/");
	JButton btnporc = new JButton("%");
	
	//Criando os botoões da QUARTA fileira
	JButton btnmul = new JButton("*");
	JButton btnfra = new JButton("1/x");
	
	//Criando os botoões da QUINTA fileira
	JButton btnfmenos = new JButton("-");
	JButton btnfigual = new JButton("=");
	
	//Criando os botoões da SEXTA fileira
	JButton btnvirgula = new JButton(",");
	JButton btnfmais = new JButton("+");
	
	//Criando os botoões de número
	JButton um = new JButton("1");
	JButton dois = new JButton("2");
	JButton tres = new JButton("3");
	JButton quatro = new JButton("4");
	JButton cinco = new JButton("5");
	JButton seis = new JButton("6");
	JButton sete = new JButton("7");
	JButton oito = new JButton("8");
	JButton nove = new JButton("9");
	JButton zero = new JButton("0");
	
	//Operações / Variaveis de texto / Variaveis parametro
	FuncoesMatematicas mat = new FuncoesMatematicas();
	
	//null quando o objeto não foi instanciado
	
	//Strings
	String sinal = null;
	String guardaMS = null;
	
	//Double
	double guardaMais = 0;
	double guardaMenos = 0;
	double valor1 = 0;
	double valor2 = 0;
	double visorAgora = 0;
	double somaMS = 0;
	
	//Boolean
	boolean igual = false;
	boolean somaAgain = false;
	
	//Calculadora 
	public Calculadora(){
		super("calculadora");
		visor.setEnabled(false);
		visor.setDisabledTextColor(Color.BLACK);
		//Criando um container para agrupar os botoes
		//Não vai ter Layout, os objetos se agruparam através do metodo setBounds
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		//Posicionando a barra de menu e add ela ao container(paine)
		menuBar.setBounds(0, 0, 228, 25);
		paine.add(menuBar);
		
		
		//Design do botão exibir, add a barra de menu o botao exibir 
		//e add ao botao exibir os outros botões
		Exibir.setFont( new Font( "Arial", Font.PLAIN, 12 ));
		Exibir.setBounds(1, 5, 45, 20);
		menuBar.add(Exibir);
		Exibir.add(radipadrao);
		Exibir.add(radicienti);
		Exibir.add(radiprograma);
		Exibir.add(radiestatist);
		Exibir.addSeparator();
		Exibir.add("Histórico       Crtl + H");
		Exibir.add(cbAgrupamento);
		Exibir.addSeparator();
		
		
		
		//Design do botão editar, add o botão editar a barra de menu
		Editar.setFont( new Font( "Arial", Font.PLAIN, 12 ));
		Editar.setBounds(46, 5, 45, 20);
		menuBar.add(Editar);
		
		//Design do botão ajuda, add o botão ajuda a barra de menu
		Ajuda.setFont( new Font( "Arial", Font.PLAIN, 12 ));
		Ajuda.setBounds(91, 5, 45, 20);
		menuBar.add(Ajuda);
		
		
		
		
		//Visor (fonte / posição / add ao container(paine))
		visor.setFont( new Font( "Arial", Font.PLAIN, 20 ));
		visor.setBounds(20, 40, 171, 50);
		paine.add(visor);
		visor.setText("0");
		
		//Primeira Fileira (fonte / margen / posição / add ao container(paine))
		
		//BTN MC
		btnMC.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnMC.setMargin(new Insets(1,1,1,1));
		btnMC.setBounds(20, 95, 30,25);
		paine.add(btnMC);
		
		btnMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guardaMS = "0";
				visor.setText("0");
				
			}
		});
		
		//BTN MR
		btnMR.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnMR.setMargin(new Insets(1,1,1,1));
		btnMR.setBounds(55, 95, 30,25);
		paine.add(btnMR);
		
		btnMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				visor.setText(guardaMS);
					
			}
		});
		
		//BTN MS
		btnMS.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnMS.setMargin(new Insets(1,1,1,1));
		btnMS.setBounds(90, 95, 30,25);
		paine.add(btnMS);
		
		btnMS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				guardaMS = visor.getText();
				
				if(guardaMS != "") {
					visorAgora = Double.parseDouble(visor.getText());
					somaMS = Double.parseDouble(guardaMS);
					visor.setText(df.format(mat.soma(visorAgora, somaMS)) + "");
				}
			}
		});
		
		//BTN M+
		btnMais.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnMais.setMargin(new Insets(1,1,1,1));
		btnMais.setBounds(125, 95, 30,25);
		paine.add(btnMais);
		
		btnMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guardaMais = Double.parseDouble(visor.getText());
			
			}
		});
		
		//BTN M-
		btnMenos.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnMenos.setMargin(new Insets(1,1,1,1));
		btnMenos.setBounds(160, 95, 30,25);
		paine.add(btnMenos);
		
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardaMenos = Double.parseDouble(visor.getText());
				
				visor.setText(df.format((guardaMais-guardaMenos)) + "");
		
			}
		});
		
		//Segunda Fileira (fonte / margen / posição / add ao container(paine))
		
		//BTN BACKSPACE
		backsp.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		backsp.setMargin(new Insets(1,1,1,1));
		backsp.setBounds(20, 125, 30, 25);
		paine.add(backsp);
		
		backsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String apaga = visor.getText();
				
				if(apaga.length() > 1) {
					apaga = apaga.substring(0, apaga.length() - 1);
					visor.setText(apaga);
				}else{
					visor.setText("0");
				}

			}
		});
		
		//BTN CE
		btnCE.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnCE.setMargin(new Insets(1,1,1,1));
		btnCE.setBounds(55, 125, 30, 25);
		paine.add(btnCE);
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Resetando tudo
				
				//Strings
				sinal = "";
				guardaMS = "";
				
				//Double
				guardaMais = 0;
				guardaMenos = 0;
				visorAgora = 0;
			    somaMS = 0;
			    valor1 = 0;
			    valor2 = 0;
			    
			    //boolean
			    igual = false;
			    somaAgain = false;
			    		
				visor.setText("0");
			}
		});
		
		//BTN C
		btnC.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnC.setMargin(new Insets(1,1,1,1));
		btnC.setBounds(90, 125, 30, 25);
		paine.add(btnC);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				visor.setText("0");
				
			}
		});
		
		//BTN +/-
		btnmom.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnmom.setMargin(new Insets(1,1,1,1));
		btnmom.setBounds(125, 125, 30, 25);
		paine.add(btnmom);
		
		btnmom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					visorAgora = Double.parseDouble(visor.getText());
					visor.setText(df.format((visorAgora * -1)) + "");
				}catch(NumberFormatException e2) {
					visor.setText("Err");
					System.out.println("Erro tratado: " + e2);
					
				}
			
			}
		});
		
		
		//BTN RAIZ
		btnraiz.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnraiz.setMargin(new Insets(1,1,1,1));
		btnraiz.setBounds(160, 125, 30, 25);
		paine.add(btnraiz);
		
		btnraiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(visor.getText());
			
					visor.setText(df.format(mat.raiz(valor1)) + "");
					if(igual) {
						visor.setText(df.format(mat.raiz(valor1)) + "");
						igual=false;
					}
						
			}
		});
		
		//Terceira Fileira (fonte / margen / posição / add ao container(paine) / eventos)
		
		//NUM 7
		sete.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		sete.setMargin(new Insets(1,1,1,1));
		sete.setBounds(20, 155, 30, 25);
		paine.add(sete);
		sete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(visor.getText().equals("0")) {
					visor.setText("7");
				}else {
					visor.setText(visor.getText() + "7");
					if(igual) {
						visor.setText("7");
						valor1 = 0;
						igual=false;
					}
				}
				
				
			}
		});
		
		
		//NUM 8
		oito.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		oito.setMargin(new Insets(1,1,1,1));
		oito.setBounds(55, 155, 30, 25);
		paine.add(oito);
		
		//Evento para exibir o número
		//ActionListener ficará de olho no botão
		//actionPerformed vai executar os comandos depois que o clique acontecer
		oito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")) {
					visor.setText("8");
				}else {
					visor.setText(visor.getText() + "8");
					if(igual) {
						visor.setText("8");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		
		//NUM 9
		nove.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		nove.setMargin(new Insets(1,1,1,1));
		nove.setBounds(90, 155, 30, 25);
		paine.add(nove);
		
		nove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")) {
					visor.setText("9");
				}else {
					visor.setText(visor.getText() + "9");
					if(igual) {
						visor.setText("9");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		//BTN DIVISÃO
		btnbarra.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnbarra.setMargin(new Insets(1,1,1,1));
		btnbarra.setBounds(125, 155, 30, 25);
		paine.add(btnbarra);
		
		btnbarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(visor.getText());
				sinal = "divide";
				visor.setText("0");
				
				if(igual) {
					visor.setText("0");
					igual=false;
				}
			}
		});
		
		//BTN PORCENTAGEM
		btnporc.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnporc.setMargin(new Insets(1,1,1,1));
		btnporc.setBounds(160, 155, 30, 25);
		paine.add(btnporc);
		
		btnporc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(visor.getText());
				sinal = "porcentagem";
				visor.setText("0");
				
				if(igual) {
					visor.setText("0");
					igual=false;
				}
			}
		});
		
		//Quarta Fileira (fonte / margen / posição / add ao container(paine) / eventos)
		
		//NUM 4
		quatro.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		quatro.setMargin(new Insets(1,1,1,1));
		quatro.setBounds(20, 185, 30, 25);
		paine.add(quatro);
		
		quatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")) {
					visor.setText("4");
				}else {
					visor.setText(visor.getText() + "4");
					if(igual) {
						visor.setText("4");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		//NUM 5
		cinco.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		cinco.setMargin(new Insets(1,1,1,1));
		cinco.setBounds(55, 185, 30, 25);
		paine.add(cinco);
		
		cinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")) {
					visor.setText("5");
				}else {
					visor.setText(visor.getText() + "5");
					if(igual) {
						visor.setText("5");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		//NUM 6
		seis.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		seis.setMargin(new Insets(1,1,1,1));
		seis.setBounds(90, 185, 30, 25);
		paine.add(seis);
		
		seis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")) {
					visor.setText("6");
				}else {
					visor.setText(visor.getText() + "6");
					if(igual) {
						visor.setText("6");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		//BTN MULTIPLICAÇÃO
		btnmul.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnmul.setMargin(new Insets(1,1,1,1));
		btnmul.setBounds(125, 185, 30, 25);
		paine.add(btnmul);
		
		btnmul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(visor.getText());
				sinal = "multiplica";
				visor.setText("0");
				
				if(igual) {
					visor.setText("0");
					igual=false;
				}
			}
		});
		
		//BTN FRAÇÃO
		btnfra.setFont( new Font( "Arial", Font.PLAIN, 12 ) );
		btnfra.setMargin(new Insets(1,1,1,1));
		btnfra.setBounds(160, 185, 30, 25);
		paine.add(btnfra);
		
		btnfra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")){
					visor.setText("0");
				}else{
					double valorFra = Double.parseDouble(visor.getText());
					visor.setText(virgula.format(mat.divisao(1, valorFra)) + "");
				}
			}
		});
		
		
		//Quinta Fileira (fonte / margen / posição / add ao container(paine) / eventos)
		
		//NUM 1
		um.setFont(new Font("Arial", Font.PLAIN, 12));
		um.setMargin(new Insets(1,1,1,1));
		um.setBounds(20, 215, 30, 25);
		paine.add(um);
		
		um.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")){
					visor.setText("1");
				}else{
					visor.setText(visor.getText() + "1");
					if(igual) {
						visor.setText("1");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		//NUM 2
		dois.setFont(new Font("Arial", Font.PLAIN, 12));
		dois.setMargin(new Insets(1,1,1,1));
		dois.setBounds(55, 215, 30, 25);
		paine.add(dois);
		
		dois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")) {
					visor.setText("2");
				}else {
					visor.setText(visor.getText() + "2");
					if(igual) {
						visor.setText("2");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		//NUM 3
		tres.setFont(new Font("Arial", Font.PLAIN, 12));
		tres.setMargin(new Insets(1,1,1,1));
		tres.setBounds(90, 215, 30, 25);
		paine.add(tres);
		
		tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")) {
					visor.setText("3");
				}else {
					visor.setText(visor.getText() + "3");
					if(igual) {
						visor.setText("3");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		//BTN MENOS
		btnfmenos.setFont(new Font("Arial", Font.PLAIN, 12));
		btnfmenos.setMargin(new Insets(1,1,1,1));
		btnfmenos.setBounds(125, 215, 30, 25);
		paine.add(btnfmenos);
		
		btnfmenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(visor.getText());
				sinal = "menos";
				visor.setText("0");
				
				if(igual) {
					visor.setText("0");
					igual=false;
				}
			}
		});
		
		//BTN IGUAL
		btnfigual.setFont(new Font("Arial", Font.PLAIN, 12));
		btnfigual.setMargin(new Insets(1,1,1,1));
		btnfigual.setBounds(160, 215, 30, 55);
		paine.add(btnfigual);
		btnfigual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor2 = Double.parseDouble(visor.getText());
				
				try {
					if(sinal.equals("soma")) {
						
						visor.setText(df.format(mat.soma(valor1, valor2)) + "");
						igual = true;
						
					}else if(sinal.equals("menos")) {
						
						visor.setText(df.format(mat.subtracao(valor1, valor2)) + "");
						igual = true;
						
					}else if(sinal.equals("multiplica")) {
						
						visor.setText(df.format(mat.multiplica(valor1, valor2)) + "");
						igual = true;
						
					}else if(sinal.equals("divide")) {
						
						visor.setText(df.format(mat.divisao(valor1, valor2)) + "");
						igual = true;
						
					}else if(sinal.equals("porcentagem")) {
						
						visor.setText(df.format(mat.divisao(valor1, valor2)) + "");
						igual = true;
						
					}
					
				}catch(NullPointerException e1) {
					
					visor.setText("0");
					System.out.println("Erro tratado: " + e1);
					
				}catch(NumberFormatException e1) { //Socorro, não está funcionanado, ME RESPEITA JAVA!
					
					visor.setText("Err");
					System.out.println("Erro tratado: " + e1);
					
				}
			}
		});
		
		//Sexta Fileira (fonte / margen / posição / add ao container(paine) / eventos)
		
		//NUM 0
		zero.setFont(new Font("Arial", Font.PLAIN, 12));
		zero.setMargin(new Insets(1,1,1,1));
		zero.setBounds(20, 245, 65, 25);
		paine.add(zero);
		
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(visor.getText().equals("0")) {
					visor.setText("0");
				}else {
					visor.setText(visor.getText() + "0");
					if(igual) {
						visor.setText("0");
						valor1 = 0;
						igual=false;
					}
				}
			}
		});
		
		//BTN VIRGULA
		btnvirgula.setFont(new Font("Arial", Font.PLAIN, 12));
		btnvirgula.setMargin(new Insets(1,1,1,1));
		btnvirgula.setBounds(90, 245, 30, 25);
		paine.add(btnvirgula);
		
		btnvirgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					visor.setText(visor.getText() + ".");
			}
		});
		
		//BTN MAIS
		btnfmais.setFont(new Font("Arial", Font.PLAIN, 12));
		btnfmais.setMargin(new Insets(1,1,1,1));
		btnfmais.setBounds(125, 245, 30, 25);
		paine.add(btnfmais);	
		btnfmais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(visor.getText());
				sinal = "soma";
				
				visor.setText("0");
				
				if(igual) {
					visor.setText("0");
					igual=false;
				}
				
			}
		});
		
		//Tamanho / Visibilidade / Redimensionar
		this.setSize(228, 322);
		this.setVisible(true);
		this.setResizable(false);
		
		
	}
	
	public static void limpaVisor(){
		
	}
	
	public static void main(String []args) {
		
		//Marcara exemplo
		/*Random r = new Random();
		int valor = r.nextInt(); 
		DecimalFormatSymbols simbolosDecimais = new DecimalFormatSymbols();
		simbolosDecimais.setDecimalSeparator(',');
		simbolosDecimais.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###,##0.00", simbolosDecimais);
		System.out.println(df.format(valor));
		System.out.println(valor);*/
		
		Calculadora calc = new Calculadora();
	}
}
