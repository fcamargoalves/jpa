package br.com.devmedia.java.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory;

    public static void main(String args[]) {


        entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
        EntityManager em = entityManagerFactory.createEntityManager();


        /* inserindo

        Lembrete lembrete = new Lembrete();
        lembrete.setTitulo("Comprar leite");
        lembrete.setDescricao("Hoje, 10h30");


        try {
            em.getTransaction().begin();
            em.persist(lembrete);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            System.out.println("INSERT: " + e.getMessage());
        } finally {
            em.close();
        }
       */

        /* listando
        List<Lembrete> lembretes = null;
        try {
            lembretes = em.createQuery("from Lembrete").getResultList();
        } catch (Exception e) {
            System.out.println("LIST ALL: " + e.getMessage());
        } finally {
            em.close();
        }

        if (lembretes != null) {
            lembretes.forEach(System.out::println);
        }*/

        /*
        Lembrete lembrete = null;
        try {
            lembrete = em.find(Lembrete.class, 1L);
        } finally {
            em.close();
        }

        System.out.println(lembrete);

         */

        /*
        List<Lembrete> lembretes = null;
        try {
            lembretes = em.createQuery("from Lembrete l where l.titulo LIKE '%comprar%'").getResultList();
        } catch (Exception e) {
            System.out.println("LIST ALL: " + e.getMessage());
        } finally {
            em.close();
        }

        if (lembretes != null) {
            lembretes.forEach(System.out::println);
        }

         */

        Lembrete lembrete = new Lembrete();


        /*
        try {
            lembrete = em.find(Lembrete.class, 1L);

            lembrete.setTitulo("Comprar café");
            lembrete.setDescricao("Hoje, 8h22");

            em.getTransaction().begin();
            em.merge(lembrete);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            System.out.println("UPDATE: " + e.getMessage());
        } finally {
            em.close();
        }

         */
        try {
            em.getTransaction().begin();
            lembrete = em.find(Lembrete.class, 1l);
            em.remove(lembrete);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            System.out.println("DELETE: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}

