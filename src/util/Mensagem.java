package util;

import javax.swing.JOptionPane;

/**
 * Classa para armazenar as mensagens utilizadas no sistema
 *
 * @author Renato Dias
 * @since Mar 16, 2021
 * @version 1.0
 */
public class Mensagem {

    // MENSAGENS DE SUCESSO
    public static void sucessoAlterarProfessor() {
        JOptionPane.showMessageDialog(null, "Professor Alterado com sucesso", Titulo.inserirProfessor, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void sucessoCadastroProfessor() {
        JOptionPane.showMessageDialog(null, "Professor Inserido com sucesso", Titulo.inserirProfessor, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void sucessoCadastroAluno() {
        JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso", Titulo.inserirAluno, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void sucessoAlterarAluno() {
        JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso", Titulo.alterarAluno, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void sucessoExcluirAluno() {
        JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso", Titulo.excluirAluno, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void sucessoExcluirProfessor() {
        JOptionPane.showMessageDialog(null, "Professor excluido com sucesso", Titulo.inserirProfessor, JOptionPane.INFORMATION_MESSAGE);
    }

    // MENSAGENS DE ERRO
    public static void erroAlterarProfessor() {
        JOptionPane.showMessageDialog(null, "Erro ao alterar Professor", Titulo.inserirProfessor, JOptionPane.ERROR_MESSAGE);
    }
   
    public static void erroCadastroProfessor() {
        JOptionPane.showMessageDialog(null, "Erro ao inserir Professor", Titulo.inserirProfessor, JOptionPane.ERROR_MESSAGE);
    }
    public static void erroCadastroAluno() {
        JOptionPane.showMessageDialog(null, "Erro ao inserir Aluno", Titulo.inserirAluno, JOptionPane.ERROR_MESSAGE);
    }

    public static void erroAlterarAluno() {
        JOptionPane.showMessageDialog(null, "Erro ao alterar Aluno", Titulo.alterarAluno, JOptionPane.ERROR_MESSAGE);
    }

    public static void erroExcluirAluno() {
        JOptionPane.showMessageDialog(null, "Erro ao excluir Aluno", Titulo.excluirAluno, JOptionPane.ERROR_MESSAGE);
    }

    public static void erroConsultarAluno() {
        JOptionPane.showMessageDialog(null, "Erro ao consultar Alunos", Titulo.consultarAluno, JOptionPane.ERROR_MESSAGE);
    }
    public static void erroConsultarProfessor() {
        JOptionPane.showMessageDialog(null, "Erro ao consultar Professor", Titulo.consultarProfessor, JOptionPane.ERROR_MESSAGE);
    }
    public static void erroSelecionarProfessor() {
        JOptionPane.showMessageDialog(null, "Erro ao selecionar Professor", Titulo.consultarProfessor, JOptionPane.ERROR_MESSAGE);
    }
      
    // MENSAGENS CAMPO OBRIGATORIO
    public static void erroCampoNomeIncluir() {
        JOptionPane.showMessageDialog(null, "Informe o nome, campo obrigatório!", Titulo.inserirAluno, JOptionPane.ERROR_MESSAGE);
    }

    public static void erroCampoIdadeIncluir() {
        JOptionPane.showMessageDialog(null, "Informe a idade, campo obrigatório!", Titulo.inserirAluno, JOptionPane.ERROR_MESSAGE);
    }

    public static void erroCampoCidadeIncluir() {
        JOptionPane.showMessageDialog(null, "Informe a cidade, campo obrigatório!", Titulo.inserirAluno, JOptionPane.ERROR_MESSAGE);
    }
    public static void erroCampoSexoincluir() {
        JOptionPane.showMessageDialog(null, "Informe o sexo, campo obrigatório!", Titulo.inserirProfessor, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void erroCampoCidadeAlterar() {
        JOptionPane.showMessageDialog(null, "Informe a cidade, campo obrigatório!", Titulo.alterarAluno, JOptionPane.ERROR_MESSAGE);
    }
    public static void erroCampoSexoAlterar() {
        JOptionPane.showMessageDialog(null, "Informe o Sexo, campo obrigatório!", Titulo.inserirProfessor, JOptionPane.ERROR_MESSAGE);
    }
    public static void erroCampoDataNscimentoIncluir() {
        JOptionPane.showMessageDialog(null, "Informe a Data de Nascimento, campo obrigatório!", Titulo.inserirProfessor, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void erroSelecionarAluno() {
        JOptionPane.showMessageDialog(null, "Selecine um aluno para alterar!", Titulo.alterarAluno, JOptionPane.ERROR_MESSAGE);
    }
    
    public static int excluirAluno() {
        return JOptionPane.showConfirmDialog(null, "Tem certeza que deseja exluir?", Titulo.excluirAluno, JOptionPane.YES_OPTION);
    }
   
    public static int excluirProfessor() {
        return JOptionPane.showConfirmDialog(null, "Tem certeza que deseja exluir?", Titulo.excluirProfessor, JOptionPane.YES_OPTION);
    }
   
}
