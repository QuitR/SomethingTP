package lt.vu.transactions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import java.io.Serializable;

@RequestScoped
public class SecondComp implements Serializable {
    @Resource
    private TransactionSynchronizationRegistry tx;

    @PostConstruct
    private void init() {
        System.out.println(this + " born :)");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println(this + " about to die :(");
    }

    //---------------------------------

    //@Transactional(Transactional.TxType.REQUIRES_NEW)
    @Transactional(Transactional.TxType.REQUIRED)
    public String sayHello() {
        return toString() + " Tx: " + tx.getTransactionKey();
    }

}
