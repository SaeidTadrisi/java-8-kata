package stream.api;

import common.tool.dataset.ClassicOnlineStore;
import common.tool.entity.Customer;
import common.tool.util.AssertUtil;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Exercise1Test extends ClassicOnlineStore {

    @Test
    public void findRichCustomers() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a {@link Stream} from customerList only including customer who has more budget than 10000.
         * Use lambda expression for Predicate and {@link Stream#filter} for filtering.
         */
        Predicate<Customer> richCustomerCondition = null;
        Stream<Customer> richCustomerStream = null;

        assertTrue("Solution for Predicate should be lambda expression", AssertUtil.isLambda(richCustomerCondition));
        List<Customer> richCustomer = richCustomerStream.collect(Collectors.toList());
        assertThat(richCustomer, hasSize(2));
        assertThat(richCustomer, contains(customerList.get(3), customerList.get(7)));
    }
}
