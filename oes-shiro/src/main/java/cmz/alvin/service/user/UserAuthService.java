package cmz.alvin.service.user;

/**
 * Created by e诺
 * on 16/7/25
 * Time 上午10:39
 */

import cmz.alvin.pojo.User;

import java.util.Set;

/**
 * 用户角色及权限的操作
 */
public interface UserAuthService {
    /**
     * 获取用户角色列表
     *
     * @param userId
     * @return
     */
    public Set<String> getRoleById(Integer userId);

    /**
     * 获取用户的权限列表
     *
     * @param userId
     * @return
     */
    public Set<String> getPermissionById(Integer userId);

    /**
     * 插入一条记录
     *
     * @param user
     */
    public void createUser(User user);

    /**
     * 通过username获取User
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username);
}
