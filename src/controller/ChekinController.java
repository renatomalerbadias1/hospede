package controller;


import dao.ChekinDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Chekin;
import util.Mensagem;

import view.ChekinView;

/**
 * classe para armazenar processos de tela e banco de dados do aluno
 *
 * @author renato dias
 */
public class ChekinController {

    // atributo para manipular tela
    private ChekinView tela;
    // lista de alunos para preencher tabela, alterar e excluir
    private ArrayList<Chekin> listaChekins;
    // objeto aluno para incluir ou alterar
    private Chekin chekin;
    // flag para controlar a opção de incluir ou alterar
    private boolean alterar = false;

   
    public ChekinController() {
    }
    
    //construto para valorizar obj tela
    public ChekinController(ChekinView tela) {
        this.tela = tela;
    }
    

   /*
     * método para acessar Classe DAO e inserir um registro na tabela aluno
     */
    public void inserir(Chekin chekin) {
        ChekinDAO dao = new ChekinDAO();
        try {
            // inserindo registro na tabela
            dao.salvar(chekin);
            // mensagem de sucesso
           JOptionPane.showMessageDialog(tela, "cadstaro com sucesso");
        } catch (Exception ex) {
            // mensagem de erro
            JOptionPane.showMessageDialog(tela, " erro ao cadstaro ");
        }
    }
   

    /*
     * método para acessar Classe DAO e alterar um registro na tabela aluno
     */
    public void alterar(Chekin chekin) {
        // objeto para manipular o registro
        ChekinDAO dao = new ChekinDAO();
        try {
            // alterando registro na tabela
            dao.salvar(chekin);
            // mensagem de sucesso
             JOptionPane.showMessageDialog(tela, "alterado com sucesso");
        } catch (Exception ex) {
  
            // mensagem de erro
            JOptionPane.showMessageDialog(tela, " erro ao cadstaro ");
        }
    }

   /*
     * método para acessar Classe DAO e excluir um registro na tabela aluno
     */
    public void excluir(Chekin chekin) {
        // objeto para manipular o registro
        ChekinDAO dao = new ChekinDAO();
        try {
            // excluindo registro na tabela
            dao.excluir(chekin);
            // mensagem de sucesso
           JOptionPane.showMessageDialog(tela, "excluido com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tela, "erro excluido ");
            // mensagem de erro
             
        }
    }

   /*
     * método para consultar os alunos cadastrados na tabela
     */
    public ArrayList<Chekin> buscarTodos() {
        // objeto para manipular o registro
        ChekinDAO dao = new ChekinDAO();
        ArrayList<Chekin> chekins = null;

    
        try {
            chekins = dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ChekinController.class.getName()).log(Level.SEVERE, null, ex);
            // mensagem de erro
            Mensagem.erroConsultarAluno();
        }
        return chekins;
    }

    
    /*
    METODO PARA CONTROLAR AÇÃO BOTOA NOVO
    */
    public void botaoNovo(){
       // bloqueando botoes de opção
        tela.getTfNome().setEditable(false);
      tela.getTfIdade().setEditable(false);
      tela.getTfCidade().setEditable(false);
      tela.getjTextFieldTelefone().setEditable(false);
      tela.getjTextFieldDocumento().setEditable(false);
      tela.getjTextFieldValor().setEditable(false);
      tela.getButtonGroup1().setSelected(null, false);
      
      tela.getBtSalvar().setEnabled(false);
      tela.getBtCancelar().setEnabled(false);
      
       tela.getTfNome().setEditable(true);
      tela.getTfIdade().setEditable(true);
      tela.getTfCidade().setEditable(true);
       tela.getjTextFieldTelefone().setEditable(true);
      tela.getjTextFieldDocumento().setEditable(true);
      tela.getjTextFieldValor().setEditable(true);
      tela.getButtonGroup1().setSelected(null, true);
      
      tela.getBtSalvar().setEnabled(true);
      tela.getBtCancelar().setEnabled(true); 
      
      alterar =false;
      
      chekin = new Chekin();//inicia um novo obj 
        
    }//fim metodo botao novo
    
    /*
    METODO PARA CONTROLAR AÇÃO BOTOA alterar
    */
    public void botaoAlterar(){
        
       alterar = true; //altera flag
           //verificando se foi selecionado algun registro   
        if (tela.getTabela().getSelectedRow()< 0) {
            JOptionPane.showMessageDialog(null,"selecione hospede","hospede",0);
            
        }else{
            chekin = listaChekins.get(tela.getTabela().getSelectedRow());
            carregarTela(chekin);
            bloqueioAlterar();
            
        }
        
    }//fim metodo botao alterar
    
    /*
    METODO PARA CONTROLAR AÇÃO BOTOA excluir
    */
    public void botaoExcluir(){
        
           //verificando se foi selecionado algun registro   
        if (tela.getTabela().getSelectedRow()< 0) {
            JOptionPane.showMessageDialog(null,"selecione hospede","hospede",0);
            
        }else{
            //inicializando o obj alunono com o aluno da tabela
            chekin = listaChekins.get(tela.getTabela().getSelectedRow());
            
            int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que vai Excluir","hospede",JOptionPane.YES_OPTION,JOptionPane.CANCEL_OPTION);
            
            
            if (opcao == JOptionPane.YES_OPTION) {
                excluir(chekin);//excluindo registro
                
                carregarTabela();
                
            }
        }
        
        
    }//fim metodo botao excluir
    
    /*
    /*
     * método para controlar ação do botão SAIR
     */
    public void botaoSair() {
        int option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair do Sistema", JOptionPane.YES_NO_OPTION);
        if (option == 0) {
             tela.dispose();
        }
    }
    /*
    METODO PARA CONTROLAR AÇÃO BOTOA salva
    */
    public void botaoSalvar(){
        
        //verificando a opção de incluir ou alterar
        if (alterar) {        
            //procedimento de alterarr              
                alterar(getchekinAlterar());
                botaoCancelar();//limpar a tela e bloquear os campos
                carregarTabela();//carregar tabela         
        }else{
            //procedimento de inclusao         
                //inserindo registro na tabela
                inserir(getChekinInserir());            
                botaoCancelar();  
               carregarTabela();         
        }
        
    }//fim metodo botao salvar
    
    /*
    METODO PARA CONTROLAR AÇÃO BOTOA cancelar
    */
    public void botaoCancelar(){
        
        // desbloqueando
        tela.getTfNome().setEditable(true);
      tela.getTfIdade().setEditable(true);
      tela.getTfCidade().setEditable(true);
      tela.getBtSalvar().setEnabled(true);
      tela.getBtCancelar().setEnabled(true);
      tela.getjTextFieldTelefone().setEditable(!false);
      tela.getjTextFieldDocumento().setEditable(!false);
      tela.getjTextFieldValor().setEditable(!false);
      tela.getButtonGroup1().setSelected(null, !false);
      
       tela.getTfNome().setEditable(false);
      tela.getTfIdade().setEditable(false);
      tela.getTfCidade().setEditable(false);
      tela.getjTextFieldTelefone().setEditable(false);
      tela.getjTextFieldDocumento().setEditable(false);
      tela.getjTextFieldValor().setEditable(false);
      tela.getButtonGroup1().setSelected(null, false);
      
      tela.getBtSalvar().setEnabled(false);
      tela.getBtCancelar().setEnabled(false); 
        
      limparTela();
        
    }//fim metodo botao cancelar
    
    
    /*
    *metodo para bloqueio inicial dos objetos
    */
    public void bloqueioInicial(){
        
        //desabilitando textField
          tela.getTfNome().setEditable(false);
      tela.getTfIdade().setEditable(false);
      tela.getTfCidade().setEditable(false);
      tela.getjTextFieldTelefone().setEditable(false);
      tela.getjTextFieldDocumento().setEditable(false);
      tela.getjTextFieldValor().setEditable(false);
      tela.getButtonGroup1().setSelected(null, false);
      tela.getBtSalvar().setEnabled(false);
      tela.getBtCancelar().setEnabled(false);
      
        
        
        
    }//fim metodo bloqueio
    
    /*
    *metodo para limpar os campos da tela
    */
    private void limparTela(){
        
        tela.getTfIdade().setText(null);
        tela.getTfNome().setText(null);
        tela.getTfCidade().setText(null);
        tela.getjTextFieldTelefone().setText(null);
       tela.getjTextFieldDocumento().setText(null);
      tela.getjTextFieldValor().setText(null);
   
        
    }//fim metodo limpar
    
    
    
    /*
    *metodo para carregar a tabela de aluno
    */
    public void carregarTabela(){
        //capturando o modelo da tabela
        DefaultTableModel modelo = (DefaultTableModel) tela.getTabela().getModel();
        
        modelo.setRowCount(0);//inicia as linhas da tabela
        
        //carregando lista de alunos
        listaChekins = buscarTodos();
        
        
        //laço para preenxer a
        for (Chekin chekin: listaChekins) {        
        
       // laço de repetiçaõ pra preencher as linhas da tabela   
            modelo.addRow(new String[] {chekin.getNome(), chekin.getDataEntrada()+"", chekin.getDataSaida()+"",chekin.getValor()+""});
        }
    }//fim carregar tabela
    
   
    
   
    
    /*
    meto 
    */
    private Chekin getChekinInserir(){
        
        chekin .setNome(tela.getTfNome().getText());
        chekin .setDataEntrada(tela.getTfIdade().getText());
        chekin .setDataSaida(tela.getTfCidade().getText());
        chekin.setNomedocumento(tela.getjTextFieldDocumento().getText());
        chekin.setTelefone(tela.getjTextFieldTelefone().getText());
        chekin.setValor(tela.getjTextFieldValor().getText());
       
        return chekin ;
       
    }//fim metodo
     /**
      * carregar tela
      */       
    private void carregarTela(Chekin chekin){
        
        tela.getTfNome().setText(chekin.getNome());
        tela.getTfIdade().setText(chekin.getDataEntrada()+"");
        tela.getTfCidade().setText(chekin.getDataSaida()+"");
        tela.getjTextFieldDocumento().setText(chekin.getNomedocumento()+"");
        tela.getjTextFieldTelefone().setText(chekin.getTelefone()+"");
        tela.getjTextFieldValor().setText(chekin.getValor()+"");
        
    }//fim metodo carregar tela
    
    /**
     * metodo para bloquear os campos de opção alterar
     */
    private void bloqueioAlterar(){
        
        // bloqueando botoes de opção
        tela.getBtNovo().setEnabled(false);
        tela.getBtAlterar().setEnabled(false);
      tela.getBtExcluir().setEnabled(false);
      tela.getBtSair().setEnabled(true);
       tela.getTfCidade().setEditable(true);
       
       tela.getBtSalvar().setEnabled(true);
        tela.getBtCancelar().setEnabled(true);
         tela.getTfCidade().grabFocus();
       
      
      
        
    }//fim metodo bloqueioAlterar
    
    /**
     * metodo para retornar obj aluno para alteração
     */
    private Chekin getchekinAlterar(){
        
        chekin .setDataEntrada(tela.getTfIdade().getText());
        chekin .setDataSaida(tela.getTfIdade().getText());
      
        
        return chekin;
        
    }
}//fim da classe
