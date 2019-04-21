package com.hk.service.sys;

import com.hk.model.SysRole;
import java.util.List;

public interface SysRoleService {

    /**
     * 获取用户的角色了吧
     *
     * @param userId 用户ID
     *
     * @return list
     */
    List<SysRole> getUerRoleById(Integer userId);

}
