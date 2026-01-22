package org.example.paging;

import java.util.List;

public class CustomerDao {

    /**
     * 查询所有
     *
     * @return
     */
    public PageBean<Customer> findAll(int pc, int ps) {
        try {
            PageBean<Customer> pb = new PageBean<>();
            pb.setPc(pc);
            pb.setPs(ps);
            String sql = "select count(*) from t_customer";
            Number num = (Number) qr.query(sql, new ScalarHandler());
            int tr = num.intValue();
            pb.setTr(tr);

            sql = "select * from t_customer limit ?,?";
            List<Customer> beanlist = qr.query(sql, new BeanListHandler<Customer>(Customer.class), (pc - 1) * ps, ps);
            pb.setBeanlist(beanlist);
            return pb;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
