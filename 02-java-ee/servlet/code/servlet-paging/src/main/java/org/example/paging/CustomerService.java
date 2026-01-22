package org.example.paging;

public class CustomerService {
    public PageBean<Customer> findAll(int pc, int ps){
        return customerDao.findAll(pc, ps);
    }
}
