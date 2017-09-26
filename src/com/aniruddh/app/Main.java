package com.aniruddh.app;

import com.aniruddh.app.helpers.PopulateHelper;
import com.mongodb.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

/**
 * Created by Aniruddh on 26-09-2017.
 */
public class Main {
    private JLabel welcomeText;
    private JButton viewExisting;
    private JButton createNew;
    private JLabel optiontext;
    private JPanel panelMain;
    private JTable table;

    public Main() {
        viewExisting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopulateHelper populateTable = new PopulateHelper();
                DefaultTableModel data_table = populateTable.getData();
                table = new JTable(){
                    @Override
                    public Dimension getPreferredScrollableViewportSize() {
                        return new Dimension(1000, 300);
                    }
                };
                table.setModel(data_table);
                table.setFont(new Font("Verdana", Font.PLAIN, 14));
                table.setRowHeight(40);
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(new JScrollPane(table));
                JOptionPane.showMessageDialog(null, panel);
            }
        });
        createNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Create New");
                new NewEntry().open();
            }
        });
    }

    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Database Connectivity");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,250));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
