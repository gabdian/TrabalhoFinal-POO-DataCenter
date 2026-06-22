package telas;

import javax.swing.*;
import java.awt.*;

public class DashboardGUI {
    public void exibirTela(String textoRelatorio){
        JFrame frame = new JFrame("Painel de Controle - Data Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        JTextArea areaTexto = new JTextArea();
        areaTexto.setText(textoRelatorio);
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 14));
        areaTexto.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scroll = new JScrollPane(areaTexto);
        JButton btnSair = new JButton("encerrar Sistema");
        btnSair.addActionListener(e -> System.exit(0));
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(btnSair, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
