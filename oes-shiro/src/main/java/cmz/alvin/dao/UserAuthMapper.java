package cmz.alvin.dao;

import cmz.alvin.pojo.User;

import java.util.Set;

public interface UserAuthMapper {
    public Set<String> getRoleById(Integer userId);

    public Set<String> getPermissionById(Integer userId);

    public Integer createUser(User user);

    public User getUserByUsername(String username);

}