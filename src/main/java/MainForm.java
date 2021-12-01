import Animals.Animal;
import Animals.AnimalKind;
import Animals.BAnimal;
import Animals.Zoo;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Vector;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JButton onlyUniqueButton;
    private JCheckBox onlyUniqueCheckBox;
    private JButton buyCageButton;
    private JButton rmSelectedButton;
    private JPanel lowerPanel;
    private JPanel buttonPanel;

    private JLabel animalsNumLabel;
    private JLabel emptyNumLabel;
    private JLabel cagesNumLabel;
    private JLabel selectedNumLabel;
    private int numberSelected;

    private JTable animalTable;

    JComboBox<String> myAnimalKindComboBox;
    private Zoo zoo;
    private DefaultTableModel animalTableModel;

    Vector<int[]> selectedRows;
    boolean pressingCTRL = false;

    public MainForm()
    {
        super();
        selectedRows = new Vector<int[]>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        zoo = new Zoo();

        createComboBox();
        createTable();

        buyCageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoo.buyCage();
                buyingWindow();
            }
        });
        rmSelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    private void buyingWindow()
    {
        JFrame frame = new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo ( null );
        frame.add(myAnimalKindComboBox);
        frame.pack();
        frame.setVisible(true);

        myAnimalKindComboBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(myAnimalKindComboBox.getSelectedIndex() != 0)
                {
                    JPanel addPanel = createAdditionalPanel((String) myAnimalKindComboBox.getSelectedItem());
                    frame.add(addPanel, BorderLayout.SOUTH);
                    frame.pack();
                }
            }
        });
    }
    private JPanel createAdditionalPanel(String strKind)
    {
        Animal animal = Objects.requireNonNull(BAnimal.build(strKind)).getMyCagedAnimal();
        GridLayout grid = new GridLayout(7, 1);
        JPanel addPanel = new JPanel(grid);

        JCheckBox createEmptyBox = new JCheckBox();
        createEmptyBox.setText("Create Empty");
        
        JPanel namePanelEditable = panelLabelEditable("Name: ");
        addPanel.add(namePanelEditable);
        JPanel voicePanelEditable = panelLabelEditable("Voice: ");
        addPanel.add(voicePanelEditable);
        
        JTextField nameEditable = (JTextField)namePanelEditable.getComponent(1);
        JTextField voiceEditable = (JTextField)voicePanelEditable.getComponent(1);
        
        addPanel.add(panelLabelLabel("Kind: ", strKind));
        addPanel.add(panelLabelLabel("Type: ", animal.getType().toString()));
        addPanel.add(panelLabelLabel("Class: ", animal.get_class().toString()));

        JPanel panelAddCancel = new JPanel(new GridLayout(1, 2));
        JButton add = new JButton("Add");
        JButton cancel = new JButton("Cancel");

        panelAddCancel.add(add);
        panelAddCancel.add(cancel);

        nameEditable.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                animal.setName(nameEditable.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                animal.setName(nameEditable.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                animal.setName(nameEditable.getText());
            }

        });

        voiceEditable.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                animal.setVoice(voiceEditable.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                animal.setVoice(voiceEditable.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                animal.setVoice(voiceEditable.getText());
            }
        });

        add.addActionListener(e -> {
            if(zoo.isFull())
            {
                zoo.buyCage();
            }
            if(!createEmptyBox.isSelected())
            {
                zoo.addAnimal(animal);
                animalTableModel.addRow(new Object[] {true, animal.getKind().toString(),
                        animal.getName(), animal.getVoice()});
                animalsNumLabel.setText("Animals: " + zoo.getRealAnimals());
                cagesNumLabel.setText("Cages: " + zoo.getCagesNum());
            }
            else
            {
                zoo.addAnimal(BAnimal.build(AnimalKind.NoKind).getMyCagedAnimal());
                animalTableModel.addRow(new Object[] {true, AnimalKind.NoKind.toString(),
                        " ", " "});
                animalsNumLabel.setText("Animals: " + zoo.getRealAnimals());
                cagesNumLabel.setText("Cages: " + zoo.getCagesNum());
                emptyNumLabel.setText("Empty: " + (zoo.getCagesNum() - zoo.getRealAnimals()));
            }
        });
        addPanel.add(createEmptyBox);
        addPanel.add(panelAddCancel);
        return addPanel;
    }

    private JPanel panelLabelEditable(String label_text)
    {
        JPanel labelEditable = new JPanel();
        JLabel label = new JLabel(label_text);
        labelEditable.add(label, BorderLayout.WEST);
        JTextField textField = new JTextField(10);
        textField.setSize(100, 200);
        labelEditable.add(textField, BorderLayout.EAST);

        return labelEditable;
    }

    private JPanel panelLabelLabel(String labelText1, String labelText2)
    {
        JPanel panelLabelLabel = new JPanel();
        JTextField textField = new JTextField(10);
        textField.setText(labelText2);
        textField.setEditable(false);
        panelLabelLabel.add(new JLabel(labelText1), BorderLayout.WEST);
        panelLabelLabel.add(textField, BorderLayout.EAST);

        return panelLabelLabel;
    }

    private void createTable()
    {
        String[] cagedAnimalsHeaders = {" ", "Kind", "Name", "Voice", "Additional Info"};

        animalTableModel = new DefaultTableModel(null, cagedAnimalsHeaders) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1 && (animalTable.getValueAt(row, column) == AnimalKind.NoKind.toString() ||
                        animalTable.getValueAt(row, column) == " ") ||
                        (column == 2 && animalTable.getValueAt(row, column) == " ") ||
                        (column == 3 && animalTable.getValueAt(row, column) == " ") ||
                        column == 0;
            }
        };

        animalTable.setModel(animalTableModel);
        animalTable.getColumnModel().getColumn(0).setMaxWidth(25);
        animalTable.getColumnModel().getColumn(1).setMaxWidth((mainPanel.getWidth() - 25) / 6);
        animalTable.getColumnModel().getColumn(2).setMaxWidth((mainPanel.getWidth() - 25) / 6);
        animalTable.getColumnModel().getColumn(3).setMaxWidth((mainPanel.getWidth() - 25) / 6);
        animalTable.getColumnModel().getColumn(4).setMaxWidth((mainPanel.getWidth() - 25) / 2);

        animalTable.setRowSelectionAllowed(true);
        animalTable.setColumnSelectionAllowed(false);

        animalTable.getSelectionModel().addListSelectionListener(e -> {
            selectedRows.clear();
            selectedRows.add(animalTable.getSelectedRows());
            selectedNumLabel.setText("Selected: " + selectedRows.size());
        });

        animalTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(myAnimalKindComboBox));
    }

    private void createComboBox()
    {
        myAnimalKindComboBox = new JComboBox<>();
        myAnimalKindComboBox.insertItemAt(" ", 0);
        for(AnimalKind kind : AnimalKind.values())
        {
            if(kind == AnimalKind.NoKind)
            {
                continue;
            }
            myAnimalKindComboBox.addItem(kind.toString());
        }
    }
}
