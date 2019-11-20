package br.com.rodrigo.projetoExemplo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


// o T que representa o tipo de entidade que está sendo enviado para a operação de CRUD e o
// PK representa o tipo de dado referente ao identificador
public abstract class AbstractDao<T, PK extends Serializable> {

    //anotação que serve para impedir o compilador de emitir algumas advertências
    @SuppressWarnings("unchecked")
    //o atributo entityClass vai ser responsável por fornecer a classe referente ao tipo de
    // entidade que está sendo persistida. Por exemplo, ao persistir um objeto cargo,
    // o tipo de classe de objeto é Cargo.class
    private final Class<T> entityClass =
            (Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    //acesso ao objeto EntityManager da JPA, o qual é injetado na classe via anotação @PersistenceContext
    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(T entity) {

        entityManager.persist(entity);
    }

    public void update(T entity) {

        entityManager.merge(entity);
    }

    public void delete(PK id) {

        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    public T findById(PK id) {

        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {

        return entityManager
                .createQuery("from " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

    protected List<T> createQuery(String jpql, Object... params) {
        TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i+1, params[i]);
        }
        return query.getResultList();
    }
}

