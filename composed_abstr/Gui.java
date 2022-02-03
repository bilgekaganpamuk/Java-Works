package chap_02.composed_abstr;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Zakladni graficke rozhrani aplikace
 * 
 */
@SuppressWarnings("serial")
public final class Gui extends javax.swing.JFrame {
	private static Gui gui;
	private JMenuBar menuBar;
	private BaseCanvas plocha;
	private JFileChooser fileChooser;
	private JMenuItem otevriMenuItem;
	private JMenuItem konecMenuItem;
	private JMenu souborMenu;

	//private Galpr galpr;

	/**
	 * Konstruktor
	 */
	private Gui() {
		super();
		initGUI();
		setVisible(true);
		//galpr = new Galpr(this);
		//galpr.start();
	}
	
	public static Gui getInstance() {
		if(gui == null) {
			gui = new Gui();
			gui.setVisible(true);
		}
		return gui;
	}
	/*
	public void setGalpr(Galpr g){
		galpr = g;		
	}
   */
	/**
	 * Inicializace GUI
	 */
	private void initGUI() {
		// JFrame
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Gazro");
		this.setSize(906, 597);

		// canvas
		plocha = new BaseCanvas(this.getSize().width, this.getSize().height);
		
		getContentPane().add(plocha, java.awt.BorderLayout.CENTER);
		plocha.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent evt) {
				plochaMouseReleased(evt);
			}
		});

		// FileChooser
		fileChooser = new JFileChooser();
		FileFilter filter = new FileFilter() {
			public boolean accept(java.io.File file) {
				return file.getName().toLowerCase().endsWith(".sbm") || file.isDirectory() ||
					file.getName().toLowerCase().endsWith(".jpg")||
					file.getName().toLowerCase().endsWith(".jpeg")||
					file.getName().toLowerCase().endsWith(".bmp")||
					file.getName().toLowerCase().endsWith(".gif")||
					file.getName().toLowerCase().endsWith(".png");
			}
			public String getDescription() {
				return "Obr�zky";
			}
		};
		fileChooser.setFileFilter(filter);

		// Menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		souborMenu = new JMenu();
		souborMenu.setText("Soubor");
		souborMenu.getPopupMenu().setLightWeightPopupEnabled(false);
		menuBar.add(souborMenu);
		
		otevriMenuItem = new JMenuItem();
		souborMenu.add(otevriMenuItem);
		otevriMenuItem.setText("Otev�i obr�zek");
		otevriMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				otevriMenuItemActionPerformed(evt);
			}
		});

		konecMenuItem = new JMenuItem();
		souborMenu.add(konecMenuItem);
		konecMenuItem.setText("Konec");
		konecMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				konecMenuItemActionPerformed(evt);
			}
		});

		pack();
	}

	/**
	 * P��stup k menu
	 * 
	 * @return Menu
	 */
	public JMenuBar getMenu() {
		return menuBar;
	}

	/**
	 * P��stup ke canvasu
	 * 
	 * @return Canvas
	 */
	public BaseCanvas getCanvas() {
		return plocha;
	}

	/**
	 * Odchycen� ud�losti Soubor/Otev�i SBM
	 * 
	 * @param Event
	 */
	private void otevriMenuItemActionPerformed(ActionEvent evt) {
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
			plocha.loadPicture(fileChooser.getSelectedFile());
	}

	/**
	 * Odchycen� ud�losti Soubor/Konec
	 * 
	 * @param Event
	 */
	private void konecMenuItemActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	/**
	 * Odchycen� skisku my�i na plochu
	 * 
	 * @param Event
	 */
	private void plochaMouseReleased(MouseEvent evt) {
		//galpr.mousePressed(evt.getX(), evt.getY(), evt.getButton());
	}

}
