/**
 * @nameAndExt MessageFacade.java
 * @date Apr 26, 2011
 * @author Kristin Ottofy
 */

package boundary;

import entities.Message;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 */
@Stateless
public class MessageFacade extends AbstractFacade<Message>
{
    @PersistenceContext(unitName = "SimpleEE6AppPU")
    private EntityManager em;

    protected EntityManager getEntityManager()
    {
        return em;
    }

    public MessageFacade()
    {
        super(Message.class);
    }



}
