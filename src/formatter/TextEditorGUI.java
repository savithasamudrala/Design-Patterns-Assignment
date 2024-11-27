package formatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TextEditorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Formatter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JTextArea textArea = new JTextArea(10, 40);
        JComboBox<String> formatSelector = new JComboBox<>(new String[]{"Plain Text", "HTML", "Markdown", "JSON"});
        JButton saveButton = new JButton("Save");

        JLabel statusLabel = new JLabel("Status: Ready");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(new JLabel("Select Format:"));
        bottomPanel.add(formatSelector);
        bottomPanel.add(saveButton);

        panel.add(bottomPanel, BorderLayout.SOUTH);
        panel.add(statusLabel, BorderLayout.NORTH);

        frame.add(panel);
        frame.setVisible(true);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFormat = (String) formatSelector.getSelectedItem();
                ArrayList<String> content = new ArrayList<>();
                for (String line : textArea.getText().split("\\n")) {
                    content.add(line);
                }

                TextFile file = new TextFile(content);
                switch (selectedFormat) {
                    case "Plain Text":
                        file.setFormat(new PlainTextFormat());
                        break;
                    case "HTML":
                        file.setFormat(new HTMLFormat());
                        break;
                    case "Markdown":
                        file.setFormat(new MarkdownFormat());
                        break;
                    case "JSON":
                        file.setFormat(new JSONFormat());
                        break;
                }

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getPath();
                    file.save(filePath);
                    statusLabel.setText("Status: File saved successfully!");
                } else {
                    statusLabel.setText("Status: Save cancelled.");
                }
            }
        });
    }
}
