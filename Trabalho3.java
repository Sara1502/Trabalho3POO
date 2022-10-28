<code>import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

public class Main {

    private static final List&lt;Tarefa&gt; listaTarefas = new ArrayList&lt;&gt;();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista de Tarefas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(createGUI());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JComponent createGUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        panel.add(createNovaTarefa());
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createListaTarefas());
        panel.add(Box.createVerticalGlue());
        return panel;
    }

    private static JComponent createNovaTarefa() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(createLabelTarefa());
        panel.add(createCampoTarefa());
        panel.add(createBotaoAdicionar());
        return panel;
    }

    private static JLabel createLabelTarefa() {
        JLabel label = new JLabel("Tarefa:");
        label.setFont(new Font(null, Font.BOLD, 16));
        return label;
    }

    private static JTextField createCampoTarefa() {
        JTextField campoTarefa = new JTextField(20);
        campoTarefa.setMaximumSize(campoTarefa.getPreferredSize());
        return campoTarefa;
    }

    private static JButton createBotaoAdicionar() {
        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.setPreferredSize(new Dimension(150, 30));
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaTarefas.add(new Tarefa("Tarefa", "Descricao", false));
            }
        });
        return botaoAdicionar;
    }

    private static JComponent createListaTarefas() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(createTabelaTarefas()), BorderLayout.CENTER);
        panel.setBorder(new javax.swing.border.TitledBorder("Lista de Tarefas"));
        return panel;
    }

    private static JList&lt;Tarefa&gt; createTabelaTarefas() {
        JList&lt;Tarefa&gt; listaTarefas = new JList&lt;&gt;(Main.listaTarefas.toArray(new Tarefa[0]));
        listaTarefas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTarefas.setCellRenderer(new TarefaCellRenderer());
        return listaTarefas;
    }

    private static class TarefaCellRenderer implements ListCellRenderer&lt;Tarefa&gt; {

        private final JPanel panel;

        public TarefaCellRenderer() {
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(Box.createVerticalGlue());
            panel.add(createTarefaPanel());
            panel.add(Box.createRigidArea(new Dimension(0, 5)));
            panel.add(createDescricaoPanel());
            panel.add(Box.createVerticalGlue());
        }

        private JComponent createTarefaPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            panel.add(Box.createHorizontalGlue());
            panel.add(createLabelTarefa());
            panel.add(Box.createRigidArea(new Dimension(5, 0)));
            panel.add(createCampoTarefa());
            panel.add(Box.createHorizontalGlue());
            return panel;
        }

        private JLabel createLabelTarefa() {
            JLabel label = new JLabel("Tarefa:");
            label.setFont(new Font(null, Font.BOLD, 16));
            return label;
        }

        private JTextField createCampoTarefa() {
            JTextField campoTarefa = new JTextField(20);
            campoTarefa.setMaximumSize(campoTarefa.getPreferredSize());
            campoTarefa.setEditable(false);
            return campoTarefa;
        }

        private JComponent createDescricaoPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            panel.add(Box.createHorizontalGlue());
            panel.add(createLabelDescricao());
            panel.add(Box.createRigidArea(new Dimension(5, 0)));
            panel.add(createCampoDescricao());
            panel.add(Box.createHorizontalGlue());
            return panel;
        }

        private JLabel createLabelDescricao() {
            JLabel label = new JLabel("Descricao:");
            label.setFont(new Font(null, Font.BOLD, 16));
            return label;
        }

        private JTextField createCampoDescricao() {
            JTextField campoDescricao = new JTextField(20);
            campoDescricao.setMaximumSize(campoDescricao.getPreferredSize());
            campoDescricao.setEditable(false);
            return campoDescricao;
        }

        @Override
        public Component getListCellRendererComponent(JList&lt;? extends Tarefa&gt; list, Tarefa value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value != null) {
                JTextField campoTarefa = (JTextField) panel.getComponent(1);
                campoTarefa.setText(value.getTarefa());
                JTextField campoDescricao = (JTextField) panel.getComponent(3);
                campoDescricao.setText(value.getDescricao());
            }
            return panel;
        }
    }

    private static class Tarefa {

        private final String tarefa;
        private final String descricao;
        private final boolean finalizada;

        public Tarefa(String tarefa, String descricao, boolean finalizada) {
            this.tarefa = tarefa;
            this.descricao = descricao;
            this.finalizada = finalizada;
        }

        public String getTarefa() {
            return tarefa;
        }

        public String getDescricao() {
            return descricao;
        }

        public boolean isFinalizada() {
            return finalizada;
        }
    }
}
</code>
