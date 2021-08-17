package util;

import javax.swing.JOptionPane;

/**
 * Classa para criar as tabelas mapeadas no banco de dados
 * @author Renato Dias
 * @since Mar 17, 2021
 * @version 1.0
 */
public class GeraTabela {
    
    public static void main(String[] args) {
        
        HibernateUtil.getSessionFactory().openSession();
        JOptionPane.showMessageDialog(null, "Tabelas criadas");
        System.exit(0);
        
    }

}
