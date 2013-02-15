package br.unioeste.mips.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class MipsMonitorGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MipsMonitorGUI frame = new MipsMonitorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MipsMonitorGUI() {
		
		try {	/**Pegar variaveis de ambiente*/
	           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_execution = new JPanel();
		panel_execution.setBounds(12, 70, 972, 690);
		contentPane.add(panel_execution);
		panel_execution.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 45, 948, 633);
		panel_execution.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_status = new JPanel();
		panel_status.setBounds(12, 12, 972, 46);
		contentPane.add(panel_status);
		panel_status.setLayout(null);
		
		JLabel lblMipsMonocycleVirtual = new JLabel("MIPS monocycle Virtual Machine");
		lblMipsMonocycleVirtual.setBounds(12, 12, 948, 15);
		panel_status.add(lblMipsMonocycleVirtual);
	}
}
