package org.example.service.impl;

import org.example.dao.IUserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.domain.PageBean;
import org.example.domain.User;
import org.example.service.IUserService;

import java.util.List;
import java.util.Map;

/**
 * 用户业务层实现类
 */
public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition) {

        int cp = Integer.parseInt(currentPage);
        int r = Integer.parseInt(rows);

        if (cp <= 0) {
            cp = 1;
        }

        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(cp);
        pb.setRows(r);

        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        int start = (cp - 1) * r;
        List<User> list = dao.findByPage(start, r, condition);
        pb.setList(list);


        //总页数
        int totalPage = (totalCount % r) == 0 ? totalCount / r : (totalCount / r) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
