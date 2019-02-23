package HW23;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;

public class OfficeModelDaoImpl implements OfficeModelDao {

    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static final Logger LOG = LogManager.getLogger(OfficeModelDaoImpl.class);
    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public Set<OfficeModel> getAllOffices() throws SQLException {
        return null;
    }

    @Override
    public Set<OfficeModel> getOfficeByCity(String city) throws SQLException {
        return null;
    }

    @Override
    public boolean insertOfficeModel(OfficeModel officeModel) throws SQLException {
        LOG.debug("persisting Office instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(officeModel);
            entityManager.getTransaction().commit();
            LOG.debug("persist successful");
            return true;
        } catch (RuntimeException exception){
            if(entityManager != null){
                System.out.println("Transaction is begin rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("persist failed", exception);
            throw exception;
        }
    }

    @Override
    public boolean updateOfficeModel(OfficeModel officeModel) throws SQLException {
        LOG.debug("merging Office instance");
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(officeModel);
            entityManager.getTransaction().commit();
            LOG.debug("merge successful");
            return true;
        } catch (RuntimeException exception){
            if(entityManager != null){
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("merge failed", exception);
            throw exception;
        }
    }

    @Override
    public boolean deleteOfficeModel(BigDecimal office) throws SQLException {
        LOG.debug("removing Office instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(OfficeModel.class,office));
            entityManager.getTransaction().commit();
            LOG.debug("remove successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("remove failed", re);
            throw re;
        }
    }
}
