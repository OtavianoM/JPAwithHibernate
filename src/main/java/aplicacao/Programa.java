package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

    public static void main(String[] args) {

//        // Post apenas com Objeto
//        Pessoa pessoa1 = new Pessoa(null, "Otaviano", "otaviano@gmail.com");
//        Pessoa pessoa2 = new Pessoa(null, "Maria", "maria@gmail.com");
//        Pessoa pessoa3 = new Pessoa(null, "Jose", "jose@gmail.com");


        // Estancia a conexão com o banco de dados, apontando para o persistence.xml
        // E permitindo o EntityManager iniciar a conexão
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("exemplo-jpa");

        // Inicia a conexão com o banco de dados e permite o DML com o banco.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        // Iniciando DML
//        entityManager.getTransaction().begin();
//        // O persist permite fazer post apenas de objetos.
//        entityManager.persist(pessoa1);
//        entityManager.persist(pessoa2);
//        entityManager.persist(pessoa3);
//        entityManager.getTransaction().commit();

        // Buscando pessoa na base de dados
        Pessoa buscarPessoa = entityManager.find(Pessoa.class, 16);

        // Removendo pessoas na base de dados
        entityManager.getTransaction().begin();
        entityManager.remove(buscarPessoa);
        entityManager.getTransaction().commit();

//        // Exibindo no console
//        System.out.println(buscarPessoa);

        System.out.println("Pronto !!!");
        entityManager.close();
        entityManagerFactory.close();
    }
}
