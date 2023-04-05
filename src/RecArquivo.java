import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RecArquivo extends javax.swing.JFrame{
    private JTextField txNome;
    private JTextField txRua;
    private JTextField txNumero;
    private JTextField txBairro;
    private JButton btnGravar;
    private JPanel panelRec;
    private JComboBox cbFormato;

    public RecArquivo() {
        setContentPane(panelRec);
        setTitle("RecArquivo");

        //Fecha o visor
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //deixa setado o tamanho do visor
        setSize(310, 260);
        //impede a alteracao no tamanho do visor
        setResizable(false);
        //visor visivel
        setVisible(true);

        btnGravar.addActionListener(e -> {
            try {
                String entrega = "Dados da Entrega \n" + "Nome do Cliente: " + txNome.getText() + "\n" + "Rua: " + txRua.getText() + "\n" +
                        "Número: " + txNumero.getText() + "\n"+ "Bairro: " + txBairro.getText();

                byte [] buff = entrega.getBytes();

                if (cbFormato.getSelectedItem().equals("HTML")){
                    try {
                        RandomAccessFile raf = new RandomAccessFile("C:\\POO\\GravacaoArquivos\\teste.html", "rw");
                        raf.write(buff);


                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else if (cbFormato.getSelectedItem().equals("TXT")){
                    try {
                        RandomAccessFile raf = new RandomAccessFile("C:\\POO\\GravacaoArquivos\\teste.txt", "rw");
                        raf.write(buff);


                    }catch (IOException ex) {
                        ex.printStackTrace();

                    }
                }

                String mensagem = "Sucesso em gravar o arquivo. ";
                String titulo = "Sucesso.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);

            }catch (Exception ex){
                String mensagem = "Erro em gravar o arquivo. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
        cbFormato.addActionListener(e -> {
            String s = (String) cbFormato.getSelectedItem();
            JOptionPane.showMessageDialog(this, "O formato: " + s);
        });
    }
    public static void main(String[] args) {
        RecArquivo recArquivo = new RecArquivo();
    }
}
