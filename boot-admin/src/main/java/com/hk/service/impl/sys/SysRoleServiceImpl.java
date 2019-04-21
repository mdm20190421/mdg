package com.hk.service.impl.sys;

import com.hk.dao.SysRoleMapper;
import com.hk.model.SysRole;
import com.hk.service.sys.SysRoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public List<SysRole> getUerRoleById(Integer userId) {
        return null;
    }
}
