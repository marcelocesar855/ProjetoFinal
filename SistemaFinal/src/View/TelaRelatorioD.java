package View;

import Model.RelatD;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Controller.RelatDDAO;

/**
 *
 * @author Max
 */
public final class TelaRelatorioD extends javax.swing.JInternalFrame {

    String modoRelatD;

    /**
     * Creates new form TelaRelatorio
     */
    public TelaRelatorioD() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbl_relat_d.getModel();
        tbl_relat_d.setRowSorter(new TableRowSorter(modelo));

        //Recarregar a lista criada
        readRelatDiario();
        modoRelatD = "Navegar";
        ManipulaInterfaceRelatD();
    }

    public void readRelatDiario() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_relat_d.getModel();
        modelo.setNumRows(0);//Para que não duplique os valores ao inserir
        //Criando o objeto DAO para ser passado na nossa Jtabel
        RelatDDAO fdao = new RelatDDAO();

        //Ira pegar os valores que estão na lista e passando para o objeto
        for (RelatD Rd : fdao.read()) {
            modelo.addRow(new Object[]{
                 //Vao pegar os valores que estão no banco
                Rd.getId(),
                Rd.getData(),
                Rd.getQtdv(),
                Rd.getKm(),
                Rd.getQtdon(),
                Rd.getLucro()
            });
        }
    }

    public void ManipulaInterfaceRelatD() { //Manipulaçao da Tabela
        //Modo de operaçao dos botoes utilizados no projeto
        switch (modoRelatD) {

            case "Navegar":     //Somente o botao novo ira estar disponivel
                btn_relat_salvar.setEnabled(false);
                btn_relat_cancelar.setEnabled(false);
                c_relat_lucro.setEnabled(false);
                c_relat_data.setEnabled(false);
                c_relat_qtd_on.setEnabled(false);
                c_relat_qtdv.setEnabled(false);
                c_relat_km.setEnabled(false);
                btn_relat_novo.setEnabled(true);
                btn_relat_editar.setEnabled(false);
                btn_relat_excluir.setEnabled(false);
                break;

            case "Novo":    //Quando Apertado o botao Novo ira liberar os campos para o cadastro

                btn_relat_salvar.setEnabled(true);
                btn_relat_cancelar.setEnabled(true);
                c_relat_lucro.setEnabled(true);
                c_relat_data.setEnabled(true);
                c_relat_qtd_on.setEnabled(true);
                c_relat_qtdv.setEnabled(true);
                c_relat_km.setEnabled(true);
                btn_relat_novo.setEnabled(false);
                btn_relat_editar.setEnabled(false);
                btn_relat_excluir.setEnabled(false);
                break;

            case "Editar":

                btn_relat_salvar.setEnabled(true);
                btn_relat_cancelar.setEnabled(true);
                c_relat_lucro.setEnabled(true);
                c_relat_data.setEnabled(true);
                c_relat_qtd_on.setEnabled(true);
                c_relat_qtdv.setEnabled(true);
                c_relat_km.setEnabled(true);
                btn_relat_novo.setEnabled(true);
                btn_relat_editar.setEnabled(false);
                btn_relat_excluir.setEnabled(false);
                break;

            case "Excluir":

                btn_relat_salvar.setEnabled(false);
                btn_relat_cancelar.setEnabled(false);
                c_relat_lucro.setEnabled(false);
                c_relat_data.setEnabled(false);
                c_relat_qtd_on.setEnabled(false);
                c_relat_qtdv.setEnabled(false);
                c_relat_km.setEnabled(false);
                btn_relat_novo.setEnabled(true);
                btn_relat_editar.setEnabled(false);
                btn_relat_excluir.setEnabled(false);
                break;

            case "Selecao":
                //Os botões editar e exluir estaram disponiveis para fazer a alterção da tabela
                btn_relat_salvar.setEnabled(false);
                btn_relat_cancelar.setEnabled(false);
                c_relat_lucro.setEnabled(false);
                c_relat_data.setEnabled(false);
                c_relat_qtd_on.setEnabled(false);
                c_relat_qtdv.setEnabled(false);
                c_relat_km.setEnabled(false);
                btn_relat_novo.setEnabled(false);
                btn_relat_editar.setEnabled(true);
                btn_relat_excluir.setEnabled(true);
                break;

            default:
                System.out.println("Modo Invalido");

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_relat_d = new javax.swing.JTable();
        btn_relat_novo = new javax.swing.JButton();
        btn_relat_editar = new javax.swing.JButton();
        btn_relat_excluir = new javax.swing.JButton();
        cmd_print_relat = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        c_relat_data = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        c_relat_qtdv = new javax.swing.JTextField();
        btn_relat_salvar = new javax.swing.JButton();
        btn_relat_cancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        c_relat_km = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        c_relat_lucro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        c_relat_qtd_on = new javax.swing.JTextField();

        setClosable(true);

        tbl_relat_d.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_relat_d.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data", "Qtd Viagens", "KM", "Qtd Horas", "Lucro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_relat_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_relat_dMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_relat_d);

        btn_relat_novo.setText("Novo");
        btn_relat_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relat_novoActionPerformed(evt);
            }
        });

        btn_relat_editar.setText("Editar");
        btn_relat_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relat_editarActionPerformed(evt);
            }
        });

        btn_relat_excluir.setText("Excluir");
        btn_relat_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relat_excluirActionPerformed(evt);
            }
        });

        cmd_print_relat.setText("Imprimir");
        cmd_print_relat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_print_relatActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Inserir Dados"));

        jLabel5.setText("Data");

        c_relat_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_relat_dataActionPerformed(evt);
            }
        });

        jLabel10.setText("Quantidade de Viagens :");

        c_relat_qtdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_relat_qtdvActionPerformed(evt);
            }
        });

        btn_relat_salvar.setText("Salvar");
        btn_relat_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relat_salvarActionPerformed(evt);
            }
        });

        btn_relat_cancelar.setText("Cancelar");
        btn_relat_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relat_cancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("KM :");

        c_relat_km.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_relat_kmActionPerformed(evt);
            }
        });

        jLabel12.setText("Lucro :");

        c_relat_lucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_relat_lucroActionPerformed(evt);
            }
        });

        jLabel17.setText("Quantidade de Horas ON :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btn_relat_salvar)
                        .addGap(29, 29, 29)
                        .addComponent(btn_relat_cancelar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_relat_data, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(c_relat_qtdv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addComponent(c_relat_km, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(c_relat_lucro, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_relat_qtd_on, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_relat_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(c_relat_qtdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(c_relat_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_relat_lucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(c_relat_qtd_on, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_relat_salvar)
                    .addComponent(btn_relat_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_relat_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_relat_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_relat_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmd_print_relat)
                .addContainerGap(126, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_relat_novo)
                    .addComponent(btn_relat_excluir)
                    .addComponent(btn_relat_editar)
                    .addComponent(cmd_print_relat))
                .addGap(32, 32, 32)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relatorio Diario", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_relat_dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_relat_dMouseClicked

        //Se clicar em linha valida ele ira abrir o modo selecao
        if (tbl_relat_d.getSelectedRow() != -1) {

            c_relat_data.setText(tbl_relat_d.getValueAt(tbl_relat_d.getSelectedRow(), 1).toString());
            c_relat_qtdv.setText(tbl_relat_d.getValueAt(tbl_relat_d.getSelectedRow(), 2).toString());
            c_relat_km.setText(tbl_relat_d.getValueAt(tbl_relat_d.getSelectedRow(), 3).toString());
            c_relat_qtd_on.setText(tbl_relat_d.getValueAt(tbl_relat_d.getSelectedRow(), 4).toString());
            c_relat_lucro.setText(tbl_relat_d.getValueAt(tbl_relat_d.getSelectedRow(), 5).toString());
            modoRelatD = "Selecao";
            ManipulaInterfaceRelatD();

        }


    }//GEN-LAST:event_tbl_relat_dMouseClicked

    private void btn_relat_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relat_novoActionPerformed
        //Limpa os campos de inserção 
        c_relat_lucro.setText("");
        c_relat_data.setText("");
        c_relat_qtd_on.setText("");
        c_relat_qtdv.setText("");
        c_relat_km.setText("");
        modoRelatD = "Novo";
        ManipulaInterfaceRelatD();
    }//GEN-LAST:event_btn_relat_novoActionPerformed

    private void btn_relat_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relat_editarActionPerformed
        modoRelatD = "Editar";
        ManipulaInterfaceRelatD();
    }//GEN-LAST:event_btn_relat_editarActionPerformed

    private void btn_relat_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relat_excluirActionPerformed
        int resp = 0;
        resp = JOptionPane.showConfirmDialog(null, "Deseja Excluir ?");

        //        Pega a linha selecionada e exclui da tabela
        if ((tbl_relat_d.getSelectedRow() != -1) && (resp == JOptionPane.YES_OPTION)) {

            RelatD f = new RelatD();
            RelatDDAO dao = new RelatDDAO();

            f.setId((int) tbl_relat_d.getValueAt(tbl_relat_d.getSelectedRow(), 0));
            dao.delete(f);
            readRelatDiario();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
        //recarrega a tabela após a alteração
        readRelatDiario();
        modoRelatD = "Excluir";
        ManipulaInterfaceRelatD();
    }//GEN-LAST:event_btn_relat_excluirActionPerformed

    private void cmd_print_relatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_print_relatActionPerformed
        //Dara o titulo para seu relatorio
        MessageFormat header = new MessageFormat("Tabela Relatorio Diario");
        MessageFormat footer = new MessageFormat("Page{0,number,integer }");
        try {
            //Chama a tabela seleciona e atribui o titulo
            tbl_relat_d.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_cmd_print_relatActionPerformed

    private void c_relat_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_relat_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_relat_dataActionPerformed

    private void c_relat_qtdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_relat_qtdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_relat_qtdvActionPerformed

    private void btn_relat_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relat_salvarActionPerformed

        RelatD D = new RelatD();
        //Objeto DAO que sera inserido no banco de dados
        RelatDDAO dao = new RelatDDAO();

        if (modoRelatD.equals("Novo")) {
            /*Se for uma nova operação então ele vai pegar os dados que vão ser inseridos 
            e passar os dados para o objeto determinado */
            D.setData(c_relat_data.getText());
            D.setKm(Integer.parseInt(c_relat_km.getText()));
            D.setQtdon(Integer.parseInt(c_relat_qtd_on.getText()));
            D.setQtdv(Integer.parseInt(c_relat_qtdv.getText()));
            D.setLucro(Double.parseDouble(c_relat_lucro.getText()));
            dao.create(D);

        } else if (modoRelatD.equals("Editar")) {
            /*Caso a operação selecionada for "Editar" então a linha selecionada
            na tabela ira recarregar os valores para os campos para poderem ser editados*/
            D.setData(c_relat_data.getText());
            D.setKm(Integer.parseInt(c_relat_km.getText()));
            D.setQtdon(Integer.parseInt(c_relat_qtd_on.getText()));
            D.setQtdv(Integer.parseInt(c_relat_qtdv.getText()));
            D.setLucro(Double.parseDouble(c_relat_lucro.getText()));
            D.setId((int) tbl_relat_d.getValueAt(tbl_relat_d.getSelectedRow(), 0));
            dao.update(D);
        }
        readRelatDiario();
        modoRelatD = "Navegar";

        //Limpa os campos de inserção 
        c_relat_lucro.setText("");
        c_relat_data.setText("");
        c_relat_qtd_on.setText("");
        c_relat_qtdv.setText("");
        c_relat_km.setText("");
        ManipulaInterfaceRelatD();
    }//GEN-LAST:event_btn_relat_salvarActionPerformed

    private void btn_relat_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relat_cancelarActionPerformed
        //Limpa os campos de inserção 
        c_relat_lucro.setText("");
        c_relat_data.setText("");
        c_relat_qtd_on.setText("");
        c_relat_qtdv.setText("");
        c_relat_km.setText("");
        modoRelatD = "Navegar";
        ManipulaInterfaceRelatD();
    }//GEN-LAST:event_btn_relat_cancelarActionPerformed

    private void c_relat_kmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_relat_kmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_relat_kmActionPerformed

    private void c_relat_lucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_relat_lucroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_relat_lucroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_relat_cancelar;
    private javax.swing.JButton btn_relat_editar;
    private javax.swing.JButton btn_relat_excluir;
    private javax.swing.JButton btn_relat_novo;
    private javax.swing.JButton btn_relat_salvar;
    private javax.swing.JTextField c_relat_data;
    private javax.swing.JTextField c_relat_km;
    private javax.swing.JTextField c_relat_lucro;
    private javax.swing.JTextField c_relat_qtd_on;
    private javax.swing.JTextField c_relat_qtdv;
    private javax.swing.JButton cmd_print_relat;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_relat_d;
    // End of variables declaration//GEN-END:variables
}
