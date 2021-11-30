package ui;

import Animals.AnimalKind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;

public class MainForm extends JFrame{
    private JPanel mainPanel;
    private JButton onlyUniqueButton;
    private JCheckBox checkBox1;
    private JButton buyCageButton;
    private JButton rmSelectedButton;
    private JPanel lowerPanel;
    private JPanel buttonPanel;
    private JLabel animalsNumLabel;
    private JLabel emptyNumLabel;
    private JLabel cagesNumLabel;
    private JList cagesList;

    public MainForm()
    {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        buyCageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyingWindow();
            }
        });
    }
    private void buyingWindow()
    {
        JFrame frame = new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComboBox<String> animalKindComboBox = new JComboBox<>();
        for(AnimalKind kind : AnimalKind.values())
        {
            animalKindComboBox.addItem(kind.toString());
        }
        frame.setLocationRelativeTo ( null );
        frame.add(animalKindComboBox);
        frame.pack();
        frame.setVisible(true);

        animalKindComboBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                JPanel addPanel = createAdditionalPanel(animalKindComboBox.getSelectedItem().toString());
                frame.add(addPanel, BorderLayout.SOUTH);
                frame.pack();
            }
        });
    }
    private JPanel createAdditionalPanel(String strKind)
    {
        JPanel addPanel = new JPanel();
        String a = strKind;
        addPanel.add(panelLabelEditable("Name"), BorderLayout.NORTH);
        addPanel.add(panelLabelEditable("Voice"), BorderLayout.NORTH);
        // addPanel.add(panelLabelLabel("Type", );
        addPanel.add(new JLabel("Class"), BorderLayout.NORTH);
        addPanel.add(new JLabel("Kind"), BorderLayout.NORTH);
        return addPanel;
    }
    private JPanel panelLabelEditable(String label_text)
    {
        JPanel labelEditable = new JPanel();
        JLabel label = new JLabel(label_text);
        labelEditable.add(label, BorderLayout.WEST);
        JTextField textField = new JTextField();
        textField.setSize(100, 200);
        labelEditable.add(textField, BorderLayout.EAST);

        return labelEditable;
    }

    private JPanel panelLabelLabel(String labelText1, String labelText2)
    {
        JPanel panelLabelLabel = new JPanel();
        panelLabelLabel.add(new JLabel(labelText1), BorderLayout.WEST);
        panelLabelLabel.add(new JLabel(labelText2), BorderLayout.EAST);

        return panelLabelLabel;
    }
}
